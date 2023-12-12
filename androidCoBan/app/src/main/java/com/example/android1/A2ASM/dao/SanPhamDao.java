package com.example.android1.A2ASM.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android1.A2ASM.database.SanPhamHelper;
import com.example.android1.A2ASM.model.SanPham;

import java.util.ArrayList;

public class SanPhamDao {
    SanPhamHelper samPhamHelper;

    public SanPhamDao(Context c){
        samPhamHelper = new SanPhamHelper(c);
    }
    public void themSP(SanPham sp){
        SQLiteDatabase db = samPhamHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",sp.getName());
        values.put("gia",sp.getGia());
        values.put("sl",sp.getSl());
        db.insert("SanPham",null,values);
    }
    public void suaSP(SanPham sp){
        SQLiteDatabase db = samPhamHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",sp.getName());
        values.put("gia",sp.getGia());
        values.put("sl",sp.getSl());
        db.update("SanPham",values,"name=?",new String[]{sp.getName()+""});
    }
    public void xoaSP(String name){
        SQLiteDatabase db = samPhamHelper.getWritableDatabase();
        db.delete("SanPham","name=?",new String[]{name});
    }
    public ArrayList<SanPham> xemSP(){
        ArrayList<SanPham> dssp = new ArrayList<SanPham>();
        SQLiteDatabase db = samPhamHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from SanPham",null);
        if(cursor.moveToFirst()==true){
            do{
                dssp.add(new SanPham(cursor.getString(0),cursor.getInt(1),cursor.getInt(2)));
            }while(cursor.moveToNext());
        }
        return  dssp;
    }
}
