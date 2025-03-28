package org.bezy.service.booking;

import jakarta.transaction.Transactional;
import org.bezy.model.booking.Booking;
import org.bezy.enums.BookingStatus;
import org.bezy.enums.ServiceType;
import org.bezy.repository.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
