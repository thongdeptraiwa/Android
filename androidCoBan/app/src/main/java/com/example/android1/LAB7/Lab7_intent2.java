package com.example.android1.LAB7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android1.R;

public class Lab7_intent2 extends AppCompatActivity {

    Button btnBack;
    ImageView imgvA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab7_intent2);

        btnBack=findViewById(R.id.btnBack);

        imgvA=findViewById(R.id.imgvA);
        imgvA.setBackgroundResource(R.drawable.anim_frame);
        AnimationDrawable anim = (AnimationDrawable) imgvA.getBackground();
        anim.start();


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab7_intent2.this, Lab7.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });

    }
}