package org.bezy.repository.booking;


import org.bezy.model.booking.Booking;
import org.bezy.model.enums.BookingStatus;
import org.bezy.model.enums.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByStatus(BookingStatus status);

    // Find bookings by consumer id
    List<Booking> findByConsumerId(Long consumerId);

    // Custom query: Find bookings for a specific service type
    List<Booking> findByServiceType(ServiceType serviceType);

    // Custom query: Find bookings by consumer email (assuming a join with consumer entity)
    List<Booking> findByConsumerEmail(String email);
}
