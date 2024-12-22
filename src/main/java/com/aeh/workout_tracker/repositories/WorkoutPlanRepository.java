package com.aeh.workout_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeh.workout_tracker.models.WorkoutPlan;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
    
}
