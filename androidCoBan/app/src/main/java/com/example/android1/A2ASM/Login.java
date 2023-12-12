package com.example.android1.A2ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android1.A2ASM.dao.UserDao;
import com.example.android1.A2ASM.model.SanPham;
import com.example.android1.A2ASM.model.User;
import com.example.android1.MainAndroid1;
import com.example.android1.MainAndroid2;
import com.example.android1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText editUsername,editPassword;
    TextView tvSignUp;
    ArrayList<User> ds = new ArrayList<>();
    UserDao userDao = new UserDao(Login.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2_asm_login);

        btnLogin=findViewById(R.id.btnLogin);
        editUsername=findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);
        tvSignUp=findViewById(R.id.tvSignUp);

        //đưa data vào
        ds = userDao.xemSP();

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                boolean check = false;

                //check
                for(int i=0;i<ds.size();i++){
                    if(username.equals(ds.get(i).getUsername())){
                        if(password.equals(ds.get(i).getPassword())){
                            check=true;
                            break;
                        }
                    }
                }

                if(check== false){
                    Toast.makeText(Login.this, "Login thất bại!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Login.this, "Login thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, TrangChu.class));
                }

            }
        });
    }
}