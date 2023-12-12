package com.example.a2asm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a2asm.database.SanPhamHelper;
import com.example.a2asm.model.SanPham;

import java.util.ArrayList;

public class SanPhamDao {
    SanPhamHelper sanPhamHelper;

    public SanPhamDao(Context c){
        sanPhamHelper = new SanPhamHelper(c);
    }
    public void themSP(SanPham sp){
        SQLiteDatabase db = sanPhamHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",sp.getName());
        values.put("gia",sp.getGia());
        values.put("sl",sp.getSl());
        db.insert("SanPham",null,values);
    }
    public void suaSP(SanPham sp){
        SQLiteDatabase db = sanPhamHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",sp.getName());
        values.put("gia",sp.getGia());
        values.put("sl",sp.getSl());
        db.update("SanPham",values,"name=?",new String[]{sp.getName()+""});
    }
    public void xoaSP(String name){
        SQLiteDatabase db = sanPhamHelper.getWritableDatabase();
        db.delete("SanPham","name=?",new String[]{name});
    }
    public ArrayList<SanPham> xemSP(){
        ArrayList<SanPham> dssp = new ArrayList<SanPham>();
        SQLiteDatabase db = sanPhamHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from SanPham",null);
        if(cursor.moveToFirst()==true){
            do{
                dssp.add(new SanPham(cursor.getString(0),cursor.getInt(1),cursor.getInt(2)));
            }while(cursor.moveToNext());
        }
        return  dssp;
    }
}
