package com.gp.passeios.repository;


import com.gp.passeios.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Long> {}
