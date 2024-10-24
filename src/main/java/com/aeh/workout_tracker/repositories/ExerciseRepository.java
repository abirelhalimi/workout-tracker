package com.aeh.workout_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeh.workout_tracker.models.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    
}
