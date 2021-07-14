package com.example.metroapp.payload;

import com.example.metroapp.model.Ticket;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SignUpRequest {
    private String username;
    private String fullname;
    private String email;
    private String password;
    private String phone_number;
    private Date date_of_birth;

    public SignUpRequest(String username,String fullname, String email, String password, String phone_number, Date date_of_birth) {
        this.username = username;
        this.fullname=fullname;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
