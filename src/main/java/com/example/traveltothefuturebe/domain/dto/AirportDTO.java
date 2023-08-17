package com.example.traveltothefuturebe.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class AirportDTO {
    private String id;
    private String city;
    private String name;
}
