package com.example.life_insurance_main.BillingOfficer;

import java.time.LocalDate;

public class BillingViewPendingPayments {
    private String billId;
    private String customerName;
    private LocalDate dueDate;
    private Double amount;
    private Integer daysOverdue;
    private String policyId;

    public BillingViewPendingPayments(String billId, String customerName, LocalDate dueDate, Double amount, Integer daysOverdue, String policyId) {
        this.billId = billId;
        this.customerName = customerName;
        this.dueDate = dueDate;
        this.amount = amount;
        this.daysOverdue = daysOverdue;
        this.policyId = policyId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getDaysOverdue() {
        return daysOverdue;
    }

    public void setDaysOverdue(Integer daysOverdue) {
        this.daysOverdue = daysOverdue;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }
}
