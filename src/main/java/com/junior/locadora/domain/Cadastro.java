package com.junior.locadora.domain;

import java.io.Serializable;
import java.util.Objects;

public class Cadastro implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	
	private String id;
	private String nome;
	private String descricao;
	double duracao;
	int idademin;
	
	public Cadastro () {
		
	}

	public Cadastro(String id, String nome, String descricao, double duracao, int idademin) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
		this.idademin = idademin;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public int getIdademin() {
		return idademin;
	}

	public void setIdademin(int idademin) {
		this.idademin = idademin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, duracao, id, idademin, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return Objects.equals(descricao, other.descricao)
				&& Double.doubleToLongBits(duracao) == Double.doubleToLongBits(other.duracao)
				&& Objects.equals(id, other.id) && idademin == other.idademin && Objects.equals(nome, other.nome);
	}
	
	

}
