package com.example.android1.ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ASMDangKi extends AppCompatActivity {

    Button btnDangNhap;
    Button btnTroLai;
    TextInputEditText editTextUsername;
    TextInputEditText editTextPassword;
    TextInputEditText editTextComfirm;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asmdangki);

        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnTroLai=findViewById(R.id.btnTroLai);

        editTextUsername=findViewById(R.id.editTextUsername);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextComfirm=findViewById(R.id.editTextComfirm);

        btnTroLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk=editTextUsername.getText().toString().trim();
                String mk=editTextPassword.getText().toString().trim();
                String mk2=editTextComfirm.getText().toString().trim();

                if(tk.equals("")){
                    Toast.makeText(ASMDangKi.this, "Bạn chưa nhập Username!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mk.equals("")){
                    Toast.makeText(ASMDangKi.this, "Bạn chưa nhập Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mk2.equals("")){
                    Toast.makeText(ASMDangKi.this, "Bạn chưa nhập Comfirm!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String DK = "\\w{5,30}";

                if(!tk.matches(DK)){
                    editTextUsername.setTextColor(Color.RED);
                    Toast.makeText(ASMDangKi.this, "Bạn nhập sai Username!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editTextUsername.setTextColor(Color.BLACK);

                if(!mk.matches(DK)){
                    editTextPassword.setTextColor(Color.RED);
                    Toast.makeText(ASMDangKi.this, "Bạn nhập sai Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editTextPassword.setTextColor(Color.BLACK);

                if(!mk.equals(mk2)){
                    editTextComfirm.setTextColor(Color.RED);
                    Toast.makeText(ASMDangKi.this, "Comfirm không giống với Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editTextComfirm.setTextColor(Color.BLACK);


                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("username",tk);
                bundle.putString("password",mk);

                // doc file roi luu file
                dataUser d = new dataUser(context);
                ArrayList<User> list = new ArrayList<>();
                try {
                    list =(ArrayList<User>) d.readUser(context,"user.txt");
                    d.writeUser(context,"user.txt",new User(tk,mk),list);
                }catch (Exception e){
                    d.writeUser(context,"user.txt",new User(tk,mk),list);
                }

                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();

            }
        });

    }
}