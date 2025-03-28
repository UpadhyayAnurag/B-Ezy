package org.bezy.service;

import jakarta.transaction.Transactional;
import org.bezy.model.booking.Booking;
import org.bezy.model.enums.BookingStatus;
import org.bezy.model.enums.ServiceType;
import org.bezy.repository.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    @Transactional
    public Booking createBooking(Booking booking) {
        // Add availability checks and other business logic before booking
        booking.setStatus(BookingStatus.PENDING);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByConsumer(Long consumerId) {
        return bookingRepository.findByConsumerId(consumerId);
    }

    @Override
    public List<Booking> getBookingsByServiceType(ServiceType serviceType) {
        return bookingRepository.findByServiceType(serviceType);
    }

    @Override
    public List<Booking> getBookingsByStatus(BookingStatus status) {
        return bookingRepository.findByStatus(status);
    }
}
