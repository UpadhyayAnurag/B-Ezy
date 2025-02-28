package org.start.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_providers")
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false, length = 50, unique = true)
    private String userName;

    @Column(nullable = false, length = 60)  // Increased length for encoded password
    private String password;

    @Column(nullable = false, length = 20)
    private String service;

    @Column(length = 300)
    private String details = "We are great at what we do!";

    @Column(nullable = false)
    private Integer totalSlots = 0;

    @Column(name = "image_path")
    private String imagePath;
}
