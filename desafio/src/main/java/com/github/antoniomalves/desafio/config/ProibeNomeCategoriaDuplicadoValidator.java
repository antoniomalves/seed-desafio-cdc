package com.github.antoniomalves.desafio.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.github.antoniomalves.desafio.dominio.categoria.Categoria;
import com.github.antoniomalves.desafio.dominio.categoria.CategoriaRepository;
import com.github.antoniomalves.desafio.dominio.categoria.CategoriaRequest;

@Component
public class ProibeNomeCategoriaDuplicadoValidator implements Validator{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		CategoriaRequest request = (CategoriaRequest) target;
		
		Optional<Categoria> categoriaPorNome = categoriaRepository.findByNome(request.getNome());
		
		if(categoriaPorNome.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma categoria com o nome cadastrado. " + request.getNome());
		}
		
	}

}
