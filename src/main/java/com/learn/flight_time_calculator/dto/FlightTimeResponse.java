package com.learn.flight_time_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightTimeResponse {
    private String departureTime;
    private String arrivalTime;
    private String departureZone;
    private String destinationZone;
}
