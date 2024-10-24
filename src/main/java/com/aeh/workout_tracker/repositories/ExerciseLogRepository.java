package com.aeh.workout_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeh.workout_tracker.models.ExerciseLog;

public interface ExerciseLogRepository extends JpaRepository<ExerciseLog, Long> {
    
}