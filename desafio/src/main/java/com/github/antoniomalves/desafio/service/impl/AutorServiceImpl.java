package com.github.antoniomalves.desafio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.antoniomalves.desafio.dominio.IAlunoRepository;
import com.github.antoniomalves.desafio.dominio.dto.AutorDTO;
import com.github.antoniomalves.desafio.service.IAutorService;

@Service
public class AutorServiceImpl implements IAutorService{

	@Autowired
	private IAlunoRepository repository;
	
	
	@Override
	public void criarAutor(AutorDTO dados) {
		repository.save(AutorDTO.criaAutor(dados));
	}

}
