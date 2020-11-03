package com.github.antoniomalves.desafio.dominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.antoniomalves.desafio.dominio.model.Autor;

@Repository
public interface IAlunoRepository extends JpaRepository<Autor, Long>{

}
