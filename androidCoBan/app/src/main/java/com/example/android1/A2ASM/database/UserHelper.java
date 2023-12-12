package com.example.android1.A2ASM.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserHelper extends SQLiteOpenHelper {
    public UserHelper(@Nullable Context context) {
        super(context, "qluser", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tạo table
        /*
        create table User
        (
            username text primary key,
            password text
        )
         */
        String sql = "create table User " +
                "( " +
                "  username text primary key, " +
                "  password text" +
                ")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists User");
        onCreate(db);
    }
}
