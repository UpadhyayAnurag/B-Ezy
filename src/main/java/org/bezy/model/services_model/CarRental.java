package org.bezy.model.services_model;

import jakarta.persistence.*;
import lombok.*;
import org.bezy.model.auth.ServiceProvider;

@Entity
@Table(name = "car_rentals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String carModel;

    @Column(unique = true, nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private Double dailyRent;

    @Column(nullable = false)
    private Boolean availability;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private ServiceProvider provider;
}
