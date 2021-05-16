package com.example.smart4aviation.smart4aviation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="AbstractCargoBaggage")
@JsonIgnoreProperties(value = {"uniqueId"})
public abstract class AbstractCargoBaggage {

    @Id
    @GeneratedValue
    private int uniqueId;

    @NotNull
    private String weightUnit;

    @NotNull
    private Integer id;

    @NotNull
    private Integer weight;

    @NotNull
    private Integer pieces;

    public AbstractCargoBaggage(String weightUnit, Integer id, Integer weight, Integer pieces) {
        this.weightUnit = weightUnit;
        this.id = id;
        this.weight = weight;
        this.pieces = pieces;
    }
}
