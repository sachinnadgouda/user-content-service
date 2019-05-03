package com.springboot.web.app.api.common.model;

import lombok.Data;

@Data
public class Question {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
