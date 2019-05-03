package com.springboot.web.app.api.common.model;

import java.util.List;

import lombok.Data;

@Data
public class Survey {
	private String id;
	private List<Question> questions;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}


}
