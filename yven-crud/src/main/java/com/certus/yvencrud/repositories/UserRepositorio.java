package com.certus.yvencrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certus.yvencrud.models.User;

@Repository
public interface UserRepositorio extends JpaRepository<User, Long>{
	 
	
	
}
