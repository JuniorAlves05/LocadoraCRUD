package com.junioralves.workshop.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junioralves.workshop.domain.User;
import com.junioralves.workshop.dto.UserDTO;
import com.junioralves.workshop.services.UserService;

@RestController  // Recurso Rest
@RequestMapping (value="/users") //  Caminho do End Point
public class UserResource { // Controlador Rest Acessa o Serviço
	
	@Autowired
	private UserService service; // O Serviço Acessa o Repositorio
	
	@GetMapping // Metodo Get
	public ResponseEntity<List<UserDTO>> findAll(){ //Encapsular a estrutura para retornar resposta http com possiveis erros
		List <User> list = service.findAll(); // Busca os usuarios e guarda na lista 
		List<UserDTO>listDto =list.stream().map (x -> new UserDTO(x)).collect(Collectors.toList()); // Conversao da lista original para o DTO
		return ResponseEntity.ok().body(listDto); //  Retornando o corpo de cadastro do listDTO
		
	}
	
	@GetMapping (value= "/{id}") // Metodo Get
	public ResponseEntity<UserDTO> findById(@PathVariable String id ){ //PathVariable > Id casa com id recebido na url
		List <User> list = service.findAll(); // Busca os usuarios e guarda na lista
		User obj = service.findById(id); // Instanciando o objeto usuario recebendo o service ( User service )
		return ResponseEntity.ok().body(new UserDTO(obj)); //Conversao do User Para User DTO
		
	}
}
