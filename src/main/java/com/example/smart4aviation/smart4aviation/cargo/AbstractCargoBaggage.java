package com.example.smart4aviation.smart4aviation.cargo;

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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="ParentClass")
public abstract class AbstractCargoBaggage {
    @NotNull
    private String weightUnit;

    @NotNull
    private Integer weight;

    @NotNull
    private Integer pieces;
}
