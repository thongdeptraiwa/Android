package com.example.android1.A2ASM.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android1.A2ASM.QuanLySanPham;
import com.example.android1.A2ASM.SanPhamADT_Recyclerview;
import com.example.android1.A2ASM.dao.SanPhamDao;
import com.example.android1.A2ASM.model.SanPham;
import com.example.android1.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Fragment_QuanLySanPham extends Fragment {
    ImageView imgThem;

    //Context context=this;
    ArrayList<SanPham> ds = new ArrayList<>();
    SanPhamDao spDao = new SanPhamDao(getContext());
    SanPhamADT_Recyclerview adapterSP;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.a2_asm_fragment_quanlysanpham,container,false);

        //ánh xạ
        recyclerView=view.findViewById(R.id.recyclerView);

        capNhatLayout();

        return view;
    }
    public void capNhatLayout(){
        //spDao.themSP(new SanPham("bánh",120000,4));
        //dua data
        ds = spDao.xemSP();

        //sapXepDSNV();

        //recycleview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterSP = new SanPhamADT_Recyclerview(getContext(),ds);
        recyclerView.setAdapter(adapterSP);

    }

    public void themSP(){
        Dialog dialogThem = new Dialog(getContext());
        dialogThem.setContentView(R.layout.a2_asm_dialog_them);
        dialogThem.show();

        Button btnThemDialog = dialogThem.findViewById(R.id.btnThem);
        EditText editName = dialogThem.findViewById(R.id.editName);
        EditText editGia = dialogThem.findViewById(R.id.editGia);
        EditText editSL = dialogThem.findViewById(R.id.editSL);

        btnThemDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString().trim();
                int gia = Integer.parseInt(editGia.getText().toString().trim());
                int sl = Integer.parseInt(editSL.getText().toString().trim());

                spDao.themSP(new SanPham(name,gia,sl));

                capNhatLayout();

                Toast.makeText(getContext(), "Thêm sp thành công", Toast.LENGTH_SHORT).show();
                dialogThem.dismiss();
            }
        });

    }
    public void chinhSuaSP(SanPham sp){
        spDao.suaSP(sp);
    }
    public void xoaSP(String name){
        spDao.xoaSP(name);
    }
}
