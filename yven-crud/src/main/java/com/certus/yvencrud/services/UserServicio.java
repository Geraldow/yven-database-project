package com.certus.yvencrud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.certus.yvencrud.models.User;
import com.certus.yvencrud.repositories.UserRepositorio;

@Service
public class UserServicio {
	
	@Autowired
	UserRepositorio userRepositorio;
	public ArrayList<User> getUsers(){
		return (ArrayList<User>) userRepositorio.findAll();
	}
	
	//Guardar Usuario
	
	public User saveUser(User user) {
		return userRepositorio.save(user);
	}
	
	// Obtener usuario atravez de un ID
	
	public Optional<User> getById(Long id){
		return userRepositorio.findById(id);
	}
	
	public User updateById(User request, Long id) {
	    Optional<User> optionalUser = userRepositorio.findById(id);
	    
	    if (optionalUser.isPresent()) {
	        User user = optionalUser.get();
	        user.setNombreUsuario(request.getNombreUsuario());
	        user.setContrasena(request.getContrasena());
	        user.setCorreoElectronico(request.getCorreoElectronico());
	        
	        return userRepositorio.save(user); // Guardar cambios en la base de datos
	    } else {
	        // Manejar el caso donde el usuario no existe
	        throw new IllegalArgumentException("User not found with id: " + id);
	    }
	}

	
	public Boolean deleteUser (Long id) {
		try {
			userRepositorio.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
