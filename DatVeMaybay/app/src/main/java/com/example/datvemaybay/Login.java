package com.example.datvemaybay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText editUsername,editPassword;
    TextView tvSignUp;
    FirebaseFirestore firebase = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnLogin=findViewById(R.id.btnLogin);
        editUsername=findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);
        tvSignUp=findViewById(R.id.tvSignUp);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSignUp = new Intent(Login.this, SignUp.class);
                startActivity(intentSignUp);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username2 = editUsername.getText().toString().trim();
                String password2 = editPassword.getText().toString().trim();

                //thông báo đang kiểm tra
                Toast.makeText(Login.this, "Đang kiểm tra", Toast.LENGTH_SHORT).show();

                //chek
                firebase.collection("User")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    //check username  và password có tồn tại ko
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        //username đúng
                                        if(username2.equals(document.get("username").toString())){
                                            //username đúng  và password đúng
                                            if(password2.equals(document.get("password").toString())){
                                                //reset lại editPassword
                                                editPassword.setText("");

                                                Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                                                //chuyển dữ liệu qua trang chủ
                                                Intent intent = new Intent(Login.this, MainActivity.class);
                                                Bundle bundleOfMainActivity = new Bundle();
                                                bundleOfMainActivity.putString("ID", document.get("ID").toString());
                                                bundleOfMainActivity.putString("username", document.get("username").toString());
                                                bundleOfMainActivity.putString("password", document.get("password").toString());
                                                bundleOfMainActivity.putString("fullName", document.get("fullName").toString());
                                                bundleOfMainActivity.putString("address", document.get("address").toString());
                                                bundleOfMainActivity.putString("passport", document.get("passport").toString());
                                                bundleOfMainActivity.putString("Date_of_birth", document.get("Date_of_birth").toString());
                                                bundleOfMainActivity.putString("nation", document.get("nation").toString());
                                                intent.putExtras(bundleOfMainActivity);
                                                //chuyển activity
                                                startActivity(intent);

                                                return;
                                            }
                                            //username đúng ,password sai
                                            Toast.makeText(Login.this, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    //Tài khoản không tồn tại
                                    Toast.makeText(Login.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Login.this, "lắng nghe failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }

        });
    }


}