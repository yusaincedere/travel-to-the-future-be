package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.domain.dto.FlightDTO;
import com.example.traveltothefuturebe.web.response.DepartureAndArrivalFlights;
import com.example.traveltothefuturebe.web.response.ResponseGetAllFlights;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface FlightController {
    ResponseEntity<ResponseGetAllFlights> getAllFlightsByArrivalCity(String city);

    ResponseEntity<DepartureAndArrivalFlights> getDepartureAndComeBackFlights(String departureCity, LocalDate departureTime,
                                                                                    String arrivalCity, LocalDate comeBackTime);

    ResponseEntity<FlightDTO> getDepartureFlights(String departureCity,LocalDate departureTime,String arrivalCity);


}
