package com.JavaProject.CinemaTicketBooking2.dao;

import com.JavaProject.CinemaTicketBooking2.model.Cinema;
import java.util.List;

public interface CinemaDAO {
    List<Cinema> findAll();
    Cinema findById(Long id);
    void save(Cinema cinema);
    void update(Cinema cinema);
    void delete(Long id);
}
