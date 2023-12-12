package com.example.android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android1.A2ASM.Login;
import com.example.android1.A2ASM.QuanLySanPham;
import com.example.android1.A2ASM.TrangChu;
import com.example.android1.A2LAB1.A2lab1;
import com.example.android1.A2Lab2.A2_Lab2_recyclerview;

public class MainAndroid2 extends AppCompatActivity {

    TextView tv,tvName;
    Button btnLab1,btnASM,btnLab2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android2);

        tv=findViewById(R.id.tv);
        tvName=findViewById(R.id.name);
        btnLab1=findViewById(R.id.btnLab1);
        btnASM=findViewById(R.id.btnASM);
        btnLab2=findViewById(R.id.btnLab2);

        btnLab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlab1 = new Intent(MainAndroid2.this, A2lab1.class);
                startActivity(intentlab1);
            }
        });
        btnASM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MainAndroid2.this, QuanLySanPham.class));
            }
        });
        btnLab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlab2 = new Intent(MainAndroid2.this, A2_Lab2_recyclerview.class);
                startActivity(intentlab2);
            }
        });

    }
}