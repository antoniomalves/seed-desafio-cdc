package com.github.antoniomalves.desafio.infra.config.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.github.antoniomalves.desafio.dominio.exceptions.EmailInvalidException;


@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(EmailInvalidException.class)
	public ResponseEntity<?> handleResourceNotFoundException(EmailInvalidException emailInvalidoException){
		
		DetalhesExcecao exceptionDetail = new DetalhesExcecao(
				"Convenente não encontrada",
				HttpStatus.BAD_REQUEST.value(),
				emailInvalidoException.getClass().getName(),
				new Date().getTime(),
				emailInvalidoException.getMessage()
				);

		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
	}
	
}
