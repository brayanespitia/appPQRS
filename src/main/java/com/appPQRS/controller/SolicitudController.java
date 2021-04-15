package com.appPQRS.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appPQRS.entity.Solicitud;
import com.appPQRS.service.SolicitudService;

@Controller
@RequestMapping("/solicitud")
public class SolicitudController {
	
	
	@Autowired
	private SolicitudService solicitudService;
	
	
	@GetMapping("/listar")
	public List<Solicitud> listarTodo(){
		return solicitudService.findAll();
		
	}
	
	@GetMapping("/registrar")
	public String crear(Map<String, Object> model) {
		Solicitud solicitud = new Solicitud();
		model.put("solicitud", solicitud);
		model.put("titulo", "formulario solicitud");
		return"registrar";
		
	}

	@PostMapping("/registrar")
	public String guardar(@RequestBody Solicitud solicitud ) {
		solicitudService.save(solicitud);
		return "registrar";
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable (value="id") Long id) {
		
		
		if (id > 0) {
			solicitudService.delete(id);
		}
		
		return "redirect/index";
		
	}
	
	@GetMapping("/consultar")
	public String consultar() {
		
		return "consultar";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
		
	}
	
}
