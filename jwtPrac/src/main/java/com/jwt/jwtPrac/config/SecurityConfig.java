package com.jwt.jwtPrac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.jwtPrac.security.JwtAuthenticationFilter;


@Configuration
public class SecurityConfig {
	
	@Autowired
	AuthenticationProvider authenticationProvider;
	
	@Autowired
	JwtAuthenticationFilter jwtAuthenticationFilter;
	
	
	private final String[] WHITE_LIST_URLS = {"/login"}; 
//	
//	private static final String[] WHITE_LIST_URLS = {
//		    "/login",
//		    "/swagger-ui/**",
//		    "/v3/api-docs/**",
//		    "/swagger-ui.html"
//		};
	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(csrf -> csrf.disable());

		httpSecurity.sessionManagement(
				sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		httpSecurity.authenticationProvider(authenticationProvider);
		
		httpSecurity.authorizeHttpRequests(
				httpConfig -> {
					httpConfig.requestMatchers(WHITE_LIST_URLS).permitAll().anyRequest().authenticated();
		});
		
		return httpSecurity.build();
	}
}





