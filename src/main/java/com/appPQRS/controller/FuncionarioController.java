package com.appPQRS.controller;

import java.security.Principal;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appPQRS.entity.Funcionario;
import com.appPQRS.service.FuncionarioService;
import com.appPQRS.service.SolicitudService;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	public FuncionarioService funcionarioService;
	
	public SolicitudService solicitudservice;
	
	/*
	@GetMapping("/log")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash) {
	

		
		if (principal !=null) {
			flash.addFlashAttribute("info", "ya ha iniciado sesion");
			return "redirect:/funcionario/loge" ;
	
		}
		
		
		if (error != null) {
			model.addAttribute("warning", "Error al iniciar sesion clave o usuario paila");
		}
		if(logout !=null) {
			
			model.addAttribute("success", "cerraste sesion con exito");
			
		}
		
	
	
	
		
		return"login";
	}
			*/
	
	@GetMapping("/home")
	public String logeo(BindingResult result, Model model) {
		
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
		
			return "/";
		}
		
		
		return "main/index";
	}
	
	
	
	
	@GetMapping("/loge")
	public String logear( Principal principal) {
		
		return "main/index";
	}
	
	@GetMapping("/pqrs")
	public String pqrs( Principal principal) {
		
		return "main/pqrs";
	}
	
	
	
	@GetMapping("/listar")
	public String listar( Principal principal) {
		
		return "main/funcionarios";
	}
	

	@GetMapping("/tipoSolicitud")
	public String tipoSolicitud( Principal principal) {
		
		return "main/tipos_solicitudes";
	}
	

	@GetMapping("/tipoUsuario")
	public String tipoUsuario( Principal principal) {
		
		return "main/tipos_usuarios";
	}
	
	@GetMapping("/reporte")
	public String reporte( Principal principal) {
		
		return "main/general_reporte";
	}
	
	
	@GetMapping("/registrar")
	public String crear(Map<String, Object> model) {
		
		Funcionario  funcionario = new Funcionario();
		model.put("funcionario", funcionario);
		model.put("titulo", "formulario funcionario");
		
		
		return "main/registrar_funcionario";
	}
	
	@PostMapping("/registrar")
	public String guardar(@Valid Funcionario funcionario, Model model, RedirectAttributes flash) {
		
		
		funcionarioService.save(funcionario);
		flash.addFlashAttribute("success","El usuario se ha registrado con Exito!!");
		return "redirect:/funcionario/registrar";
	}
	
	
	
@GetMapping("/registroTiposolicitud")
public String tipoSolicitud() {
	
	return "main/registrar_tipo_solicitud";
}
	
}
