package com.example.android1.LAB4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android1.R;


public class Lab4B3A1 extends AppCompatActivity {

    Button btnDangNhap;

    Button btnDangKi;

    EditText editUsername;

    EditText editPassword;

    int REQUEST_CODE_EDIT = 1;
    Intent intent;
    Bundle bundle;
    String tk;
    String mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab4b3a1);

        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnDangKi=findViewById(R.id.btnDangKi);
        editUsername=findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);

        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDK = new Intent(Lab4B3A1.this,Lab4B3A2.class);
                startActivityForResult(intentDK,REQUEST_CODE_EDIT);
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tk2=editUsername.getText().toString().trim();
                String mk2=editPassword.getText().toString().trim();

                //rong
                if(tk2.equals("")){
                    Toast.makeText(Lab4B3A1.this, "Bạn chưa nhập Username!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mk2.equals("")){
                    Toast.makeText(Lab4B3A1.this, "Bạn chưa nhập Password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //sai
                if(!tk2.equals(tk)){
                    editUsername.setTextColor(Color.RED);
                    Toast.makeText(Lab4B3A1.this, "Username không đúng!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!mk2.equals(mk)){
                    editPassword.setTextColor(Color.RED);
                    Toast.makeText(Lab4B3A1.this, "Password không đúng!", Toast.LENGTH_SHORT).show();
                    return;
                }

                editUsername.setTextColor(Color.BLACK);
                editPassword.setTextColor(Color.BLACK);

                Toast.makeText(Lab4B3A1.this, "ĐĂNG NHẬP THÀNH CÔNG!", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null){

            bundle = data.getExtras();
            tk = bundle.getString("username");
            mk = bundle.getString("password");

        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}