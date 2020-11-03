package com.github.antoniomalves.desafio.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.antoniomalves.desafio.dominio.dto.AutorDTO;
import com.github.antoniomalves.desafio.service.IAutorService;

@RestController
@RequestMapping("/api/desafio")
public class AutorResource {
	
	@Autowired
	IAutorService service;

	@PostMapping("/criarAutor")
	public ResponseEntity<?> criarAutor(@RequestBody @Valid AutorDTO autorDTO){
		service.criarAutor(autorDTO);
		return ResponseEntity.ok().build();
	}
	
}
