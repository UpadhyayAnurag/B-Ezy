package org.bezy.model.booking;

import jakarta.persistence.*;
import lombok.*;
import org.bezy.enums.BookingStatus;
import org.bezy.enums.ServiceType;
import org.bezy.model.auth.Consumer;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consumer_id", nullable = false)
    private Consumer consumer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType serviceType; // HOTEL, FLIGHT, TAXI, CAR

    @Column(nullable = false)
    private Long serviceId;

    @Column(nullable = false)
    private LocalDateTime bookingDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private BookingStatus status; // PENDING, CONFIRMED, CANCELLED
}
