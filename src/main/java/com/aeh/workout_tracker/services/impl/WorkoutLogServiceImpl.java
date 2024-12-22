package com.aeh.workout_tracker.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aeh.workout_tracker.models.WorkoutLog;
import com.aeh.workout_tracker.repositories.WorkoutLogRepository;
import com.aeh.workout_tracker.services.WorkoutLogService;

@Service
public class WorkoutLogServiceImpl extends GenericServiceImpl<WorkoutLog, Long> implements WorkoutLogService {
    private final WorkoutLogRepository repository;

    public WorkoutLogServiceImpl(WorkoutLogRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<WorkoutLog, Long> repository() {
        return repository;
    }

    
}
