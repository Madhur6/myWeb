package com.jwt.jwtPrac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.jwtPrac.model.LoginRequest;
import com.jwt.jwtPrac.model.LoginResponse;
import com.jwt.jwtPrac.util.JwtUtil;

@Service
public class LoginService {
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationProvider authenticationProvider;
	
	
	public ResponseEntity<Object> loginUser(LoginRequest loginRequest){
		try {
			UserDetails userDB = userDetailsService.loadUserByUsername(loginRequest.getEmailId());
			
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmailId(), loginRequest.getPassword());
			
			authenticationProvider.authenticate(authenticationToken);
			
			String token = jwtUtil.generateToken(userDB);
			
			return ResponseEntity.ok(new LoginResponse(token));
			
		}
		catch (UsernameNotFoundException exception) {
			return ResponseEntity.status(404).body("User does not exists!");
		}
	}
}
