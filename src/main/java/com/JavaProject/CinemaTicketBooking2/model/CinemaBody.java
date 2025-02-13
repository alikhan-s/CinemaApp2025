package com.JavaProject.CinemaTicketBooking2.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class CinemaBody {

    @Column(nullable = false)
    private String name;

    public CinemaBody() {
    }

    public CinemaBody(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaBody that = (CinemaBody) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
