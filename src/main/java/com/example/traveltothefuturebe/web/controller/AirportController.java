package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.domain.dto.AirportDTO;
import com.example.traveltothefuturebe.web.request.RequestCreateAirport;
import com.example.traveltothefuturebe.web.response.ResponseGetAllAirports;
import org.springframework.http.ResponseEntity;

public interface AirportController {
    ResponseEntity<ResponseGetAllAirports> getAllAirports();
    ResponseEntity<AirportDTO> getAirportById(String id);

    ResponseEntity<AirportDTO> createAirport(RequestCreateAirport requestCreateAirport);
}
