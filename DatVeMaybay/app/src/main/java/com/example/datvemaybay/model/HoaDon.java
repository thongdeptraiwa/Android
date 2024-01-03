package com.example.datvemaybay.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HoaDon implements Serializable {
    private String ID;
    private String ID_of_User;
    private String fullName;
    private String khoiHanh;
    private String ketThuc;
    private String tu;
    private String den;
    private String gia;

    public HoaDon(String ID, String ID_of_User, String fullName, String khoiHanh, String ketThuc, String tu, String den, String gia) {
        this.ID = ID;
        this.ID_of_User = ID_of_User;
        this.fullName = fullName;
        this.khoiHanh = khoiHanh;
        this.ketThuc = ketThuc;
        this.tu = tu;
        this.den = den;
        this.gia = gia;
    }

    public String getID_of_User() {
        return ID_of_User;
    }

    public void setID_of_User(String ID_of_User) {
        this.ID_of_User = ID_of_User;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getKhoiHanh() {
        return khoiHanh;
    }

    public void setKhoiHanh(String khoiHanh) {
        this.khoiHanh = khoiHanh;
    }

    public String getKetThuc() {
        return ketThuc;
    }

    public void setKetThuc(String ketThuc) {
        this.ketThuc = ketThuc;
    }

    public String getTu() {
        return tu;
    }

    public void setTu(String tu) {
        this.tu = tu;
    }

    public String getDen() {
        return den;
    }

    public void setDen(String den) {
        this.den = den;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
    public Map<String, Object> covertHashMap(){
        Map<String, Object> work = new HashMap<>();
        work.put("ID",ID);
        work.put("ID_of_User",ID_of_User);
        work.put("fullName",fullName);
        work.put("khoiHanh",khoiHanh);
        work.put("ketThuc",ketThuc);
        work.put("tu",tu);
        work.put("den",den);
        work.put("gia",gia);
        return work;
    }
}
