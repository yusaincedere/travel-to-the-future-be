package com.example.traveltothefuturebe.domain.mapper;

import com.example.traveltothefuturebe.domain.dto.AirportDTO;
import com.example.traveltothefuturebe.domain.model.AirPort;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirportMapper {

    AirportDTO airportToAirportDTO(AirPort airPort);

    List<AirportDTO> airportsToAirportDTOs(List<AirPort> airPort);

}
