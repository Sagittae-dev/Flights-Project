package com.example.smart4aviation.smart4aviation.controller;

import com.example.smart4aviation.smart4aviation.dto.AirportDetailsDTO;
import com.example.smart4aviation.smart4aviation.models.Flight;
import com.example.smart4aviation.smart4aviation.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getFlights(){
    return flightService.getFlightList();
    }

    @GetMapping(value = "{arrivalAirportIATACode}&{departureDate}")
    public AirportDetailsDTO getFlightByIata(@PathVariable("arrivalAirportIATACode") String arrivalAirportIATACode,
                                             @PathVariable("departureDate") String departureDate){
        return flightService.findFlightDetailsByIata(arrivalAirportIATACode, departureDate);
    }

    @PostMapping
    public void addFlight(@RequestBody Flight flight){
        flightService.addNewFlight(flight);
    }

    @PostMapping("/addAll")
    public void addListOfFlights(@RequestBody List<Flight> list){flightService.addListOfFlights(list);}
}
