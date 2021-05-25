package com.helloworlddois.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping //("/hello")
public class HelloController {
	
	@RequestMapping (value = "/mentalidades_habilidades")
	@GetMapping 
	public String mentalidades_habilidades() {
		return "Mentalidade: Persistência;\n"
				+ "Habilidade:  Atenção aos detalhes";
	}
	
	@RequestMapping (value = "/objetivo_aprendizagem")
	@GetMapping 
	public String objetivo_aprendizagem() {
		return "Objetivo de aprendizagem: aprender sobre spring";
			
	}
		
}
