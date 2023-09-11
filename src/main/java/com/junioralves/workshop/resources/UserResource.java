package com.junioralves.workshop.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping // Mapeamento para requisições POST
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) { 
	    User obj = service.fromDTO(objDto); // Conversão do objeto DTO para User
	    obj = service.insert(obj); // Inserção no banco de dados
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	        .path("/{id}")
	        .buildAndExpand(obj.getId())
	        .toUri();
	    return ResponseEntity.created(uri).build(); // Resposta vazia com o codigo 201, e a localização com o novo recurso criado
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE) // Metodo para deletar
	public ResponseEntity<Void>delete(@PathVariable String id){ 
		service.delete(id);
		return ResponseEntity.noContent().build(); // Resposta com codigo 204 ( noContent )
	}
		
}
