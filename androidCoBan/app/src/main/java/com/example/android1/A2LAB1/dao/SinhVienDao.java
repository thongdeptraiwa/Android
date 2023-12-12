package com.example.android1.A2LAB1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android1.A2LAB1.database.MyHelper;
import com.example.android1.A2LAB1.model.SinhVien;

import java.util.ArrayList;
import java.util.Currency;

public class SinhVienDao {
    MyHelper myHelper;

    public SinhVienDao(Context c){
        myHelper = new MyHelper(c);
    }
    public void themSV(SinhVien sv){
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",sv.getName());
        values.put("old",sv.getOld());
        db.insert("SinhVien",null,values);
    }
    public void suaSV(SinhVien sv){
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",sv.getName());
        values.put("old",sv.getOld());
        db.update("SinhVien",values,"_id=?",new String[]{sv.get_id()+""});
    }
    public void xoaSV(int _id){
        SQLiteDatabase db = myHelper.getWritableDatabase();
        db.delete("SinhVien","_id=?",new String[]{_id+""});
    }
    public ArrayList<SinhVien> xemSV(){
        ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
        SQLiteDatabase db = myHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from SinhVien",null);
        if(cursor.moveToFirst()==true){
            do{
                dssv.add(new SinhVien(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
            }while(cursor.moveToNext());
        }
        return  dssv;
    }
}
