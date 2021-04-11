package com.appPQRS.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appPQRS.entity.Solicitud;
import com.appPQRS.service.SolicitudService;

@Controller
@RequestMapping("/index")
public class SolicitudController {
	
	
	@Autowired
	private SolicitudService solicitudService;
	
	
	@GetMapping("/listar")
	public List<Solicitud> listarTodo(){
		return solicitudService.findAll();
		
	}
	
	@GetMapping("/guardar")
	public String crear(Map<String, Object> model) {
		Solicitud solicitud = new Solicitud();
		model.put("solicitud", solicitud);
		model.put("titulo", "formulario solicitud");
		return"form";
		
	}

	@PostMapping("/guardar")
	public String guardar(@RequestBody Solicitud solicitud ) {
		solicitudService.save(solicitud);
		return "redirect:index";
		
	}
	
}
