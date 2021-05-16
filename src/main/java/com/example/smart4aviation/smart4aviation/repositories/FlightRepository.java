package com.example.smart4aviation.smart4aviation.repositories;

import com.example.smart4aviation.smart4aviation.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByarrivalAirportIATACodeAndDepartureDate(String arrivalAirportIATACode, String departureDate);
    List<Flight> findBydepartureAirportIATACodeAndDepartureDate(String departureAirportIATACode, String departureDate);
}
