package com.appPQRS.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appPQRS.entity.Solicitud;
import com.appPQRS.entity.Usuario;
import com.appPQRS.service.UsuarioService;


@Controller
public class UsuarioController {

	@Autowired
	public UsuarioService usuarioService;

	@RequestMapping(value = "/registrarUsuario", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", "formulario usuario");
		return "registrarUsuario";

	}

	@RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash) {
		System.out.println("hola papu 2");

		Usuario user = usuarioService.buscarCedula(usuario.getIdentificacion());

		if (user != null) {
			
			flash.addFlashAttribute("warning","La informacion del usuaraio ya se encuntra registrada");
			
			return "redirect:/registrarUsuario";
		}

		if (result.hasErrors()) {

			model.addAttribute("titulo", "formulario usuario");

			System.out.println("hola papu");
			return "index";

		}

		System.out.println("hola papu 3");
		usuarioService.save(usuario);
		flash.addFlashAttribute("success","El usuario se ha registrado con Exito!!");
		return "redirect:/registrarUsuario";
	}
	


}
