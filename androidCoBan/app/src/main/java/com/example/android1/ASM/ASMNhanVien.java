package com.example.android1.ASM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android1.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ASMNhanVien extends AppCompatActivity {
    ArrayList<NhanVien> ds = new ArrayList<>();

    ListView lv,lvDialogXoa,lvDialogSua;
    Button btnThem;
    Toolbar toolbar;
    Context context=this;
    SearchView searchView;
    //NhanVienADT
    NhanVienADT adapterNV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asmnhanvien);

        lv=findViewById(R.id.lv);

        //contextMenu
        registerForContextMenu(lv);

        btnThem=findViewById(R.id.btnThem);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //btn Thoat toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //add Nv
//        ds.add(new NhanVien("NV001","Nguyễn Văn Bảo","Hành Chính"));
//        ds.add(new NhanVien("NV002","Nguyễn Văn Cường","Nhân Sự"));
//        ds.add(new NhanVien("NV003","Nguyễn Văn Dũng","Nhân Sự"));
//        ds.add(new NhanVien("NV004","Nguyễn Văn Em","Đào Tạo"));
//        ds.add(new NhanVien("NV005","Nguyễn Văn Hà","Hành Chính"));
//        ds.add(new NhanVien("NV006","Nguyễn Văn Minh","Nhân Sự"));
//        ds.add(new NhanVien("NV007","Nguyễn Văn Trí","Nhân Sự"));
//        ds.add(new NhanVien("NV008","Nguyễn Văn An","Đào Tạo"));

        capNhatLayout();


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themNV();
            }
        });

    }

    public  void themNV(){
        Dialog dialogThem = new Dialog(ASMNhanVien.this);
        dialogThem.setContentView(R.layout.asm_dialog_themnv);
        dialogThem.setCanceledOnTouchOutside(false);
        dialogThem.show();

        Button btnThem1 = dialogThem.findViewById(R.id.btnThem1);
        Button btnHuy = dialogThem.findViewById(R.id.btnHuy);

        btnThem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editMaNV = dialogThem.findViewById(R.id.editMaNV);
                EditText editTenNV = dialogThem.findViewById(R.id.editTenNV);
                EditText editPhongBan = dialogThem.findViewById(R.id.editPhongBan);

                String maNV=editMaNV.getText().toString().trim();
                String hoTen=editTenNV.getText().toString().trim();
                String phong=editPhongBan.getText().toString().trim();

                //rỗng
                if(maNV.equals("")){
                    Toast.makeText(ASMNhanVien.this, "Bạn chưa nhập Mã NV!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(hoTen.equals("")){
                    Toast.makeText(ASMNhanVien.this, "Bạn chưa nhập Họ Tên!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(phong.equals("")){
                    Toast.makeText(ASMNhanVien.this, "Bạn chưa nhập Phòng Ban!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //sai định dạng
                String dkMaNV = "[NV]+\\d{3}";
                String dkHoTen = "([A-Z AĂÂEÊIOÔƠUƯÁẮẤÉẾÍÓỐỚÚỨÝÀẰẦÈỀÌÒỒỜÙỪỲẢẲẨẺỂỈỎỔỞỦỬỶÃẴẪẼỄỈÕỖỠŨỮỸẠẶẬẸỆỊỌỘỢỤỰỴĐ]" +
                        "+[a-zaăâeêioôơuưyáắấéếíóốớúứýàằầèềìòồờùừỳảẳẩẻểỉỏổởủửỷãẵẫẽễĩõỗỡũữỹạặậẹệịọộợụựỵđ]{1,5}" +
                        "+[ ]" +
                        "+[A-Z AĂÂEÊIOÔƠUƯÁẮẤÉẾÍÓỐỚÚỨÝÀẰẦÈỀÌÒỒỜÙỪỲẢẲẨẺỂỈỎỔỞỦỬỶÃẴẪẼỄỈÕỖỠŨỮỸẠẶẬẸỆỊỌỘỢỤỰỴĐ]" +
                        "+[a-zaăâeêioôơuưyáắấéếíóốớúứýàằầèềìòồờùừỳảẳẩẻểỉỏổởủửỷãẵẫẽễĩõỗỡũữỹạặậẹệịọộợụựỵđ]{1,5}){1,6}";


                if(!maNV.matches(dkMaNV)){
                    editMaNV.setTextColor(Color.RED);
                    Toast.makeText(ASMNhanVien.this, "Bạn nhập sai định dạng MÃ NV!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editMaNV.setTextColor(Color.BLACK);

                if(!hoTen.matches(dkHoTen) || !hoTen.contains(" ")){
                    editTenNV.setTextColor(Color.RED);
                    Toast.makeText(ASMNhanVien.this, "Bạn nhập sai định dạng Họ tên!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editTenNV.setTextColor(Color.BLACK);

                if(!phong.equals("Nhân Sự") && !phong.equals("Hành Chính") && !phong.equals("Đào Tạo")){
                    editPhongBan.setTextColor(Color.RED);
                    Toast.makeText(ASMNhanVien.this, "Không có phòng ban "+phong+" !", Toast.LENGTH_SHORT).show();
                    return;
                }
                editPhongBan.setTextColor(Color.BLACK);

                //ko trùng nhau
                for(int j =0;j<ds.size();j++){
                    if(ds.get(j).getMaNV().equals(maNV)){
                        editMaNV.setTextColor(Color.RED);
                        Toast.makeText(ASMNhanVien.this, "MÃ NV: "+maNV+" đã tồn tại !", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                editMaNV.setTextColor(Color.BLACK);

                Toast.makeText(ASMNhanVien.this, "Thêm NV Thành Công", Toast.LENGTH_SHORT).show();
                ds.add(new NhanVien(maNV,hoTen,phong));

                //luu file
                dataNhanVien d = new dataNhanVien(context);
                d.writeNhanVien(context,"nhanvien.txt",ds);

                capNhatLayout();
                dialogThem.dismiss();

            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogThem.cancel();
            }
        });
    }

    public void XoaNV(int index, int check){
        ds.remove(index);
        //luu file
        dataNhanVien d = new dataNhanVien(context);
        d.writeNhanVien(context,"nhanvien.txt",ds);

        capNhatLayout();
        if(check == 1){
            capNhatLayoutDialogXoa();
        }
    }

    public void suaNV(int index, String maNV, String tenNV, String phongNV, int check){
        ds.get(index).setMaNV(maNV);
        ds.get(index).setTenNV(tenNV);
        ds.get(index).setPhongNV(phongNV);

        //luu file
        dataNhanVien d = new dataNhanVien(context);
        d.writeNhanVien(context,"nhanvien.txt",ds);

        capNhatLayout();
        if(check == 1){
            capNhatLayoutDialogSua();
        }
    }

    public void capNhatLayout(){
        // doc file
        dataNhanVien d = new dataNhanVien(context);
        ds = (ArrayList<NhanVien>) d.readNhanVien(context,"nhanvien.txt");

        sapXepDSNV();
        adapterNV = new NhanVienADT(ASMNhanVien.this,ds);
        lv.setAdapter(adapterNV);
    }
    public void capNhatLayoutDialogXoa(){
        Dialog_ListviewNV_ADT_XoaNV adapter = new Dialog_ListviewNV_ADT_XoaNV(ASMNhanVien.this,ds);
        sapXepDSNV();
        lvDialogXoa.setAdapter(adapter);
    }
    public void capNhatLayoutDialogSua(){
        Dialog_ListviewNV_ADT_SuaNV adapter = new Dialog_ListviewNV_ADT_SuaNV(ASMNhanVien.this,ds);
        sapXepDSNV();
        lvDialogSua.setAdapter(adapter);
    }

    public void sapXepDSNV(){
        Comparator<NhanVien> comp = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return (o1.getMaNV().compareTo(o2.getMaNV()));
            }
        };
        Collections.sort(ds, comp);
    }

    //dialog Menu
    public void menuSua(){
        //tạo dialog Xoa
        Dialog dialogSua = new Dialog(ASMNhanVien.this);
        dialogSua.setContentView(R.layout.asm_dialog_listview);
        dialogSua.setCanceledOnTouchOutside(false);
        dialogSua.show();

        //ánh xạ
        TextView tvTitle = dialogSua.findViewById(R.id.tvTitle);
        ImageView imgThoat = dialogSua.findViewById(R.id.imgThoat);
        // Listview toàn cục
        lvDialogSua = dialogSua.findViewById(R.id.lvDialog);

        //núng layout zo listview
        capNhatLayoutDialogSua();

        tvTitle.setText("Sửa NV");

        imgThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSua.dismiss();
            }
        });
    }

    public void menuXoa(){
        //tạo dialog Xoa
        Dialog dialogXoa = new Dialog(ASMNhanVien.this);
        dialogXoa.setContentView(R.layout.asm_dialog_listview);
        dialogXoa.setCanceledOnTouchOutside(false);
        dialogXoa.show();

        //ánh xạ
        TextView tvTitle = dialogXoa.findViewById(R.id.tvTitle);
        ImageView imgThoat = dialogXoa.findViewById(R.id.imgThoat);
        // Listview toàn cục
        lvDialogXoa = dialogXoa.findViewById(R.id.lvDialog);

        //núng layout zo listview
        capNhatLayoutDialogXoa();

        tvTitle.setText("Xóa NV");

        imgThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogXoa.dismiss();
            }
        });
    }

    //option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf= getMenuInflater();
        inf.inflate(R.menu.option_menu,menu);

        //search
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.tim).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        //Action search
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapterNV.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterNV.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       if(item.getItemId()==R.id.them){
           themNV();
       }
        if(item.getItemId()==R.id.sua){
            menuSua();
        }
        if(item.getItemId()==R.id.xoa){
            menuXoa();
        }
        return super.onOptionsItemSelected(item);
    }

    //context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.option_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //chon menu them
        if (item.getItemId() == R.id.them) {
            themNV();
        }
        //chon menu sua
        if (item.getItemId() == R.id.sua) {
            menuSua();
        }
        //chon menu xoa
        if (item.getItemId() == R.id.xoa) {
            menuXoa();
        }
        return super.onContextItemSelected(item);
    }

    //khi nhấn back
    @Override
    public void onBackPressed() {
        if(!searchView.isIconified()){
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
}