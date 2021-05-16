package com.example.smart4aviation.smart4aviation.controller;

import com.example.smart4aviation.smart4aviation.models.FlightWithCargoAndBaggage;
import com.example.smart4aviation.smart4aviation.services.FlightWithCargoAndBaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return flightWithCargoAndBaggageService.getFlightsWithCargoAndBaggage();
    }

    @GetMapping(value = "{flightNumber}")
    public Optional<FlightWithCargoAndBaggage> getFlightWithCargoAndBaggageByNumber(@PathVariable("flightNumber") Integer flightNumber){
        return flightWithCargoAndBaggageService.getCargoAndBaggageByFlightNumber(flightNumber);
    }

    @GetMapping(value = "/weightFor{flightNumber}")
    public Integer getCargoWeightForFlightNumber(@PathVariable("flightNumber") Integer flightNumber){
        return flightWithCargoAndBaggageService.getCargoWeightForFlightNumber(flightNumber);
    }


    @PostMapping
    public void addFlightWithCargoAndBaggage(@RequestBody FlightWithCargoAndBaggage flightWithCargoAndBaggage){
        flightWithCargoAndBaggageService.addFlightWithCargoAndBaggage(flightWithCargoAndBaggage);
    }

    @PostMapping("/addAll")
    public void addAllFlightsWithCargoAndBaggage(@RequestBody List<FlightWithCargoAndBaggage> flightWithCargoAndBaggages){
        flightWithCargoAndBaggageService.addFlightWithCargoAndBaggages(flightWithCargoAndBaggages);
    }

}
