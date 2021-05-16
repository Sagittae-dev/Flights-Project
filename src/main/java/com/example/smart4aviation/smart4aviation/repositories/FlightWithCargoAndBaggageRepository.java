package com.example.smart4aviation.smart4aviation.repositories;

import com.example.smart4aviation.smart4aviation.models.FlightWithCargoAndBaggage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightWithCargoAndBaggageRepository extends JpaRepository<FlightWithCargoAndBaggage, Integer> {
}
