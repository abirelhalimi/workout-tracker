package com.aeh.workout_tracker.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aeh.workout_tracker.models.Exercise;
import com.aeh.workout_tracker.repositories.ExerciseRepository;
import com.aeh.workout_tracker.services.ExerciseService;

@Service
public class ExerciseServiceImpl extends GenericServiceImpl<Exercise, Long> implements ExerciseService{

    private final ExerciseRepository repository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.repository = exerciseRepository;
    }

    @Override
    protected CrudRepository<Exercise, Long> repository() {
        return repository;
    }
    
}
