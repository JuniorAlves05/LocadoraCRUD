package com.junioralves.workshop.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.junioralves.workshop.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

//Manipulador de excecoes na camada de resource

@ControllerAdvice
public class ResourceExceptionHandler {
	
	//Metodo >> Quando der problema na consulta 
	
	@ExceptionHandler(ObjectNotFoundException.class)// Sreve para funcionar e identificar a excessão,executar o tratamento informado
	public ResponseEntity<StandardError>objectNotFound(ObjectNotFoundException e,HttpServletRequest request ){
		
		HttpStatus status =HttpStatus.NOT_FOUND;
		StandardError err = new StandardError
				(System.currentTimeMillis(),status.value(),
						"Nao encontrado",
						e.getMessage(),
						request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
