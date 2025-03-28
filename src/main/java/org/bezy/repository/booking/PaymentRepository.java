package org.bezy.repository.booking;

import org.bezy.model.booking.Payment;
import org.bezy.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Retrieve payment by booking id
    Payment findByBookingId(Long bookingId);

    // Find payments by payment status
    List<Payment> findByPaymentStatus(PaymentStatus paymentStatus);

    // Custom query: Sum the total payments for a specific consumer
    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.consumer.id = :consumerId")
    Double sumPaymentsByConsumer(@Param("consumerId") Long consumerId);
}
