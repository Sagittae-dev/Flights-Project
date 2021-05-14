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
public class Cargo extends AbstractCargoBaggage{
    @Id
    @GeneratedValue
    private int cargoId;
    public Cargo(String weightUnit,  Integer weight, Integer pieces) {
        super(weightUnit,  weight, pieces);
    }
}
