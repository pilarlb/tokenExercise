package com.prueba.tokenexercise.model;

import org.springframework.stereotype.Component;

@Component
public class Token {

	private String token;
	

	public Token() {
		super();
	}

	public Token(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
