package com.example.android1.ASM;

import java.io.Serializable;

public class NhanVien implements Serializable {
    public String maNV;
    public String tenNV;
    public String phongNV;

    public NhanVien(String maNV,String tenNV,String phongNV){
        this.maNV=maNV;
        this.tenNV=tenNV;
        this.phongNV=phongNV;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getPhongNV() {
        return phongNV;
    }

    public void setPhongNV(String phongNV) {
        this.phongNV = phongNV;
    }
}
