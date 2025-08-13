package com.example.life_insurance_main.PolicyManager;

import java.io.Serializable;
import java.time.LocalDate;

public class CreateNewPolicy {
    private String name;
    private String id;
    private int Coverage;
    private int Premium;
    private LocalDate date;
    private String Status;

    public CreateNewPolicy(String name, String id, int premium, int coverage, LocalDate date) {
        this.name = name;
        this.id = id;
        Premium = premium;
        Coverage = coverage;
        this.date = date;
        this.Status ="Active";

    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCoverage() {
        return Coverage;
    }

    public void setCoverage(int coverage) {
        Coverage = coverage;
    }

    public int getPremium() {
        return Premium;
    }

    public void setPremium(int premium) {
        Premium = premium;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate validate) {
        date = validate;
    }
}
