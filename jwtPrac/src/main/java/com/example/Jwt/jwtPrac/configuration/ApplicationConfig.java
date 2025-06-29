package com.example.Jwt.jwtPrac.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Jwt.jwtPrac.repo.UserRepo;

@Configuration
public class ApplicationConfig {
    @Autowired
	UserRepo userRepo;
	
	@Bean
	UserDetailsService userDetailsService(){
		return username -> userRepo.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User is not found!"));
	}
}

// Our user is already identified by the spring-framework
// Our service-layer should have a Interface to interact with User
// So there is a default Interface called -> "UserDetailsService"
// loadUserByUsername()


// Another method:
// 1). Create a bean of type "UserDetailsService"
// 2). Spring Security will look for a bean of type "UserDetailsService" 
//       during configuration ------> Where it figures out --> How to load users 
// 3). Instead of creating entire "UserService" class, What we did?
//           --> We created the bean, Which is essentially the same thing.
//			 --> Since it is a bean, Spring can autowire it whenever it wants

// 
//
//UserDetailsService obj = new UserDetailsService() {
//	public UserDetails loadUserByUsername(String username) {
//		return userRepo.findByEmail(username).orElseThrow(new UsernameNotFoundException("User is not found!"));
//	}
//}










