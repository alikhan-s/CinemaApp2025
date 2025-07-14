package com.JavaProject.CinemaTicketBooking2.dao;

import com.JavaProject.CinemaTicketBooking2.model.Movie;
import java.util.List;

public interface MovieDAO {
    List<Movie> findAll();
    Movie findById(Long id);
    void save(Movie movie);
    void update(Movie movie);
    void delete(Long id);
}
