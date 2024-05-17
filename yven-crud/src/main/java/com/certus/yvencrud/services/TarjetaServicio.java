package com.certus.yvencrud.services;

import com.certus.yvencrud.models.Tarjeta;
import com.certus.yvencrud.repositories.TarjetaRepositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class TarjetaServicio {
	
	@Autowired
	private TarjetaRepositorio repositorio;
	
	public List<Tarjeta> buscarTodo(){
		return ( List<Tarjeta> ) repositorio.findAll();
	}
	
	public Tarjeta crear(Tarjeta tarjeta) {
		return repositorio.save(tarjeta);
	}
	
	public Tarjeta actualizar(Tarjeta tarjetaActualizar) {
		Tarjeta personaActual= repositorio.findById(tarjetaActualizar.getIdTarjeta()).get();
		
		personaActual.setIdTarjeta(personaActual.getIdTarjeta());
		
		Tarjeta tarjetaActualizada = repositorio.save(tarjetaActualizar);
		return tarjetaActualizada;
	
	}

	public Tarjeta buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorId(Integer id) {
		repositorio.deleteById(id);
	}
	
}
