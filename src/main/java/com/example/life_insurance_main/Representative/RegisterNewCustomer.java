package com.example.life_insurance_main.Representative;

import java.time.LocalDate;

public class RegisterNewCustomer {
    private String id;
    private String name;
    private  String phone;
    private  String email;
    private  String gander;
    private  String address;
    private LocalDate date;

    public RegisterNewCustomer(String id, String name, String phone, String email, String gander, String address, LocalDate date) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gander = gander;
        this.address = address;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
