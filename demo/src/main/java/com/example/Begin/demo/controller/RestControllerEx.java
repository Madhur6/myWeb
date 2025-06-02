package com.example.Begin.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerEx {
	
	@RequestMapping("/rest-controller")
	public String goToLogin() {
		return "login"; // DO CHECK OUT THE `VIEW-SOURCE` FOR THIS END-POINT ON THE BROWSER😉
	}
}

// ACTUATOR: monitor and manage our app. in production

// provides by-default end-points: health / metrics / beans / mapping / 
// spring-boot-starter-actuator




