package com.github.antoniomalves.desafio.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.antoniomalves.desafio.dominio.exceptions.EmailInvalidException;
import com.github.antoniomalves.desafio.dominio.model.Email;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailsComEnderecosInvalidos() {
		assertThrows(EmailInvalidException.class,
				() -> new Email(null));
		
		assertThrows(EmailInvalidException.class,
				() -> new Email(""));
		
		assertThrows(EmailInvalidException.class,
				() -> new Email("emailinvalido"));
	}

	@Test
	void deveriaPermitirCriarEmailComEnderecoValido() {
		String endereco = "fulano@teste.com.br";
		Email email = new Email(endereco);
		assertEquals(endereco, email.getEndereco());
	}

}
