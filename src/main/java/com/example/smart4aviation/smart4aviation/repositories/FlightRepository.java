package com.example.smart4aviation.smart4aviation.repositories;

import com.example.smart4aviation.smart4aviation.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByarrivalAirportIATACode(String arrivalAirportIATACode);
    List<Flight> findBydepartureAirportIATACode(String departureAirportIATACode);
}
