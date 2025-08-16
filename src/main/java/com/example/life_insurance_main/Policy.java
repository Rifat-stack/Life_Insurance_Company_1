package com.example.life_insurance_main;

import com.example.life_insurance_main.Representative.AppendableObjectOutputStream;

import java.io.*;
import java.time.LocalDate;

public class Policy implements Serializable{
    private String policyId;
    private String title;
    private String coverageType;
    private double coverageAmount;
    private int termYears;
    private double premiumRate;
    private LocalDate expiryDate;
    private String renewalStatus;

    // --- Constructor ---
    public Policy(String policyId, String title, String coverageType, double coverageAmount,
                  int termYears, double premiumRate, LocalDate expiryDate, String renewalStatus) {
        this.policyId = policyId;
        this.title = title;
        this.coverageType = coverageType;
        this.coverageAmount = coverageAmount;
        this.termYears = termYears;
        this.premiumRate = premiumRate;
        this.expiryDate = expiryDate;
        this.renewalStatus = renewalStatus;
    }

    // --- Getters and Setters ---
    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public int getTermYears() {
        return termYears;
    }

    public void setTermYears(int termYears) {
        this.termYears = termYears;
    }

    public double getPremiumRate() {
        return premiumRate;
    }

    public void setPremiumRate(double premiumRate) {
        this.premiumRate = premiumRate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getRenewalStatus() {
        return renewalStatus;
    }

    public void setRenewalStatus(String renewalStatus) {
        this.renewalStatus = renewalStatus;
    }

    // --- Custom Methods ---

    public String getDetails() {
        return "Policy ID: " + policyId +
                "\nTitle: " + title +
                "\nCoverage Type: " + coverageType +
                "\nCoverage Amount: $" + coverageAmount +
                "\nTerm (Years): " + termYears +
                "\nPremium Rate: " + premiumRate + "%" +
                "\nExpiry Date: " + expiryDate +
                "\nRenewal Status: " + renewalStatus;
    }

    // Calculate remaining term (years left until expiry)
    public int getRemainingTerm() {
        if (expiryDate != null && expiryDate.isAfter(LocalDate.now())) {
            return expiryDate.getYear() - LocalDate.now().getYear();
        }
        return 0;
    }

    // Check if expiry is within 1 year
    public boolean isNearingExpiry() {
        if (expiryDate != null && expiryDate.isAfter(LocalDate.now())) {
            int yearsRemaining = expiryDate.getYear() - LocalDate.now().getYear();

            if (yearsRemaining == 0) {
                return true; // expires this year
            } else if (yearsRemaining == 1) {
                // same year next year but check month/day
                if (expiryDate.getMonthValue() < LocalDate.now().getMonthValue() ||
                        (expiryDate.getMonthValue() == LocalDate.now().getMonthValue() &&
                                expiryDate.getDayOfMonth() <= LocalDate.now().getDayOfMonth())) {
                    return true;
                }
            }
        }
        return false;
    }

}
