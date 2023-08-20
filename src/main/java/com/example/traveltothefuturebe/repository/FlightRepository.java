package com.example.traveltothefuturebe.repository;

import com.example.traveltothefuturebe.domain.model.AirPort;
import com.example.traveltothefuturebe.domain.model.Flight;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;
import java.util.List;


public interface FlightRepository extends MongoRepository<Flight,String> {

    List<Flight> findAllByDepartureAirport(AirPort departureAirport);
    @Query("{ 'arrivalAirport.$id': ?0, 'departureAirport.$id': ?1, 'departureTime': { $gte: ?2, $lt: ?3 } }")
    List<Flight> findAllByArrivalAirportCityAndDepartureAirportCityAndDepartureTimeBetween(ObjectId arrivalAirportId, ObjectId departureAirportId,
                                                                                           Instant startDate, Instant endDate);

}
