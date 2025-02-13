package com.JavaProject.CinemaTicketBooking2.service;

import java.util.List;

public interface iTicketBooking {
    String bookTicket(List<String> movie, boolean check);
}