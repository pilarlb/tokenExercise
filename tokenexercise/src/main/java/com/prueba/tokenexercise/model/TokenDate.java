package com.prueba.tokenexercise.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class TokenDate {
	
	@JsonProperty("auth-vivelibre-token")
	private String authVivelibreToken;
	@JsonFormat(pattern="MMMM dd, yyyy")
	private Date date;
	
	
	public TokenDate() {
		super();
	}
	
	
	public String getAuthVivelibreToken() {
		return authVivelibreToken;
	}
	public void setAuthVivelibreToken(String authVivelibreToken) {
		this.authVivelibreToken = authVivelibreToken;
	}


	public Date getDate() {
		return date;
	}

	
	public void setDate(Long date) {
		Date newdate = new Date (date);
	
		this.date = newdate;
	}
	
	
	

}
