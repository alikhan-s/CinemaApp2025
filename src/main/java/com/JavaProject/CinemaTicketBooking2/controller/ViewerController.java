package com.JavaProject.CinemaTicketBooking2.controller;

import com.JavaProject.CinemaTicketBooking2.model.Viewer;
import com.JavaProject.CinemaTicketBooking2.repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viewers")
public class ViewerController {

    @Autowired
    private ViewerRepository viewerRepository;

    @GetMapping
    public List<Viewer> getAllViewers() {
        return viewerRepository.findAll();
    }

    @PostMapping
    public Viewer createViewer(@RequestBody Viewer viewer) {
        return viewerRepository.save(viewer);
    }

    @GetMapping("/{id}")
    public Viewer getViewerById(@PathVariable Long id) {
        return viewerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viewer not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Viewer updateViewer(@PathVariable Long id, @RequestBody Viewer viewerDetails) {
        Viewer viewer = viewerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viewer not found with id: " + id));

        viewer.setName(viewerDetails.getName());
        viewer.setAge(viewerDetails.getAge());
        return viewerRepository.save(viewer);
    }

    @DeleteMapping("/{id}")
    public String deleteViewer(@PathVariable Long id) {
        Viewer viewer = viewerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viewer not found with id: " + id));

        viewerRepository.delete(viewer);
        return "Viewer deleted successfully with id: " + id;
    }
}