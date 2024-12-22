package com.aeh.workout_tracker.controllers.crud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeh.workout_tracker.models.ProgressTracker;
import com.aeh.workout_tracker.services.ProgressTrackerService;




@RestController
@RequestMapping("/api/v1/progresstrackers")
public class ProgressTrackerCrudController {
    private final ProgressTrackerService progressTrackerService;

    public ProgressTrackerCrudController(ProgressTrackerService progressTrackerService) {
        this.progressTrackerService = progressTrackerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgressTracker> getProgressTracker(@PathVariable Long id) {
        return ResponseEntity.of(progressTrackerService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<ProgressTracker>> getAllProgressTrackers() {
        return ResponseEntity.ok(progressTrackerService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<ProgressTracker> createProgressTracker(@RequestBody ProgressTracker progressTracker) {
        return new ResponseEntity<>(progressTrackerService.save(progressTracker), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgressTracker> updateProgressTracker(@PathVariable Long id, @RequestBody ProgressTracker newProgressTrackerData) {        
        return ResponseEntity.ok(progressTrackerService.update(id, newProgressTrackerData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgressTracker(@PathVariable Long id) {
        progressTrackerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
