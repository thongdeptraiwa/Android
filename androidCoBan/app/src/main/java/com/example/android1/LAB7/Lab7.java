package com.example.android1.LAB7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android1.ASM.ASM1;
import com.example.android1.ASM.ASMDangNhap;
import com.example.android1.R;

public class Lab7 extends AppCompatActivity {

    ImageView imgvAlpha,imgvRotate1,imgvRotate2,imgbScalen,imgvTranslate;
    Button btnVao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab7);

        //ánh xạ
        imgvAlpha=findViewById(R.id.imgvAlpha);

        imgvRotate1=findViewById(R.id.imgvRotate1);
        imgvRotate2=findViewById(R.id.imgvRotate2);

        imgbScalen=findViewById(R.id.imgbScalen);

        imgvTranslate=findViewById(R.id.imgvTranslate);

        btnVao=findViewById(R.id.btnVao);

        //anim
        Animation animAlpha = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);

        Animation animRotate1 = AnimationUtils.loadAnimation(this,R.anim.anim_rotate_chuong);
        Animation animRotate2 = AnimationUtils.loadAnimation(this,R.anim.anim_rotate_xoaytron);

        Animation animScale = AnimationUtils.loadAnimation(this,R.anim.anim_scale);

        Animation animTranslate = AnimationUtils.loadAnimation(this,R.anim.anim_translate);



        imgvAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha);
            }
        });
        imgvRotate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animRotate1);
            }
        });
        imgvRotate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animRotate2);
            }
        });
        imgbScalen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animScale);
            }
        });
        imgvTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animTranslate);
            }
        });
        btnVao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab7.this, Lab7_intent2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });

    }
}