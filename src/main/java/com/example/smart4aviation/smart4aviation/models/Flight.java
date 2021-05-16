package com.example.smart4aviation.smart4aviation.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Flight {

    @NotNull
    private String departureDate;

    @Id
    private int flightId;

    @NotNull
    private String arrivalAirportIATACode;

    @NotNull
    private int flightNumber;

    @NotNull
    private String departureAirportIATACode;
}
