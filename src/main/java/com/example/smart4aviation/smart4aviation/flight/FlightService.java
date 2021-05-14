package com.example.smart4aviation.smart4aviation.flight;

import com.example.smart4aviation.smart4aviation.flightmodel.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getFlightList(){
        return flightRepository.findAll();
    }

    public void addNewFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public String findFlightbyIata(String arrivalAirportIATACode) {
        List<Flight> listOfArrives = flightRepository.findByarrivalAirportIATACode(arrivalAirportIATACode);
        List<Flight> listOfDepartures = flightRepository.findBydepartureAirportIATACode(arrivalAirportIATACode);
        return "Number of flights departing from "+arrivalAirportIATACode+" airport: " + listOfDepartures.size()+ "\n Number of flights arriving from " +arrivalAirportIATACode+ " airport: " + listOfArrives.size();
    }
}
