package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.domain.dto.AirportDTO;
import com.example.traveltothefuturebe.domain.mapper.AirportMapper;
import com.example.traveltothefuturebe.domain.model.AirPort;
import com.example.traveltothefuturebe.repository.AirportRepository;
import com.example.traveltothefuturebe.web.response.ResponseGetAllAirports;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService{
    private final AirportRepository airportRepository;

    private final AirportMapper airportMapper;

    public AirportServiceImpl(AirportRepository airportRepository,AirportMapper airportMapper){
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
    }

    @Override
    public ResponseGetAllAirports getAllAirports() {
        List<AirPort> airports = airportRepository.findAll();
        List<AirportDTO> airportDTOList = airportMapper.airportsToAirportDTOs(airports);
        return ResponseGetAllAirports.builder().airportList(airportDTOList).build();
    }
}
