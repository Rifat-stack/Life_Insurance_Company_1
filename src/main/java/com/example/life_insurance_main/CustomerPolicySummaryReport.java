package com.example.life_insurance_main;

import java.time.LocalDate;

public class CustomerPolicySummaryReport {
    private String reportId;
    private String agentId;
    private String dateRange;
    private int numPoliciesSold;
    private int numApplicationsSubmitted;
    private int numApprovedApplications;
    private double totalCommission;
    private LocalDate generationDate;

    public CustomerPolicySummaryReport(String reportId, String agentId, String dateRange, int numPoliciesSold, int numApplicationsSubmitted, int numApprovedApplications, double totalCommission, LocalDate generationDate)
    {
        this.reportId = reportId;
        this.agentId = agentId;
        this.dateRange = dateRange;
        this.numPoliciesSold = numPoliciesSold;
        this.numApplicationsSubmitted = numApplicationsSubmitted;
        this.numApprovedApplications = numApprovedApplications;
        this.totalCommission = totalCommission;
        this.generationDate = generationDate;
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

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public int getNumPoliciesSold() {
        return numPoliciesSold;
    }

    public void setNumPoliciesSold(int numPoliciesSold) {
        this.numPoliciesSold = numPoliciesSold;
    }

    public int getNumApplicationsSubmitted() {
        return numApplicationsSubmitted;
    }

    public void setNumApplicationsSubmitted(int numApplicationsSubmitted) {
        this.numApplicationsSubmitted = numApplicationsSubmitted;
    }

    public int getNumApprovedApplications() {
        return numApprovedApplications;
    }

    public void setNumApprovedApplications(int numApprovedApplications) {
        this.numApprovedApplications = numApprovedApplications;
    }

    public double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public LocalDate getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(LocalDate generationDate) {
        this.generationDate = generationDate;
    }

    @Override
    public String toString() {
        return "CustomerPolicySummaryReport{" +
                "reportId='" + reportId + '\'' +
                ", agentId='" + agentId + '\'' +
                ", dateRange='" + dateRange + '\'' +
                ", numPoliciesSold=" + numPoliciesSold +
                ", numApplicationsSubmitted=" + numApplicationsSubmitted +
                ", numApprovedApplications=" + numApprovedApplications +
                ", totalCommission=" + totalCommission +
                ", generationDate=" + generationDate +
                '}';
    }
}

