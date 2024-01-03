package com.example.datvemaybay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datvemaybay.ADT.ADT_Recyclerview_DanhSachVe;
import com.example.datvemaybay.MainActivity;
import com.example.datvemaybay.R;
import com.example.datvemaybay.model.HoaDon;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class fragment_danhsachve extends Fragment {


    MainActivity mainActivity;
    Context c;
    FirebaseFirestore firebase = FirebaseFirestore.getInstance();
    ArrayList<HoaDon> ds = new ArrayList<>();
    ADT_Recyclerview_DanhSachVe adapter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danhsachve,container,false);
        c = getActivity();
        //ánh xạ
        mainActivity = (MainActivity) getActivity();
        recyclerView=view.findViewById(R.id.recyclerView);

        //recyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(c);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        CapNhatData();

        return view;
    }
    public void CapNhatData(){
        //reset
        ds.clear();

        firebase.collection("HoaDon")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                if(document.get("ID_of_User").equals(mainActivity.getID())){
                                    //bị chậm
                                    HoaDon hd = new HoaDon(document.getId().toString(),
                                            document.get("ID_of_User").toString(),
                                            document.get("fullName").toString(),
                                            document.get("khoiHanh").toString(),
                                            document.get("ketThuc").toString(),
                                            document.get("tu").toString(),
                                            document.get("den").toString(),
                                            document.get("gia").toString());
                                    ds.add(hd);
                                    //id++;
                                    adapter = new ADT_Recyclerview_DanhSachVe(c,ds);
                                    recyclerView.setAdapter(adapter);
                                    Toast.makeText(c, "Cập nhập thành công", Toast.LENGTH_SHORT).show();
                                }

                            }
                        } else {
                            Toast.makeText(c, "lắng nghe failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}
