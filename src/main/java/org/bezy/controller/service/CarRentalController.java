package org.bezy.controller.service;

import org.bezy.model.services_model.CarRental;
import org.bezy.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/car-rentals")
public class CarRentalController {

    @Autowired
    private CarRentalService carRentalService;

    @GetMapping
    public ResponseEntity<List<CarRental>> getAvailableCarRentals() {
        List<CarRental> rentals = carRentalService.getAvailableCarRentals();
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CarRental>> searchCarRentals(
            @RequestParam Double minRent,
            @RequestParam Double maxRent) {
        List<CarRental> rentals = carRentalService.filterCarRentalsByRentRange(minRent, maxRent);
        return ResponseEntity.ok(rentals);
    }

    @PostMapping
    public ResponseEntity<CarRental> addCarRental(@RequestBody CarRental carRental) {
        CarRental created = carRentalService.addCarRental(carRental);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarRental> updateCarRental(@PathVariable Long id, @RequestBody CarRental carRental) {
        CarRental updated = carRentalService.updateCarRental(carRental);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarRental(@PathVariable Long id) {
        carRentalService.deleteCarRental(id);
        return ResponseEntity.ok("Car rental deleted successfully");
    }
}

