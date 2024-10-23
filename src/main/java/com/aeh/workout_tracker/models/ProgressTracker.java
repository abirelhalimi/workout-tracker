package com.aeh.workout_tracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="PTRACKER_SQ", sequenceName="ptracker_sequence")
public class ProgressTracker {
    
    @Id
    @GeneratedValue(generator = "PTRACKER_SQ", strategy=GenerationType.AUTO)
    private Long id;

    private int totalWorkouts;

    private int totalTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalWorkouts() {
        return totalWorkouts;
    }

    public void setTotalWorkouts(int totalWorkouts) {
        this.totalWorkouts = totalWorkouts;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }


}
