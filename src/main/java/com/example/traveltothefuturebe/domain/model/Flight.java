package com.example.traveltothefuturebe.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "flights")
public class Flight {
    @Id
    private String id;
    private BigDecimal price;
    private Instant departureTime;
    private Instant arrivalTime;

    @DBRef
    private AirPort departureAirport;

    @DBRef
    private AirPort arrivalAirport;

}
