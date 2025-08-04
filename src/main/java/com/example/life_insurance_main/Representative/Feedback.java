package com.example.life_insurance_main.Representative;

public class Feedback {
    private String id;
    private String type;
    private String feedback;

    public Feedback(String id, String type, String feedback) {
        this.id = id;
        this.type = type;
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
