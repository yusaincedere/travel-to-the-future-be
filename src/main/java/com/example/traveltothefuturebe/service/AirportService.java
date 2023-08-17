package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.domain.dto.AirportDTO;
import com.example.traveltothefuturebe.web.response.ResponseGetAllAirports;

public interface AirportService {
    ResponseGetAllAirports getAllAirports();

    AirportDTO getAirportById(String id);
}
