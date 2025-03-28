package org.bezy.service;

import org.bezy.model.booking.Payment;
import org.bezy.model.enums.PaymentStatus;

import java.util.List;

public interface PaymentService {
    Payment processPayment(Payment payment);
    Payment getPaymentByBookingId(Long bookingId);
    List<Payment> getPaymentsByStatus(PaymentStatus status);
    Double getTotalPaymentsByConsumer(Long consumerId);
}
