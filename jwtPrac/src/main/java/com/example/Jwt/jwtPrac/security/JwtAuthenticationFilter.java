package com.example.Jwt.jwtPrac.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.Jwt.jwtPrac.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// Extract authentication header
		String authHeader = request.getHeader("JWT");

		// If the "header" of our token Does not contain the "Bearer_"
		if ((authHeader == null || !authHeader.startsWith("Bearer "))) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String jwtToken = authHeader.substring(7);
		
		String username = jwtUtil.extractUsername(jwtToken);
		
		// The username exists, But not authenticated yet!
		if ((username != null) && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails userDB = userDetailsService.loadUserByUsername(username);
			
			if (userDB != null && jwtUtil.validateToken(jwtToken, userDB)) {
				
				UsernamePasswordAuthenticationToken authenticationToken = new 
						UsernamePasswordAuthenticationToken(userDB, null, userDB.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
			
		}
		
		filterChain.doFilter(request, response);
		
	}
}
