package com.example.datvemaybay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datvemaybay.ADT.ADT_Recyclerview_DiaChi_Tu;
import com.example.datvemaybay.fragment.fragment_danhsachve;
import com.example.datvemaybay.fragment.fragment_datve;
import com.example.datvemaybay.fragment.fragment_doimatkhau;
import com.example.datvemaybay.fragment.fragment_hoadon;
import com.example.datvemaybay.fragment.fragment_taikhoan;
import com.example.datvemaybay.fragment.fragment_thongtincanhan;
import com.example.datvemaybay.fragment.fragment_trangchu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    Context c=this;

    //thuốc tính của user
    private String ID;
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String passport;
    private String Date_of_birth;
    private String nation;
    //hoa don
    public String tu= "....",
            den= "....",
            khoiHanh= "....",
            ketThuc= "....",
            ghe= "....",
            chieu = "....",
            gia;

    //FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        //frameLayout = findViewById(R.id.frameLayout);

        hienBottomNavigationView(true);

        //menu
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //lấy dữ liệu từ Login
        Intent intent = getIntent();
        Bundle bundleOfLogin = intent.getExtras();
        ID = bundleOfLogin.getString("ID", "");
        username = bundleOfLogin.getString("username", "");
        password = bundleOfLogin.getString("password", "");
        fullName = bundleOfLogin.getString("fullName", "");
        address = bundleOfLogin.getString("address", "");
        passport = bundleOfLogin.getString("passport", "");
        Date_of_birth = bundleOfLogin.getString("Date_of_birth", "");
        nation = bundleOfLogin.getString("nation", "");

        //fragment mặc định khi vào app
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new fragment_trangchu()).commit();

        //truyền data từ activity sang fragment
        //fragment_trangchu fragmentTrangchu = new fragment_trangchu();
        //Bundle bundleOfFragment = new Bundle();
        //bundleOfFragment.putString("fullname", fullName);
        //fragmentTrangchu.setArguments(bundleOfFragment);

        //nhan bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new fragment_trangchu();
                if(item.getItemId() == R.id.mTrangChu){
                    fragment = new fragment_trangchu();
                    //đổi title
                    getSupportActionBar().setTitle("Mythos Horizon");
                }else if (item.getItemId() == R.id.mKhuyenMai){
                    //fragment = new fragment_caidat();
                    //đổi title
                    getSupportActionBar().setTitle("Danh sách khuyến mãi");
                }
                else if (item.getItemId() == R.id.mDanhSachVe){
                    fragment = new fragment_danhsachve();
                    //đổi title
                    getSupportActionBar().setTitle("Danh sách vé");
                }
                else if (item.getItemId() == R.id.mTaiKhoan){
                    fragment = new fragment_taikhoan();
                    //đổi title toolbar
                    getSupportActionBar().setTitle("Tài khoản");
                }

                //nhúng fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
                //tắc drawer khi nhan xong
                //drawerLayout.closeDrawer(GravityCompat.START);
                //true là chọn
                return true;
            }
        });
    }
    public void backLogin(){
        finish();
    }
    public void truyenFragmentHoaDon(){
        Fragment fragment = new fragment_hoadon();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
        //đổi title toolbar
        getSupportActionBar().setTitle("Hóa đơn");
        //ẩn bottomNavigationView
        hienBottomNavigationView(false);
    }
    public void truyenFragmentTrangChu(){
        Fragment fragment = new fragment_trangchu();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
        //đổi title toolbar
        getSupportActionBar().setTitle("Mythos Horizon");
        //ẩn bottomNavigationView
        hienBottomNavigationView(true);
    }
    public void truyenFragmentDatVe(){
        Fragment fragment = new fragment_datve();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
        //đổi title toolbar
        getSupportActionBar().setTitle("Đặt chuyến bay");
        //ẩn bottomNavigationView
        hienBottomNavigationView(false);
    }
    public void truyenFragmentDoiMatKhau(){
        Fragment fragment = new fragment_doimatkhau();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
        //đổi title toolbar
        getSupportActionBar().setTitle("Đổi mật khẩu");
        //ẩn bottomNavigationView
        hienBottomNavigationView(false);
    }
    public void truyenFragmentThongTinCaNhan(){
        Fragment fragment = new fragment_thongtincanhan();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
        //đổi title toolbar
        getSupportActionBar().setTitle("Thông tin cá nhân");
        //ẩn bottomNavigationView
        hienBottomNavigationView(false);
    }
    public void backFragmentTaiKhoan(){
        Fragment fragment = new fragment_taikhoan();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
        //đổi title toolbar
        getSupportActionBar().setTitle("Tài khoản");
        //hiện bottomNavigationView
        hienBottomNavigationView(true);
    }
    public void hienBottomNavigationView(boolean tf){
        if(tf == true){
            //hiện bottomNavigationView
            bottomNavigationView.setVisibility(View.VISIBLE);
        }else {
            //ẩn bottomNavigationView
            bottomNavigationView.setVisibility(View.GONE);
        }
    }

    public void dangXuat(){
        finish();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDate_of_birth() {
        return Date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        Date_of_birth = date_of_birth;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getTu() {
        return tu;
    }

    public void setTu(String tu) {
        this.tu = tu;
        truyenFragmentDatVe();
    }

    public String getDen() {
        return den;
    }

    public void setDen(String den) {
        this.den = den;
        truyenFragmentDatVe();
    }

    public String getKhoiHanh() {
        return khoiHanh;
    }

    public void setKhoiHanh(String khoiHanh) {
        this.khoiHanh = khoiHanh;
        truyenFragmentDatVe();
    }

    public String getKetThuc() {
        return ketThuc;
    }

    public void setKetThuc(String ketThuc) {
        this.ketThuc = ketThuc;
        truyenFragmentDatVe();
    }

    public String getGhe() {
        return ghe;
    }

    public void setGhe(String ghe) {
        this.ghe = ghe;
        truyenFragmentDatVe();
    }

    public String getChieu() {
        return chieu;
    }

    public void setChieu(String chieu) {
        this.chieu = chieu;
        truyenFragmentDatVe();
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}