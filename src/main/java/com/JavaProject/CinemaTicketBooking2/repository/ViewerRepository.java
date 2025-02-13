package com.JavaProject.CinemaTicketBooking2.repository;

import com.JavaProject.CinemaTicketBooking2.model.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Long> {
}
