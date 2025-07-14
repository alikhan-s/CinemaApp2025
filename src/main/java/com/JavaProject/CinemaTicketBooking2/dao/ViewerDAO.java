package com.JavaProject.CinemaTicketBooking2.dao;

import com.JavaProject.CinemaTicketBooking2.model.Viewer;
import java.util.List;

public interface ViewerDAO {
    List<Viewer> findAll();
    Viewer findById(Long id);
    void save(Viewer viewer);
    void update(Viewer viewer);
    void delete(Long id);
}
