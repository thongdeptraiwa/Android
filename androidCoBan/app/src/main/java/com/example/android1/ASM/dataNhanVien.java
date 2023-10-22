package com.example.android1.ASM;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class dataNhanVien {
    Context context;

    public dataNhanVien(Context context) {
        this.context = context;
    }

    public void writeNhanVien(Context context, String fileName, ArrayList<NhanVien> list) {

        try {
            FileOutputStream f = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(list);
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<NhanVien> readNhanVien (Context context, String fileName) {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            FileInputStream f = context.openFileInput(fileName);
            ObjectInputStream o = new ObjectInputStream(f);
            list = (ArrayList<NhanVien>) o.readObject();
            o.close();
            f.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
