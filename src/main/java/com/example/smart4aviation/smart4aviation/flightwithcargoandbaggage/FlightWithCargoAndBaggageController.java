package com.example.smart4aviation.smart4aviation.flightwithcargoandbaggage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/flightsCB")
public class FlightWithCargoAndBaggageController {

    private final FlightWithCargoAndBaggageService flightWithCargoAndBaggageService;

    @Autowired
    public FlightWithCargoAndBaggageController(FlightWithCargoAndBaggageService flightWithCargoAndBaggageService) {
        this.flightWithCargoAndBaggageService = flightWithCargoAndBaggageService;
    }

    @GetMapping
    public List<FlightWithCargoAndBaggage> getFlightWithCargoAndBaggage(){
        return flightWithCargoAndBaggageService.getFlightWithCargoAndBaggage();
    }

    @PostMapping
    public void addFlightWithCargoAndBaggage(FlightWithCargoAndBaggage flightWithCargoAndBaggage){
        flightWithCargoAndBaggageService.addFlightWithCargoAndBaggage(flightWithCargoAndBaggage);
    }
}
