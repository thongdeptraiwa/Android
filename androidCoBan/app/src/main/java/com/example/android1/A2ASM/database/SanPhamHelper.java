package com.example.android1.A2ASM.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SanPhamHelper extends SQLiteOpenHelper {

    public SanPhamHelper(@Nullable Context context) {
        super(context, "qlsp", null, 2);
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
        String sql = "create table SanPham " +
                "( " +
                    " name text primary key, " +
                    "gia integer, " +
                    "sl integer" +
                ")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists SanPham");
        onCreate(db);
    }
}
