package com.generation.blog.Pessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.blog.Pessoal.model.Usuario;
	
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	class UsuarioControllerTest{
		
		@Autowired
		private TestRestTemplate testRestTemplate;
		
		private Usuario usuario;
		private Usuario usuarioAlterar;
		
		@BeforeAll
		public void start() {
			usuario = new Usuario(2L,"Bueno Vital","vjbueno","123456");
			usuarioAlterar = new Usuario(2L,"Arissa Marques","arissalivros","789456");
			
		}
		@Disabled
		@Test
		void deveSalvarUsuarioRetornaStatus201() {
			
			HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
			
			ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, request, Usuario.class);
			assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
			
		}
		
		@Test
		void deveRetornarListadeUsuarioRetornaStatus200() {
			ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("vjbueno", "123456")
					.exchange("/usuarios/todos",HttpMethod.GET, null,String.class);
			assertEquals(HttpStatus.OK,resposta.getStatusCode());
		}
		
	}
