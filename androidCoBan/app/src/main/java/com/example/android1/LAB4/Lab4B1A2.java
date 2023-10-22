package com.example.android1.LAB4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android1.R;

public class Lab4B1A2 extends AppCompatActivity {
    Button lab4B1btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab4b1a2);
        lab4B1btn2=findViewById(R.id.lab4b1btn2);

        lab4B1btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab4B1A2.this,Lab4B1A1.class);
                startActivity(intent);
            }
        });
    }
}