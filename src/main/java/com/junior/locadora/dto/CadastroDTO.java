package com.junior.locadora.dto;

import java.io.Serializable;

import com.junior.locadora.domain.Cadastro;

public class CadastroDTO implements Serializable {
	
	public static final long serialVersionUID=1L;
	
	
	private String id;
	private String nome;
	private String descricao;
	double duracao;
	int idademin;
	
	public CadastroDTO() { // Consturtor vazio
		
	}
	
	public CadastroDTO (Cadastro obj) { // Instanciar um Cadastro apartir de um Cadastro OBJ
	// 	Copia os dados dos usuario para o DTO
	id =obj.getId();
	nome=obj.getNome();
	descricao=obj.getDescricao();
	duracao =obj.getDuracao();
	idademin=obj.getIdademin();
	
		
}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		id=this.id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		nome=this.nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao (String descricao) {
		descricao=this.descricao;
	}
	
	public int getIdademin() {
		return idademin;
	}
	
	public void setIdademin(int idademin) {
		idademin=this.idademin;
	}
	
	
}
	


