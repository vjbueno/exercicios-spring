package com.farmacia.farmacia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.farmacia.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Object> findAllByNomeCategoria(String nomeCategoria); // isso aqui é igual o like no MySQL
	
	public Optional<Object> findByNomeCategoria(String nomeCategoria); // isso aqui procura exatamente igual ao nome que esta na tabela
}
