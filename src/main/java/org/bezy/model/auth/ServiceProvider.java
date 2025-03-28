package org.bezy.model.auth;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "Company Name is required")
    @Column(nullable = false, unique = true)
    private String companyName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "Phone Number is required")
    @Pattern(regexp = "^[0-9]+$", message = "Mobile number must contain only digits")
    @Size(min = 10, max = 10, message = "Mobile number must be exactly 10 digits")
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @NotEmpty(message = "Password is required")
    @Column(nullable = false)
    private String password;

    @NotEmpty(message = "Field Service Type is required")
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