package com.example.traveltothefuturebe.web.response;

import com.example.traveltothefuturebe.domain.dto.AirportDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ResponseGetAllAirports {
    private List<AirportDTO> airportList;
}
