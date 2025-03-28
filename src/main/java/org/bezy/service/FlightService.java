package org.bezy.service;

import org.bezy.model.services_model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<Flight> getAllFlights();
    List<Flight> searchFlights(String departure, String destination);
    List<Flight> findFlightsWithinPeriod(LocalDateTime start, LocalDateTime end);
    // Filter by price or other criteria can be added here.



    // Provider listing functionality
    Flight addFlight(Flight flight);
    Flight updateFlight(Flight flight);
    void deleteFlight(Long flightId);
}
