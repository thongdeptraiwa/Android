package com.example.android1.ASM;
import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class dataUser {
    Context context;

    public dataUser(Context context) {
        this.context = context;
    }

    public void writeUser(Context context, String fileName, User user, ArrayList<User> list) {

        try {
            FileOutputStream f = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream o = new ObjectOutputStream(f);
            list.add(user);
            o.writeObject(list);
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> readUser (Context context, String fileName) {
        ArrayList<User> list = new ArrayList<>();
        try {
            FileInputStream f = context.openFileInput(fileName);
            ObjectInputStream o = new ObjectInputStream(f);
            list = (ArrayList<User>) o.readObject();
            o.close();
            f.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}
