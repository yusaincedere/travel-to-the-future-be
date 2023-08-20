package com.example.traveltothefuturebe.web.response;

import com.example.traveltothefuturebe.domain.dto.FlightDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class DepartureAndArrivalFlights {
   private List<FlightDTO> departureFlights;
   private List<FlightDTO> comeBackFlights;
}
