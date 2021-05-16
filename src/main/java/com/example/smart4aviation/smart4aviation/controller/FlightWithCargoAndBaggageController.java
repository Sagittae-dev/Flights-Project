package com.example.smart4aviation.smart4aviation.controller;

import com.example.smart4aviation.smart4aviation.dto.CargoAndWeightDetailsDTO;
import com.example.smart4aviation.smart4aviation.models.FlightWithCargoAndBaggage;
import com.example.smart4aviation.smart4aviation.services.FlightWithCargoAndBaggageService;
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
        return flightWithCargoAndBaggageService.getFlightsWithCargoAndBaggage();
    }

    @GetMapping(value = "/weightFor{flightNumber}&{departureDate}")
    public CargoAndWeightDetailsDTO getCargoWeightForFlightNumber(@PathVariable("flightNumber") Integer flightNumber, @PathVariable("departureDate")String departureDate){
        return flightWithCargoAndBaggageService.getCargoAndBaggageByFlightNumberAndDate(flightNumber, departureDate);
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
