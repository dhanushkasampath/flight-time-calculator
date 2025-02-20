package com.learn.flight_time_calculator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// db takes care of the id.
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "timezone_id", nullable = false)
    private TimeZone timeZone;

    @OneToMany(mappedBy = "departingAirport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Journey> departingJourneyList;

    @OneToMany(mappedBy = "landingAirport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Journey> landingJourneyList;

}
