package com.myPrac2.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class HelloController {
	
	@RequestMapping("/greet")
	@ResponseBody
	public String sayHello() {
		return "Hello-World";
	}
	
	
	@RequestMapping("/jsp")
	public String sayHelloJsp() {
		return "welcome";
	}
}
