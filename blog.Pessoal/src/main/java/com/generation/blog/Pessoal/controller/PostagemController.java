package com.generation.blog.Pessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")

// nome da classe
public class PostagemController {
	
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping("/todospost")
	public ResponseEntity<List<Postagem>> GetAll () {
		return ResponseEntity.status(200).body(repository.findAll());
	}
	
	
	/* utilizando o método get para passar o parametro/numero de ID na URL
	 * desta forma: http://localhost:8090/postagens/id{id}*/
	@GetMapping("id/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	/*Método busca postagem pelo título da postagem 
	* caminho: http://localhost:8090/postagens/titulo/{titulo} */
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GeyByTitulo(@PathVariable String titulo){
		return ResponseEntity.status(200).body(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	/* método inclui postagem 
	caminho: http://localhost:8090/postagens/incluipost */
	@PostMapping("incluipost")
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(201).body(repository.save(postagem));
	}
	
	/* Método atualiza post pelo id do post informado
	 caminho: http://localhost:8090/postagens/atualizardadospost/id/{id}*/
	@PutMapping("atualizardadospost/id/{id}")
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(200).body(repository.save(postagem));
	}
	
	/* Método deleta post pelo id do post informado
	 caminho: */
	@DeleteMapping("id/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}