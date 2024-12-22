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

import com.aeh.workout_tracker.models.Exercise;
import com.aeh.workout_tracker.services.ExerciseService;

@RestController
@RequestMapping("/api/v1/exercises")
public class ExerciseCrudController {
    
    private final ExerciseService exerciseService;

    public ExerciseCrudController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExercise(@PathVariable Long id) {
        return ResponseEntity.of(exerciseService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Exercise>> getAllExercises() {
        return ResponseEntity.ok(exerciseService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        return new ResponseEntity<>(exerciseService.save(exercise), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody Exercise newExerciseData) {        
        return ResponseEntity.ok(exerciseService.update(id, newExerciseData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        exerciseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
