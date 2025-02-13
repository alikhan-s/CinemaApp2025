package com.JavaProject.CinemaTicketBooking2.repository;

import com.JavaProject.CinemaTicketBooking2.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
