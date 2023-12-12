package com.example.android1.A2ASM.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android1.A2ASM.database.UserHelper;
import com.example.android1.A2ASM.model.User;

import java.util.ArrayList;

public class UserDao {
    UserHelper userHelper;

    public UserDao(Context c){
        userHelper = new UserHelper(c);
    }
    public void themUser(User user){
        SQLiteDatabase db = userHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",user.getUsername());
        values.put("password",user.getPassword());
        db.insert("User",null,values);
    }
    public ArrayList<User> xemSP(){
        ArrayList<User> dsUser = new ArrayList<User>();
        SQLiteDatabase db = userHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from User",null);
        if(cursor.moveToFirst()==true){
            do{
                dsUser.add(new User(cursor.getString(0),cursor.getString(1)));
            }while(cursor.moveToNext());
        }
        return  dsUser;
    }
}
