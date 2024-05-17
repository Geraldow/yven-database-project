package com.certus.yvencrud.services;

import com.certus.yvencrud.models.Persona;
import com.certus.yvencrud.repositories.PersonaRepositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class PersonaServicio {
	
	@Autowired
	private PersonaRepositorio repositorio;
	
	public List<Persona> buscarTodo(){
		return ( List<Persona> ) repositorio.findAll();
	}
	
	public Persona crear(Persona persona) {
		return repositorio.save(persona);
	}
	
	public Persona actualizar(Persona personaActualizar) {
		Persona personaActual= repositorio.findById(personaActualizar.getNumeroDocumento()).get();
		
		personaActual.setNumeroDocumento(personaActual.getNumeroDocumento());
		
		Persona personaActualizado = repositorio.save(personaActualizar);
		return personaActualizado;
	}

	public Persona buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorId(Integer id) {
		repositorio.deleteById(id);
	}
	
}
