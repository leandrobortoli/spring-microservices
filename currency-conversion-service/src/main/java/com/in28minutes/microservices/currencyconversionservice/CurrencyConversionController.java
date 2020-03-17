package com.in28minutes.microservices.currencyconversionservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class CurrencyConversionController {

    private CurrencyExchangeClient currencyExchangeClient;

    public CurrencyConversionController(CurrencyExchangeClient currencyExchangeClient) {
        this.currencyExchangeClient = currencyExchangeClient;
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = currencyExchangeClient.retrieveExchangeValue(from, to);
        log.info("{}", response);
        return new CurrencyConversionBean(
                response.getId(),
                from,
                to,
                response.getConversionMultiple(),
                quantity,
                quantity.multiply(response.getConversionMultiple()),
                response.getPort());
    }
}
