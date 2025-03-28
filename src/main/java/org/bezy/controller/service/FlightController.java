package org.bezy.controller.service;

import org.bezy.model.services_model.Flight;
import org.bezy.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id) {
        List<Flight> flights = flightService.searchFlights("NYC", "LAX");
        return flights.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(flights.get(0));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String departure,
            @RequestParam String destination,
            @RequestParam(required = false) String start,
            @RequestParam(required = false) String end) {

        LocalDateTime startTime = (start != null) ? LocalDateTime.parse(start) : LocalDateTime.now().minusDays(1);
        LocalDateTime endTime = (end != null) ? LocalDateTime.parse(end) : LocalDateTime.now().plusDays(1);
        List<Flight> flights = flightService.findFlightsWithinPeriod(startTime, endTime);
        return ResponseEntity.ok(flights);
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight created = flightService.addFlight(flight);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Flight updated = flightService.updateFlight(flight);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.ok("Flight deleted successfully");
    }
}

