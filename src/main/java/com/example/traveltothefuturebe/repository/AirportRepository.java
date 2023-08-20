package com.example.traveltothefuturebe.repository;

import com.example.traveltothefuturebe.domain.model.AirPort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AirportRepository extends MongoRepository<AirPort,String> {


    AirPort findByCity(String city);
}
