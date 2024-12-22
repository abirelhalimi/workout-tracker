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

import com.aeh.workout_tracker.models.MuscleGroup;
import com.aeh.workout_tracker.services.MuscleGroupService;




@RestController
@RequestMapping("/api/v1/musclegroups")
public class MuscleGroupCrudController {
    private final MuscleGroupService muscleGroupService;

    public MuscleGroupCrudController(MuscleGroupService muscleGroupService) {
        this.muscleGroupService = muscleGroupService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MuscleGroup> getMuscleGroup(@PathVariable Long id) {
        return ResponseEntity.of(muscleGroupService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<MuscleGroup>> getAllMuscleGroups() {
        return ResponseEntity.ok(muscleGroupService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<MuscleGroup> createMuscleGroup(@RequestBody MuscleGroup muscleGroup) {
        return new ResponseEntity<>(muscleGroupService.save(muscleGroup), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MuscleGroup> updateMuscleGroup(@PathVariable Long id, @RequestBody MuscleGroup newMuscleGroupData) {        
        return ResponseEntity.ok(muscleGroupService.update(id, newMuscleGroupData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMuscleGroup(@PathVariable Long id) {
        muscleGroupService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
