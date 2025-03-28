package org.bezy.service.booking;

import org.bezy.model.booking.Payment;
import org.bezy.enums.PaymentStatus;

import java.util.List;

public interface PaymentService {
    Payment processPayment(Payment payment);
    Payment getPaymentByBookingId(Long bookingId);
    List<Payment> getPaymentsByStatus(PaymentStatus status);
    Double getTotalPaymentsByConsumer(Long consumerId);
}
