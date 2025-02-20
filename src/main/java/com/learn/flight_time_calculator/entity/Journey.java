package com.learn.flight_time_calculator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// db takes care of the id.
    private int id;

    @Column
    private String name;

    @Column
    private Long duration;

    @Column
    private LocalDateTime departingTime;

    @ManyToOne
    @JoinColumn(name = "departing_airport_id", nullable = false)
    private Airport departingAirport;

    @ManyToOne
    @JoinColumn(name = "landing_airport_id", nullable = false)
    private Airport landingAirport;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;
}
