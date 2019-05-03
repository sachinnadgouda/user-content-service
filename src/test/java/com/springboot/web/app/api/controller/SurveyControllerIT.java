package com.springboot.web.app.api.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.web.app.api.Application;
import com.springboot.web.app.api.common.glue.CommonWorld;
import com.springboot.web.app.api.common.model.Survey;;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

	@LocalServerPort
	private int port;
	
	@Autowired
    private CommonWorld world;

	@Test
	public void testRetrieveSurveyQuestion() {

		String surveyId = "1";
		String QuestionId = "1";
		
		String url = "http://localhost:" + port
				+ "/surveys/" + surveyId +"/questions/" + QuestionId;

		TestRestTemplate restTemplate = new TestRestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(url,
				HttpMethod.GET, entity, String.class);
		world.setResponseEntity(response);
		Survey surveyDetails = world.getResponseAsObject(Survey.class);
		assertEquals(surveyId, surveyDetails.getId());
		System.out.println(surveyDetails.getQuestions());

	}

}


