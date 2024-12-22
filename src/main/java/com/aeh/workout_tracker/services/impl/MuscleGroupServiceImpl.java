package com.aeh.workout_tracker.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aeh.workout_tracker.models.MuscleGroup;
import com.aeh.workout_tracker.repositories.MuscleGroupRepository;
import com.aeh.workout_tracker.services.MuscleGroupService;

@Service
public class MuscleGroupServiceImpl extends GenericServiceImpl<MuscleGroup, Long> implements MuscleGroupService {
    private final MuscleGroupRepository repository;

    public MuscleGroupServiceImpl(MuscleGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<MuscleGroup, Long> repository() {
        return repository;
    }

}
