package com.generation.blog.Pessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@NotNull
	@Size(min = 02, max = 100)
	private String nomeUsuario;

	@NotNull
	@Size(min = 05, max = 100)
	private String usuario;
	
	@NotNull
	@Size(min = 05, max = 100)
	private String senha;
	
	// para utilizar nos testes
	public Usuario() {
		
	}

	// Construtores para utilizar nos testes
	public Usuario(long idUsuario, @NotNull @Size(min = 2, max = 100) String nomeUsuario,
			@NotNull @Size(min = 5, max = 100) String usuario, @NotNull @Size(min = 5, max = 100) String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.usuario = usuario;
		this.senha = senha;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	

}
