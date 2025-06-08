package com.example.Begin.demo.security;

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

@Configuration  // By default, SB treats these classes as "singleton" 
public class SpringSecurityConfiguration {
	
//	IOC: inversion of control, 
	
//	Bean: singleton
		// By default, fetched eagerly
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		
		http.formLogin(form -> form.defaultSuccessUrl("/todo-list", true));
//		http.formLogin(withDefaults());
		
		http.csrf(csrf -> csrf.disable()); // not for production
		
		http.headers(headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
		
		return http.build();
	}
	
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder().
									passwordEncoder(passwordEncoder)
									.username("harry").password("123")
									.roles("USER", "ADMIN")
									.build();
		
		return new InMemoryUserDetailsManager(userDetails);						
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}




