package com.example.life_insurance_main;

import java.time.LocalDate;

public class PaymentRecord {
    private String paymentId;
    private String customerId;
    private String policyId;
    private LocalDate paymentDate;
    private double amountPaid;
    private String paymentMethod;
    private String receiptId;

    public PaymentRecord(String paymentId, String customerId, String policyId,
                         LocalDate paymentDate, double amountPaid,
                         String paymentMethod, String receiptId) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.policyId = policyId;
        this.paymentDate = paymentDate;
        this.amountPaid = amountPaid;
        this.paymentMethod = paymentMethod;
        this.receiptId = receiptId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public String getPaymentSummary() {
        return "Payment ID: " + paymentId +
                "\nCustomer ID: " + customerId +
                "\nPolicy ID: " + policyId +
                "\nPayment Date: " + paymentDate +
                "\nAmount Paid: $" + amountPaid +
                "\nPayment Method: " + paymentMethod +
                "\nReceipt ID: " + receiptId;
    }
}