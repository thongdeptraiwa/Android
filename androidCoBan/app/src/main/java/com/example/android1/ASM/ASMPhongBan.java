package com.example.android1.ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android1.R;

import java.util.ArrayList;

public class ASMPhongBan extends AppCompatActivity {

    ArrayList<PhongBan> ds= new ArrayList<PhongBan>();

    ListView lv;
    TextView tvPopupMenu;
    Button btnPopupMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asmphongban);
        lv=findViewById(R.id.lv);
        tvPopupMenu=findViewById(R.id.txtPopupMenu);
        btnPopupMenu=findViewById(R.id.btnPopupMenu);

        ds.add(new PhongBan(R.drawable.home,"Nhân Sự"));
        ds.add(new PhongBan(R.drawable.home,"Hành Chính"));
        ds.add(new PhongBan(R.drawable.home,"Đào Tạo"));

        PhongBanADT adapter = new PhongBanADT(ASMPhongBan.this,ds);
        lv.setAdapter(adapter);

        //Popup Menu
        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu pp = new PopupMenu(ASMPhongBan.this,tvPopupMenu);
                pp.getMenuInflater().inflate(R.menu.option_menu,pp.getMenu());
                pp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.them) {
                            Toast.makeText(ASMPhongBan.this, "thêm NV", Toast.LENGTH_SHORT).show();
                        }
                        if (menuItem.getItemId() == R.id.sua) {
                            Toast.makeText(ASMPhongBan.this, "Sửa Thông Tin NV", Toast.LENGTH_SHORT).show();
                        }
                        if (menuItem.getItemId() == R.id.xoa) {
                            Toast.makeText(ASMPhongBan.this, "Xóa NV", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                pp.show();
            }
        });

    }

}