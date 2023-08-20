package com.example.traveltothefuturebe.repository;

import com.example.traveltothefuturebe.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByUsername(String username);
}
