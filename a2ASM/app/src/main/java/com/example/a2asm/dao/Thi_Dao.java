package com.example.a2asm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a2asm.database.SanPhamHelper;
import com.example.a2asm.database.Thi_Helper;
import com.example.a2asm.model.SanPham;
import com.example.a2asm.model.Thi_model;

import java.util.ArrayList;

public class Thi_Dao {
    Thi_Helper thiHelper;

    public Thi_Dao(Context c){
        thiHelper = new Thi_Helper(c);
    }
    public void themSP(Thi_model spThi){
        SQLiteDatabase db = thiHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",spThi.getName());
        values.put("gia",spThi.getGia());
        values.put("ma",spThi.getMa());
        db.insert("spthi",null,values);
    }
    public void suaSP(Thi_model spThi){
        SQLiteDatabase db = thiHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",spThi.getName());
        values.put("gia",spThi.getGia());
        values.put("ma",spThi.getMa());
        db.update("spthi",values,"name=?",new String[]{spThi.getName()+""});
    }
    public void xoaSP(String name){
        SQLiteDatabase db = thiHelper.getWritableDatabase();
        db.delete("spthi","name=?",new String[]{name});
    }
    public ArrayList<Thi_model> xemSP(){
        ArrayList<Thi_model> dssp = new ArrayList<Thi_model>();
        SQLiteDatabase db = thiHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from spthi",null);
        if(cursor.moveToFirst()==true){
            do{
                dssp.add(new Thi_model(cursor.getString(0),cursor.getInt(1),cursor.getInt(2)));
            }while(cursor.moveToNext());
        }
        return  dssp;
    }
}
