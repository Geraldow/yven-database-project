package com.certus.yvencrud.services;
import com.certus.yvencrud.models.Evento;
import com.certus.yvencrud.repositories.EventoRepositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class EventoServicio {
	
	@Autowired
	private EventoRepositorio repositorio;
	
	public List<Evento> buscarTodo(){
		return ( List<Evento> ) repositorio.findAll();
	}
	
	public Evento crear(Evento evento) {
		return repositorio.save(evento);
	}
	
	public Evento actualizar(Evento eventoActualizar) {
		Evento eventoActual= repositorio.findById(eventoActualizar.getIdEvento()).get();
		
		eventoActual.setTituloEvento(eventoActual.getTituloEvento());
		
		Evento eventoActualizado = repositorio.save(eventoActualizar);
		return eventoActualizado;
	
	}

	public Evento buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorId(Integer id) {
		repositorio.deleteById(id);
	}
	
}
