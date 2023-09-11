package com.junioralves.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junioralves.workshop.domain.User;
import com.junioralves.workshop.dto.UserDTO;
import com.junioralves.workshop.repository.UserRepository;
import com.junioralves.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> optionalUser = repo.findById(id);
        return optionalUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }
    
    public void delete(String id) {
        User user = findById(id);
        repo.delete(user);
    }
    
    public User update(User obj) {
        User newObj = repo.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        updateData(newObj, obj); // Responsável por copiar os dados de obj para newObj
        return repo.save(newObj);
    }


    private void updateData(User newObj, User obj) {
			newObj.setName(obj.getName());
			newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
        return new User(null, objDto.getName(), objDto.getEmail());
    }
}
