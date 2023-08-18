package com.example.traveltothefuturebe.common;

public class URLConstants {
    public static final String AIRPORT = "/airport";
    public static final String FLIGHT = "/flight";
    public static class AirportUrlConstants{
        public static final String GET_ALL_AIRPORTS = "/airports";
        public static final String GET_AIRPORT_BY_ID = "/{id}";
        public static final String CREATE_AIRPORT = "/create";
        public static final String DELETE_AIRPORT_BY_ID = "/delete/{id}";
        public static final String UPDATE_AIRPORT_BY_ID = "/update/{id}";
    }

    public static class FlightUrlConstants{
        public static final String GET_ALL_FLIGHTS_BY_DEPARTURE_CITY= "/flights/{departureCity}";
        public static final String GET_ALL_FLIGHTS_BY_DEPARTURE_INFO_AND_ARRIVAL_INFO= "/flights/from/{departureCity}/{departureTime}/to" +
                "/{arrivalCity}/{arrivalTime}";
        public static final String GET_ALL_FLIGHTS_BY_CITY_AND_DEPARTURE_TIME= "/flights/{departureCity}/{departureTime}";
        public static final String GET_FLIGHT_BY_ID = "/{id}";
        public static final String CREATE_FLIGHT = "/create";
        public static final String DELETE_FLIGHT_BY_ID = "/delete/{id}";
        public static final String UPDATE_FLIGHT_BY_ID = "/update/{id}";
    }
}
