package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.common.ExceptionConstants;
import com.example.traveltothefuturebe.domain.dto.AirportDTO;
import com.example.traveltothefuturebe.domain.mapper.AirportMapper;
import com.example.traveltothefuturebe.domain.model.AirPort;
import com.example.traveltothefuturebe.exception.CreateException;
import com.example.traveltothefuturebe.exception.NotFoundException;
import com.example.traveltothefuturebe.repository.AirportRepository;
import com.example.traveltothefuturebe.web.request.RequestCreateAirport;
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
            throw new NotFoundException(ExceptionConstants.AIRPORT_NOT_FOUND_MESSAGE+" with id: " +id);
        }
        return airportMapper.airportToAirportDTO(optionalAirPort.get());
    }

    @Override
    public AirportDTO createAirport(RequestCreateAirport requestCreateAirport) {
        AirPort airPort = AirPort.builder().name(requestCreateAirport.getName())
                .city(requestCreateAirport.getCity()).build();
        if(airPort == null){
            throw new CreateException(ExceptionConstants.AIRPORT_CREATE_EXCEPTION_MESSAGE);
        }
        return airportMapper.airportToAirportDTO(airPort);
    }

    @Override
    public void deleteAirportById(String id) {
       airportRepository.deleteById(id);
    }

    @Override
    public AirportDTO updateAirport(String id, AirportDTO updatedAirportDTO) {
        Optional<AirPort> optionalAirPort = airportRepository.findById(id);
        if(optionalAirPort.isEmpty()){
            throw new NotFoundException(ExceptionConstants.AIRPORT_NOT_FOUND_MESSAGE+ " with id: " + id);
        }
        AirPort airPort = optionalAirPort.get();
        airPort.setCity(updatedAirportDTO.getCity() != null ? updatedAirportDTO.getCity() : airPort.getCity());
        airPort.setName(updatedAirportDTO.getName() != null ? updatedAirportDTO.getName() : airPort.getName());
        airportRepository.save(airPort);
        return airportMapper.airportToAirportDTO(airPort);
    }
}
