package com.github.antoniomalves.desafio.resources;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.antoniomalves.desafio.config.ProibeNomeCategoriaDuplicadoValidator;
import com.github.antoniomalves.desafio.dominio.categoria.Categoria;
import com.github.antoniomalves.desafio.dominio.categoria.CategoriaRequest;

@RestController
@RequestMapping("/api/desafio")
public class CategoriaResource {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ProibeNomeCategoriaDuplicadoValidator proibeNomeCategoriaDuplicadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeCategoriaDuplicadoValidator);
	}

	@PostMapping("/categorias")
	@Transactional
	public ResponseEntity<CategoriaRequest> criarCategoria(@RequestBody @Valid CategoriaRequest request) {
		Categoria categoria = request.toModel();
		manager.persist(categoria);
		return ResponseEntity.ok(request);
	}
	
}
