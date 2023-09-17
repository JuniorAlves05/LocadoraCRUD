	package com.junior.locadora.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L; // Essa RunTimeException o compilador não obriga a tratar
	

	public ObjectNotFoundException( String msg) {
		super(msg); 
	}
}
