package com.junior.locadora.resource;

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
	@RequestMapping(value="/{id}")
	public ResponseEntity <CadastroDTO> findbyId(@PathVariable String id){ // O @PathVariable serve para mapear um id 
		Cadastro obj = service.findById(id);
		return ResponseEntity.ok().body(new CadastroDTO(obj));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CadastroDTO objDto) { // Removi o ponto após "insert" e corrigi o @RequestBody
	    Cadastro obj = service.fromDTO(objDto); // Conversão de objDto para obj
	    obj = service.insert(obj); // Inserindo no banco de dados

	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(obj.getId())
	            .toUri();
	            
	    return ResponseEntity.created(uri).build(); // Resposta vazia com o código 201 e a localização com o novo recurso criado
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity <Void> delete (@PathVariable String id){ // O @PathVariable serve para mapear um id 
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
}
