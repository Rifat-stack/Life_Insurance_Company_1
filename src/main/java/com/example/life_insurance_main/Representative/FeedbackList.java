package com.example.life_insurance_main.Representative;

public abstract class FeedbackList {
    protected String id;
    protected String type;
    protected String feedback;

    public FeedbackList(String id, String type, String feedback) {
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

    public abstract String getMessage();
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
