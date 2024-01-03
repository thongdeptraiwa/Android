package com.example.datvemaybay.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
    private String ID;
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String passport;
    private String Date_of_birth;
    private String nation;

    public User(String ID, String username, String password, String fullName, String address, String passport, String date_of_birth, String nation) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.passport = passport;
        this.Date_of_birth = date_of_birth;
        this.nation = nation;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDate_of_birth() {
        return Date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        Date_of_birth = date_of_birth;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    public Map<String, Object> covertHashMap(){
        Map<String, Object> work = new HashMap<>();
        work.put("ID",ID);
        work.put("username",username);
        work.put("password",password);
        work.put("fullName",fullName);
        work.put("address",address);
        work.put("passport",passport);
        work.put("Date_of_birth",Date_of_birth);
        work.put("nation",nation);
        return work;
    }
}
