package com.aeh.workout_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeh.workout_tracker.models.WorkoutLog;

public interface  WorkoutLogRepository extends JpaRepository<WorkoutLog, Long> {
    
}
