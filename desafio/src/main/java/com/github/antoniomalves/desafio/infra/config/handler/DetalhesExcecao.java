package com.github.antoniomalves.desafio.infra.config.handler;

public class DetalhesExcecao {

	private String titulo;
	private int status;
	private String detalhe;
	private long timestamp;
	private String mensagemDesenvolvedor;
	
	public DetalhesExcecao(String titulo, int status, String detalhe, long timestamp, String mensagemDesenvolvedor) {
		this.titulo = titulo;
		this.status = status;
		this.detalhe = detalhe;
		this.timestamp = timestamp;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getStatus() {
		return status;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
	
}
