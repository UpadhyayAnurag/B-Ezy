package org.bezy.service;

import org.bezy.model.services_model.Flight;
import org.bezy.repository.services_repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> searchFlights(String departure, String destination) {
        return flightRepository.findByDepartureAndDestination(departure, destination);
    }

    @Override
    public List<Flight> findFlightsWithinPeriod(LocalDateTime start, LocalDateTime end) {
        return flightRepository.findFlightsWithinPeriod(start, end);
    }

    // Provider functionality: add a new flight listing
    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Update flight details
    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Delete flight listing
    @Override
    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
