package com.github.antoniomalves.desafio.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.github.antoniomalves.desafio.dominio.autor.Autor;
import com.github.antoniomalves.desafio.dominio.autor.AutorRepository;
import com.github.antoniomalves.desafio.dominio.autor.AutorRequest;

@Component
public class ProibeEmailDuplicadoValidator implements Validator{
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		AutorRequest request = (AutorRequest) target;
		
		Optional<Autor> autorPorEmail = autorRepository.findByEmail(request.getEmail());
		
		if(autorPorEmail.isPresent()) {
			errors.rejectValue("email", null, "Já existe um(a) autor(a) com o email cadastrado. " + request.getEmail());
		}
		
	}

}
