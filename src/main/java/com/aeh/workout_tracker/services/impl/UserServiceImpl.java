package com.aeh.workout_tracker.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aeh.workout_tracker.models.User;
import com.aeh.workout_tracker.repositories.UserRepository;
import com.aeh.workout_tracker.services.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    protected CrudRepository<User, Long> repository() {
        return repository;
    }    
    
}
