package com.gp.passeios.controller;


import com.gp.passeios.model.Tour;
import com.gp.passeios.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/tours")
@CrossOrigin
public class TourController {


    private final TourRepository repo;


    @Autowired
    public TourController(final TourRepository repo) {
        this.repo = repo;
    }


    @GetMapping
    public List<Tour> list() {
        return repo.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tour> get(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Tour> create(@RequestBody Tour tour) {
        Tour novoTour = repo.save(tour);
        return new ResponseEntity<>(novoTour, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tour> update(@PathVariable Long id, @RequestBody Tour tourDetails) {
        return repo.findById(id)
                .map(tour -> {
                    tour.setTitle(tourDetails.getTitle());
                    tour.setDescription(tourDetails.getDescription());
                    tour.setDurationHours(tourDetails.getDurationHours());
                    tour.setPrice(tourDetails.getPrice());
                    tour.setLocation(tourDetails.getLocation());
                    tour.setIdealTime(tourDetails.getIdealTime());
                    Tour tourAtualizado = repo.save(tour);
                    return ResponseEntity.ok(tourAtualizado);
                }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repo.findById(id)
                .map(tour -> {
                    repo.delete(tour);
                    return ResponseEntity.noContent().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}