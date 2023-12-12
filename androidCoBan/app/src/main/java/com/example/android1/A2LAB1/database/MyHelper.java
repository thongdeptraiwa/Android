package com.example.android1.A2LAB1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(@Nullable Context context) {
        super(context, "qlsv", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tạo table
        /*
        create table SinhVien
        (
            _id integer primary key autoincrement,
            name text,
            old integer
        )
         */
        String sql = "create table SinhVien " +
                "( " +
                    "_id integer primary key autoincrement, " +
                    "name text, " +
                    "old integer" +
                ")";
        db.execSQL(sql);

        //thêm dữ liệu
//        String data = "insert into SinhVien values ('Nguyen Van Teo',5)";
//        db.execSQL(data);
    }

//    public void themSV(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("name","Nguyen Van Teo");
//        values.put("old",5);
//        db.insert("SinhVien",null,values);
//    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists SinhVien");
        onCreate(db);
    }
}
