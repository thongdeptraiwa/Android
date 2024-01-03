package com.example.datvemaybay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.datvemaybay.MainActivity;
import com.example.datvemaybay.R;
import com.example.datvemaybay.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;


public class fragment_doimatkhau extends Fragment {

    MainActivity mainActivity;
    Button btnHuy,btnDoiMatKhau;
    Context c;
    TextView tvUsername;
    EditText editPassword1,editPassword2;
    FirebaseFirestore firebase = FirebaseFirestore.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doimatkhau,container,false);
        c = getActivity();
        //ánh xạ
        mainActivity = (MainActivity) getActivity();
        btnHuy = view.findViewById(R.id.btnHuy);
        btnDoiMatKhau = view.findViewById(R.id.btnDoiMatKhau);
        tvUsername = view.findViewById(R.id.tvUsername);
        editPassword1 = view.findViewById(R.id.editPassword1);
        editPassword2 = view.findViewById(R.id.editPassword2);


        //lấy data từ MainActivity
        tvUsername.setText(mainActivity.getUsername());

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.backFragmentTaiKhoan();
            }
        });

        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password1 = editPassword1.getText().toString().trim();
                String password2 = editPassword2.getText().toString().trim();

                //check mật khẩu cũ
                if(password1.equals(mainActivity.getPassword())){

                    //set trên firebase
                    User user = new User(mainActivity.getID(),
                            mainActivity.getUsername(),
                            password2,
                            mainActivity.getFullName(),
                            mainActivity.getAddress(),
                            mainActivity.getPassport(),
                            mainActivity.getDate_of_birth(),
                            mainActivity.getNation());
                    suaThongTin(user);

                    //back Login
                    mainActivity.backLogin();

                    //set trên Mainactivity
//                    mainActivity.setFullName(editFullName.getText().toString().trim());
//                    mainActivity.setAddress(editAddress.getText().toString().trim());
//                    mainActivity.setPassport(editPassport.getText().toString().trim());
//                    mainActivity.setDate_of_birth(editDate_of_birth.getText().toString().trim());
//                    mainActivity.setNation(editNation.getText().toString().trim());

                }else {
                    Toast.makeText(c, "Mật khẩu cũ sai", Toast.LENGTH_SHORT).show();
                }


            }
        });


        return view;
    }
    public void suaThongTin(User user){

        Map<String, Object> hashMap = user.covertHashMap();

        firebase.collection("User")
                .document(user.getID())
                .update(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(c, "chinh sua thanh cong", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(c, "chinh sua that bai", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
