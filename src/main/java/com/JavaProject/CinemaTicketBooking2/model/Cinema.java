package com.JavaProject.CinemaTicketBooking2.model;

import com.JavaProject.CinemaTicketBooking2.service.iTicketBooking;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Entity
@Table(name = "cinemas")
public class Cinema extends CinemaBody implements iTicketBooking {

    @Id
    private Long id;

    @Column(nullable = false)
    private String location;

    @Transient
    private final Random random = new Random();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Cinema() {
    }

    public Cinema(String name, String location) {
        super(name);
        this.location = location;
    }

    @Override
    public String bookTicket(List<String> movie, boolean check) {
        if (check) {
            return "Cinema: " + getName() +
                    "\nLocation: " + location +
                    "\nMovie: " + movie.get(0) +
                    "\nDate: 15.01.2025" +
                    "\nTime: " + (13 + random.nextInt(6)) + ":00\n" +
                    "Hall: " + (1 + random.nextInt(1)) +
                    "\nRow: " + (1 + random.nextInt(11)) + ", Seat: " + (1 + random.nextInt(11)) +
                    "\n\nTicket Price: $10.00";
        }
        return "You are under " + movie.get(1) + " years old";
    }

    @Override
    public String toString() {
        return super.toString() + ", Location: " + location;
    }
}