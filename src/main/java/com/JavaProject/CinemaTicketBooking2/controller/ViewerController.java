package com.JavaProject.CinemaTicketBooking2.controller;

import com.JavaProject.CinemaTicketBooking2.dao.ViewerDAO;
import com.JavaProject.CinemaTicketBooking2.model.Viewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viewers")
public class ViewerController {

    @Autowired
    private ViewerDAO viewerDAO;

    @GetMapping
    public List<Viewer> getAllViewers() {
        return viewerDAO.findAll();
    }

    @PostMapping
    public void createViewer(@RequestBody Viewer viewer) {
        viewerDAO.save(viewer);
    }

    @GetMapping("/{id}")
    public Viewer getViewerById(@PathVariable Long id) {
        Viewer viewer = viewerDAO.findById(id);
        if (viewer == null) {
            throw new RuntimeException("Viewer not found with id: " + id);
        }
        return viewer;
    }

    @PutMapping("/{id}")
    public void updateViewer(@PathVariable Long id, @RequestBody Viewer viewer) {
        viewer.setId(id);
        viewerDAO.update(viewer);
    }

    @DeleteMapping("/{id}")
    public String deleteViewer(@PathVariable Long id) {
        viewerDAO.delete(id);
        return "Viewer deleted successfully with id: " + id;
    }
}
