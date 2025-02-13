package com.JavaProject.CinemaTicketBooking2.repository;

import com.JavaProject.CinemaTicketBooking2.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
