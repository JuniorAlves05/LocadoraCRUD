package com.junior.locadora.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.locadora.domain.Cadastro;
import com.junior.locadora.domain.User;
import com.junior.locadora.dto.CadastroDTO;
import com.junior.locadora.dto.UserDTO;
import com.junior.locadora.repository.UserRepository;
import com.junior.locadora.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User createUser(String nome, int idade, String email) {
        // Validar os campos de entrada (opcional)
        if (nome == null || idade < 0 || email == null) {
            throw new IllegalArgumentException("Campos de entrada inválidos.");
        }

        LocalDateTime dataHoraCadastro = LocalDateTime.now(); // Obtém a data e hora atuais

        User user = new User(null, nome, idade, email, dataHoraCadastro);
        return repo.save(user);
    }

    public User findById(String id) {
        Optional<User> userOptional = repo.findById(id);
        if (!userOptional.isPresent()) {
            throw new ObjectNotFoundException("Usuário não encontrado");
        }
        return userOptional.get();
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        User user = findById(id); // Primeiro, encontre o objeto pelo ID
        repo.delete(user); // Agora, delete o objeto encontrado
    }

    public User update(User obj) {
        Optional<User> optionalUser = repo.findById(obj.getId());

        if (optionalUser.isEmpty()) {
            throw new ObjectNotFoundException("Usuário não encontrado");
        }

        User existingUser = optionalUser.get();

        updateData(existingUser, obj);

        return repo.save(existingUser);
    }

    private void updateData(User newUser, User obj) {
        newUser.setNome(obj.getNome());
        newUser.setIdade(obj.getIdade());
        newUser.setEmail(obj.getEmail());
        newUser.setDataHoraCadastro(obj.getDataHoraCadastro());
    }
    
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getNome(), objDto.getIdade(), objDto.getEmail(),objDto.getDataHoraCadastro());
    }
}
