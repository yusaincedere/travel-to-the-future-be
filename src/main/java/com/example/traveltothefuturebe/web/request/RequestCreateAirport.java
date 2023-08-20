package com.example.traveltothefuturebe.web.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
public class RequestCreateAirport {
    private String name;
    private String city;
}
