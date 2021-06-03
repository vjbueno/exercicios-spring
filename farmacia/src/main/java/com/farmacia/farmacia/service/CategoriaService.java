package com.farmacia.farmacia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.farmacia.model.Categoria;
import com.farmacia.farmacia.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositoryC;
	
	public Optional<Object> cadastrarNovoCategoria(Categoria novaCategoria){
		Optional<Object> verificaCategoria = repositoryC.findByNomeCategoria(novaCategoria.getNomeCategoria());
		
		if(verificaCategoria.isPresent()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(repositoryC.save(novaCategoria));
		}
	}
	
	public Optional<Object> atualizarCategoria(Long idCategoria, Categoria atualizacaoCategoria){
		Optional<Categoria> verificaIdCategoria = repositoryC.findById(idCategoria);
		Optional<Object> verificaCategoria = repositoryC.findByNomeCategoria(atualizacaoCategoria.getNomeCategoria());
		
		if(verificaIdCategoria.isPresent() && verificaCategoria.isEmpty()) {
			verificaIdCategoria.get().setNomeCategoria(atualizacaoCategoria.getNomeCategoria());
			verificaIdCategoria.get().setTipoCategoria(atualizacaoCategoria.getTipoCategoria());
			return Optional.ofNullable(repositoryC.save(verificaIdCategoria.get()));
		}else {
			
			return Optional.empty();
		}
		
	}
	
	public Optional<Object> deleteIdCategoria(Long idCategoria) {
		Optional<Categoria> verificaIdCategoria = repositoryC.findById(idCategoria);
		
		if(verificaIdCategoria.isEmpty()) {
			return Optional.ofNullable(verificaIdCategoria);
		} else {
			repositoryC.deleteById(idCategoria);
			return Optional.empty();
		}
}
	
}
