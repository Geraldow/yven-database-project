package com.certus.yvencrud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certus.yvencrud.models.User;
import com.certus.yvencrud.services.UserServicio;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServicio userServicio;
	
	@GetMapping
	public ArrayList<User> getUsers() {
		return this.userServicio.getUsers();
	}
	
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return this.userServicio.saveUser(user);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id){
		return this.userServicio.getById(id);
	}
	
	@PutMapping(path = "/{id}")
	public User updateUserById(@RequestBody User request, @PathVariable ("id") Long id) {
		return this.userServicio.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable ("id") Long id) {
		boolean ok = this.userServicio.deleteUser(id);
		
		if (ok) {
			return "User with id "+ id + " deleted!";
		} else {
			return "Error, we have a problem, can't delete a user.";
		}
	}

}
