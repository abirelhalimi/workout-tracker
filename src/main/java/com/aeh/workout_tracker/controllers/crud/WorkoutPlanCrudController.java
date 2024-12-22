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

import com.aeh.workout_tracker.models.WorkoutPlan;
import com.aeh.workout_tracker.services.WorkoutPlanService;


@RestController
@RequestMapping("/api/v1/workoutplans")
public class WorkoutPlanCrudController {
    
    private final WorkoutPlanService workoutPlanService;

    public WorkoutPlanCrudController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutPlan> getWorkoutPlan(@PathVariable Long id) {
        return ResponseEntity.of(workoutPlanService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<WorkoutPlan>> getAllWorkoutPlans() {
        return ResponseEntity.ok(workoutPlanService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<WorkoutPlan> createWorkoutPlan(@RequestBody WorkoutPlan WorkoutPlan) {
        return new ResponseEntity<>(workoutPlanService.save(WorkoutPlan), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutPlan> updateWorkoutPlan(@PathVariable Long id, @RequestBody WorkoutPlan newWorkoutPlanData) {        
        return ResponseEntity.ok(workoutPlanService.update(id, newWorkoutPlanData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutPlan(@PathVariable Long id) {
        workoutPlanService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
