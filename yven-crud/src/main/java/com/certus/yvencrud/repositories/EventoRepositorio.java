package com.certus.yvencrud.repositories;
import com.certus.yvencrud.models.Evento;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface EventoRepositorio extends CrudRepository<Evento, Integer> {

	@Query (value = "SELECT e FROM Evento e WHERE e.tituloEvento=?1")
	public List<Evento> buscarEventosPorTitulo (String titulo);
	
}
