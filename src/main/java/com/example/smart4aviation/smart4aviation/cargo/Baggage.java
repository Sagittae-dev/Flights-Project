package com.example.smart4aviation.smart4aviation.cargo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@DiscriminatorValue("childClasss")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Baggage extends AbstractCargoBaggage{
    @Id
    @GeneratedValue
    private int baggageId;
    public Baggage(String weightUnit,  Integer weight, Integer pieces) {
        super(weightUnit,  weight, pieces);
    }
}
