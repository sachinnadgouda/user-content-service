package com.springboot.web.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.app.api.exception.UserNotFoundException;
import com.springboot.web.app.api.model.User;
import com.springboot.web.app.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/welcome")
	public String welcomeUser() {
		return userService.retriveWelcomeMessage();
	}
	
	@GetMapping("/users")
	public Iterable<User> getAllUser() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable Long userId) {
		User user = userService.findById(userId);
		if(user == null) {
			throw new UserNotFoundException("id" + userId);
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User newUser = userService.createUser(user);
		if(newUser == null) {
			throw new RuntimeException("User not created");
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		Long deletedUser = userService.deleteUser(userId);
		if(deletedUser == null) {
			throw new RuntimeException("User not deleted");
		}
	}

}

