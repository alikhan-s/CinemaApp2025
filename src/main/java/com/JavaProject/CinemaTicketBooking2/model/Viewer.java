package com.JavaProject.CinemaTicketBooking2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "viewers")
public class Viewer extends CinemaBody {

    @Id
    private Long id;

    @Column(nullable = false)
    private int age;

    public Viewer() {
    }

    public Viewer(String name, int age) {
        super(name);
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + ", Age: " + age;
    }
}