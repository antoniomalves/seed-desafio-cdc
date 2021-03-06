package com.github.antoniomalves.desafio.dominio.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class AutorRequest {
	
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorRequest(@NotBlank String nome, 
			@NotBlank @Email String email, 
			@NotBlank @Size(max=400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	
	public String getEmail() {
		return email;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}


	public AutorRequest modelToAutorRequest(Autor autor) {
		return new AutorRequest(autor.getNome(), autor.getEmail(), autor.getDescricao());
	}
	
}
