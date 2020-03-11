package com.in28minutes.microservices.currencyexchangeservice;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@RequiredArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ExchangeValue {

    @Id
    @NonNull
    private Long id;
    @NonNull
    @Column(name = "currency_from")
    private String from;
    @NonNull
    @Column(name = "currency_to")
    private String to;
    @NonNull
    private BigDecimal conversionMultiple;
    @Setter
    private int port;
}
