package com.example.plannerr.models;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("success")
    private boolean success;
    @SerializedName("message")
    private String message;
    @SerializedName("user")
    User UserObject;
    @SerializedName("image_link")
    private String image_link;
    @SerializedName("email_link")
    private String email_link;
    @SerializedName("token")
    private String token;
    @SerializedName("goal")
    Goal GoalObject;

    // Getter Methods

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return UserObject;
    }

    public String getImage_link() {
        return image_link;
    }

    public String getEmail_link() {
        return email_link;
    }

    public String getToken() {
        return token;
    }

    public Goal getGoal() {
        return GoalObject;
    }

    // Setter Methods

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(User userObject) {
        this.UserObject = userObject;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public void setEmail_link(String email_link) {
        this.email_link = email_link;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setGoal(Goal goalObject) {
        this.GoalObject = goalObject;
    }
}
