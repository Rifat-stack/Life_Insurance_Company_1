package com.example.life_insurance_main.Representative;

public class Feedback extends FeedbackList {
    private String id;
    private String type;
    private String feedback ;

    public Feedback(String id, String type, String feedback) {
        super(id, type,feedback);
//        this.id = id;
//        this.type = type;// Call constructor of abstract base class
//        this.feedback = feedback;
    }

    @Override
    public String getMessage() {
        return feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
