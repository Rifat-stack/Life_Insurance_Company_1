package com.example.life_insurance_main.PolicyManager;

public class ApproveRenewal {
    private String id;
    private String name;
    private String date;
    private String policyname;
    private String req;

    public ApproveRenewal(String id, String name, String date, String policyname, String req) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.policyname = policyname;
        this.req = req;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPolicyname() {
        return policyname;
    }

    public void setPolicyname(String policyname) {
        this.policyname = policyname;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }
}
