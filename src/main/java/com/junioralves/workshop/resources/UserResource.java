package com.junioralves.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junioralves.workshop.domain.User;
import com.junioralves.workshop.services.UserService;

@RestController  // Recurso Rest
@RequestMapping (value="/users") //  Caminho do End Point
public class UserResource { // Controlador Rest Acessa o Serviço
	
	@Autowired
	private UserService service; // O Serviço Acessa o Repositorio
	
	@GetMapping // Metodo Get
	public ResponseEntity<List<User>> findAll(){ //Encapsular a estrutura para retornar resposta http com possiveis erros
		List <User> list = service.findAll(); // Busca os usuarios e guarda na lista 
		return ResponseEntity.ok().body(list); // Retornando o corpo de cadastro
		
	}
	
	
	

}
