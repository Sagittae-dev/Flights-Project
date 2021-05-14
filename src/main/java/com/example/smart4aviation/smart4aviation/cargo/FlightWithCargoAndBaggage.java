package com.example.smart4aviation.smart4aviation.cargo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightWithCargoAndBaggage {
    @OneToMany(targetEntity = Cargo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fc_fk", referencedColumnName = "flightId")
    private List<Cargo> cargoList;

    @Id
    @GeneratedValue
    private Integer flightId;

    @OneToMany(targetEntity = Baggage.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fb_fk", referencedColumnName = "flightId")
    private List<Baggage> baggageList;
}
