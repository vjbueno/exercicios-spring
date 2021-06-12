package com.generation.blog.Pessoal.repository;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blog.Pessoal.model.Usuario;


// Anotação @SpringBootTest inicializa a classe para que possamos realizar nossos testes
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UsuarioRepositoryTest {
	
	

	@Autowired
	private UsuarioRepository repository;
	
	//incluindo usuarios no bd para testar a situação antes de realizar os demais testes 
	@BeforeAll
	void start() {
		Usuario usuario = new Usuario(1,"Dalva Vital","vdalva","789456");
		if(repository.findByUsuario(usuario.getUsuario())!=null)
			repository.save(usuario);
		
		usuario = new Usuario(2,"Dalva Jeronimo","jjeronimo","123456");
		if(repository.findByUsuario(usuario.getUsuario())!=null)
			repository.save(usuario);
		
		usuario = new Usuario(3,"Dalva Souza","talinhas","123456");
		if(repository.findByUsuario(usuario.getUsuario())!=null)
			repository.save(usuario);
		
	}
	
	// Teste retorna com todos os usuários cadastrados no bd
	@Test
	public void findByUsuarioRetornaTodosUsuarios() throws Exception {
		
		Usuario usuario = repository.findByUsuario("vdalva").get();
		assertTrue(usuario.getUsuario().equals("vdalva"));
		
	}
	
	//Teste retorna apenas dois usuários cadastrados no bd que tenham "Jerônimo" em seus nomes
	@Test
	public void findAllByUsuarioContainingIgnoreCaseTresUsuario() {
		List<Usuario> listaDeUsuarios = repository.findAllByUsuarioContainingIgnoreCase("Dalva");
		assertEquals(3, listaDeUsuarios.size());
	}
	
	//Deleta do banco os usuários criados após e execução dos dois testes anteriores 
	@AfterAll
	public void end() {
		repository.deleteAll();
	}
	
}
