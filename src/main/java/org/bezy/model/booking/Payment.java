package org.bezy.model.booking;

import jakarta.persistence.*;
import lombok.*;
import org.bezy.enums.PaymentStatus;
import org.bezy.model.auth.Consumer;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consumer_id", nullable = false)
    private Consumer consumer;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus; // SUCCESS, FAILED, PENDING

    @Column(nullable = false)
    private LocalDateTime paymentDate = LocalDateTime.now();
}
