package com.example.life_insurance_main;

import java.io.Serializable;
import java.util.List;

public class InsuranceAgent extends USER implements Serializable {
    public String licesnseNumber;
    public String address;
    public String region;
    public String CommissionRate;
    public Integer TotalCommissionEarned;
    public List<Customer> activeCustomer;

    public InsuranceAgent(String userId, String name, String email, String phone, String password, String licesnseNumber, String address, String region, String commissionRate, Integer totalCommissionEarned, List<Customer> activeCustomer) {
        super(userId, name, email, phone, password);
        this.licesnseNumber = licesnseNumber;
        this.address = address;
        this.region = region;
        CommissionRate = commissionRate;
        TotalCommissionEarned = totalCommissionEarned;
        this.activeCustomer = activeCustomer;
    }

    public String getLicesnseNumber() {
        return licesnseNumber;
    }

    public void setLicesnseNumber(String licesnseNumber) {
        this.licesnseNumber = licesnseNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommissionRate() {
        return CommissionRate;
    }

    public void setCommissionRate(String commissionRate) {
        CommissionRate = commissionRate;
    }

    public Integer getTotalCommissionEarned() {
        return TotalCommissionEarned;
    }

    public void setTotalCommissionEarned(Integer totalCommissionEarned) {
        TotalCommissionEarned = totalCommissionEarned;
    }

    public List<Customer> getActiveCustomer() {
        return activeCustomer;
    }

    public void setActiveCustomer(List<Customer> activeCustomer) {
        this.activeCustomer = activeCustomer;
    }

    @Override
    public String toString() {
        return "InsuranceAgent{" +
                "licesnseNumber='" + licesnseNumber + '\'' +
                ", address='" + address + '\'' +
                ", region='" + region + '\'' +
                ", CommissionRate='" + CommissionRate + '\'' +
                ", TotalCommissionEarned=" + TotalCommissionEarned +
                ", activeCustomer=" + activeCustomer +
                '}';
    }
    public boolean changeProfileInfo(){
        return true;
    }
}
