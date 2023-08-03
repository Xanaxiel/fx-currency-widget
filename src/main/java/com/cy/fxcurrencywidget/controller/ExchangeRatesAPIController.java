package com.cy.fxcurrencywidget.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
@Slf4j
public class ExchangeRatesAPIController {
    private final RestTemplate restTemplate;

    @Value("${app.exchangerates.apiKey}") String apiKey;

    @GetMapping("/symbols")
    public ResponseEntity<?> getSymbols() {
        ResponseEntity<String> response = restTemplate.getForEntity("/symbols?access_key=" + apiKey, String.class);
        log.info("getSymbols {} ",response.getBody());
        return response;
    }
}
