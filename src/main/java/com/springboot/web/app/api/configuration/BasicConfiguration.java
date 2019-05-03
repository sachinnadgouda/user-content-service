package com.springboot.web.app.api.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("web.application.api.welcome")
public class BasicConfiguration {

    private String message;

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }



}