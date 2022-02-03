package br.com.curso.comercio.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.curso.comercio.services.exceptions.ObjetoNaoEncontrado;

@ControllerAdvice
public class ResourseExceptionHandler {
	
	@ExceptionHandler(ObjetoNaoEncontrado.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado(ObjetoNaoEncontrado e, HttpServletRequest request) {
		
		StandardError erro = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
}
