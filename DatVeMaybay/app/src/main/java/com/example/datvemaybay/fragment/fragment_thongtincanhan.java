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


public class fragment_thongtincanhan extends Fragment {

    MainActivity mainActivity;
    Button btnHuy,btnChinhSua;
    Context c;
    TextView tvUsername;
    EditText editFullName,editAddress,editPassport,editDate_of_birth,editNation;
    FirebaseFirestore firebase = FirebaseFirestore.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongtincanhan,container,false);
        c = getActivity();
        //ánh xạ
        mainActivity = (MainActivity) getActivity();
        btnHuy = view.findViewById(R.id.btnHuy);
        btnChinhSua = view.findViewById(R.id.btnChinhSua);
        tvUsername = view.findViewById(R.id.tvUsername);
        editFullName = view.findViewById(R.id.editFullName);
        editAddress = view.findViewById(R.id.editAddress);
        editPassport = view.findViewById(R.id.editPassport);
        editDate_of_birth = view.findViewById(R.id.editDate_of_birth);
        editNation = view.findViewById(R.id.editNation);


        //chặn tất cả các lần chạm vào EditText
        notOnTouchEdit(editFullName);
        notOnTouchEdit(editAddress);
        notOnTouchEdit(editPassport);
        notOnTouchEdit(editDate_of_birth);
        notOnTouchEdit(editNation);

        //lấy data từ MainActivity
        tvUsername.setText(mainActivity.getUsername());
        editFullName.setText(mainActivity.getFullName());
        editAddress.setText(mainActivity.getAddress());
        editPassport.setText(mainActivity.getPassport());
        editDate_of_birth.setText(mainActivity.getDate_of_birth());
        editNation.setText(mainActivity.getNation());

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.backFragmentTaiKhoan();
            }
        });

        btnChinhSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnChinhSua.getText().equals("Chỉnh Sữa")){
                    btnChinhSua.setText("Lưu");
                    onTouchEdit(editFullName);
                    onTouchEdit(editAddress);
                    onTouchEdit(editPassport);
                    onTouchEdit(editDate_of_birth);
                    onTouchEdit(editNation);
                    return;
                }
                if(btnChinhSua.getText().equals("Lưu")){
                    btnChinhSua.setText("Chỉnh Sữa");
                    notOnTouchEdit(editFullName);
                    notOnTouchEdit(editAddress);
                    notOnTouchEdit(editPassport);
                    notOnTouchEdit(editDate_of_birth);
                    notOnTouchEdit(editNation);

                    //set trên firebase
                    User user = new User(mainActivity.getID(),
                            mainActivity.getUsername(),
                            mainActivity.getPassword(),
                            editFullName.getText().toString().trim(),
                            editAddress.getText().toString().trim(),
                            editPassport.getText().toString().trim(),
                            editDate_of_birth.getText().toString().trim(),
                            editNation.getText().toString().trim());
                    suaThongTin(user);

                    //set trên Mainactivity
                    mainActivity.setFullName(editFullName.getText().toString().trim());
                    mainActivity.setAddress(editAddress.getText().toString().trim());
                    mainActivity.setPassport(editPassport.getText().toString().trim());
                    mainActivity.setDate_of_birth(editDate_of_birth.getText().toString().trim());
                    mainActivity.setNation(editNation.getText().toString().trim());

                    return;
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
    public void notOnTouchEdit(EditText edit){
        edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;// true là chặn tất cả các lần chạm vào EditText
            }
        });
    }
    public void onTouchEdit(EditText edit){
        edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;// true là chặn tất cả các lần chạm vào EditText
            }
        });
    }

}
