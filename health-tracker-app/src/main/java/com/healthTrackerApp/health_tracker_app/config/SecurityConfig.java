package com.healthTrackerApp.health_tracker_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(antMatcher("/"), antMatcher("/login"), antMatcher("/h2-console/**")).permitAll()
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers(antMatcher("/h2-console/**")) 
            )
            .headers(headers -> headers
                .frameOptions(frame -> frame.disable()) 
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/oauth2/authorization/google") 
            )
            
            .logout(logout -> logout
                .logoutUrl("/logout") 
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true) 
                .deleteCookies("JSESSIONID") 
            );

        return http.build();
    }
}
