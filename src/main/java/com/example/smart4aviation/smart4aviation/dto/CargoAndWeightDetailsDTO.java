package com.example.smart4aviation.smart4aviation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CargoAndWeightDetailsDTO {
    int cargoWeightForFlight;
    int baggageWeightForFlight;
    int totalWeightForFlight;
}
