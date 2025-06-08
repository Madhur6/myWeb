package com.example.Begin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Begin.demo.service.AuthenticationService;

@Controller
@SessionAttributes("name")
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
//	
//	request (get method) ---------->   server (response (200 ok) page)
//	client               <---page----  server
//	page (post method) ------------>   server (201 created 200 ok) 5xx
//	4xx
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String tryLogin(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if (authenticationService.authService(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "redirect:todo-list";
		}
		
		return "login";
	}// Model
	// ModelMap: 
	// ModelAndView
	
	
	
	// Dispatcher-Servlet: Front-Controller, Any request is going to come into our website, The FC is going to stand in b/w
//							and is going to accept these requests.
//						   Makes the decision that who is the right controller to handle this request.
	
	
	// Request [Header] ------> DS ----------> SpringSecurity/FilterChain ---------> Controller
									// [HttpSecurityFilterChain ---> HttpSecurity.build()]
	
	

}









