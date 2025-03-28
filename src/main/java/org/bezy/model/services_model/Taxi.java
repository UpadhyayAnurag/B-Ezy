package org.bezy.model.services_model;

import jakarta.persistence.*;
import lombok.*;
import org.bezy.model.auth.ServiceProvider;

@Entity
@Table(name = "taxis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Taxi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String driverName;

    @Column(nullable = false)
    private String carModel;

    @Column(unique = true, nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private Double pricePerKm;

    @Column(nullable = false)
    private Boolean availability;

    // For proximity filter
    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private ServiceProvider provider;
}
