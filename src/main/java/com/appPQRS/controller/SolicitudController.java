package com.appPQRS.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appPQRS.entity.Solicitud;
import com.appPQRS.entity.Usuario;
import com.appPQRS.service.SolicitudService;
import com.appPQRS.service.UsuarioService;

@Controller
@SessionAttributes("solicitud")
@RequestMapping("/solicitud")
public class SolicitudController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private SolicitudService solicitudService;

	@GetMapping("/listar")
	public List<Solicitud> listarTodo() {
		return solicitudService.findAll();

	}

	@GetMapping("/registrar")
	public String crear(Map<String, Object> model) {
		Solicitud solicitud = new Solicitud();
		Usuario usuario = new Usuario();
		model.put("solicitud", solicitud);
		model.put("usuario", usuario);
		model.put("titulo", "enviar");
		return "registrar";

	}

	@PostMapping("/registrar")
	public String guardar(@RequestParam(value = "identificacion") String identificacion, @Valid Solicitud solicitud,
			Usuario usuario, BindingResult result, RedirectAttributes flash, SessionStatus status) {
		System.out.println("prueba test");
		Usuario user = usuarioService.buscarCedula(identificacion);

		// System.out.println("prueba 2 " +
		// usuarioService.buscarCedula(identificacion));
		if (user == null) {

			flash.addFlashAttribute("danger", "La identificacion del usuario no existe en la base de datos debe registrarse primero ");
			System.out.println("prueba 1");
			return "redirect:/solicitud/registrar";

		}
		System.out.println("test " + user.getIdentificacion());

		if (result.hasErrors()) {

			flash.addFlashAttribute("warning", "hubo un error inesperado");
			System.out.println("prueba 2");
			return "redirect:/solicitud/registrar";

		}			

		// System.out.println("prueba 2" + solicitud.getUsuario().getIdentificacion());
		solicitud.setUsuario(user);
		solicitudService.save(solicitud);
		if (solicitud.getRespuesta() !=null) {
			
			return "redirect:/solicitud/listarPQRS";
		}
		
		
		status.setComplete();
	
		flash.addFlashAttribute("success",
				"La PQRS se ha registrado Exitosamente su numero de radicado es :  " + solicitud.getId());
		return "redirect:/solicitud/registrar";

	}

	// EDITAR FORMULARIO PARA ENVIAR PQRS

	@PostMapping("/editar}")
	public String editar(@Valid Solicitud solicitud, Map<String, Object> model, BindingResult result) {
	
		if(result.hasErrors()) {
		System.out.println("hubo un error");
			return "index";
		}

		solicitudService.save(solicitud);
	
		return  "redirect:/solicitud/registrar";

	}

	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		if (id > 0) {
			solicitudService.delete(id);
		}

		else {

			return "redirect/registrar";
		}
		return "redirect/index";

	}

	@GetMapping("/consultar")
	public String consultar() {

		return "consultar";
	}

	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Solicitud solicitud = solicitudService.findOne(id);

		if (solicitud == null) {

			flash.addFlashAttribute("warning", "no PQRS CON ESA id");
			return "redirect:/solicitud/consultar";
			
		}

		Usuario usuario = solicitudService.findUsuarioBySolicitud(solicitud.getUsuario().getId());

		model.put("solicitud", solicitud);
		model.put("usuario", usuario);

		return "detalle";
	}

	@PostMapping("/detalle")
	public String ruta(@RequestParam(value = "solicitudId") @PathVariable(value = "id") Long solicitudId, Long id,
			Model model, RedirectAttributes flash) {
		System.out.println("hola" + solicitudId);

		return "redirect:/solicitud/detalle/" + solicitudId;
	}

	@GetMapping("/listarPQRS")
	public String listar(Model model) {
		
	
		
		model.addAttribute("titulo", "listado de pqrs");
		model.addAttribute("solicitudes", solicitudService.findAll());
		model.addAttribute("usuarios", usuarioService.findAll());
		

		return "main/pqrs";
	}

	@GetMapping("/detallito/{id}")
	public String detallito(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Solicitud solicitud= null;
		
		if(id>0) {
		solicitud = solicitudService.findOne(id);

			if (solicitud == null) {

				flash.addFlashAttribute("warning", "no PQRS CON ESA id");
				return "redirect:/solicitud/consultar";
			}
			
		}
		
	

		Usuario usuario = solicitudService.findUsuarioBySolicitud(solicitud.getUsuario().getId());

		model.put("solicitud", solicitud);
		model.put("usuario", usuario);
		model.put("titulo", "Editar pqrs");

		return "main/detalle";
	}

	@PostMapping("/detallito")
	public String rutica(@RequestParam(value = "solicitudId") @PathVariable(value = "id") Long solicitudId, Long id,
			Model model, RedirectAttributes flash) {
		System.out.println("hola" + solicitudId);

		return "redirect:/solicitud/detallito/" + solicitudId;
	}

}
