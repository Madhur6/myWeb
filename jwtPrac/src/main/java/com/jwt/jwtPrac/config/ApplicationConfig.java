package com.jwt.jwtPrac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jwt.jwtPrac.repo.UserRepo;

@Configuration
public class ApplicationConfig {
//	
//	@Autowired
//	UserRepo userRepo;
//	
//	@Bean
//	UserDetailsService userDetailsService() {
//		return username -> userRepo.findByEmail(username)
//								.orElseThrow(() -> new UsernameNotFoundException("User is not found!"));
//	}
	
	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
//	@Bean
//	UserDetailsService userDetailsService() {
//		return username -> userRepo.findByEmail(username)
//							.orElseThrow(() -> new UsernameNotFoundException("User is not found!"));
//	}
	
	
	@Autowired
	UserRepo userRepo;
	
	@Bean
	PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		// This class works with DB
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setPasswordEncoder(encoder());
		
		authProvider.setUserDetailsService(userDetailsService);
		
		return authProvider;
	}
	
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

}
