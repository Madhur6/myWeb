package com.jwt.jwtPrac.model;

public class LoginResponse {
	private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public LoginResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	
}
