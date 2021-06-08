package com.appPQRS.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash) {
		
		
		if (principal !=null) {
			flash.addFlashAttribute("info", "ya ha iniciado sesion");
			return "redirect:/funcionario/loge";
		}
		if (error != null) {
			model.addAttribute("danger", "Error al iniciar sesion clave o usuario incorrectos");
		}
		if(logout !=null) {
			
			model.addAttribute("info", "cerraste sesion con exito");
			
		}
		return"login";
	}
	
}
