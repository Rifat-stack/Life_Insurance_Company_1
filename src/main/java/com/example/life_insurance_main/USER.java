package com.example.life_insurance_main;

import java.io.Serializable;
import java.util.Objects;

public abstract class USER implements Serializable {
    public final String UserId;
    public String Name;
    private String Email;
    private String Phone;
    private String Password;



    public USER(String userId, String name, String email, String phone, String password) {
        UserId = userId;
        Name = name;
        Email = email;
        Phone = phone;
        Password = password;
    }

    public String getUserId() {
        return UserId;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "USER{" +
                "UserId='" + UserId + '\'' +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
    public boolean login(String id, String password)  {
        if (Objects.equals(id, this.getUserId()) && Objects.equals(password, this.getPassword())) {
            return true ;
        }
        return false ;
    }
    protected abstract boolean changeProfileInfo();

}



