package com.generation.blog.Pessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // informando que classe POSTAGEM será a entidade da tabela
@Table(name = "postagem") // <nome da minha tabela
public class Postagem {

	@Id // < anotação onde sinaliza que o atributo ID será uma coluna na minha tabela, será do tipo PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// atributo ID da classe POSTAGEM
	private long id;

	@NotNull // < coluna TITULO é do tipo Not Null
	@Size(min = 5, max = 100)
	// atributo TITULO da classe POSTAGEM
	private String titulo;

	@NotNull
	@Size(min = 10, max = 500)
	// atributo TEXTO da classe POSTAGEM
	private String texto;

	@Temporal(TemporalType.TIMESTAMP)
	// atributo DATE da classe POSTAGEM
	private Date date = new java.sql.Date(System.currentTimeMillis());

	private Tema tema;
	@ManyToOne
	@JsonIgnoreProperties("postagem")

	// getters e setters da classe POSTAGEM
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
