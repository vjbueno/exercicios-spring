package com.loja.lojaDeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.lojaDeGames.model.Categoria;
import com.loja.lojaDeGames.repository.CategoriaRepository;

@RestController // <- sinalizando que esta é uma classe controller  

@RequestMapping("/categorias") // <- delimitando caminho a ser utilizado na URL

@CrossOrigin(origins = "*", allowedHeaders = "*") // <- anotação sinaliza que esta classe aceita requisições de qualquer origem

public class CategoriaController {
	
	@Autowired // <- serve para fazer a injeção de dependencias, fazendo assim está fazendo uma conexão com a classe CategoriaRepository
	private CategoriaRepository repository;
	
	
	
	/**
	 * Método que apresenta todas as categorias
	 * @return retorna uma lista com todas as categorias
	 * @author Bueno
	 * */
	
	@GetMapping
	public ResponseEntity<List<Categoria>> todasCategoria() {
	List<Categoria> listaDeCategoria = repository.findAll();
	return ResponseEntity.status(200).body(listaDeCategoria);
	
	/*@GetMapping ("/id{id}")
	public ResponseEntity<Categoria> buscaPorId(@PathVariable long id){
		return repository.findById(id);*/
	}
	
	
	
	
	

}
