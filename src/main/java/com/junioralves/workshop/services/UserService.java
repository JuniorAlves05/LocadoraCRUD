package com.junioralves.workshop.services;

import java.util.List;
import java.util.Optional; // Importe a classe Optional

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junioralves.workshop.domain.User;
import com.junioralves.workshop.repository.UserRepository;
import com.junioralves.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo; // Repositório
	
	public List<User> findAll(){
		return repo.findAll(); 
	}
	
	public User findById(String id) {
		Optional<User> optionalUser = repo.findById(id); 
		return optionalUser.orElseThrow(() -> new 
				ObjectNotFoundException("Objeto não encontrado"));
		// Adicione esta linha para retornar o usuário encontrado
	}
}
