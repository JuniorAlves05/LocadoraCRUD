package com.junioralves.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junioralves.workshop.domain.User;
import com.junioralves.workshop.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo; // Repositorio
	
	public List<User> findAll(){
		return repo.findAll(); 
		
	}

}
