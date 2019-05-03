package com.springboot.web.app.api.common.glue;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class CommonWorld {

    @Autowired
    private ObjectMapper objectMapper;


    public ResponseEntity<String> getResponseEntity() {
		return responseEntity;
	}

	public void setResponseEntity(ResponseEntity<String> responseEntity) {
		this.responseEntity = responseEntity;
	}

	private ResponseEntity<String> responseEntity;

    public <T> T getResponseAsObject(final Class<T> type) {
        try {
            return objectMapper.readValue(getResponseEntity().getBody(), type);
        } catch (IOException e) {
            throw new BadResponseException(e);
        }
    }
    
    public void reset() {
        setResponseEntity(null);
    }

}