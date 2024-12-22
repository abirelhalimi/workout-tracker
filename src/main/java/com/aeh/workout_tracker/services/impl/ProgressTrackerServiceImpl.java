package com.aeh.workout_tracker.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aeh.workout_tracker.models.ProgressTracker;
import com.aeh.workout_tracker.repositories.ProgressTrackerRepository;
import com.aeh.workout_tracker.services.ProgressTrackerService;

@Service
public class ProgressTrackerServiceImpl extends GenericServiceImpl<ProgressTracker, Long> implements ProgressTrackerService {
    private final ProgressTrackerRepository repository;

    public ProgressTrackerServiceImpl(ProgressTrackerRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<ProgressTracker, Long> repository() {
        return repository;
    }

    
}
