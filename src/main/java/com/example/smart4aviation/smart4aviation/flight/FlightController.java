package com.example.smart4aviation.smart4aviation.flight;

import com.example.smart4aviation.smart4aviation.flightmodel.Flight;
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

    @GetMapping(value = "{arrivalAirportIATACode}")
    public String getFlightByIata(@PathVariable("arrivalAirportIATACode") String arrivalAirportIATACode){
        return flightService.findFlightbyIata(arrivalAirportIATACode);
    }

    @PostMapping
    public void addFlight(@RequestBody Flight flight){
        flightService.addNewFlight(flight);
    }
}
