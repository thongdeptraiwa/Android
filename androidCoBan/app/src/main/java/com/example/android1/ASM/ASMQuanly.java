package com.example.android1.ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android1.MainActivity;
import com.example.android1.R;

public class ASMQuanly extends AppCompatActivity {

    Button btnThoat;
    Button btnPhongBan;
    Button btnNhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asmquanly);

        btnPhongBan=findViewById(R.id.btnPhongBan);
        btnNhanVien=findViewById(R.id.btnNhanVien);
        btnThoat=findViewById(R.id.btnThoat);

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ASMQuanly.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnPhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ASMQuanly.this, ASMPhongBan.class);
                startActivity(intent);
            }
        });
        btnNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ASMQuanly.this, ASMNhanVien.class);
                startActivity(intent);
            }
        });


    }
}