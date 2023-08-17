package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.common.URLConstants;
import com.example.traveltothefuturebe.web.response.ResponseGetAllFlights;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = URLConstants.FLIGHT)
@RestController
public class FlightControllerImpl implements FlightController{

    @GetMapping(path = URLConstants.FlightUrlConstants.GET_ALL_FLIGHTS_BY_DEPARTURE_CITY)
    @Override
    public ResponseGetAllFlights getAllFlightsByArrivalCity(@PathVariable String departureCity) {
        return null;
    }
}
