package com.example.smart4aviation.smart4aviation.flightmodel;

import com.example.smart4aviation.smart4aviation.cargo.FlightWithCargoAndBaggage;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    private String arrivalAirportIATACode;

    @NotNull
    private int flightNumber;

    @NotNull
    private String departureAirportIATACode;

    /*@OneToMany(targetEntity = FlightWithCargoAndBaggage.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fcb_fk", referencedColumnName = "id")
    private List<FlightWithCargoAndBaggage> listOfCargoAndBaggage;*/

}
