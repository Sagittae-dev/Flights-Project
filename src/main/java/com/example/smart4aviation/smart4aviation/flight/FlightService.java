package com.example.smart4aviation.smart4aviation.flight;

import com.example.smart4aviation.smart4aviation.flightmodel.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightService implements ParsingService {

    private final FlightRepository flightRepository;

    /*@Value("${url.flights}")
    private String urlToFlights;*/

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getFlightList(){
        return flightRepository.findAll();
    }

    @Override
    public Object parse(String url) {
        return restTemplate.getForObject(url, Object.class);
    }

    public void addNewFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public String findFlightbyIata(String arrivalAirportIATACode) {
        List<Flight> listOfArrives = flightRepository.findByarrivalAirportIATACode(arrivalAirportIATACode);
        List<Flight> listOfDepartures = flightRepository.findBydepartureAirportIATACode(arrivalAirportIATACode);
        return "Number of flights departing from "+arrivalAirportIATACode+" airport: " + listOfDepartures.size()+ "\n Number of flights arriving from " +arrivalAirportIATACode+ " airport: " + listOfArrives.size();
    }
}
