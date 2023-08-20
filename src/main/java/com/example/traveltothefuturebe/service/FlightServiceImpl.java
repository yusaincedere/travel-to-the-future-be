package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.domain.dto.FlightDTO;
import com.example.traveltothefuturebe.domain.mapper.FlightMapper;
import com.example.traveltothefuturebe.domain.model.Flight;
import com.example.traveltothefuturebe.repository.FlightRepository;
import com.example.traveltothefuturebe.web.response.DepartureAndArrivalFlights;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService{
    private final FlightRepository flightRepository;

    private FlightMapper flightMapper;

    @Override
    public DepartureAndArrivalFlights getDepartureAndComeBackFlights(String departureCity, LocalDate departureTime, String arrivalCity, LocalDate comeBackTime) {
        Instant departureStartTime = departureTime.atTime(LocalTime.MIN).toInstant(ZoneOffset.UTC);
        Instant departureEndTime = departureTime.atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC);
        Instant comeBackStartTime = comeBackTime.atTime(LocalTime.MIN).toInstant(ZoneOffset.UTC);
        Instant comeBackEndTime = comeBackTime.atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC);

        List<Flight> departureFlights = flightRepository.findAllByArrivalAirportCityAndDepartureAirportCityAndDepartureTimeBetween(
                arrivalCity,departureCity,departureStartTime,departureEndTime
        );

        List<Flight> comeBackFlights = flightRepository.findAllByArrivalAirportCityAndDepartureAirportCityAndDepartureTimeBetween(
                departureCity,arrivalCity,comeBackStartTime,comeBackEndTime
        );
        List<FlightDTO> departureFlightsDTO = flightMapper.flightsToFlightDTOs(departureFlights);
        List<FlightDTO> comeBackFlightsDTO = flightMapper.flightsToFlightDTOs(comeBackFlights);

        DepartureAndArrivalFlights departureAndArrivalFlights = new DepartureAndArrivalFlights();

        departureAndArrivalFlights.setDepartureFlights(departureFlightsDTO);
        departureAndArrivalFlights.setComeBackFlights(comeBackFlightsDTO);

        return departureAndArrivalFlights;

    }

    @Override
    public List<FlightDTO> getDepartureFlights(String departureCity, String arrivalCity, LocalDate departureTime) {
        Instant departureStartTime = departureTime.atTime(LocalTime.MIN).toInstant(ZoneOffset.UTC);
        Instant departureEndTime = departureTime.atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC);

        List<Flight> departureFlights = flightRepository.findAllByArrivalAirportCityAndDepartureAirportCityAndDepartureTimeBetween(
                arrivalCity,departureCity,departureStartTime,departureEndTime
        );
        return flightMapper.flightsToFlightDTOs(departureFlights);
    }
}
