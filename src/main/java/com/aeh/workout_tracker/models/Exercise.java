package com.aeh.workout_tracker.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;

@Entity
@SequenceGenerator(name="EXERCISE_SQ", sequenceName="exercise_sq")
public class Exercise {
    
    @Id
    @GeneratedValue(generator="EXERCISE_SQ", strategy=GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @ManyToMany
    @JoinTable(
        name = "exercise_muscle_group",
        joinColumns = @JoinColumn(name="exercise_id"),
        inverseJoinColumns = @JoinColumn(name = "muscle_group_id")
    )
    @NotEmpty
    private Set<MuscleGroup> MuscleGroups;

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

    public Set<MuscleGroup> getMuscleGroups() {
        return MuscleGroups;
    }

    public void setMuscleGroups(Set<MuscleGroup> MuscleGroups) {
        this.MuscleGroups = MuscleGroups;
    }


}
