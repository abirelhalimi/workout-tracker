package com.aeh.workout_tracker.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aeh.workout_tracker.models.WorkoutPlan;
import com.aeh.workout_tracker.repositories.WorkoutPlanRepository;
import com.aeh.workout_tracker.services.WorkoutPlanService;

@Service
public class WorkoutPlanServiceImpl extends GenericServiceImpl<WorkoutPlan, Long> implements WorkoutPlanService {
    private final WorkoutPlanRepository repository;

    public WorkoutPlanServiceImpl(WorkoutPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<WorkoutPlan, Long> repository() {
        return repository;
    }

    
}
