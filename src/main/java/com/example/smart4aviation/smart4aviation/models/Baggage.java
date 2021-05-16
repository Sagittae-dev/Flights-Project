package com.example.smart4aviation.smart4aviation.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table
@DiscriminatorValue("Baggage")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Baggage extends AbstractCargoBaggage {
    public Baggage(String weightUnit, Integer id, Integer weight, Integer pieces) {
        super(weightUnit, id, weight, pieces);
    }
}
