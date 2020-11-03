package com.github.antoniomalves.desafio.dominio.model;

import javax.persistence.Embeddable;

import com.github.antoniomalves.desafio.dominio.exceptions.EmailInvalidException;
import com.github.antoniomalves.desafio.infra.Utils;

@Embeddable
public class Email {

	private String endereco;
	
	public Email(String endereco) {
		if(endereco == null || !Utils.validaEmail(endereco)) {
			throw new EmailInvalidException("Email inválido");
		}
		this.endereco = endereco;
	}
	
	public Email() {}

	public String getEndereco() {
		return endereco;
	}
	
}
