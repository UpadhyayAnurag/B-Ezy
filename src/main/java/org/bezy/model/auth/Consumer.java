package org.bezy.model.auth;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username is required")
    @Column(nullable = false, unique = true)
    private String username;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "consumer_roles",
            joinColumns = @JoinColumn(name = "consumer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
