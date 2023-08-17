package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.common.URLConstants;
import com.example.traveltothefuturebe.service.AirportService;
import com.example.traveltothefuturebe.web.response.ResponseGetAllAirports;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path=URLConstants.AIRPORT)
@RestController
public class AirportControllerImpl implements AirportController{
    private final AirportService airportService;


    public AirportControllerImpl(AirportService airportService){
        this.airportService = airportService;
    }
    @GetMapping(path = URLConstants.AirportUrlConstants.GET_ALL_AIRPORTS)
    @Override
    public ResponseEntity<ResponseGetAllAirports> getAllAirports() {
        ResponseGetAllAirports response = airportService.getAllAirports();
        return ResponseEntity.ok(response);
    }
}
