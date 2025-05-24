package com.jwt.jwtPrac.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.jwt.jwtPrac.repo.UserRepo;
import com.jwt.jwtPrac.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
@SuppressWarnings("deprecation")
public class JwtUtil {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserService userService;
	
	private static final String SECRET_KEY = "ThisIsASecretKeyThisIsASecretKeyThisIsASecretKey";
	
	private static final long EXPIRATION = 24 * 60 * 60 * 1000l;
	
	
	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
	}
	
	public String extractUsername(String token) {
		Claims claims = extractAllClaims(token);
		return claims.getSubject();
	}
	
	public Date extractExpiry(String token) {
		Claims claims = extractAllClaims(token);
		return claims.getExpiration();
	}
	
	
	public boolean validateToken(String token, UserDetails user) {
		String username = extractUsername(token);
		Date expiry = extractExpiry(token);
		
		return ((username.equalsIgnoreCase(user.getUsername())) && expiry.after(new Date(System.currentTimeMillis())));
	}
	
	public String generateToken(UserDetails user) {
		return Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET_KEY).addClaims(new HashMap<>())
				.setSubject(user.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)).compact();
	}
	
	
	public static void main(String[] args) {
		JwtUtil jwtUtil = new JwtUtil();
		UserDetails user = new User("harry", "123", Set.of(new SimpleGrantedAuthority("ADMIN")));
		
		String token = jwtUtil.generateToken(user);
		
		System.err.println("Token - " + token);
		System.err.println("Token - " + jwtUtil.extractUsername(token));
		System.err.println("Token - " + jwtUtil.extractExpiry(token));
		System.err.println("Token - " + jwtUtil.validateToken(token, user));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
