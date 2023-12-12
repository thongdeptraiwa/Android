package com.example.a2asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2asm.A2Lab2.A2_Lab2_recyclerview;
import com.example.a2asm.Lab6.Lab6;
import com.example.a2asm.Lab7.Lab7;
import com.example.a2asm.Lab8.Lab8;
import com.example.a2asm.thi.main;

public class MainChinh extends AppCompatActivity {

    Button btnASM,btnLab6,btnLab2,btnLab8,btnLab7,btnThi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chinh);

        //ánh xạ
        btnASM=findViewById(R.id.btnASM);
        btnLab6=findViewById(R.id.btnLab6);
        btnLab2=findViewById(R.id.btnLab2);
        btnLab8=findViewById(R.id.btnLab8);
        btnLab7=findViewById(R.id.btnLab7);
        btnThi=findViewById(R.id.btnThi);

        btnThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainChinh.this, main.class));
            }
        });
        btnASM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainChinh.this, Login.class));
            }
        });
        btnLab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainChinh.this, Lab6.class));
            }
        });
        btnLab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainChinh.this, A2_Lab2_recyclerview.class));
            }
        });
        btnLab8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainChinh.this, Lab8.class));
            }
        });
        btnLab7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainChinh.this, Lab7.class));
            }
        });
    }
}