package com.example.smart4aviation.smart4aviation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightWithCargoAndBaggage {

    @OneToMany(targetEntity = Cargo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fc_fk", referencedColumnName = "flightId")
    private List<Cargo> cargo;

    @Id
    private Integer flightId;

    @OneToMany(targetEntity = Baggage.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fb_fk", referencedColumnName = "flightId")
    private List<Baggage> baggage;
}
