package com.example.android1.A2ASM.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String name;
    private int gia;
    private int sl;

    public SanPham(String name, int gia, int sl) {
        this.name = name;
        this.gia = gia;
        this.sl = sl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
}
