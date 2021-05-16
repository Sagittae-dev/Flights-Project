package com.example.smart4aviation.smart4aviation.services;

import com.example.smart4aviation.smart4aviation.models.Baggage;
import com.example.smart4aviation.smart4aviation.models.Flight;
import com.example.smart4aviation.smart4aviation.repositories.BaggageRepository;
import com.example.smart4aviation.smart4aviation.repositories.CargoRepository;
import com.example.smart4aviation.smart4aviation.models.FlightWithCargoAndBaggage;
import com.example.smart4aviation.smart4aviation.repositories.FlightRepository;
import com.example.smart4aviation.smart4aviation.repositories.FlightWithCargoAndBaggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightWithCargoAndBaggageService {

    private final FlightWithCargoAndBaggageRepository flightWithCargoAndBaggageRepository;
    private final FlightRepository flightRepository;
    private final BaggageRepository baggageRepository;
    private final CargoRepository cargoRepository;

    @Autowired
    public FlightWithCargoAndBaggageService(FlightWithCargoAndBaggageRepository flightWithCargoAndBaggageRepository, FlightRepository flightRepository, BaggageRepository baggageRepository, CargoRepository cargoRepository) {
        this.flightWithCargoAndBaggageRepository = flightWithCargoAndBaggageRepository;
        this.flightRepository = flightRepository;
        this.baggageRepository = baggageRepository;
        this.cargoRepository = cargoRepository;
    }

    public List<FlightWithCargoAndBaggage> getFlightsWithCargoAndBaggage() {
        return flightWithCargoAndBaggageRepository.findAll();
    }

    public void addFlightWithCargoAndBaggage(FlightWithCargoAndBaggage flightWithCargoAndBaggage) {
        flightWithCargoAndBaggageRepository.save(flightWithCargoAndBaggage);
    }

    public Optional<FlightWithCargoAndBaggage> getCargoAndBaggageByFlightNumber(Integer number) {
        Optional<Flight> flightWithNumber = flightRepository.findAll().stream().filter(flight -> flight.getFlightNumber() == number).findAny();
        Optional<FlightWithCargoAndBaggage> flightWithCB = Optional.empty();
        if (flightWithNumber.isPresent()){
            Flight flight = flightWithNumber.get();
            int flightId = flight.getFlightId();
            flightWithCB = flightWithCargoAndBaggageRepository.findById(flightId);
        }
        return flightWithCB;
    }

    public Integer getCargoWeightForFlightNumber(Integer flightNumber) {
        Optional<FlightWithCargoAndBaggage> flightWithCargoAndBaggage = getCargoAndBaggageByFlightNumber(flightNumber);
        if(flightWithCargoAndBaggage.isPresent()){
            FlightWithCargoAndBaggage flightWithCB = flightWithCargoAndBaggage.get();
            return flightWithCB.getBaggage().stream().map(Baggage::getWeight).reduce(Integer::sum).get();
        }
        return null;
    }
}
