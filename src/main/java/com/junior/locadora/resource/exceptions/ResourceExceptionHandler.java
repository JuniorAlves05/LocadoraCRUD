package com.junior.locadora.resource.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.junior.locadora.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // Responsável para tratar possiveis erros nas requisições
public class ResourceExceptionHandler { // Manipulador de exceções na camada de resource
	
	@ExceptionHandler(ObjectNotFoundException.class)// Tem que colocar para informar que quando ocorrer uma excessão é para fazer esse tratamento  personalizado abaixo. 
	 public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {// Metodo para tratar o ObjectNotFoundException
	
	HttpStatus status = HttpStatus.NOT_FOUND;
	StandardError err = new StandardError(System.currentTimeMillis(),status.value()," Usuário Inválido ",e.getMessage(),request.getRequestURI());
	// System.currentTimeMillis >> Pega o estante atual do sistema
	// status.value = Recebe um NOT_FOUND >> Error 404 " Erro não encontrado "
	// Message = Mensagem personalizada do e.getMessage
	// Request = Caminho que gerou o erro
	return ResponseEntity.status(status).body(err);
	
	// ResponseEntity passa o status declaro em cima e o err que foi declarado em cima

}
}