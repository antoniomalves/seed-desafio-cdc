package com.github.antoniomalves.desafio.dominio.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Embedded
	private Email email;
	
	@Size(min = 10, max = 400, message = "Campo descricao deve ter o tamanho entre 10 e 400 caracteres.")
	private String descricao;
	
	@Column(name = "data_hora_registro")
	private LocalDateTime dataHoraRegistro;
	
	public Autor() {}

	public Autor(String nome, Email email, String descricao) {
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

	public Email getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataHoraRegistro() {
		return dataHoraRegistro;
	}
	
}
