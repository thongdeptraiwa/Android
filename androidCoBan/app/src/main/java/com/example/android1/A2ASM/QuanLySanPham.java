package com.example.android1.A2ASM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android1.A2ASM.Fragment.Fragment_GioiThieu;
import com.example.android1.A2ASM.Fragment.Fragment_QuanLySanPham;
import com.example.android1.A2ASM.dao.SanPhamDao;
import com.example.android1.A2ASM.model.SanPham;
import com.example.android1.A2LAB1.A2lab1;
import com.example.android1.A2LAB1.dao.SinhVienDao;
import com.example.android1.A2LAB1.model.SinhVien;
import com.example.android1.ASM.ASMNhanVien;
import com.example.android1.ASM.NhanVien;
import com.example.android1.ASM.NhanVienADT;
import com.example.android1.ASM.dataNhanVien;
import com.example.android1.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class QuanLySanPham extends AppCompatActivity {
    ImageView imgThem;

    Context context=this;
    ArrayList<SanPham> ds = new ArrayList<>();
    //SanPhamDao spDao = new SanPhamDao(QuanLySanPham.this);
    //SanPhamADT_Recyclerview adapterSP;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    //RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2_asm_quan_ly_san_pham);
        //ánh xạ
        //recyclerView=findViewById(R.id.recyclerView);
        //imgThem=findViewById(R.id.imgThem);
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        //navigationView=findViewById(R.id.navigationView);

        //menu
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_menu);

        //capNhatLayout();

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new Fragment_QuanLySanPham()).commit();

        //nhan them
//        imgThem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                themSP();
//            }
//        });

        //nhan navigationView
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                Fragment fragment = new Fragment_QuanLySanPham();
//                if(item.getItemId() == R.id.mGioiThieu){
//                    fragment = new Fragment_GioiThieu();
//                }
//
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout,fragment).commit();
//
//                return false;
//            }
//        });


    }


    //onclick menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //android.R.id.home là icon 3 que (tên mặc định của hệ thống)
        if(item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}