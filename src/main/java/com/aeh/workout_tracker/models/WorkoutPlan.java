package com.aeh.workout_tracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;

@Entity
@SequenceGenerator(name = "WOPLAN_SQ", sequenceName = "woplan_sequence")
public class WorkoutPlan {
    
    @Id
    @GeneratedValue(generator="WOPLAN_SQ", strategy=GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
