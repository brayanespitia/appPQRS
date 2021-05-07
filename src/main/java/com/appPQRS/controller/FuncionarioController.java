package com.appPQRS.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	
	
	
	@GetMapping("/log")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash) {
		System.out.println("hola papu");

		
		if (principal !=null) {
			flash.addFlashAttribute("info", "ya ha iniciado sesion");
			return "redirect:/" ;
	
		}
		
		
	
		
		
		if (error != null) {
			model.addAttribute("warning", "Error al iniciar sesion clave o usuario paila");
		}
		if(logout !=null) {
			
			model.addAttribute("success", "cerraste sesion con exito");
			
		}
		
	
		
		System.out.println("hola papu 2");
		
		return"login";
	}
	
	
		
	
	
	@PostMapping("/log")
	public String logeo(BindingResult result, Model model) {
		
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			System.out.println("hola papu 4");
			return "/";
		}
		
		System.out.println("hola papu 3");
		return "main/index";
	}
	
	
	
	
	@PostMapping("/loge")
	public String logear( Principal principal) {
		
		return "main/index";
	}
	
}
