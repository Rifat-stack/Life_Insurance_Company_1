package com.example.life_insurance_main;

import com.example.life_insurance_main.ClaimOfficer.Claim;

import java.io.Serializable;
import java.util.List;

public class Customer extends USER implements Serializable {
    public String nomineeName;
    public String address;
    public List<Policy> policies;
    public List<Claim> claims;

    public Customer(String userId, String name, String email, String phone, String password, String nomineeName, String address, List<Policy> policies, List<Claim> claims) {
        super(userId, name, email, phone, password);
        this.nomineeName = nomineeName;
        this.address = address;
        this.policies = policies;
        this.claims = claims;

    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nomineeName='" + nomineeName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public boolean changeProfileInfo() {
        return true;

    }
}











