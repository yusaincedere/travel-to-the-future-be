package com.example.traveltothefuturebe.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HomeControllerImpl implements HomeController{
    @Override
    public ResponseEntity<String> home() {
        return ResponseEntity.status(HttpStatus.OK).body("App is running");
    }
}
