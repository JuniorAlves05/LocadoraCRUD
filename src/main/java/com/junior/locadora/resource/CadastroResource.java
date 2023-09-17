package com.junior.locadora.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junior.locadora.domain.Cadastro;
import com.junior.locadora.dto.CadastroDTO;
import com.junior.locadora.services.CadastroService;

@RestController  // Informando que a classe é um recurso Rest
@RequestMapping(value="/cadastro") // Caminho da requisicao
public class CadastroResource {
	
	@Autowired
	private CadastroService service; // Injetando o service
	
	
	@GetMapping // Serve para informar o caminho cadastro
	public ResponseEntity <List<CadastroDTO>> findAll(){ // findAll >> Retorne todos
		List < Cadastro> list = service.findAll(); // Criando uma nova lista
		//Conversao da lista original para dto
		List <CadastroDTO>listDto =list.stream() .map ( x-> new CadastroDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto); 
		
		
	}

}
