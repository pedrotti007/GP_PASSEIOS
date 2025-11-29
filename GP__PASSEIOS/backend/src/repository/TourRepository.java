package com.gp.passeios.repository;


import com.gp.passeios.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TourRepository extends JpaRepository<Tour, Long> {}