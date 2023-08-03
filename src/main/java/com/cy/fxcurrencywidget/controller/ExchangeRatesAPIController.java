package com.cy.fxcurrencywidget.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
@Slf4j
public class ExchangeRatesAPIController {
    private final RestTemplate restTemplate;

    @Value("${app.exchangerates.apiKey}") String apiKey;


    @Operation(summary = "Get symbols")
    @GetMapping("/symbols")
    public ResponseEntity<?> getSymbols() {
        ResponseEntity<String> response = restTemplate.getForEntity(UriComponentsBuilder
                .fromPath("/symbols")
                .queryParam("access_key", apiKey)
                .build()
                .toUriString(), String.class);
        log.info("getSymbols {} ",response.getBody());
        return response;
    }

    @Operation(summary = "Convert from one currency to another")
    @GetMapping("/convert")
    public ResponseEntity<?> convert(@RequestParam("from") String from,
                                     @RequestParam("to") String to,
                                     @RequestParam("amount") String amount) throws Exception {
        if (StringUtils.isEmpty(from)) {
            throw new Exception("from currency is required");
        }
        if (StringUtils.isEmpty(to)) {
            throw new Exception("to currency is required");
        }
        if (StringUtils.isEmpty(amount)) {
            throw new Exception("amount is required");
        }
        ResponseEntity<String> response = restTemplate.getForEntity(UriComponentsBuilder
                .fromPath("/convert")
                .queryParam("access_key", apiKey)
                .queryParam("from", from)
                .queryParam("to", to)
                .queryParam("amount", amount)
                .build()
                .toUriString(), String.class);
        log.info("convert {} ",response.getBody());
        return response;
    }

    @Operation(summary = "Get latest rate for currency")
    @GetMapping("/latest/{currency}")
    public ResponseEntity<?> getLatestRate(@PathVariable("currency") String currency) {
        ResponseEntity<String> response = restTemplate.getForEntity(UriComponentsBuilder
                .fromPath("/latest")
                .queryParam("access_key", apiKey)
                .queryParam("symbols", currency)
                .build()
                .toUriString(), String.class);
        log.info("getLatestRate {} ",response.getBody());
        return response;
    }
}
