package com.example.android1.ASM;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.android1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;


public class ASMDangNhap extends AppCompatActivity {
    Button btnDangNhap;
    Button btnDangKi;
    TextInputEditText editTextUsername;
    TextInputEditText editTextPassword;
    int REQUEST_CODE_EDIT = 1;
    Intent intent;
    Bundle bundle;
    String tk;
    String mk;
    CheckBox checkBox;
    Context context=this;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asmdangnhap);

        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnDangKi=findViewById(R.id.btnDangKi);
        editTextUsername=findViewById(R.id.editTextUsername);
        editTextPassword=findViewById(R.id.editTextPassword);
        checkBox=findViewById(R.id.checkBox);

        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        //lấy giá trị sharedPreferences
        editTextUsername.setText(sharedPreferences.getString("username",""));
        editTextPassword.setText(sharedPreferences.getString("password",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checkbox",false));


        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ASMDangNhap.this, ASMDangKi.class);
                startActivityForResult(intent,REQUEST_CODE_EDIT);

            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //đọc file
                dataUser d = new dataUser(context);
                ArrayList<User> list = new ArrayList<>();
                list =(ArrayList<User>) d.readUser(context,"user.txt");

                String tk2=editTextUsername.getText().toString().trim();
                String mk2=editTextPassword.getText().toString().trim();

                int index=-1;
                boolean checkUserName=false,checkPassword=false;

                //check username
                for(int i=0;i<list.size();i++){
                    if(tk2.equals(list.get(i).getUserName())){
                        index=i;
                        checkUserName=true;
                        break;
                    }
                }
                //check password
                if(index != -1){
                    if(mk2.equals(list.get(index).getPassword())){
                            checkPassword=true;
                    }
                }


                //rong
                if(tk2.equals("")){
                    Toast.makeText(ASMDangNhap.this, "Bạn chưa nhập Username!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mk2.equals("")){
                    Toast.makeText(ASMDangNhap.this, "Bạn chưa nhập Password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //check
                if(checkUserName==true && checkPassword==true){
                    editTextUsername.setTextColor(Color.BLACK);
                    editTextPassword.setTextColor(Color.BLACK);

                    if(checkBox.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",tk2);
                        editor.putString("password",mk2);
                        editor.putBoolean("checkbox",true);
                        editor.commit();
                    }else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("username");
                        editor.remove("password");
                        editor.remove("checkbox");
                        editor.commit();
                   }

                    Toast.makeText(ASMDangNhap.this, "ĐĂNG NHẬP THÀNH CÔNG!", Toast.LENGTH_SHORT).show();
                    intent = new Intent(ASMDangNhap.this, ASMQuanly.class);
                    startActivity(intent);
                }else{

                    if(checkUserName==false){
                        editTextUsername.setTextColor(Color.RED);
                        Toast.makeText(ASMDangNhap.this, "Username không đúng!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(checkPassword==false){
                        editTextPassword.setTextColor(Color.RED);
                        Toast.makeText(ASMDangNhap.this, "Password không đúng!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

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