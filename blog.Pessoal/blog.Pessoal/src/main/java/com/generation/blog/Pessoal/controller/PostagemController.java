package com.generation.blog.Pessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blog.Pessoal.model.Postagem;
import com.generation.blog.Pessoal.repository.PostagemRepository;


//Anotação "RestController" serve para informar que essa classe POSTAGEM CONTROLLER tratasse de um controlador
@RestController

//Anotação "RequestMapping" sinaliza por qual URL a aplicação será acessada:
@RequestMapping("/postagens")

// Anotação "CrossOrigin" sinaliza que essa classe irá aceitar requisições de qualquer origem.
@CrossOrigin("*")

// nome da classe
public class PostagemController {
	
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll () {
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	/* utilizando o método get para passar o parametro/numero de ID na URL
	 * desta forma: http://localhost:8090/postagens/1 */
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	/*utilizando o método get para passar o parametro(titulo) e o titulo em si da postagem na URL
	* desta forma: http://localhost:8090/postagens/titulo/api */
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GeyByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
}