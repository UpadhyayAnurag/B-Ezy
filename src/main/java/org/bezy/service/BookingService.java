package org.bezy.service;

import org.bezy.model.booking.Booking;
import org.bezy.model.enums.BookingStatus;
import org.bezy.model.enums.ServiceType;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getBookingsByConsumer(Long consumerId);
    List<Booking> getBookingsByServiceType(ServiceType serviceType);
    List<Booking> getBookingsByStatus(BookingStatus status);
}

