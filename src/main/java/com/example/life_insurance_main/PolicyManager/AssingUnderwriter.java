package com.example.life_insurance_main.PolicyManager;

import java.time.LocalDate;

public class AssingUnderwriter {
    public String id;
    public String localdate;
    public String type;

    public AssingUnderwriter(String id, String localdate, String type) {
        this.id = id;
        this.localdate = localdate;
        this.type = type;
    }

    public String getLocaldate() {
        return localdate;
    }

    public void setLocaldate(String localdate) {
        this.localdate = localdate;
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
