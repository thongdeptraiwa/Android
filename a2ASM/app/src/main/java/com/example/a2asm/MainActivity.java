package com.example.a2asm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.a2asm.fragment.fragment_caidat;
import com.example.a2asm.fragment.fragment_gioithieu;
import com.example.a2asm.fragment.fragment_quanlysanpham;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2_asm_main);

        //ánh xạ
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigationView);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);

        //menu
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_menu);

        getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout,new fragment_quanlysanpham()).commit();

        //nhan navigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = new fragment_quanlysanpham();
                if(item.getItemId() == R.id.mGioiThieu){
                    fragment = new fragment_gioithieu();
                }else if (item.getItemId() == R.id.mCaiDat){
                    fragment = new fragment_caidat();
                }else if (item.getItemId() == R.id.mDangXuat) {
                    //tạo dialog thông báo đăng xuat
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setTitle("Thông Báo!");
                    alertDialogBuilder.setMessage("Bạn có chắc chắn muốn đăng xuất không!");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setPositiveButton("Đồng Ý", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                }

                //đổi title
                getSupportActionBar().setTitle(item.getTitle());
                //nhúng fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout,fragment).commit();
                //tắc drawer khi nhan xong
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        //nhan bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new fragment_quanlysanpham();
                if(item.getItemId() == R.id.mGioiThieu){
                    fragment = new fragment_gioithieu();
                }else if (item.getItemId() == R.id.mCaiDat){
                    fragment = new fragment_caidat();
                }

                //đổi title
                getSupportActionBar().setTitle(item.getTitle());
                //nhúng fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout,fragment).commit();
                //tắc drawer khi nhan xong
                drawerLayout.closeDrawer(GravityCompat.START);
                //true là chọn
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //android.R.id.home là icon 3 que (tên mặc định của hệ thống)
        if(item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}