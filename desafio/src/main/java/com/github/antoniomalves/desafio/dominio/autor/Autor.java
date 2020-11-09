package com.github.antoniomalves.desafio.dominio.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	private String email;
	
	@Size(min = 10, max = 400)
	private String descricao;
	
	@Column(name = "data_hora_registro")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraRegistro;
	
	@Deprecated
	public Autor() {}

	public Autor(@NotBlank String nome, 
			@NotBlank @Email String email, 
			@NotBlank @Size(min= 5, max=400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataHoraRegistro = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataHoraRegistro() {
		return dataHoraRegistro;
	}
	
}
