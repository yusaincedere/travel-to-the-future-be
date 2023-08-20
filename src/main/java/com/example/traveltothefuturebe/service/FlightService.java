package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.web.response.DepartureAndArrivalFlights;

import java.time.LocalDate;
import java.util.List;

public interface FlightService{
    DepartureAndArrivalFlights getDepartureAndComeBackFlights(String departureCity, LocalDate departureTime, String arrivalCity, LocalDate comeBackTime);
}
