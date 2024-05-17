package com.certus.yvencrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.certus.yvencrud.models.Evento;
import com.certus.yvencrud.models.Persona;
import com.certus.yvencrud.services.EventoServicio;
import com.certus.yvencrud.services.PersonaServicio;

@Controller
@RequestMapping("/personas")

public class PersonaWebController {
	
	@Autowired
	private PersonaServicio servicio;
	
	@RequestMapping ("/personList")
	public String listarPersonas(Model model ) {
		List <Persona> listaPersonas = servicio.buscarTodo();
		
		model.addAttribute("listaPersonas", listaPersonas);
		return "/moduloPersonas/personList"; // file html personList
	}
	
	@RequestMapping("/nuevo")
	public String nuevaPersona(Model model) {
		Persona persona = new Persona();
		model.addAttribute("persona",persona);
		return "/moduloPersonas/personNew"; // file html personNew
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearPersona(@ModelAttribute("persona") Persona persona) {
		servicio.crear(persona);
		return "redirect:/personas/personList"; // file html personList
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarPersona(@PathVariable(name= "id") int id) {
		ModelAndView mav= new ModelAndView("/moduloPersonas/personEdit"); // file html eventEdit
		Persona persona= servicio.buscarPorId(id); 
		mav.addObject("persona", persona);
		return mav;
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public  String eliminarEvento(@PathVariable(name = "id") int id) {
		servicio.borrarPorId(id);
		return "redirect:/eventos/eventList";
	}
	
}
