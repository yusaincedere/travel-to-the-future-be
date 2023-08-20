package com.example.traveltothefuturebe.domain.mapper;

import com.example.traveltothefuturebe.domain.dto.FlightDTO;
import com.example.traveltothefuturebe.domain.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    @Mapping(target = "airportName",source = "departureAirport.name")
    @Mapping(target = "departureCity",source = "departureAirport.city")
    @Mapping(target = "departureTime",source = "departureTime",qualifiedByName = "instantToDateString")
    @Mapping(target = "arrivalCity",source = "arrivalAirport.city")
    @Mapping(target = "arrivalTime",source = "arrivalTime",qualifiedByName = "instantToDateString")
    FlightDTO flightToFlightDTO(Flight flight);

    List<FlightDTO> flightsToFlightDTOs(List<Flight> flights);

    @Named("instantToDateString")
    default String instantToDateString(Instant instant){
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(zonedDateTime);
    }
}
