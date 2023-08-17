package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.web.response.ResponseGetAllFlights;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping()
@RestController
public class FlightControllerImpl implements FlightController{
    @Override
    public ResponseGetAllFlights getAllFlightsByArrivalCity(String city) {
        return null;
    }
}
