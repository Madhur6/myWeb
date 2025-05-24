package com.todoapp.myFirstWebApp.hello;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Transforms this class into a "bean"
public class HelloController {
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello, World";
	}
	
	
	// Not an efficient approach...
	@RequestMapping("say-hello-html")
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
	
	
	// Redirect to a JSP using Spring boot - Controller, @ResponseBody and view resolver
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
