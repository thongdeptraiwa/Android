package com.example.datvemaybay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datvemaybay.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;
import java.util.UUID;

public class SignUp extends AppCompatActivity {
    FirebaseFirestore firebase = FirebaseFirestore.getInstance();
    ImageView imgBack;
    Button btnSignUp;
    EditText editUsername,editPassword1,editPassword2,editFullName,editAddress,editPassport,editDate_of_birth,editNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        //ánh xạ
        imgBack=findViewById(R.id.imgBack);
        btnSignUp=findViewById(R.id.btnLogin);
        editUsername=findViewById(R.id.editUsername);
        editPassword1=findViewById(R.id.editPassword1);
        editPassword2=findViewById(R.id.editPassword2);
        editFullName=findViewById(R.id.editFullName);
        editAddress=findViewById(R.id.editAddress);
        editPassport=findViewById(R.id.editPassport);
        editDate_of_birth=findViewById(R.id.editDate_of_birth);
        editNation=findViewById(R.id.editNation);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemUser();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void ThemUser(){
        String username = editUsername.getText().toString().trim();
        String password1 = editPassword1.getText().toString().trim();
        String password2 = editPassword2.getText().toString().trim();
        String fullname = editFullName.getText().toString().trim();
        String address = editAddress.getText().toString().trim();
        String passport = editPassport.getText().toString().trim();
        String date_of_birth = editDate_of_birth.getText().toString().trim();
        String nation = editNation.getText().toString().trim();

        //đk thiếu
        if(username.equals("")){
            Toast.makeText(SignUp.this, "Chưa nhập tài khoản", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password1.equals("")){
            Toast.makeText(SignUp.this, "Chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password2.equals("")){
            Toast.makeText(SignUp.this, "Chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }
        if(fullname.equals("")){
            Toast.makeText(SignUp.this, "Chưa nhập họ tên", Toast.LENGTH_SHORT).show();
            return;
        }
        if(address.equals("")){
            Toast.makeText(SignUp.this, "Chưa nhập địa chỉ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(passport.equals("")){
            Toast.makeText(SignUp.this, "Chưa nhập passport", Toast.LENGTH_SHORT).show();
            return;
        }
        if(date_of_birth.equals("")){
            Toast.makeText(SignUp.this, "Chưa nhập ngày sinh", Toast.LENGTH_SHORT).show();
            return;
        }
        if(nation.equals("")){
            Toast.makeText(SignUp.this, "Chưa nhập quốc tịch", Toast.LENGTH_SHORT).show();
            return;
        }

        //đk password lại sai
        if(!password1.equals(password2)){
            Toast.makeText(SignUp.this, "Xác nhận mật khẩu lại sai", Toast.LENGTH_SHORT).show();
            return;
        }

        //thông báo đang kiểm tra
        Toast.makeText(SignUp.this, "Đang kiểm tra", Toast.LENGTH_SHORT).show();

        //chek
        firebase.collection("User")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            //check username có trùng ko
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if(username.equals(document.get("username").toString())){
                                    Toast.makeText(SignUp.this, "Tài khoản này đã có người sử dụng", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                            //them
                            String ID = UUID.randomUUID().toString();
                            User user = new User(ID,username,password1,fullname,address,passport,date_of_birth,nation);
                            Map<String, Object> hashMap = user.covertHashMap();

                            firebase.collection("User")
                                    .document(ID)
                                    .set(hashMap)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(SignUp.this, "them thanh cong", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(SignUp.this, "them that bai", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                            //truyền activity
                            finish();

                        } else {
                            Toast.makeText(SignUp.this, "lắng nghe failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}
