package com.springboot.web.app.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	protected UserNotFoundException() {
		
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
	

}
