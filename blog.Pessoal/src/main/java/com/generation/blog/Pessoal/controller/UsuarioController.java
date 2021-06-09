package com.generation.blog.Pessoal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blog.Pessoal.model.UserLogin;
import com.generation.blog.Pessoal.model.Usuario;
import com.generation.blog.Pessoal.repository.UsuarioRepository;
import com.generation.blog.Pessoal.service.UsuarioService;

@RestController
@RequestMapping("/usuarios") // caminho "raiz" da url: http://localhost:8090/usuarios
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository repository;
	
	/* Método para usuario logar
	caminho: http://localhost:8090/usuarios/logar */
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(401).build());
	}
	
	/* Método para cadastrar usuario
	 * caminho: http://localhost:8090/usuarios/cadastrar */
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastraUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.status(201)
				.body(usuarioService.CadastrarUsuario(usuario));
	}

	/* Método para buscar todos os usuários
	 * caminho:http://localhost:8090/usuarios/todos 
	 */
	@GetMapping("/todos")
	public ResponseEntity<List<Usuario>> buscarTodosUsuarios(){
		List<Usuario> todosUsuarios = repository.findAll();
		return ResponseEntity.status(200).body(todosUsuarios);
	}
	
	
	
	
}
