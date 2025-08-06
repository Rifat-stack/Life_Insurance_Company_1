package com.example.life_insurance_main.PolicyManager;

import java.time.LocalDate;

public class AssignUnderwriter {
    public String id;
    public LocalDate localdate;
    public String type;

    public AssignUnderwriter(String id, LocalDate localdate, String type) {
        this.id = id;
        this.localdate = localdate;
        this.type = type;
    }

    public LocalDate getLocaldate() {
        return localdate;
    }

    public void setLocaldate(LocalDate localdate) {
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
