package com.mariana.parcialDos.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mariana.parcialDos.service.ProductoService;

@RestController
@RequestMapping("/api/v1")
public class SaludoController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	ProductoService productoService;

	@GetMapping("/saludo2")
	public String obtenerSaludo() {

		return "¡Hola, API RESTful!";
	}

	@GetMapping("/saludo")
	public String obtenerSaludo(@RequestHeader(name = "Accept-Language", required = false) String language) {
		Locale locale = (language != null) ? Locale.forLanguageTag(language) : Locale.getDefault();
		String saludos = messageSource.getMessage("saludo", null, locale);

		return saludos;
	}

}
