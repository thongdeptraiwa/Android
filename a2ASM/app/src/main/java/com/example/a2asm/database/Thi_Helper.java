package com.example.a2asm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Thi_Helper extends SQLiteOpenHelper {
    public Thi_Helper(@Nullable Context context) {
        super(context, "qlthi", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tạo table
        /*
        create table SanPham
        (
            name text primary key,
            gia integer,
            sl integer
        )
         */
        String sql = "create table spthi " +
                "( " +
                " name text primary key, " +
                "gia integer, " +
                "ma integer" +
                ")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists spthi");
        onCreate(db);
    }
}
