//package com.todoapp.myFirstWebApp.login;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.todoapp.myFirstWebApp.loginAuthenticationService.AuthenticationService;
//
//@Controller
//@SessionAttributes("name")
//public class loginController {
//
//// Autowired
//	private AuthenticationService authenticationService;
//	
//	
//// 4th implementation..............
//	public loginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//		
//	}
//
//	
//	@RequestMapping(value="login", method=RequestMethod.GET)
//	public String goToLoginPage() {
//		return "login";
//	}
//
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		
//		if (authenticationService.authenticate(name, password)) {
//			model.put("name", name);
//			model.put("password", password);
//			return "welcome";	
//		}
//		return "login";
//	}
//	
//	
//	
//// 1st implementation..............
////	@RequestMapping("login")
////	public String goToLoginPage() {
////		return "login";
////	}
//
//	
//// 2nd implementation..............
////	@RequestMapping("login")
////	public String goToLoginPage(@RequestParam String name, ModelMap model) {
////		model.put("name", name);
////		System.out.println("Request param is " + name); // Not for production level product...
////		return "login";
////	}
//	
//	
//// 3rd implementation..............
////		@RequestMapping(value="login", method=RequestMethod.GET)
////		public String goToLoginPage() {
////			return "login";
////		}
////		// But just using the above code will throw an error["POST" is not supported], So we need to create a post method
////		
////		@RequestMapping(value="login", method=RequestMethod.POST)
////		public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
////			model.put("name", name);
////			model.put("password", password);
////			return "welcome";
////		}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
