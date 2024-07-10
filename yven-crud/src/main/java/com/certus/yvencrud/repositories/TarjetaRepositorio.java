package com.certus.yvencrud.repositories;
import com.certus.yvencrud.models.Tarjeta;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface TarjetaRepositorio extends CrudRepository<Tarjeta, Integer> {

	
}
