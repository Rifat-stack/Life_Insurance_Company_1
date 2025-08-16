package com.example.life_insurance_main;

import java.time.LocalDate;

public class CommissionReport {
    private String reportId;
    private String agentId;
    private String customerId;
    private String policyId;
    private double commissionAmount;
    private double commissionRate;
    private LocalDate reportGenDate;

    public CommissionReport(String reportId, String agentId, String customerId, String policyId, double commissionAmount, double commissionRate, LocalDate reportGenDate)
    {
        this.reportId = reportId;
        this.agentId = agentId;
        this.customerId = customerId;
        this.policyId = policyId;
        this.commissionAmount = commissionAmount;
        this.commissionRate = commissionRate;
        this.reportGenDate = reportGenDate;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public LocalDate getReportGenDate() {
        return reportGenDate;
    }

    public void setReportGenDate(LocalDate reportGenDate) {
        this.reportGenDate = reportGenDate;
    }

    @Override
    public String toString() {
        return "CommissionReport{" +
                "reportId='" + reportId + '\'' +
                ", agentId='" + agentId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", policyId='" + policyId + '\'' +
                ", commissionAmount=" + commissionAmount +
                ", commissionRate=" + commissionRate +
                ", reportGenDate=" + reportGenDate +
                '}';
    }
}

