package org.bezy.controller.booking;

import org.bezy.model.booking.Payment;
import org.bezy.enums.PaymentStatus;
import org.bezy.service.booking.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        Payment processed = paymentService.processPayment(payment);
        return ResponseEntity.ok(processed);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentByBookingId(id);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/consumer/{consumerId}")
    public ResponseEntity<List<Payment>> getPaymentsByConsumer(@PathVariable Long consumerId) {
        List<Payment> payments = paymentService.getPaymentsByStatus(PaymentStatus.SUCCESS);
        return ResponseEntity.ok(payments);
    }
}

