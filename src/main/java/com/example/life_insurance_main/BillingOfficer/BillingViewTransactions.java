package com.example.life_insurance_main.BillingOfficer;

import java.time.LocalDate;

public class BillingViewTransactions {
    private String transactionId;
    private LocalDate date;
    private Double amount;
    private String policyId;
    private String customerName;
    private String status;
    private String paymentMethod;

    public BillingViewTransactions(String transactionId, LocalDate date, Double amount, String policyId, String customerName, String status, String paymentMethod) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.policyId = policyId;
        this.customerName = customerName;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}


