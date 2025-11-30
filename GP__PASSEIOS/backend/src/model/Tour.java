package com.gp.passeios.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(mappedBy = "tour", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore 
    private List<Booking> bookings = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(double durationHours) {
        this.durationHours = durationHours;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIdealTime() {
        return idealTime;
    }

    public void setIdealTime(String idealTime) {
        this.idealTime = idealTime;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
