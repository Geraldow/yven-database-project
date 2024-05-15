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
import com.certus.yvencrud.services.EventoServicio;

@Controller
@RequestMapping("/eventos")

public class EventoWebController {
	
	@Autowired
	private EventoServicio servicio;
	
	@RequestMapping ("/eventList")
	public String listarEventos (Model model ) {
		List <Evento> listaEventos = servicio.buscarTodo();
		// System.out.println(listaEventos);
		model.addAttribute("listaEventos", listaEventos);
		return "/moduloEventos/eventList"; // file html eventList
	}
	
	@RequestMapping("/nuevo")
	public String nuevoEvento(Model model) {
		Evento evento = new Evento();
		model.addAttribute("evento",evento);
		return "/moduloEventos/eventNew"; // file html eventNew
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearEvento(@ModelAttribute("evento") Evento evento) {
		servicio.crear(evento);
		return "redirect:/eventos/eventList"; // file html eventList
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarEvento(@PathVariable(name= "id") int id) {
		ModelAndView mav= new ModelAndView("/moduloEventos/eventEdit"); // file html eventEdit
		Evento evento= servicio.buscarPorId(id); 
		mav.addObject("evento", evento);
		return mav;
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public  String eliminarEvento(@PathVariable(name = "id") int id) {
		servicio.borrarPorId(id);
		return "redirect:/eventos/eventList";
	}
	
}
