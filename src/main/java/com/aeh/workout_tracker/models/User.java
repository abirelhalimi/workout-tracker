package com.aeh.workout_tracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity(name = "users")
@SequenceGenerator(name = "USER_SQ", sequenceName = "user_sequence")
public class User {
    
    @Id
    @GeneratedValue(generator = "USER_SQ", strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    
    private String password;

    private String firstName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



}
