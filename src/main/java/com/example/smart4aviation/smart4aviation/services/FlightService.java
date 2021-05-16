package com.example.smart4aviation.smart4aviation.services;

import com.example.smart4aviation.smart4aviation.dto.AirportFlightsDetailsDTO;
import com.example.smart4aviation.smart4aviation.models.Baggage;
import com.example.smart4aviation.smart4aviation.models.Flight;
import com.example.smart4aviation.smart4aviation.models.FlightWithCargoAndBaggage;
import com.example.smart4aviation.smart4aviation.repositories.FlightRepository;
import com.example.smart4aviation.smart4aviation.repositories.FlightWithCargoAndBaggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightWithCargoAndBaggageRepository flightWithCargoAndBaggageRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, FlightWithCargoAndBaggageRepository flightWithCargoAndBaggageRepository) {
        this.flightRepository = flightRepository;
        this.flightWithCargoAndBaggageRepository = flightWithCargoAndBaggageRepository;
    }

    public List<Flight> getFlightList(){
        return flightRepository.findAll();
    }

    public void addNewFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public AirportFlightsDetailsDTO findFlightDetailsByIata(String arrivalAirportIATACode) {
        List<Flight> listOfArrives = flightRepository.findByarrivalAirportIATACode(arrivalAirportIATACode);
        int numberOfFlightsArriving = listOfArrives.size();
        List<Flight> listOfDepartures = flightRepository.findBydepartureAirportIATACode(arrivalAirportIATACode);
        int numberOfFlightsDeparting = listOfDepartures.size();
        int piecesOfBaggageArriving = getBaggagePiecesCount(listOfArrives);
        int piecesOfBaggageDeparting = getBaggagePiecesCount(listOfDepartures);
        AirportFlightsDetailsDTO airportFlightsDetailsDTO = new AirportFlightsDetailsDTO(numberOfFlightsArriving, numberOfFlightsDeparting, piecesOfBaggageArriving, piecesOfBaggageDeparting);
    return airportFlightsDetailsDTO;
    }

    private int getBaggagePiecesCount(List<Flight> listOfArrives) {
        int allPieces = 0;
        for(Flight flight : listOfArrives){
            Optional<FlightWithCargoAndBaggage> optionalFlightWithCB = flightWithCargoAndBaggageRepository.findById(flight.getFlightId());
            if (optionalFlightWithCB.isPresent()){
                FlightWithCargoAndBaggage flightWithCB = optionalFlightWithCB.get();
                int pieces = flightWithCB.getBaggage().stream().map(Baggage::getPieces).reduce(Integer::sum).get();
                allPieces = allPieces + pieces;
            }
        }
        return allPieces;
    }


}
