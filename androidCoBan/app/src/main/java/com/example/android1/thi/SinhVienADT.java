package com.example.android1.thi;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android1.ASM.ASMPhongBan;
import com.example.android1.ASM.ASMQuanly;
import com.example.android1.R;

import java.util.ArrayList;

public class SinhVienADT extends BaseAdapter {

    Context c;
    ArrayList<SinhVien> ds = new ArrayList<SinhVien>();


    public SinhVienADT(Context c, ArrayList<SinhVien> ds){
        this.c = c;
        this.ds = ds;

    }

    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //lấy LayoutInflater
        LayoutInflater inf = ((Activity)c).getLayoutInflater();

        // ánh xạ view
        view = inf.inflate(R.layout.item_sv,null);

        //ánh xạ
        TextView tvMa = view.findViewById(R.id.tvMa);
        TextView tvTen = view.findViewById(R.id.tvTen);
        //TextView tvPhong = view.findViewById(R.id.tvPhong);
        ImageView imgSua=view.findViewById(R.id.imgSua);
        ImageView imgXoa=view.findViewById(R.id.imgXoa);

        tvMa.setText(ds.get(i).ID);
        tvTen.setText(ds.get(i).ten);
        //tvPhong.setText(ds.get(i).phongNV);

        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //tạo dialog
                Dialog dialogXoa = new Dialog((Activity)c);
                dialogXoa.setContentView(R.layout.asm_dialog_xoa_sv);
                dialogXoa.setCanceledOnTouchOutside(false);
                dialogXoa.show();

                //ánh xạ
                Button btnXoa = dialogXoa.findViewById(R.id.btnXoa);
                Button btnHuy = dialogXoa.findViewById(R.id.btnHuy);

                TextView tvMaNV = dialogXoa.findViewById(R.id.tvMaNV);
                TextView tvHoTen = dialogXoa.findViewById(R.id.tvHoTen);
                //TextView tvPhongBan = dialogXoa.findViewById(R.id.tvPhongBan);

                tvMaNV.setText(ds.get(i).ID);
                tvHoTen.setText(ds.get(i).ten);
                //tvPhongBan.setText(ds.get(i).phongNV);

                btnXoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //gọi phương thức của Activity
                        ((Activity)c).XoaNV(i);

                        dialogXoa.dismiss();
                    }
                });

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogXoa.cancel();
                    }
                });
            }
        });

        imgSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Activity
                ((Activity)c).chuyenActivity();
            }
        });

        Animation anim = AnimationUtils.loadAnimation((Activity)c,R.anim.anim_list);
        view.startAnimation(anim);

        return view;
    }

}
