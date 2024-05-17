package com.certus.yvencrud.controllers;

import java.util.List;

import com.certus.yvencrud.models.Tarjeta;
import com.certus.yvencrud.services.TarjetaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/tarjetas")

public class TarjetaWebController {
	
	@Autowired
	private TarjetaServicio servicio;
	
	@RequestMapping ("/cardList")
	public String listarTarjetas ( Model model ) {
		List <Tarjeta> listaTarjetas = servicio.buscarTodo();
		
		model.addAttribute("listaTarjetas", listaTarjetas);
		return "/moduloTarjetas/cardList"; // file html cardList
	}
	
	@RequestMapping("/nuevo")
	public String nuevaTarjeta ( Model model ) {
		Tarjeta tarjeta = new Tarjeta();
		model.addAttribute("tarjeta", tarjeta);
		return "/moduloTarjetas/cardNew"; // file html cardtNew
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearTarjeta ( @ModelAttribute ( "tarjeta" ) Tarjeta tarjeta) {
		servicio.crear(tarjeta);
		return "redirect:/tarjetas/cardList"; // file html cardList
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarTarjeta (@PathVariable(name= "id") int id) {
		ModelAndView mav = new ModelAndView("/moduloTarjetas/cardEdit"); // file html eventEdit
		Tarjeta tarjeta = servicio.buscarPorId(id); 
		mav.addObject("tarjeta", tarjeta);
		return mav;
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public  String eliminarTarjeta(@PathVariable(name = "id") int id) {
		servicio.borrarPorId(id);
		return "redirect:/tarjetas/cardList";
	}
	
}
