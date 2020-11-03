package com.github.antoniomalves.desafio.dominio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailInvalidException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmailInvalidException(String msg) {
		super(msg);
	}
}
