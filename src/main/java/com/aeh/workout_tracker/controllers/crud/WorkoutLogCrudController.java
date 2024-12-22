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

import com.aeh.workout_tracker.models.WorkoutLog;
import com.aeh.workout_tracker.services.WorkoutLogService;


@RestController
@RequestMapping("/api/v1/workoutlogs")
public class WorkoutLogCrudController {
    
    private final WorkoutLogService workoutLogService;

    public WorkoutLogCrudController(WorkoutLogService workoutLogService) {
        this.workoutLogService = workoutLogService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutLog> getWorkoutLog(@PathVariable Long id) {
        return ResponseEntity.of(workoutLogService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<WorkoutLog>> getAllWorkoutLogs() {
        return ResponseEntity.ok(workoutLogService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<WorkoutLog> createWorkoutLog(@RequestBody WorkoutLog WorkoutLog) {
        return new ResponseEntity<>(workoutLogService.save(WorkoutLog), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutLog> updateWorkoutLog(@PathVariable Long id, @RequestBody WorkoutLog newWorkoutLogData) {        
        return ResponseEntity.ok(workoutLogService.update(id, newWorkoutLogData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutLog(@PathVariable Long id) {
        workoutLogService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
