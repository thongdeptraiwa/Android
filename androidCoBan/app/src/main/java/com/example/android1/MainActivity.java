package com.example.android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android1.ASM.ASM1;
import com.example.android1.BAI3LA.Bai3la;
import com.example.android1.LAB2.Lab2;
import com.example.android1.LAB3.Lab3;
import com.example.android1.LAB4.Lab4Menu;
import com.example.android1.LAB7.Lab7;
import com.example.android1.thi.Activity;

public class MainActivity extends AppCompatActivity {

    Button ASM,btn2,btn3,btn4,btn7,btnThi;

    Button btnBai3la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ASM=findViewById(R.id.btnASM);
        btn2=findViewById(R.id.lab2);
        btn3=findViewById(R.id.lab3);
        btn4=findViewById(R.id.lab4);
        btn7=findViewById(R.id.lab7);
        btnThi=findViewById(R.id.btnThi);
        btnBai3la=findViewById(R.id.btnBai3la);

        ASM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlab = new Intent(MainActivity.this, ASM1.class);
                startActivity(intentlab);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlab = new Intent(MainActivity.this, Lab2.class);
                startActivity(intentlab);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlab = new Intent(MainActivity.this, Lab3.class);
                startActivity(intentlab);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlab = new Intent(MainActivity.this, Lab4Menu.class);
                startActivity(intentlab);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlab = new Intent(MainActivity.this, Lab7.class);
                startActivity(intentlab);
            }
        });
        btnBai3la.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlab = new Intent(MainActivity.this, Bai3la.class);
                startActivity(intentlab);
            }
        });
        btnThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentThi = new Intent(MainActivity.this, Activity.class);
                startActivity(intentThi);
            }
        });
    }
}