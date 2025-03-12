package com.healthTrackerApp.health_tracker_app.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.healthTrackerApp.health_tracker_app.service.GoogleFitService;

import java.util.Map;



@Controller
public class UserController {

    private final OAuth2AuthorizedClientService authorizedClientService;
    private final GoogleFitService googleFitService;

    public UserController(OAuth2AuthorizedClientService authorizedClientService, GoogleFitService googleFitService) {
        this.authorizedClientService = authorizedClientService;
        this.googleFitService = googleFitService;
    }
    


    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal OidcUser principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }

        String username = principal.getName();
        model.addAttribute("username", username);

        
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                "google", principal.getName()
        );

        if (client == null || client.getAccessToken() == null) {
            model.addAttribute("error", "Access token not found. Please reauthorize.");
            return "dashboard"; 
        }

        // Fetch Google Fit data
        Map<String, Object> stepData = googleFitService.fetchFitData(client);
        model.addAttribute("stepData", stepData);

        return "dashboard"; 
    }
}


