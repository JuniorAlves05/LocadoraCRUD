package com.junior.locadora.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserDTO implements Serializable {
	
	public static final long serialVersionUID =1L;
	
	private String id;
	private String nome;
	private int idade;
	private String email;
	private LocalDateTime dataHoraCadastro;

    public UserDTO() {
        // Construtor vazio
    }

	public UserDTO(String id, String nome, int idade, String email, LocalDateTime dataHoraCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.dataHoraCadastro = dataHoraCadastro;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
