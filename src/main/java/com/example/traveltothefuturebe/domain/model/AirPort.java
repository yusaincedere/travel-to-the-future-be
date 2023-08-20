package com.example.traveltothefuturebe.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "airports")
@SuperBuilder
public class AirPort {

    @Id
    private String id;
    private String name;
    private String city;

    @DBRef
    private List<Flight> departingFlights;

    @DBRef
    private List<Flight> arrivingFlights;
}
