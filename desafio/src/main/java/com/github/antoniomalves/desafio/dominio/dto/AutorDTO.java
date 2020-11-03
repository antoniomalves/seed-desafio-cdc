package com.github.antoniomalves.desafio.dominio.dto;

import javax.validation.constraints.Size;

import com.github.antoniomalves.desafio.dominio.model.Autor;
import com.github.antoniomalves.desafio.dominio.model.Email;

public class AutorDTO {

	private String nome;
	
	private String email;
	
	@Size(min=10, max = 400, message = "Descricao deve ter entre 10 e 400 caracteres.")
	private String descricao;

	public AutorDTO(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public static Autor criaAutor(AutorDTO dados) {
		return new Autor(dados.nome, new Email(dados.email), dados.descricao);
	}
}
