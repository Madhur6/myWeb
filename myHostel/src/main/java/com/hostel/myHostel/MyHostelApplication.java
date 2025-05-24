package com.hostel.myHostel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyHostelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyHostelApplication.class, args);
	}

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://10.0.2.2:8080")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
	
}
