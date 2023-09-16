package com.junior.locadora.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junior.locadora.domain.Cadastro;
import com.junior.locadora.services.CadastroService;

@RestController  // Informando que a classe é um recurso Rest
@RequestMapping(value="/cadastro") // Caminho da requisicao
public class CadastroResource {
	
	@Autowired
	private CadastroService service; // Injetando o service
	
	
	@GetMapping // Serve para informar o caminho cadastro
	public ResponseEntity <List<Cadastro>> findAll(){ // findAll >> Retorne todos
		
		List < Cadastro> list = service.findAll(); // Criando uma nova lista
		return ResponseEntity.ok().body(list); 
		
		
	}

}
