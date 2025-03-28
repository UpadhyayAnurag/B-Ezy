package org.bezy.controller.service;

import org.bezy.model.services_model.Taxi;
import org.bezy.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/taxis")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    @GetMapping
    public ResponseEntity<List<Taxi>> getAvailableTaxis() {
        List<Taxi> taxis = taxiService.getAvailableTaxis();
        return ResponseEntity.ok(taxis);
    }

    @GetMapping("/near")
    public ResponseEntity<List<Taxi>> getTaxisNearLocation(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam double radius) {
        List<Taxi> taxis = taxiService.findTaxisNearLocation(lat, lng, radius);
        return ResponseEntity.ok(taxis);
    }

    @PostMapping
    public ResponseEntity<Taxi> addTaxi(@RequestBody Taxi taxi) {
        Taxi created = taxiService.addTaxi(taxi);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Taxi> updateTaxi(@PathVariable Long id, @RequestBody Taxi taxi) {
        Taxi updated = taxiService.updateTaxi(taxi);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaxi(@PathVariable Long id) {
        taxiService.deleteTaxi(id);
        return ResponseEntity.ok("Taxi deleted successfully");
    }
}

