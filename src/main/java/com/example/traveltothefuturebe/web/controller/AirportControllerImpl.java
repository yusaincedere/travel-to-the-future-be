package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.common.URLConstants;
import com.example.traveltothefuturebe.domain.dto.AirportDTO;
import com.example.traveltothefuturebe.service.AirportService;
import com.example.traveltothefuturebe.web.request.RequestCreateAirport;
import com.example.traveltothefuturebe.web.response.ResponseGetAllAirports;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = URLConstants.AirportUrlConstants.GET_AIRPORT_BY_ID)
    @Override
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable String id) {
        AirportDTO airportDTO = airportService.getAirportById(id);
        return ResponseEntity.status(HttpStatus.OK).body(airportDTO);
    }

    @Override
    public ResponseEntity<AirportDTO> createAirport(RequestCreateAirport requestCreateAirport) {
        AirportDTO airportDTO = airportService.createAirport(requestCreateAirport);
        return ResponseEntity.status(HttpStatus.CREATED).body(airportDTO);
    }


}
