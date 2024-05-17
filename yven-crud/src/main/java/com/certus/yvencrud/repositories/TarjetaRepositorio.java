package com.certus.yvencrud.repositories;
import com.certus.yvencrud.models.Tarjeta;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface TarjetaRepositorio extends CrudRepository<Tarjeta, Integer> {

	@Query (value = "SELECT t FROM Tarjeta t WHERE t.nombreTarjeta=?1")
	public List<Tarjeta> buscarTarjetaPorNombres (String nombreTarjeta);
	
}
