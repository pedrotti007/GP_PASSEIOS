package com.gp.passeios.controller;


import com.gp.passeios.model.Booking;
import com.gp.passeios.repository.BookingRepository;
import com.gp.passeios.repository.TourRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {


    private final BookingRepository repo;
    private final TourRepository tours;


    public BookingController(BookingRepository repo, TourRepository tours) {
        this.repo = repo;
        this.tours = tours;
    }


    @PostMapping
    public Booking create(@RequestBody Booking b) {
        b.setTour(tours.findById(b.getTour().getId()).orElse(null));
        return repo.save(b);
    }


    @GetMapping
    public List<Booking> list() {
        return repo.findAll();
    }
}
