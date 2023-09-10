package com.junioralves.workshop.services.exception;

// Package criada para retornar uma "Exception" quando solicitar um "Id" invalido

public class ObjectNotFoundException extends RuntimeException {
	
	// Usando o RunTimeExceptions para utilizar uma classe auxiliar para excessão ( Modificada )
	// Utilizando apaenas o Exception o compilador obriga a tratar a excessão .
	
	private static final long serialVersionUID = 1L;
	
	// Construtor que recebe uma String como argumento ( Mensagem Personalizada )
	public ObjectNotFoundException(String msg ) {
		super (msg);
		
		
	}
	

}
