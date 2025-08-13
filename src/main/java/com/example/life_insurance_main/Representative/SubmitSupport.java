package com.example.life_insurance_main.Representative;

import java.io.Serializable;

public class SubmitSupport implements Serializable {
    private String id;
    private String type;
    private String text;

    public SubmitSupport(String id, String type, String text) {
        this.id = id;
        this.type = type;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
