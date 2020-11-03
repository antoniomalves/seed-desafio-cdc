package com.github.antoniomalves.desafio.resources;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.antoniomalves.desafio.novoautor.dominio.Autor;
import com.github.antoniomalves.desafio.novoautor.dominio.AutorRequest;


@RestController
@RequestMapping("/api/desafio")
public class AutorResource {
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/autores")
	@Transactional
	public ResponseEntity<Autor> criarAutor(@RequestBody @Valid AutorRequest request){
		Autor autor = request.toModel();
		manager.persist(autor);
		return ResponseEntity.ok(autor);
	}
	
}
