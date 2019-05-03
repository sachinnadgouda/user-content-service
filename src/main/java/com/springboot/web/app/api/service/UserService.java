package com.springboot.web.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.api.configuration.BasicConfiguration;
import com.springboot.web.app.api.jpa.UserRepository;
import com.springboot.web.app.api.model.User;

@Service
public class UserService{
	

	@Autowired
	private BasicConfiguration basicConfiguration;
	
	@Autowired
	private UserRepository userRepository;
	
	public String retriveWelcomeMessage() {
		return basicConfiguration.getMessage();
	}
	
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User findById(Long userId) {
		return userRepository.findById(userId).get();
	}

	public User createUser(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}
	
	public Long deleteUser(Long userId) {	
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			return userId;
		}
		return null;
	}
	
}
