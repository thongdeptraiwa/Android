package com.example.android1.LAB4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android1.R;

public class Lab4Menu extends AppCompatActivity {
    Button btnBai1;
    Button btnBai2;

    Button btnBai3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab4menu);

        btnBai1=findViewById(R.id.bai1);
        btnBai2=findViewById(R.id.bai2);
        btnBai3=findViewById(R.id.bai3);

        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBai1 = new Intent(Lab4Menu.this,Lab4B1A1.class);
                startActivity(intentBai1);
            }
        });

        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBai2 = new Intent(Lab4Menu.this,Lab4B2A1.class);
                startActivity(intentBai2);
            }
        });
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBai2 = new Intent(Lab4Menu.this,Lab4B3A1.class);
                startActivity(intentBai2);
            }
        });
    }
}