package com.example.plannerr.models;

public class Goal {
    private String title;
    private String description;
    private String begin_date;
    private String due_date;
    private String level;
    private float goal_status;
    private String updated_at;
    private String created_at;
    private float id;


    // Getter Methods

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBegin_date() {
        return begin_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public String getLevel() {
        return level;
    }

    public float getGoal_status() {
        return goal_status;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public float getId() {
        return id;
    }

    // Setter Methods

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setGoal_status(float goal_status) {
        this.goal_status = goal_status;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setId(float id) {
        this.id = id;
    }

}
