package com.example.plannerr.models;

public class Data {

    private boolean success;
    private String message;
    User UserObject;
    private String image_link;
    private String email_link;


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
}
