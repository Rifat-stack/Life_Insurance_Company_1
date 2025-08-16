package com.example.life_insurance_main;

import java.time.LocalDate;

public class Premium {
    private String billId;
    private String customerId;
    private String policyId;
    private double amountDue;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private boolean isPaid;
    private String paymentMethod;

    // --- Constructor ---
    public Premium(String billId, String customerId, String policyId, double amountDue,
                   LocalDate dueDate, LocalDate paymentDate, boolean isPaid, String paymentMethod) {
        this.billId = billId;
        this.customerId = customerId;
        this.policyId = policyId;
        this.amountDue = amountDue;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.isPaid = isPaid;
        this.paymentMethod = paymentMethod;
    }

    // --- Getters and Setters ---
    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
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

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public boolean isOverdue() {
        return !isPaid && LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return "Premium{" +
                "billId='" + billId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", policyId='" + policyId + '\'' +
                ", amountDue=" + amountDue +
                ", dueDate=" + dueDate +
                ", paymentDate=" + paymentDate +
                ", isPaid=" + isPaid +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
}
}

