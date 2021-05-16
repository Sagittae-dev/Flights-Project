package com.example.smart4aviation.smart4aviation.models;

import lombok.*;

import javax.persistence.*;


@Entity
@Table
@DiscriminatorValue("Cargo")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cargo extends AbstractCargoBaggage {

    public Cargo(String weightUnit, Integer id, Integer weight, Integer pieces) {
        super(weightUnit, id, weight, pieces);
    }

}
