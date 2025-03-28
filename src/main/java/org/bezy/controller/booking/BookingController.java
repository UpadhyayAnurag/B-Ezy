package org.bezy.controller.booking;

import org.bezy.model.booking.Booking;
import org.bezy.enums.BookingStatus;
import org.bezy.enums.ServiceType;
import org.bezy.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking created = bookingService.createBooking(booking);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        // In a complete implementation, get booking by id would be implemented.
        // Here we use search by consumer id or status.
        List<Booking> bookings = bookingService.getBookingsByStatus(BookingStatus.PENDING);
        return bookings.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(bookings.get(0));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Booking>> searchBookings(
            @RequestParam(required = false) ServiceType serviceType,
            @RequestParam(required = false) BookingStatus status,
            @RequestParam(required = false) Long consumerId) {
        if (consumerId != null) {
            return ResponseEntity.ok(bookingService.getBookingsByConsumer(consumerId));
        }
        if (serviceType != null) {
            return ResponseEntity.ok(bookingService.getBookingsByServiceType(serviceType));
        }
        if (status != null) {
            return ResponseEntity.ok(bookingService.getBookingsByStatus(status));
        }
        return ResponseEntity.ok(bookingService.getBookingsByStatus(BookingStatus.PENDING));
    }
}

