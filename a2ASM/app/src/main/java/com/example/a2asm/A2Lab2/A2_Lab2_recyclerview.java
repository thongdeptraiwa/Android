package com.example.a2asm.A2Lab2;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a2asm.R;
import com.example.a2asm.dao.SanPhamDao;
import com.example.a2asm.model.SanPham;

import java.util.ArrayList;

public class A2_Lab2_recyclerview extends AppCompatActivity {
    Context context=this;
    ArrayList<SanPham> ds = new ArrayList<>();
    SanPhamDao spDao = new SanPhamDao(A2_Lab2_recyclerview.this);
    A2_Lab2_SanPhamADT_Recylerview adapterSP;
    RecyclerView recyclerViewNgang,recyclerViewGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2_lab2_recyclerview);
        //ánh xạ
        recyclerViewNgang=findViewById(R.id.recyclerViewNganh);
        recyclerViewGrid=findViewById(R.id.recyclerViewGrid);

        capNhatLayout();
    }
    public void capNhatLayout(){
        //spDao.themSP(new SanPham("bánh",120000,4));
        //dua data
        ds = spDao.xemSP();


        adapterSP = new A2_Lab2_SanPhamADT_Recylerview(context,ds);
        //recycleview Nganh
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewNgang.setLayoutManager(linearLayoutManager);
        recyclerViewNgang.setAdapter(adapterSP);
        //recycleview Grid
        GridLayoutManager linearLayoutManager1=new GridLayoutManager(this,
                2,
                GridLayoutManager.VERTICAL,
                false
        );
        linearLayoutManager1.setSpanSizeLookup(
                new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return (position % 3 == 0 ? 2 : 1 );
                    }
                }
        );
        recyclerViewGrid.setLayoutManager(linearLayoutManager1);
        recyclerViewGrid.setAdapter(adapterSP);
    }
}