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

import com.aeh.workout_tracker.models.ExerciseLog;
import com.aeh.workout_tracker.services.ExerciseLogService;

@RestController
@RequestMapping("/api/v1/exerciselogs")
public class ExerciseLogCrudController {
    
    private final ExerciseLogService exerciseLogService;

    public ExerciseLogCrudController(ExerciseLogService exerciseLogService) {
        this.exerciseLogService = exerciseLogService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseLog> getExerciseLog(@PathVariable Long id) {
        return ResponseEntity.of(exerciseLogService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<ExerciseLog>> getAllExerciseLogs() {
        return ResponseEntity.ok(exerciseLogService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<ExerciseLog> createExerciseLog(@RequestBody ExerciseLog exerciseLog) {
        return new ResponseEntity<>(exerciseLogService.save(exerciseLog), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciseLog> updateExerciseLog(@PathVariable Long id, @RequestBody ExerciseLog newExerciseLogData) {        
        return ResponseEntity.ok(exerciseLogService.update(id, newExerciseLogData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExerciseLog(@PathVariable Long id) {
        exerciseLogService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
