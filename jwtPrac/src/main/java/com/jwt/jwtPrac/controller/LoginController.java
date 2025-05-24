package com.jwt.jwtPrac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.jwtPrac.model.LoginRequest;
import com.jwt.jwtPrac.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestBody LoginRequest loginRequest){
		return loginService.loginUser(loginRequest);
	}
}
