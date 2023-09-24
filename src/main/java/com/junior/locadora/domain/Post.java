package com.junior.locadora.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id ;
	private Date date;
	private String titulo;
	private String Corpo;
	private User author;
	private Cadastro filme;
	
	public Post() {
		
	}

	public Post(String id, Date date, String titulo, String corpo, User author, Cadastro filme) {
		super();
		this.id = id;
		this.date = date;
		this.titulo = titulo;
		Corpo = corpo;
		this.author= author;
		this.filme=filme;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return Corpo;
	}

	public void setCorpo(String corpo) {
		Corpo = corpo;
	}
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	public Cadastro getFilme() {
		return filme;
	}

	public void setFilme(Cadastro filme) {
		this.filme = filme;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

	

	
	
	
	
	

}
