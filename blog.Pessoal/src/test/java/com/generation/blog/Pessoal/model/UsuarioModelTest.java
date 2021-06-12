package com.generation.blog.Pessoal.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

//anotação @SpringBootTest inicializa o ambiente de teste
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UsuarioModelTest {

	public Usuario usuario;
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	//anotação @BeforeEach que indica que o método deve ser executado primeiro;
	@BeforeEach
	public void start() {
		usuario = new Usuario(1,"Bueno Vital","vjbueno","123456");	
	}
	
	
	/*
	 * Teste que verifica se a lista de usuários está vazia;
	 * se estiver vazia, o teste irá dar true, caso contrario false;
	 * false não passaria no teste.
	 */
	@Test
	void testValidarAtribtutos(){
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);
		System.out.println(violacao.toString());
		assertTrue(violacao.isEmpty());
		
	}
	
	//Teste verifica se há campos que não foram preenchidos
	
	@Test
	void testValidaAtributosNulos() {
		Usuario usuarioErro = new Usuario();
		usuarioErro.setNomeUsuario("Barbara Vital");
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuarioErro);
		System.out.println(violacao.toString());
		assertFalse(violacao.isEmpty());
	}
	

}
