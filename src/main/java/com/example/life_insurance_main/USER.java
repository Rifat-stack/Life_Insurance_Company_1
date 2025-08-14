package com.example.life_insurance_main;

import java.util.Objects;

public class USER {
    private String UserId;
    private String Name;
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

    public void setUserId(String userId) {
        UserId = userId;
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
}



