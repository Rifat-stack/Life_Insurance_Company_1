package com.example.life_insurance_main;

import java.time.LocalDate;

public class ExceptionRequest {
    private int requestId;
    private String type;
    private String reason;
    private String status;
    private LocalDate requestDate;


    public ExceptionRequest(int requestId, String type, String reason,
                            String status, LocalDate requestDate) {
        this.requestId = requestId;
        this.type = type;
        this.reason = reason;
        this.status = status;
        this.requestDate = requestDate;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "ExceptionRequest{" +
                "requestId=" + requestId +
                ", type='" + type + '\'' +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }

    public void submitRequest(String type, String reason) {
        this.type = type;
        this.reason = reason;
        this.status = "Pending";
        this.requestDate = LocalDate.now(); // Auto-assign current date
    }

}
