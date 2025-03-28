package org.bezy.service.booking;

import org.bezy.model.booking.Booking;
import org.bezy.enums.BookingStatus;
import org.bezy.enums.ServiceType;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getBookingsByConsumer(Long consumerId);
    List<Booking> getBookingsByServiceType(ServiceType serviceType);
    List<Booking> getBookingsByStatus(BookingStatus status);
}

