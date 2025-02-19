package com.learn.flight_time_calculator.controller;

import com.learn.flight_time_calculator.dto.FlightTimeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/flights")
public class FlightTimeController {

    @GetMapping("/calculate")
    public FlightTimeResponse calculateArrivalTime(
            @RequestParam String departureTime,  // Format: "yyyy-MM-dd'T'HH:mm"
            @RequestParam String departureZone,  // Example: "Asia/Kuala_Lumpur"
            @RequestParam String destinationZone, // Example: "Europe/London"
            @RequestParam int flightDurationHours,
            @RequestParam int flightDurationMinutes) {

        // Parse the departure time and apply time zone
        ZonedDateTime departureDateTime = ZonedDateTime.of(
                java.time.LocalDateTime.parse(departureTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                ZoneId.of(departureZone)
        );

        // Add the flight duration
        ZonedDateTime arrivalDateTime = departureDateTime.plus(Duration.ofHours(flightDurationHours)
                .plusMinutes(flightDurationMinutes));

        // Convert to the destination time zone
        ZonedDateTime arrivalInDestinationZone = arrivalDateTime.withZoneSameInstant(ZoneId.of(destinationZone));

        // Return Response
        return new FlightTimeResponse(
                departureDateTime.toString(),
                arrivalInDestinationZone.toString(),
                departureZone,
                destinationZone
        );
    }
}
