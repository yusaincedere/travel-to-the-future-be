package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.common.URLConstants;
import com.example.traveltothefuturebe.web.response.ResponseGetAllAirports;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path=URLConstants.AIRPORT)
@RestController
public class AirportControllerImpl implements AirportController{
    @Override
    public ResponseGetAllAirports getAllAirports() {
        return null;
    }
}
