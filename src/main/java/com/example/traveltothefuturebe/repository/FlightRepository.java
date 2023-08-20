package com.example.traveltothefuturebe.repository;

import com.example.traveltothefuturebe.domain.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;
import java.util.List;


public interface FlightRepository extends MongoRepository<Flight,String> {

    List<Flight> findAllByArrivalAirportCityAndDepartureAirportCityAndDepartureTimeBetween(String arrivalCity,String departureCity,
                                                                                           Instant startDate,Instant endDate);

}
