package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.common.URLConstants;
import com.example.traveltothefuturebe.domain.dto.FlightDTO;
import com.example.traveltothefuturebe.service.FlightService;
import com.example.traveltothefuturebe.web.response.DepartureAndArrivalFlights;
import com.example.traveltothefuturebe.web.response.ResponseGetAllFlights;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping(path = URLConstants.FLIGHT)
@RestController
@RequiredArgsConstructor
public class FlightControllerImpl implements FlightController{
    private final FlightService flightService;
    @GetMapping(path = URLConstants.FlightUrlConstants.GET_ALL_FLIGHTS_BY_DEPARTURE_CITY)
    @Override
    public ResponseEntity<ResponseGetAllFlights> getAllFlightsByArrivalCity(@PathVariable String departureCity) {
        return null;
    }

    @GetMapping(path = URLConstants.FlightUrlConstants.GET_ALL_FLIGHTS_BY_DEPARTURE_INFO_AND_ARRIVAL_INFO)
    @Override
    public ResponseEntity<DepartureAndArrivalFlights> getDepartureAndComeBackFlights(@PathVariable String departureCity,
                                                                                           @PathVariable LocalDate departureTime,
                                                                                           @PathVariable String arrivalCity,
                                                                                           @PathVariable LocalDate comeBackTime) {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.getDepartureAndComeBackFlights(departureCity,departureTime,
                arrivalCity,comeBackTime));
    }

    @Override
    public ResponseEntity<List<FlightDTO>> getDepartureFlights(@PathVariable String departureCity,
                                                         @PathVariable String arrivalCity,
                                                         @PathVariable LocalDate departureTime) {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.getDepartureFlights(departureCity,arrivalCity,departureTime));
    }
}
