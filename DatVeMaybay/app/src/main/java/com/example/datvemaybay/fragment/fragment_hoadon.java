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
import com.example.datvemaybay.model.HoaDon;
import com.example.datvemaybay.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;
import java.util.UUID;


public class fragment_hoadon extends Fragment {

    MainActivity mainActivity;
    Button btnXacNhan,btnTroVe;
    Context c;
    TextView tvFullName,tvKhoiHanh,tvKetThuc,tvTu,tvDen,tvGia;
    FirebaseFirestore firebase = FirebaseFirestore.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hoadon,container,false);
        c = getActivity();
        //ánh xạ
        mainActivity = (MainActivity) getActivity();
        btnXacNhan = view.findViewById(R.id.btnXacNhan);
        btnTroVe = view.findViewById(R.id.btnTroVe);
        tvFullName = view.findViewById(R.id.tvFullName);
        tvKhoiHanh = view.findViewById(R.id.tvKhoiHanh);
        tvKetThuc = view.findViewById(R.id.tvKetThuc);
        tvTu = view.findViewById(R.id.tvTu);
        tvDen = view.findViewById(R.id.tvDen);
        tvGia = view.findViewById(R.id.tvGia);


        //lấy data từ MainActivity
        tvFullName.setText(mainActivity.getFullName());
        tvKhoiHanh.setText(mainActivity.getKhoiHanh());
        tvKetThuc.setText(mainActivity.getKetThuc());
        tvTu.setText(mainActivity.getTu());
        tvDen.setText(mainActivity.getDen());

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //gia
                mainActivity.setGia(tvGia.getText().toString().trim());

                //thêm vé
                String ID = UUID.randomUUID().toString();
                HoaDon hoaDon = new HoaDon(ID,
                        mainActivity.getID(),//ID_of_User
                        mainActivity.getFullName(),
                        mainActivity.getKhoiHanh(),
                        mainActivity.getKetThuc(),
                        mainActivity.getTu(),
                        mainActivity.getDen(),
                        mainActivity.getGia());
                Map<String, Object> hashMap = hoaDon.covertHashMap();

                firebase.collection("HoaDon")
                        .document(ID)
                        .set(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(c, "them thanh cong", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(c, "them that bai", Toast.LENGTH_SHORT).show();
                            }
                        });

                mainActivity.truyenFragmentTrangChu();
            }
        });
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.truyenFragmentDatVe();
            }
        });

        return view;
    }

}
