package com.example.Begin.demo.security;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;

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

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		//	If you don't configure SecurityFilterChain, Spring Security will apply its default security, which protects everything by default.

		// Require authentication for all HTTP requests
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		
		// Enable form-based login with default settings
		http.formLogin(form -> form.defaultSuccessUrl("/todo-list", true));
//		http.formLogin(withDefaults());
		
        // Disable CSRF protection (not recommended for production use)
		http.csrf(csrf -> csrf.disable());
		
		// Disable X-Frame-Options to allow embedding in iframes (use cautiously)
		http.headers(headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
		// X-Frame-Options is an HTTP response header used to control whether a webpage can be embedded inside an <iframe>. 
		// it helps prevent clickjacking attacks, where a malicious site could embed your site in a hidden or disguised iframe to 
		// trick users into clicking things they didn’t intend to.
        // ⭐Risks (why it's dangerous):
        // 1). it opens your app up to clickjacking attacks.
        // 2). if users are logged in, malicious sites could trick them into performing actions (like clicking buttons) without their knowledge.

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




