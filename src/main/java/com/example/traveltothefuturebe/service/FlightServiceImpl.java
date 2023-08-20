package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.domain.dto.FlightDTO;
import com.example.traveltothefuturebe.domain.mapper.FlightMapper;
import com.example.traveltothefuturebe.domain.model.AirPort;
import com.example.traveltothefuturebe.domain.model.Flight;
import com.example.traveltothefuturebe.repository.AirportRepository;
import com.example.traveltothefuturebe.repository.FlightRepository;
import com.example.traveltothefuturebe.web.response.DepartureAndArrivalFlights;
import com.example.traveltothefuturebe.web.response.ResponseGetAllFlights;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService{
    private final FlightRepository flightRepository;

    private final FlightMapper flightMapper;

    private final AirportRepository airportRepository;

    @Override
    public DepartureAndArrivalFlights getDepartureAndComeBackFlights(String departureCity, LocalDate departureTime, String arrivalCity, LocalDate comeBackTime) {
        Instant departureStartTime = departureTime.atTime(LocalTime.MIN).toInstant(ZoneOffset.UTC);
        Instant departureEndTime = departureTime.atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC);
        Instant comeBackStartTime = comeBackTime.atTime(LocalTime.MIN).toInstant(ZoneOffset.UTC);
        Instant comeBackEndTime = comeBackTime.atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC);
        DepartureAndArrivalFlights departureAndArrivalFlights = new DepartureAndArrivalFlights();
        AirPort arrivalAirport = airportRepository.findByCity(arrivalCity);
        AirPort departureAirport = airportRepository.findByCity(departureCity);
        if(arrivalAirport != null && departureAirport !=null){
            ObjectId arrivalAirportId = new ObjectId(arrivalAirport.getId());
            ObjectId departureAirportId = new ObjectId(departureAirport.getId());
            List<Flight> departureFlights = flightRepository.findAllByArrivalAirportCityAndDepartureAirportCityAndDepartureTimeBetween(
                    arrivalAirportId,departureAirportId,departureStartTime,departureEndTime
            );

            List<Flight> comeBackFlights = flightRepository.findAllByArrivalAirportCityAndDepartureAirportCityAndDepartureTimeBetween(
                    departureAirportId,arrivalAirportId,comeBackStartTime,comeBackEndTime
            );

            List<FlightDTO> departureFlightsDTO = flightMapper.flightsToFlightDTOs(departureFlights);
            List<FlightDTO> comeBackFlightsDTO = flightMapper.flightsToFlightDTOs(comeBackFlights);



            departureAndArrivalFlights.setDepartureFlights(departureFlightsDTO);
            departureAndArrivalFlights.setComeBackFlights(comeBackFlightsDTO);
        }
        return departureAndArrivalFlights;

    }

    @Override
    public List<FlightDTO> getDepartureFlights(String departureCity, String arrivalCity, LocalDate departureTime) {
        Instant departureStartTime = departureTime.atTime(LocalTime.MIN).toInstant(ZoneOffset.UTC);
        Instant departureEndTime = departureTime.atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC);
        AirPort departureAirport = airportRepository.findByCity(departureCity);
        AirPort arrivalAirport = airportRepository.findByCity(arrivalCity);
        List<Flight> departureFlights = new ArrayList<>();
        if(departureAirport != null && arrivalAirport !=null){
            ObjectId arrivalAirportId = new ObjectId(arrivalAirport.getId());
            ObjectId departureAirportId = new ObjectId(departureAirport.getId());
            departureFlights = flightRepository.findAllByArrivalAirportCityAndDepartureAirportCityAndDepartureTimeBetween(
                    arrivalAirportId,departureAirportId,departureStartTime,departureEndTime
            );
        }
        return flightMapper.flightsToFlightDTOs(departureFlights);
    }

    @Override
    public ResponseGetAllFlights getAllFlightsByDepartureCity(String departureCity) {
        AirPort departureAirport = airportRepository.findByCity(departureCity);
        List<Flight> departureFlights = flightRepository.findAllByDepartureAirport(departureAirport);
        List<FlightDTO> flightDTOList = flightMapper.flightsToFlightDTOs(departureFlights);
        ResponseGetAllFlights responseGetAllFlights = new ResponseGetAllFlights();
        responseGetAllFlights.setFlightList(flightDTOList);
        return responseGetAllFlights;
    }
}
