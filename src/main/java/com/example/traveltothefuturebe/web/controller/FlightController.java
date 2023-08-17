package com.example.traveltothefuturebe.web.controller;

import com.example.traveltothefuturebe.web.response.ResponseGetAllFlights;

public interface FlightController {
    ResponseGetAllFlights getAllFlightsByArrivalCity(String city);
}
