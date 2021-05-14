package com.example.smart4aviation.smart4aviation.cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<FlightWithCargoAndBaggage> getFlightWithCargoAndBaggage() {
        return cargoRepository.findAll();
    }

    public void addFlightWithCargoAndBaggage(FlightWithCargoAndBaggage flightWithCargoAndBaggage) {
        cargoRepository.save(flightWithCargoAndBaggage);
    }
}
