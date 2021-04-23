package com.appPQRS.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appPQRS.entity.Solicitud;
import com.appPQRS.entity.Usuario;
import com.appPQRS.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	
	@Autowired
	public UsuarioService usuarioService;
	
	
	@GetMapping("/registrarUsuario")
	public String crear(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", "formulario usuario");
		return"registrarUsuario";
		
	}
	
	@PostMapping("registrar")
	public String guardar (@RequestBody Usuario usuario) {
		
		usuarioService.save(usuario);
		return"redirect/index";
	}
	
	
}
