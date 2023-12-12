package com.example.a2asm.Lab7;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;

import android.os.Bundle;
import android.os.Handler;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.a2asm.R;

import com.example.a2asm.model.SanPham;
import com.example.a2asm.model.SanPham_ID;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import java.util.Map;
import java.util.UUID;


public class Lab7 extends AppCompatActivity {
    Context c = this;
    FirebaseFirestore firebase = FirebaseFirestore.getInstance();
    ArrayList<SanPham_ID> ds = new ArrayList<>();
    Lab7ADT_Recyclerview adapterSP;

    EditText editName,editGia,editSL;
    Button btnThem;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7);

        //ánh xạ
        editName=findViewById(R.id.editName);
        editGia=findViewById(R.id.editGia);
        editSL=findViewById(R.id.editSL);
        btnThem=findViewById(R.id.btnThem);
        recyclerView=findViewById(R.id.recyclerView);

        //recyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(c);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        CapNhatData();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemSP();
            }
        });

    }
    public void CapNhatData(){
        //reset
        ds.clear();

        firebase.collection("SanPham")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //bị chậm
                                SanPham_ID sp = new SanPham_ID(document.getId().toString(),document.get("name").toString(),Integer.parseInt(document.get("gia").toString()),Integer.parseInt(document.get("sl").toString()));
                                ds.add(sp);
                                //id++;
                                x();
                                }
                        } else {
                            Toast.makeText(Lab7.this, "lắng nghe failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }
    public void x(){
        //recycleview
        adapterSP = new Lab7ADT_Recyclerview(c,ds);
        recyclerView.setAdapter(adapterSP);
        Toast.makeText(Lab7.this, "Cập nhập thành công", Toast.LENGTH_SHORT).show();
    }
    public void ThemSP(){
        String name = editName.getText().toString().trim();
        int gia = Integer.parseInt(editGia.getText().toString().trim());
        int sl = Integer.parseInt(editSL.getText().toString().trim());

        //them
        //id++;
        String ID = UUID.randomUUID().toString();
        SanPham_ID sanPham = new SanPham_ID(ID,name,gia,sl);
        Map<String, Object> hashMap = sanPham.covertHashMap();

        firebase.collection("SanPham")
                .document(ID)
                .set(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Lab7.this, "them thanh cong", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Lab7.this, "them that bai", Toast.LENGTH_SHORT).show();
                    }
                });

        CapNhatData();
        //reset
        editName.setText("");
        editGia.setText("");
        editSL.setText("");

    }
    public void SuaSP(String ID,String name,int gia,int sl,int index){

        SanPham_ID sanPham = new SanPham_ID(ID,name,gia,sl);
        Map<String, Object> hashMap = sanPham.covertHashMap();

        firebase.collection("SanPham")
                .document(ID)
                .update(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Lab7.this, "sua thanh cong", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Lab7.this, "sua that bai", Toast.LENGTH_SHORT).show();
                    }
                });

        CapNhatData();


    }
    public void XoaSP(String ID){

        firebase.collection("SanPham")
                .document(ID)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Lab7.this, "Xóa thanh cong", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Lab7.this, "Xóa that bai", Toast.LENGTH_SHORT).show();
                    }
                });

        CapNhatData();

    }

}