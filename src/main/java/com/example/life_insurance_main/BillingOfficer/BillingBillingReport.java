package com.example.life_insurance_main.BillingOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.time.format.DateTimeFormatter;

public class BillingBillingReport {
    private String monthYear;
    private Double totalCollected;
    private Double totalPending;
    private Double totalLatePayments;
    private String policyNumbers;
    private Double paymentAmounts;

    public BillingBillingReport(String monthYear, Double totalCollected, Double totalPending, Double totalLatePayments, String policyNumbers, Double paymentAmounts) {
        this.monthYear = monthYear;
        this.totalCollected = totalCollected;
        this.totalPending = totalPending;
        this.totalLatePayments = totalLatePayments;
        this.policyNumbers = policyNumbers;
        this.paymentAmounts = paymentAmounts;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    public Double getTotalCollected() {
        return totalCollected;
    }

    public void setTotalCollected(Double totalCollected) {
        this.totalCollected = totalCollected;
    }

    public Double getTotalPending() {
        return totalPending;
    }

    public void setTotalPending(Double totalPending) {
        this.totalPending = totalPending;
    }

    public Double getTotalLatePayments() {
        return totalLatePayments;
    }

    public void setTotalLatePayments(Double totalLatePayments) {
        this.totalLatePayments = totalLatePayments;
    }

    public String getPolicyNumbers() {
        return policyNumbers;
    }

    public void setPolicyNumbers(String policyNumbers) {
        this.policyNumbers = policyNumbers;
    }

    public Double getPaymentAmounts() {
        return paymentAmounts;
    }

    public void setPaymentAmounts(Double paymentAmounts) {
        this.paymentAmounts = paymentAmounts;
    }

    // Helper method to generate mock report data
    public void generateReport(String monthYear) {
        this.monthYear = monthYear;
        this.totalCollected = 12500.00;
        this.totalPending = 3500.00;
        this.totalLatePayments = 1800.00;
        this.policyNumbers = "POL-1001,POL-1002,POL-1003,POL-1004";
        this.paymentAmounts = 2500.00;
    }

    // Helper method to get payment details as string
    public String getPaymentDetailsAsString() {
        if (policyNumbers == null || policyNumbers.isEmpty()) {
            return "No payment details available";
        }

        String[] policies = policyNumbers.split(",");
        StringBuilder sb = new StringBuilder();


        for (String policy : policies) {
            sb.append("Policy ").append(policy.trim())
                    .append(": $").append(String.format("%,.2f", paymentAmounts))
                    .append("\n");
        }
        return sb.toString();
    }

    public String formatCurrency(Double amount) {
    return String.format("%,.2f", amount);
    }

}



