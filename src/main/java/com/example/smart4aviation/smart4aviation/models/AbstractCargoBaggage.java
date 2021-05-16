package com.example.smart4aviation.smart4aviation.models;

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
public abstract class AbstractCargoBaggage {

    @NotNull
    private String weightUnit;

    @Id
    private Integer id;

    @NotNull
    private Integer weight;

    @NotNull
    private Integer pieces;
}
