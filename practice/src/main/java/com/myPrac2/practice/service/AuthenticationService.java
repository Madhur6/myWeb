package com.myPrac2.practice.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String name, String password) {
//		System.out.println("name: " + name + " password: " + password);
		boolean isValidName = name.equalsIgnoreCase("name");
		boolean isValidPassword = password.equalsIgnoreCase("password");
		System.out.println("boolean Result: " + (isValidPassword && isValidName));
		return isValidName && isValidPassword;
	}
	
}
