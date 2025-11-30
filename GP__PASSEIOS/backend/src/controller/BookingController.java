package com.gp.passeios.controller;


import com.gp.passeios.model.Booking;
import com.gp.passeios.repository.BookingRepository;
import com.gp.passeios.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import com.gp.passeios.model.Tour;


@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {


    private final BookingRepository repo;
    private final TourRepository tours;


    @Autowired
    public BookingController(BookingRepository repo, TourRepository tours) {
        this.repo = repo;
        this.tours = tours;
    }


    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody Booking bookingRequest) {
        Tour tour = tours.findById(bookingRequest.getTour().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Passeio não encontrado"));

        bookingRequest.setTour(tour);
        Booking novaReserva = repo.save(bookingRequest);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }


    @GetMapping
    public List<Booking> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> get(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> update(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        return repo.findById(id)
                .map(booking -> {
                    Tour tour = tours.findById(bookingDetails.getTour().getId())
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Passeio não encontrado para atualização"));

                    booking.setClientName(bookingDetails.getClientName());
                    booking.setClientEmail(bookingDetails.getClientEmail());
                    booking.setDate(bookingDetails.getDate());
                    booking.setTour(tour); 
                    Booking bookingAtualizada = repo.save(booking);
                    return ResponseEntity.ok(bookingAtualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repo.findById(id).map(booking -> {
            repo.delete(booking);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
