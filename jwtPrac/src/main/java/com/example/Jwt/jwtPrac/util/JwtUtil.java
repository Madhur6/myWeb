package com.example.Jwt.jwtPrac.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SuppressWarnings("deprecation")
public class JwtUtil {
	private final static String SECRET_KEY = "ThisIsASecretKeyThisIsASecretKeyThisIsASecretKey";
	private final static long EXPIRATION = 48*60*60*1000L;
	
	// JWT
	// Header ------> JWT / AUTHORIZATION <typ, alg>
	// PAYLOAD -----> SUBJECT <name, user, iat, expiration>
	// SIGNATURE ---> ENCODED HEADER & PAYLOAD + SECRET_KEY <e(H) + e(P)>
	
	// token: sadfgnrewaretydhtgasdfgdhgjhngdsadsretrytu
	//         yikhjghfgfdazfxghgjhmnbddqwegjhfdnb365754r
	//        dfghjrerthrteghtyhytrjytyujtyghjtyhgjtetfgd
	
	// request --------------------------> generates the token
	// 
	
	// EXTRACT ------------------------------------------------------------- ⭐
	// PAYLOAD
	// Each key in JWT payload is called as "claim"
	
	// JWT
	

	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
	}
	
	public String extractUsername(String token) {
		Claims claim = extractAllClaims(token);
		return claim.getSubject();
	}
	
	public Date extractExpiry(String token) {
		Claims claim = extractAllClaims(token);
		return claim.getExpiration();
	}
	
	//GENERATION ----------------------------------------------------------- ⭐
	public String generateToken(UserDetails user) {
		return Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.addClaims(new HashMap<>()).setSubject(user.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)).compact();
	}
	
	//VALIDATION ----------------------------------------------------------- ⭐
	public boolean validateToken(String token, UserDetails user) {
		String username = extractUsername(token);
		Date expiry = extractExpiry(token);
		return (username.equals(user.getUsername()) && expiry.after(new Date(System.currentTimeMillis())));
	}
	
	
	public static void main(String[] args) {
		UserDetails user = new User("harry", "123", Set.of(new SimpleGrantedAuthority("ADMIN")));
		
		JwtUtil jwtUtil = new JwtUtil();
		String token = jwtUtil.generateToken(user);
		
		System.out.println(token);
		System.err.println("Username - " + jwtUtil.extractUsername(token));
		System.err.println("Expiration - " + jwtUtil.extractExpiry(token));
		System.err.println("IsValid - " + jwtUtil.validateToken(token, user));
	}
}
















