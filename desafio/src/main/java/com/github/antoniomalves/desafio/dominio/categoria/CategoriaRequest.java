package com.github.antoniomalves.desafio.dominio.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;


public class CategoriaRequest {
	
	@NotBlank
	private String nome;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}
	
}
