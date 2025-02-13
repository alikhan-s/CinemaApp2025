package com.JavaProject.CinemaTicketBooking2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie extends CinemaBody {

    @Id
    private Long id;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private int ageLimit;

    public Movie() {
    }

    public Movie(String name, String genre, int duration, int ageLimit) {
        super(name);
        this.genre = genre;
        this.duration = duration;
        this.ageLimit = ageLimit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    @Override
    public String toString() {
        return super.toString() + "\nGenre: " + genre + " Duration: " + duration + "\nminutes, AgeLimit: " + ageLimit;
    }
}
