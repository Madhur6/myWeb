package com.prac.myPrac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.prac.myPrac.service.AuthenticationService;

@Controller
@SessionAttributes("name")
public class loginController {
	
//  method-I-----------------------------------------------------------------------
//	@RequestMapping("login2")
//	public String goToLoginPage() {
//		return "login";
//	}
	
	
//  method-II---------------------------------------------------------------------
//	@RequestMapping(value="login2", method=RequestMethod.GET)
//	public String goToLoginPage(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		System.out.println("Request param is " + name); // Not for production level product...
//		return "login";
//	}
	
	
//  method-III--------------------------------------------------------------------
//	@RequestMapping(value="login2", method=RequestMethod.GET)
//	public String goToLoginPage() {
//		return "login";
//	}
//	
//	@RequestMapping(value="login2", method=RequestMethod.POST)
//	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		model.put("name", name);
//		model.put("password", password);
//		return "welcome";
//	}
	
	
	
// method-IV--------------------------------------------------------------------
	@Autowired
	private AuthenticationService authenticationService;
    public loginController(AuthenticationService authenticationService) {
		super();
	    this.authenticationService = authenticationService;
    }
    
    @RequestMapping(value="login2", method=RequestMethod.GET)
    public String goToLoginPage() {
    	return "login";
    }
    
    
    @RequestMapping(value="login2", method=RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
    	if (authenticationService.authenticate(name, password)) {
    		model.put("name", name);
    		model.put("password", password);
    		return "welcome";
    	}
    	return "login";
    }
    
	
	
}
