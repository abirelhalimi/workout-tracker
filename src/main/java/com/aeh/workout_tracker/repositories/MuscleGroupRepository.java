package com.aeh.workout_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeh.workout_tracker.models.MuscleGroup;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {
    
}
