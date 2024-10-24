package com.aeh.workout_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeh.workout_tracker.models.ProgressTracker;

public interface ProgressTrackerRepository extends JpaRepository<ProgressTracker, Long> {
    
}
