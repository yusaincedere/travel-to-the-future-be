package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.common.URLConstants;
import com.example.traveltothefuturebe.domain.dto.AirportDTO;
import com.example.traveltothefuturebe.service.AirportService;
import com.example.traveltothefuturebe.web.request.RequestCreateAirport;
import com.example.traveltothefuturebe.web.response.ResponseGetAllAirports;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = URLConstants.AirportUrlConstants.CREATE_AIRPORT)
    @Override
    public ResponseEntity<AirportDTO> createAirport(@RequestBody RequestCreateAirport requestCreateAirport) {
        AirportDTO airportDTO = airportService.createAirport(requestCreateAirport);
        return ResponseEntity.status(HttpStatus.CREATED).body(airportDTO);
    }

    @DeleteMapping(path = URLConstants.AirportUrlConstants.DELETE_AIRPORT_BY_ID)
    @Override
    public ResponseEntity<Void> deleteAirportById(@PathVariable String id) {
        airportService.deleteAirportById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = URLConstants.AirportUrlConstants.UPDATE_AIRPORT_BY_ID)
    @Override
    public ResponseEntity<AirportDTO> updateAirportById(@PathVariable String id, @RequestBody AirportDTO updatedAirportDTO) {
       AirportDTO airportDTO = airportService.updateAirport(id,updatedAirportDTO);
       return ResponseEntity.status(HttpStatus.OK).body(airportDTO);
    }


}
