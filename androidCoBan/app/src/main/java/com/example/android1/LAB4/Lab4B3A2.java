package com.example.android1.LAB4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android1.R;

public class Lab4B3A2 extends AppCompatActivity {

    Button btnDangKi;

    EditText editUsername;
    EditText editPassword;
    EditText editComfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab4b3a2);

        btnDangKi=findViewById(R.id.btnDangKi);
        editUsername=findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);
        editComfirm=findViewById(R.id.editComfirm);


        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tk=editUsername.getText().toString().trim();
                String mk=editPassword.getText().toString().trim();
                String mk2=editComfirm.getText().toString().trim();

                if(tk.equals("")){
                    Toast.makeText(Lab4B3A2.this, "Bạn chưa nhập Username!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mk.equals("")){
                    Toast.makeText(Lab4B3A2.this, "Bạn chưa nhập Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mk2.equals("")){
                    Toast.makeText(Lab4B3A2.this, "Bạn chưa nhập Comfirm!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String DK = "\\w{5,30}";

                if(!tk.matches(DK)){
                    editUsername.setTextColor(Color.RED);
                    Toast.makeText(Lab4B3A2.this, "Bạn nhập sai Username!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editUsername.setTextColor(Color.BLACK);
                if(!mk.matches(DK)){
                    editPassword.setTextColor(Color.RED);
                    Toast.makeText(Lab4B3A2.this, "Bạn nhập sai Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editPassword.setTextColor(Color.BLACK);
                if(!mk.equals(mk2)){
                    editComfirm.setTextColor(Color.RED);
                    Toast.makeText(Lab4B3A2.this, "Comfirm không giống với Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editComfirm.setTextColor(Color.BLACK);

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("username",tk);
                bundle.putString("password",mk);
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}