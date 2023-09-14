package com.junior.locadora.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junior.locadora.domain.Cadastro;

@RestController  // Informando que a classe é um recurso Rest
@RequestMapping(value="/cadastro") // Caminho da requisicao
public class CadastroResource {
	
	@GetMapping // Serve para informar o caminho cadastro
	public ResponseEntity <List<Cadastro>> findAll(){ // findAll >> Retorne todos
		Cadastro f1 = new Cadastro("1", "Tarzan", "Rei da floresta", 2.20, 8);
		Cadastro f2 = new Cadastro("2","Simba","Rei leao",2.30,6);
		
		List < Cadastro> list = new ArrayList<>(); // Criando uma nova lista
		list.addAll(Arrays.asList(f1,f2)); // Adicionando na nova lista e informando 
		return ResponseEntity.ok().body(list);
		
		
	}

}
