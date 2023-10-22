package com.example.android1.thi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android1.ASM.ASMQuanly;
import com.example.android1.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Activity extends AppCompatActivity {
    ArrayList<SinhVien> ds = new ArrayList<>();
    SinhVienADT adapterSV;
    ListView lv;
    Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        lv=findViewById(R.id.lv);
        btnThem=findViewById(R.id.btnThem);

        //add Nv
        ds.add(new SinhVien("SV001","Nguyễn Văn Bảo"));
        ds.add(new SinhVien("SV002","Nguyễn Văn Cường"));
        ds.add(new SinhVien("SV003","Nguyễn Văn Dũng"));
        ds.add(new SinhVien("SV004","Nguyễn Văn Em"));
        ds.add(new SinhVien("SV005","Nguyễn Văn Hà"));


        capNhatLayout();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themNV();
            }
        });

    }
    public  void themNV(){
        Dialog dialogThem = new Dialog(Activity.this);
        dialogThem.setContentView(R.layout.asm_dialog_themsv);
        dialogThem.setCanceledOnTouchOutside(false);
        dialogThem.show();

        Button btnThem1 = dialogThem.findViewById(R.id.btnThem1);
        Button btnHuy = dialogThem.findViewById(R.id.btnHuy);

        btnThem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editMaNV = dialogThem.findViewById(R.id.editMaNV);
                EditText editTenNV = dialogThem.findViewById(R.id.editTenNV);
                //EditText editPhongBan = dialogThem.findViewById(R.id.editPhongBan);

                String maNV=editMaNV.getText().toString().trim();
                String hoTen=editTenNV.getText().toString().trim();
                //String phong=editPhongBan.getText().toString().trim();

                //rỗng
                if(maNV.equals("")){
                    Toast.makeText(Activity.this, "Bạn chưa nhập Mã NV!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(hoTen.equals("")){
                    Toast.makeText(Activity.this, "Bạn chưa nhập Họ Tên!", Toast.LENGTH_SHORT).show();
                    return;
                }
//                if(phong.equals("")){
//                    Toast.makeText(Activity.this, "Bạn chưa nhập Phòng Ban!", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                //sai định dạng
                String dkMaNV = "[SV]+\\d{3}";
                String dkHoTen = "([A-Z AĂÂEÊIOÔƠUƯÁẮẤÉẾÍÓỐỚÚỨÝÀẰẦÈỀÌÒỒỜÙỪỲẢẲẨẺỂỈỎỔỞỦỬỶÃẴẪẼỄỈÕỖỠŨỮỸẠẶẬẸỆỊỌỘỢỤỰỴĐ]" +
                        "+[a-zaăâeêioôơuưyáắấéếíóốớúứýàằầèềìòồờùừỳảẳẩẻểỉỏổởủửỷãẵẫẽễĩõỗỡũữỹạặậẹệịọộợụựỵđ]{1,5}" +
                        "+[ ]" +
                        "+[A-Z AĂÂEÊIOÔƠUƯÁẮẤÉẾÍÓỐỚÚỨÝÀẰẦÈỀÌÒỒỜÙỪỲẢẲẨẺỂỈỎỔỞỦỬỶÃẴẪẼỄỈÕỖỠŨỮỸẠẶẬẸỆỊỌỘỢỤỰỴĐ]" +
                        "+[a-zaăâeêioôơuưyáắấéếíóốớúứýàằầèềìòồờùừỳảẳẩẻểỉỏổởủửỷãẵẫẽễĩõỗỡũữỹạặậẹệịọộợụựỵđ]{1,5}){1,6}";


                if(!maNV.matches(dkMaNV)){
                    editMaNV.setTextColor(Color.RED);
                    Toast.makeText(Activity.this, "Bạn nhập sai định dạng ID!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editMaNV.setTextColor(Color.BLACK);

                if(!hoTen.matches(dkHoTen) || !hoTen.contains(" ")){
                    editTenNV.setTextColor(Color.RED);
                    Toast.makeText(Activity.this, "Bạn nhập sai định dạng Họ tên!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editTenNV.setTextColor(Color.BLACK);

//                if(!phong.equals("Nhân Sự") && !phong.equals("Hành Chính") && !phong.equals("Đào Tạo")){
//                    editPhongBan.setTextColor(Color.RED);
//                    Toast.makeText(Activity.this, "Không có phòng ban "+phong+" !", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                editPhongBan.setTextColor(Color.BLACK);

                //ko trùng nhau
                for(int j =0;j<ds.size();j++){
                    if(ds.get(j).getID().equals(maNV)){
                        editMaNV.setTextColor(Color.RED);
                        Toast.makeText(Activity.this, "ID: "+maNV+" đã tồn tại !", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                editMaNV.setTextColor(Color.BLACK);

                Toast.makeText(Activity.this, "Thêm SV Thành Công", Toast.LENGTH_SHORT).show();
                ds.add(new SinhVien(maNV,hoTen));


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
    public void XoaNV(int index){
        ds.remove(index);
        capNhatLayout();
    }

    public void suaNV(int index, String maNV, String tenNV){
        ds.get(index).setID(maNV);
        ds.get(index).setTen(tenNV);
        //ds.get(index).setPhongNV(phongNV);
        capNhatLayout();
    }
    public void capNhatLayout(){
        sapXepDSNV();
        adapterSV = new SinhVienADT(Activity.this,ds);
        lv.setAdapter(adapterSV);
    }
    public void sapXepDSNV(){
        Comparator<SinhVien> comp = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return (o1.getID().compareTo(o2.getID()));
            }
        };
        Collections.sort(ds, comp);
    }
    public void chuyenActivity(){
        Intent intent = new Intent(Activity.this, Activity2.class);
        startActivity(intent);
    }
}