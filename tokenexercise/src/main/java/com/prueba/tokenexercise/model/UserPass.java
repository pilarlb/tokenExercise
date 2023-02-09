package com.prueba.tokenexercise.model;

import org.springframework.stereotype.Component;

@Component
public class UserPass {
	
	private String username;
	private String password;
	
	
	public UserPass() {
		super();
	}
	
	

	public UserPass(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
