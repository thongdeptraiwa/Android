package com.example.a2asm.thi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2asm.R;
import com.example.a2asm.SanPhamADT_Recyclerview;
import com.example.a2asm.dao.SanPhamDao;
import com.example.a2asm.dao.Thi_Dao;
import com.example.a2asm.model.SanPham;
import com.example.a2asm.model.Thi_model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class main extends AppCompatActivity {
    Context c= this;
    ArrayList<Thi_model> ds = new ArrayList<>();
    Thi_Dao spDao;
    Thi_SanPhamADT_Recyclerview adapterSP;
    RecyclerView recyclerView;
    FloatingActionButton floatAdd;
    int index=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thi_main);

        //ánh xạ
        recyclerView=findViewById(R.id.recyclerView);
        floatAdd=findViewById(R.id.floatAdd);




        capNhatLayout();

        //nhan floatAdd
        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themSP();
            }
        });

    }
    public void capNhatLayout(){

        spDao = new Thi_Dao(c);

        //dua dat
        ds = spDao.xemSP();

        //recycleview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(c);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterSP = new Thi_SanPhamADT_Recyclerview(c,ds,spDao);
        recyclerView.setAdapter(adapterSP);

    }

    public void themSP(){
        Dialog dialogThem = new Dialog(c);
        dialogThem.setContentView(R.layout.thi_dialog_them);
        dialogThem.show();

        Button btnThemDialog = dialogThem.findViewById(R.id.btnThem);
        EditText editName = dialogThem.findViewById(R.id.editName);
        EditText editGia = dialogThem.findViewById(R.id.editGia);
        //EditText editSL = dialogThem.findViewById(R.id.editSL);

        btnThemDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString().trim();
                int gia = Integer.parseInt(editGia.getText().toString().trim());
                //int sl = Integer.parseInt(editSL.getText().toString().trim());
                int ma = (int)index / 2 ;
                spDao.themSP(new Thi_model(name,gia,ma));

                capNhatLayout();

                Toast.makeText(c, "Thêm sp thành công", Toast.LENGTH_SHORT).show();

                index++;

                dialogThem.dismiss();
            }
        });

    }
}