package com.JavaProject.CinemaTicketBooking2.controller;

import com.JavaProject.CinemaTicketBooking2.model.Cinema;
import com.JavaProject.CinemaTicketBooking2.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;

    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @PostMapping
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @GetMapping("/{id}")
    public Cinema getCinemaById(@PathVariable Long id) {
        return cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Cinema updateCinema(@PathVariable Long id, @RequestBody Cinema cinemaDetails) {
        Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found with id: " + id));

        cinema.setName(cinemaDetails.getName());
        cinema.setLocation(cinemaDetails.getLocation());
        return cinemaRepository.save(cinema);
    }

    @DeleteMapping("/{id}")
    public String deleteCinema(@PathVariable Long id) {
        Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found with id: " + id));

        cinemaRepository.delete(cinema);
        return "Cinema deleted successfully with id: " + id;
    }
}
