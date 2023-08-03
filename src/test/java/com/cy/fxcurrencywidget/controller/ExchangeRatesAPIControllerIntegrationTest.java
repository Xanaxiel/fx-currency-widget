package com.cy.fxcurrencywidget.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ExchangeRatesAPIControllerIntegrationTest {
//    Buy Currency (Pick from a list of currencies)
//- Buy Amount
//- Sell Currency (Pick from a list of currencies)
//- Sell Amount
//- Display the rate offered
    @Autowired
    private ExchangeRatesAPIController exchangeRatesAPIController;

    @Test
    public void getSymbols() {
        ResponseEntity<?> response = exchangeRatesAPIController.getSymbols();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void buyCurrency() {

    }
    @Test
    public void sellCurrency() {

    }
    @Test
    public void buyAmount() {

    }
    @Test
    public void sellAmount() {

    }
    @Test
    public void getAllRates() {

    }
    @Test
    public void getSelectedRate() {

    }
}
