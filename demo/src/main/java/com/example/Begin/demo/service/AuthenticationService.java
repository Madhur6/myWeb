package com.example.Begin.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authService(String name, String password) {
		boolean validName = name.equals("name");
		boolean validPassword = password.equals("123");
		return validName && validPassword;
	}
}
