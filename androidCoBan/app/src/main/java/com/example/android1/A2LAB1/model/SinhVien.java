package com.example.android1.A2LAB1.model;

public class SinhVien {

    private int _id;
    private String name;
    private int old;

    public SinhVien(int _id, String name, int old) {
        this._id = _id;
        this.name = name;
        this.old = old;
    }

    public SinhVien(String name, int old) {
        this.name = name;
        this.old = old;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
}
