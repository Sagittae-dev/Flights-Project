package com.example.smart4aviation.smart4aviation.cargo;

import lombok.*;

import javax.persistence.*;

@Data
@Table
@Entity
@DiscriminatorValue("childClasss")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cargo extends AbstractCargoBaggage{
    @Id
    @GeneratedValue
    private int cargoId;
    public Cargo(String weightUnit,  Integer weight, Integer pieces) {
        super(weightUnit,  weight, pieces);
    }
}
