package com.cy.fxcurrencywidget.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

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
        is200OKResponse(response);
    }

    @Test
    public void convert() throws Exception {
        ResponseEntity<?> response = exchangeRatesAPIController.convert("USD", "JPY", "25");
        is200OKResponse(response);
    }
    @Test
    public void convertWithExceptionMissingAmount() {
        assertThrows(
                Exception.class,
                () -> exchangeRatesAPIController.convert("USD", "JPY", ""));
    }
    @Test
    public void convertWithExceptionMissingFrom() {
        assertThrows(
                Exception.class,
                () -> exchangeRatesAPIController.convert("", "JPY", "25"));
    }
    @Test
    public void convertWithExceptionMissingTo() {
        assertThrows(
                Exception.class,
                () -> exchangeRatesAPIController.convert("USD", "", "25"));
    }
    @Test
    public void getLatestForCurrency() {
        ResponseEntity<?> response = exchangeRatesAPIController.getLatestRate("USD");
        is200OKResponse(response);
    }

    private static void is200OKResponse(ResponseEntity<?> response) {
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
