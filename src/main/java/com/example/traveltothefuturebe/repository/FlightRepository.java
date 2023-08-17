package com.example.traveltothefuturebe.repository;

import com.example.traveltothefuturebe.domain.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FlightRepository extends MongoRepository<Flight,String> {
}
