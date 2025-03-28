package org.bezy.service.booking;

import jakarta.transaction.Transactional;
import org.bezy.model.booking.Payment;
import org.bezy.enums.PaymentStatus;
import org.bezy.repository.booking.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements  PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public Payment processPayment(Payment payment) {
        // Payment processing logic, e.g., integration with payment gateways, can be added here
        payment.setPaymentStatus(PaymentStatus.PENDING);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentByBookingId(Long bookingId) {
        return paymentRepository.findByBookingId(bookingId);
    }

    @Override
    public List<Payment> getPaymentsByStatus(PaymentStatus status) {
        return paymentRepository.findByPaymentStatus(status);
    }

    @Override
    public Double getTotalPaymentsByConsumer(Long consumerId) {
        return paymentRepository.sumPaymentsByConsumer(consumerId);
    }
}
