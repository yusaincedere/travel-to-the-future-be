package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.common.ExceptionConstants;
import com.example.traveltothefuturebe.domain.dto.AirportDTO;
import com.example.traveltothefuturebe.domain.mapper.AirportMapper;
import com.example.traveltothefuturebe.domain.model.AirPort;
import com.example.traveltothefuturebe.exception.NotFoundException;
import com.example.traveltothefuturebe.repository.AirportRepository;
import com.example.traveltothefuturebe.web.response.ResponseGetAllAirports;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public AirportDTO getAirportById(String id) {
        Optional<AirPort> optionalAirPort =airportRepository.findById(id);
        if(optionalAirPort.isEmpty()){
            throw new NotFoundException(ExceptionConstants.FLIGHT_NOT_FOUND_MESSAGE+" with id: " +id);
        }
        return airportMapper.airportToAirportDTO(optionalAirPort.get());
    }
}
