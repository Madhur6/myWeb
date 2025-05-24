package com.prac.myPrac.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String name, String password) {
		boolean isValidName = name.equalsIgnoreCase(name);
		boolean isValidPassword = password.equalsIgnoreCase(password);
		
		return isValidName && isValidPassword;
	}
}
