package com.JavaProject.CinemaTicketBooking2.controller;

import com.JavaProject.CinemaTicketBooking2.dao.CinemaDAO;
import com.JavaProject.CinemaTicketBooking2.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {

    @Autowired
    private CinemaDAO cinemaDAO;

    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaDAO.findAll();
    }

    @PostMapping
    public void createCinema(@RequestBody Cinema cinema) {
        cinemaDAO.save(cinema);
    }

    @GetMapping("/{id}")
    public Cinema getCinemaById(@PathVariable Long id) {
        Cinema cinema = cinemaDAO.findById(id);
        if (cinema == null) {
            throw new RuntimeException("Cinema not found with id: " + id);
        }
        return cinema;
    }

    @PutMapping("/{id}")
    public void updateCinema(@PathVariable Long id, @RequestBody Cinema cinemaDetails) {
        cinemaDetails.setId(id);
        cinemaDAO.update(cinemaDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteCinema(@PathVariable Long id) {
        cinemaDAO.delete(id);
        return "Cinema deleted successfully with id: " + id;
    }
}
