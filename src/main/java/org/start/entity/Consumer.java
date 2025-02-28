package org.start.entity;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "consumers")
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false, length = 10, unique = true)
    private String username;

    @Column(nullable = false, length = 60)  // Increased length for encoded password
    private String password;
}
