package com.example.smart4aviation.smart4aviation.services;

import com.example.smart4aviation.smart4aviation.dto.CargoAndWeightDetailsDTO;
import com.example.smart4aviation.smart4aviation.models.Baggage;
import com.example.smart4aviation.smart4aviation.models.Cargo;
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

    public void addFlightWithCargoAndBaggages(List<FlightWithCargoAndBaggage> flightWithCargoAndBaggages) {
        flightWithCargoAndBaggageRepository.saveAll(flightWithCargoAndBaggages);
    }

    public CargoAndWeightDetailsDTO getCargoAndBaggageByFlightNumberAndDate(Integer number, String departureDate) {
        Optional<Flight> flightByNumberAndDate =
                flightRepository.findByFlightNumberAndDepartureDate(number, departureDate);
        if (flightByNumberAndDate.isPresent()) {
            Flight flightByNrAndDate = flightByNumberAndDate.get();
            FlightWithCargoAndBaggage flightWithCargoAndBaggage = flightWithCargoAndBaggageRepository.findById(flightByNrAndDate.getFlightId()).get();
            int baggageTotatWeight = flightWithCargoAndBaggage.getBaggage().stream().map(Baggage::getWeight).reduce(Integer::sum).get();
            int cargoTotalWeight = flightWithCargoAndBaggage.getCargo().stream().map(Cargo::getWeight).reduce(Integer::sum).get();
            int totalWeight = baggageTotatWeight + cargoTotalWeight;
            return new CargoAndWeightDetailsDTO(baggageTotatWeight, cargoTotalWeight, totalWeight);
        }
        return null;
    }
}
