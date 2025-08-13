package com.example.life_insurance_main.Representative;

import java.io.Serializable;

public class ForwordQuery implements Serializable {
    private String id;
    private String query;

    public ForwordQuery(String id, String query) {
        this.id = id;
        this.query = query;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
