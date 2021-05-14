package com.example.smart4aviation.smart4aviation.baggage;


import com.example.smart4aviation.smart4aviation.cargo.AbstractCargoBaggage;
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
public class Baggage extends AbstractCargoBaggage {
    @Id
    @GeneratedValue
    private int baggageId;
    public Baggage(String weightUnit,  Integer weight, Integer pieces) {
        super(weightUnit,  weight, pieces);
    }
}
