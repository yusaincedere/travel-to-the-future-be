package com.example.traveltothefuturebe.scheduler;

import com.example.traveltothefuturebe.domain.model.AirPort;
import com.example.traveltothefuturebe.domain.model.Flight;
import com.example.traveltothefuturebe.repository.AirportRepository;
import com.example.traveltothefuturebe.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class FlightGeneratorScheduler {
    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;


    @Scheduled(cron = "${spring.scheduled.cron-expression}")
    public void generateRandomFlights(){
        System.out.println("Scheduled job running...");
        List<Flight> flightsToSave = new ArrayList<>();
        List<AirPort> airPorts = airportRepository.findAll();

        Random random = new Random();

        for(int i = 0; i<10; i++){
            AirPort departureAirport = getRandomAirport(airPorts,random);
            AirPort arrivalAirport = getRandomAirportDifferentFromDeparture(departureAirport,airPorts,random);
            Instant departureTime = generateRandomDepartureTime();
            Instant arrivalTime = generateRandomArrivalTime(departureTime,random);
            BigDecimal price = generateRandomPrice(random);

            Flight flight = Flight.builder()
                    .departureAirport(departureAirport)
                    .arrivalAirport(arrivalAirport)
                    .departureTime(departureTime)
                    .arrivalTime(arrivalTime)
                    .price(price)
                    .build();
            flightsToSave.add(flight);
        }
        flightRepository.saveAll(flightsToSave);
        System.out.println("Scheduled job finished...");
    }


    private long randomLong(long min,long max){
        return min + (long) (Math.random()*(max-min+1));
    }

    private BigDecimal generateRandomPrice(Random random){
        int minPrice = 1000;
        int maxPrice = 5000;
        return BigDecimal.valueOf(random.nextInt(maxPrice-minPrice+1) +minPrice);
    }

    private Instant generateRandomDepartureTime(){
        return Instant.now().plus(randomLong(20,365), ChronoUnit.DAYS);
    }
    private Instant generateRandomArrivalTime(Instant departureTime,Random random){
        long hours = randomLong(1,3);
        return departureTime.plus(hours,ChronoUnit.HOURS);
    }

    private AirPort getRandomAirport(List<AirPort> airPorts, Random random){
        return airPorts.get(random.nextInt(airPorts.size()));
    }

    private AirPort getRandomAirportDifferentFromDeparture(AirPort departureAirport, List<AirPort> airports, Random random) {
        AirPort arrivalAirport;
        do {
            arrivalAirport = getRandomAirport(airports, random);
        } while (arrivalAirport.equals(departureAirport));
        return arrivalAirport;
    }

}
