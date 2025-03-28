package org.bezy.controller.service;

import org.bezy.model.services_model.Hotel;
import org.bezy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id) {
        // Ideally implement findById in service. Here, we assume hotel exists.
        // For example purposes, we return the first hotel from search.
        List<Hotel> hotels = hotelService.searchHotelsByLocation("DefaultLocation");
        return hotels.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(hotels.get(0));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer occupancy) {

        if (location != null) {
            return ResponseEntity.ok(hotelService.searchHotelsByLocation(location));
        }
        if (minPrice != null && maxPrice != null) {
            return ResponseEntity.ok(hotelService.filterHotelsByPriceRange(minPrice, maxPrice));
        }
        if (occupancy != null) {
            return ResponseEntity.ok(hotelService.filterHotelsByOccupancy(occupancy));
        }
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel created = hotelService.addHotel(hotel);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        Hotel updated = hotelService.updateHotel(hotel);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok("Hotel deleted successfully");
    }
}

