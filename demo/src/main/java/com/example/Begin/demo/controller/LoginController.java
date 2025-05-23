package com.example.Begin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Begin.demo.service.AuthenticationService;

@Controller
public class LoginController {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@RequestMapping("/hello")
	@ResponseBody // Allow us to return JSON/XML, OTHERWISE IT LOOKS FOR .jsp FILE IN RESOURCES...💡
	public String displayHello() {
		return "Hello-World";
	}
	
	
	@RequestMapping("/welcome")
	public String goToWelcome() {
		return "welcome";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String tryLogin(@RequestParam String name, @RequestParam String password) {
		if (authenticationService.authService(name, password)) {
			return "welcome";
		}
		return "login";
	}
	
}
