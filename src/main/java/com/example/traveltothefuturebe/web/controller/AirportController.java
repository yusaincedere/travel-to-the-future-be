package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.web.response.ResponseGetAllAirports;
import org.springframework.http.ResponseEntity;

public interface AirportController {
    ResponseEntity<ResponseGetAllAirports> getAllAirports();
}
