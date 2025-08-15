package com.example.life_insurance_main.BillingOfficer;
import java.time.LocalDate;
public class BillingRefundRequest {
    private String refundId;
    private String customerId;
    private String policyId;
    private LocalDate requestDate;
    private Double amount;
    private String status;
    private String reason;

    public BillingRefundRequest(String refundId, String customerId, String policyId, LocalDate requestDate, Double amount, String status, String reason) {
        this.refundId = refundId;
        this.customerId = customerId;
        this.policyId = policyId;
        this.requestDate = requestDate;
        this.amount = amount;
        this.status = status;
        this.reason = reason;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
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

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "BillingRefundRequest{" +
                "refundId='" + refundId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", policyId='" + policyId + '\'' +
                ", requestDate=" + requestDate +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
