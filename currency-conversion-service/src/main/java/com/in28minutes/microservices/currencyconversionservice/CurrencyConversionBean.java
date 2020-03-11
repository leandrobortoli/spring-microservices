package com.in28minutes.microservices.currencyconversionservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionBean {
    @NonNull
    private Long id;
    @NonNull
    private String from;
    @NonNull
    private String to;
    @NonNull
    private BigDecimal conversionMultiple;
    @NonNull
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    @NonNull
    private int port;
}
