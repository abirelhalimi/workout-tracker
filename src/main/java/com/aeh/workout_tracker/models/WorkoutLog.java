package com.aeh.workout_tracker.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="WOLOG_SQ", sequenceName="wolog_sequence")
public class WorkoutLog {
    
    @Id
    @GeneratedValue(generator="WOLOG_SQ", strategy=GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    
    private int duration;

    private String notes;

    @ManyToOne
    private WorkoutPlan workoutPlan;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy="workoutLog", cascade=CascadeType.ALL)
    private Set<ExerciseLog> exerciseLog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ExerciseLog> getExerciseLog() {
        return exerciseLog;
    }

    public void setExerciseLog(Set<ExerciseLog> exerciseLog) {
        this.exerciseLog = exerciseLog;
    }

}
