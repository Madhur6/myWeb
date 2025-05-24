package com.prac.myPrac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller  // Transforms this class into a "bean"
//@RestController // If we use RestController, We don't need to use "@ResponseBody" to return JSON or XML response... 
public class HelloController {
	@RequestMapping("hello-world")
	@ResponseBody
	public String sayHello() {
		return "Hello, World!";
	}
	
	
	@RequestMapping("hello-html")
	@ResponseBody
	public String sayHelloHTML() {
		StringBuffer sb = new StringBuffer(); // Because we need to append data...
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first html page! (edited) </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html body content! (edited) ");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	
	@RequestMapping("hello-jsp")
	public String sayHelloJSP() {
		return "sayHello";
	}
}
