package com.generation.blog.Pessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blog.Pessoal.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByUsuario(String usuario);
	
	List<Usuario> findAllByUsuarioContainingIgnoreCase(String nomeUsuario);
}
