package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.common.URLConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeControllerImpl implements HomeController{
    @GetMapping
    @Override
    public ResponseEntity<String> home() {
        return ResponseEntity.status(HttpStatus.OK).body("App is running");
    }
}
