package org.bezy.model.auth;

import jakarta.persistence.*;
import lombok.*;
import org.bezy.model.services_model.CarRental;
import org.bezy.model.services_model.Flight;
import org.bezy.model.services_model.Hotel;
import org.bezy.model.services_model.Taxi;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "service_providers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String companyName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String serviceType; // HOTEL, FLIGHT, TAXI, CAR_RENTAL

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "provider_roles",
            joinColumns = @JoinColumn(name = "provider_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    // Service relationships
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> flights;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Taxi> taxis;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarRental> carRentals;
}