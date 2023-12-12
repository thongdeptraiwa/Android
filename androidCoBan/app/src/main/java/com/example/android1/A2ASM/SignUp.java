package com.example.android1.A2ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android1.A2ASM.dao.SanPhamDao;
import com.example.android1.A2ASM.dao.UserDao;
import com.example.android1.A2ASM.database.UserHelper;
import com.example.android1.A2ASM.model.SanPham;
import com.example.android1.A2ASM.model.User;
import com.example.android1.R;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {
    Button btnSignUp;
    EditText editUsername,editPassword;
    ImageView imgBack;
    UserDao userDao = new UserDao(SignUp.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2_asm_sign_up);

        btnSignUp=findViewById(R.id.btnLogin);
        editUsername=findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);
        imgBack=findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                userDao.themUser(new User(username,password));
                Toast.makeText(SignUp.this, "Sign UP thành công!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}