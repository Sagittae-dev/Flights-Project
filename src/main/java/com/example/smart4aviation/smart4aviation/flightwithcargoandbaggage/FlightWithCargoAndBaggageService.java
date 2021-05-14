package com.example.smart4aviation.smart4aviation.flightwithcargoandbaggage;

import com.example.smart4aviation.smart4aviation.baggage.Baggage;
import com.example.smart4aviation.smart4aviation.baggage.BaggageRepository;
import com.example.smart4aviation.smart4aviation.cargo.Cargo;
import com.example.smart4aviation.smart4aviation.cargo.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightWithCargoAndBaggageService {

    private final FlightWithCargoAndBaggageRepository flightWithCargoAndBaggageRepository;
    private final BaggageRepository baggageRepository;
    private final CargoRepository cargoRepository;

    @Autowired
    public FlightWithCargoAndBaggageService(FlightWithCargoAndBaggageRepository flightWithCargoAndBaggageRepository, BaggageRepository baggageRepository, CargoRepository cargoRepository) {
        this.flightWithCargoAndBaggageRepository = flightWithCargoAndBaggageRepository;
        this.baggageRepository = baggageRepository;
        this.cargoRepository = cargoRepository;
    }

    public List<FlightWithCargoAndBaggage> getFlightWithCargoAndBaggage() {
        return flightWithCargoAndBaggageRepository.findAll();
    }

    public void addFlightWithCargoAndBaggage(FlightWithCargoAndBaggage flightWithCargoAndBaggage) {
        flightWithCargoAndBaggageRepository.save(flightWithCargoAndBaggage);
    }
}
