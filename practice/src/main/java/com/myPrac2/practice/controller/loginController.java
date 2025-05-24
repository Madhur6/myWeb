package com.myPrac2.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myPrac2.practice.service.AuthenticationService;

@Controller
@SessionAttributes("name")
public class loginController {
	
//	@RequestMapping("/login")
//	public String goToLoginPage() {
//		return "login";
//	}
	
	@Autowired
	private AuthenticationService authenticationService;
	
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String goToLoginPage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if (authenticationService.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);	
			return "redirect:list-todo";
//			return "welcome";
		}
		
		return "login";
	}
}