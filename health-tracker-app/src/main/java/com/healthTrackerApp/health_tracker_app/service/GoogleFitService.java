package com.healthTrackerApp.health_tracker_app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import java.util.Map;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
public class GoogleFitService {

    private static final String GOOGLE_FIT_URL = "https://www.googleapis.com/fitness/v1/users/me/dataset:aggregate";

    private final OAuth2AuthorizedClientService authorizedClientService;

    public GoogleFitService(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }

    public Map<String, Object> fetchFitData(OAuth2AuthorizedClient authorizedClient) {
        if (authorizedClient == null || authorizedClient.getAccessToken() == null) {
            return Map.of("error", "Access token is missing or invalid.");
        }

        String accessToken = authorizedClient.getAccessToken().getTokenValue();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

      
        long endTimeMillis = Instant.now().toEpochMilli();
        long startTimeMillis = endTimeMillis - 86400000; 

        String requestBody = String.format("""
        {
            "aggregateBy": [{
                "dataTypeName": "com.google.step_count.delta"
            }],
            "bucketByTime": { "durationMillis": 86400000 },
            "startTimeMillis": %d,
            "endTimeMillis": %d
        }
        """, startTimeMillis, endTimeMillis);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    GOOGLE_FIT_URL, HttpMethod.POST, entity, Map.class
            );
            return response.getBody();
        } catch (Exception e) {
            return Map.of("error", "Failed to fetch data from Google Fit: " + e.getMessage());
        }
    }
}



