package com.example.traveltothefuturebe.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class FlightDTO {
    private BigDecimal price;
    private String airportName;
    private String departureCity;
    private String departureTime;
    private String arrivalCity;
    private String arrivalTime;

}
