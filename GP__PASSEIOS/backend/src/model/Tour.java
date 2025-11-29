package com.gp.passeios.model;


import jakarta.persistence.*;


@Entity
@Table(name = "tours")
public class Tour {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double durationHours;
    private double price;
    private String location;
    private String idealTime;


// getters e setters
}
