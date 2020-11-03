package com.github.antoniomalves.desafio.config;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleResourceNotFoundException(IllegalArgumentException illegalArgumentException){
		
		DetalhesExcecao exceptionDetail = new DetalhesExcecao(
				"Parâmetro de entrada incorreto. Verifique os valores enviados na requisição.",
				HttpStatus.BAD_REQUEST.value(),
				illegalArgumentException.getClass().getName(),
				new Date().getTime(),
				illegalArgumentException.getMessage()
				);

		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
	}
	
}
