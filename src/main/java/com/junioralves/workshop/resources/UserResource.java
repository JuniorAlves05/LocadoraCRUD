package com.junioralves.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.junioralves.workshop.domain.User;

@RestController  // Recurso Rest
@RequestMapping (value="/users") //  Caminho do End Point
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET) // Metodo Get
	public ResponseEntity<List<User>> findAll(){ //Encapsular a estrutura para retornar resposta http com possiveis erros
		User maria = new User("1", "Maria Silva", "maria@gmail.com"); //Cadastro
		User alex = new User ("2","Alex Green","alex@gmail.com"); // Cadastro
		List <User> list = new ArrayList<>(); //  Listando os usuarios
		list.addAll(Arrays.asList(maria,alex));// Adicionando o cadastro na lista
		return ResponseEntity.ok().body(list); // Retornando o corpo de cadastro
		
	}
	
	
	

}
