package com.prueba.tokenexercise.controller;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prueba.tokenexercise.model.Token;
import com.prueba.tokenexercise.model.TokenDate;
import com.prueba.tokenexercise.model.UserPass;


@RestController
public class TokenController {
	
	
	@PostMapping(value = "/login")
	private ResponseEntity<Token> getTokenFromLogin( @RequestBody UserPass userPass) throws Exception{
		
		URI url = new URI("http://localhost:8080/token");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<UserPass> requestEntity = new HttpEntity<>(userPass, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Token> resulttoken = restTemplate.postForEntity(url, requestEntity, Token.class);
		
		if(resulttoken.getStatusCode().is2xxSuccessful()) {
			return resulttoken;
		}
		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@GetMapping(value="/get-token")
	private ResponseEntity<TokenDate> getToken(@RequestBody UserPass userPass){
		TokenDate tokenDate = null;
		
		try {
			ResponseEntity<Token> resulttoken = getTokenFromLogin(userPass);
			
			if(resulttoken.getStatusCode().is2xxSuccessful()) {
				tokenDate = new TokenDate();
				tokenDate.setDate(resulttoken.getHeaders().getDate());
				tokenDate.setAuthVivelibreToken(resulttoken.getBody().getToken());
				
				
				return new ResponseEntity<>(tokenDate, HttpStatus.OK);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(tokenDate, HttpStatus.BAD_REQUEST);
			
	}
	
	
	
	
	
	
	
	
	
	
}
