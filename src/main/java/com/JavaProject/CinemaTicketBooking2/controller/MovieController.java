package com.JavaProject.CinemaTicketBooking2.controller;

import com.JavaProject.CinemaTicketBooking2.dao.MovieDAO;
import com.JavaProject.CinemaTicketBooking2.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieDAO movieDAO;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieDAO.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieDAO.findById(id);
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieDAO.save(movie);
    }

    @PutMapping("/{id}")
    public void updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        movie.setId(id);
        movieDAO.update(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieDAO.delete(id);
    }
}

