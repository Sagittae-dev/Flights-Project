package com.example.smart4aviation.smart4aviation.cargo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<FlightWithCargoAndBaggage, Integer> {
}
