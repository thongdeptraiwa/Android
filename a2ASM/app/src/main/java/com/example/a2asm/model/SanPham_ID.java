package com.example.a2asm.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SanPham_ID implements Serializable {
    private String ID;
    private String name;
    private int gia;
    private int sl;

    public SanPham_ID(String ID,String name, int gia, int sl) {
        this.ID = ID;
        this.name = name;
        this.gia = gia;
        this.sl = sl;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public Map<String, Object> covertHashMap(){
        Map<String, Object> work = new HashMap<>();
        work.put("ID",ID);
        work.put("name",name);
        work.put("gia",gia);
        work.put("sl",sl);
        return work;
    }
}

