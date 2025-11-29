package com.gp.passeios.controller;


import com.gp.passeios.model.Tour;
import com.gp.passeios.repository.TourRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/tours")
@CrossOrigin
public class TourController {


    private final TourRepository repo;


    public TourController(TourRepository repo) {
        this.repo = repo;
    }


    @GetMapping
    public List<Tour> list() {
        return repo.findAll();
    }


    @GetMapping("/{id}")
    public Tour get(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}