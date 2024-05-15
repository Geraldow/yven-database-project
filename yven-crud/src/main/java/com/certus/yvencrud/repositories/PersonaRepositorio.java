package com.certus.yvencrud.repositories;
import com.certus.yvencrud.models.Persona;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PersonaRepositorio extends CrudRepository<Persona, Integer> {

	@Query (value = "SELECT p FROM Persona p WHERE p.numeroDocumento=?1")
	public List<Persona> buscarPersonasPorNumeroDocumento (String numeroDocumento);
}
