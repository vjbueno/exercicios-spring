package com.farmacia.farmacia.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.farmacia.model.Categoria;
import com.farmacia.farmacia.repository.CategoriaRepository;
import com.farmacia.farmacia.service.CategoriaService;

@RestController
@CrossOrigin ("*")
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repositoryC; 
	
	@Autowired private CategoriaService serviceC;
	
	@GetMapping
	public ResponseEntity <List<Categoria>> buscaTodasCategorias(){
		List<Categoria> listaDeCategorias = repositoryC.findAll();
		
		if(listaDeCategorias.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else {
			return ResponseEntity.status(200).body(listaDeCategorias);
		
		}	
	}
	
	@GetMapping("id/{id_categoria}")
	public ResponseEntity<Optional<Categoria>> buscarCategoriaPorId(@PathVariable(value = "id_categoria") Long idCategoria) {
		Optional<Categoria> idDaCategoria = repositoryC.findById(idCategoria);
		
		if (idDaCategoria.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(idDaCategoria);
		}
		
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Object> bucarCategoriaPorNome(@RequestParam String nomeCategoria){
		List<Object> listaDeCategorias = repositoryC.findAllByNomeCategoria(nomeCategoria);
		
		if(listaDeCategorias.isEmpty()) {
			return ResponseEntity.status(400).body("Não tem categoria com esse nome");
		} else {
			return ResponseEntity.status(200).body(listaDeCategorias);
		}
	}
	
	
	@PostMapping("/salvar")
	public ResponseEntity<Object> salvarNovaCategoria(@RequestBody Categoria categoria){
		return serviceC.cadastrarNovoCategoria(categoria)
				.map(verificandoCategoria -> ResponseEntity.status(200).body(verificandoCategoria))
				.orElse(ResponseEntity.status(400).body("Categoria já cadastrada"));
	}
	
	@PutMapping("/atualizar/{id_categoria")
	public ResponseEntity<Object> remodelarCategoria(@PathVariable (value = "id_categoria") Long idCategoria,
			@Valid @RequestBody Categoria atualizacaoCategoria) {
		
		return serviceC.atualizarCategoria(idCategoria, atualizacaoCategoria)
				.map(categoriaAtualizada -> ResponseEntity.status(201).body(categoriaAtualizada))
				.orElse(ResponseEntity.status(400).body("Categoria inexistente"
						+ "ou já está cadastrada"));
			
		
	}

	@DeleteMapping("/deletar")
	public ResponseEntity<String> deletarCategoria(@RequestParam Long idCategoria) {
		return serviceC.deleteIdCategoria(idCategoria)
				.map(categoriaDeletada -> ResponseEntity.status(400).body("Categoria não localizada."))
				.orElse(ResponseEntity.status(200).body("Categoria deletado."));
				
	}
	
}
