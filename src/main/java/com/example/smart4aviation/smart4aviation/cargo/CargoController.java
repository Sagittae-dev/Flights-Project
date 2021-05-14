package com.example.smart4aviation.smart4aviation.cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/flightsCB")
public class CargoController {

    private final CargoService cargoService;

    @Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    public List<FlightWithCargoAndBaggage> getFlightWithCargoAndBaggage(){
        return cargoService.getFlightWithCargoAndBaggage();
    }

    @PostMapping
    public void addFlightWithCargoAndBaggage(FlightWithCargoAndBaggage flightWithCargoAndBaggage){
        cargoService.addFlightWithCargoAndBaggage(flightWithCargoAndBaggage);
    }
}
