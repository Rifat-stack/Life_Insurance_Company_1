package com.example.life_insurance_main.PolicyManager;



public class ApproveandReject {
    private String id;
    private String policyHolder;
    private String policyName;
    private String coverage;
    private String premium;
    private String status;

    public ApproveandReject(String id, String policyHolder, String policyName, String coverage, String premium) {
        this.id = id;
        this.policyHolder = policyHolder;
        this.policyName = policyName;
        this.coverage = coverage;
        this.premium = premium;
        this.status = "Pending";
    }



    public String getId() {
        return id;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public String getPolicyName() {
        return policyName;
    }

    public String getCoverage() {
        return coverage;
    }

    public String getPremium() {
        return premium;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus (String status){
        this.status= status;
    }


}
