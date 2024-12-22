package com.aeh.workout_tracker.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aeh.workout_tracker.models.ExerciseLog;
import com.aeh.workout_tracker.repositories.ExerciseLogRepository;
import com.aeh.workout_tracker.services.ExerciseLogService;

@Service
public class ExerciseLogServiceImpl extends GenericServiceImpl<ExerciseLog, Long> implements ExerciseLogService {
    
    private final ExerciseLogRepository repository;

    public ExerciseLogServiceImpl(ExerciseLogRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<ExerciseLog, Long> repository() {
        return repository;
    }

    
}
