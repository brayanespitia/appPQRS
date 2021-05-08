package com.appPQRS.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appPQRS.entity.Solicitud;
import com.appPQRS.entity.Usuario;
import com.appPQRS.service.SolicitudService;
import com.appPQRS.service.UsuarioService;

@Controller
@RequestMapping("/solicitud")
public class SolicitudController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
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
	public String guardar(@Valid Solicitud solicitud,Usuario usuario, RedirectAttributes flash ) {
		
		Usuario user = usuarioService.buscarCedula(usuario.getIdentificacion());
		if(user !=null){
			
			flash.addFlashAttribute("danger","La identificacion del usuario no existe en la base de datos");
			
			 return "redirect:/solicitud/registrar";
			
		}
		
		System.out.println("prueba 2" + solicitud.getUsuario().getIdentificacion());
		
		
		solicitudService.save(solicitud);
		
		
		flash.addFlashAttribute("succes", "La PQRS se ha registrado Exitosamente");
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
	
	
	@GetMapping("/detalle")
	public String detalle() {
		
		return "detalle";
	}

	

	
}
