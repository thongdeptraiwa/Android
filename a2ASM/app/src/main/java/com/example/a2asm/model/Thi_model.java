package com.example.a2asm.model;

import java.io.Serializable;


public class Thi_model implements Serializable {
    private String name;
    private int ma;
    private int gia;

    public Thi_model(String name, int gia, int ma) {
        this.name = name;
        this.gia = gia;
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}

