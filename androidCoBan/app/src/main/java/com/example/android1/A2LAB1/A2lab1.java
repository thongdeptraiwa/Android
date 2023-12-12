package com.example.android1.A2LAB1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.android1.A2LAB1.dao.SinhVienDao;
import com.example.android1.A2LAB1.model.SinhVien;
import com.example.android1.R;

import java.util.ArrayList;

public class A2lab1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2lab1);

        SinhVienDao svDao = new SinhVienDao(A2lab1.this);
        SinhVien sv = new SinhVien("thongdeptrai",9);
        SinhVien sv1 = new SinhVien("thay Khoa",10);

        svDao.themSV(sv);
        svDao.themSV(sv1);

        svDao.xoaSV(1);
        svDao.xoaSV(2);
        svDao.xoaSV(3);
        svDao.xoaSV(6);
        svDao.xoaSV(7);
        svDao.xoaSV(8);

        svDao.suaSV(new SinhVien(11,"a",11));

        ArrayList<SinhVien> dssv = svDao.xemSV();
        for(int i=0;i<dssv.size();i++){
            Log.d("duLieu",dssv.get(i).get_id()+" "+dssv.get(i).getName()+" "+dssv.get(i).getOld());
        }
    }
}