package com.myPrac2.practice.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecurityConfiguration {
//	If you don't configure SecurityFilterChain, Spring Security will apply its default security, which protects everything by default.
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Require authentication for all HTTP requests
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		
        // Enable form-based login with default settings
		http.formLogin(withDefaults());
		
        // Disable CSRF protection (not recommended for production use)
		http.csrf(csrf -> csrf.disable());
		
        // Disable X-Frame-Options to allow embedding in iframes (use cautiously)
		http.headers(headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
		
		return http.build();
	}
	
	
    /**
     * Creates an in-memory user details manager with predefined user credentials.
     *
     * @return InMemoryUserDetailsManager with a single user.
     */
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		// Lambda function to encode passwords using BCrypt
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		// Creating a user with a username, encoded password, and assigned roles
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username("practice")
				.password("123")
				.roles("USER", "ADMIN")
				.build();
		
		// Returning an in-memory user details manager with the created user
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

