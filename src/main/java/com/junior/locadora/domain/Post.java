package com.junior.locadora.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.junior.locadora.dto.AuthorDTO;

@Document
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id ;
	private Date date;
	private String comentario;
	private AuthorDTO author;
	private Cadastro filme;
	
	public Post() {
		
	}

	public Post(String id, Date date, String comentario, AuthorDTO author, Cadastro filme) {
		super();
		this.id = id;
		this.date = date;
		this.comentario = comentario;
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
		return comentario;
	}

	public void setTitulo(String comentario) {
		this.comentario = comentario;
	}
	
	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
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
