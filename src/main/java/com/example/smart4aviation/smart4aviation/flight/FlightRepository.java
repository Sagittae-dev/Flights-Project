package com.example.smart4aviation.smart4aviation.flight;

import com.example.smart4aviation.smart4aviation.flightmodel.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByarrivalAirportIATACode(String arrivalAirportIATACode);
    List<Flight> findBydepartureAirportIATACode(String departureAirportIATACode);
}
