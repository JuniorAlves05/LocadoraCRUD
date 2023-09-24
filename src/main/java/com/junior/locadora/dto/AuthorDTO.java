package com.junior.locadora.dto;

import java.io.Serializable;

import com.junior.locadora.domain.User;

public class AuthorDTO implements Serializable {
		
	public static final long serialVersionUID=1L;
	
	private String id;
	private String nome;
	
	public AuthorDTO() {
		
	}

	public AuthorDTO(User obj) {
		id = obj.getId();
		nome = obj.getNome();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
