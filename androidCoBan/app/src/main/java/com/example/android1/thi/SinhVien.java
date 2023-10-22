package com.example.android1.thi;

import java.io.Serializable;

public class SinhVien implements Serializable {
    public String ID;
    public String ten;

    public SinhVien(String ID, String ten){
        this.ID=ID;
        this.ten=ten;

    }

    public SinhVien() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
