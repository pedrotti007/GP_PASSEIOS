package com.gp.passeios.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "bookings")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private String clientEmail;
    private String date;


    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;


    private LocalDateTime createdAt = LocalDateTime.now();


// getters e setters
}