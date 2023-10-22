package com.example.android1.ASM;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android1.R;

import java.util.ArrayList;

public class Dialog_ListviewNV_ADT_XoaNV extends BaseAdapter {
    Context c;
    ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
    public Dialog_ListviewNV_ADT_XoaNV(Context c, ArrayList<NhanVien> ds){
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
        LayoutInflater inf = ((ASMNhanVien)c).getLayoutInflater();

        // ánh xạ view
        view = inf.inflate(R.layout.item_asm_dialog,null);

        //ánh xạ
        TextView tvMa = view.findViewById(R.id.tvMaNV);
        ImageView imgXoa = view.findViewById(R.id.img);

        tvMa.setText(ds.get(i).maNV);

        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tạo dialog
                Dialog dialogXoa = new Dialog((ASMNhanVien)c);
                dialogXoa.setContentView(R.layout.asm_dialog_xoa);
                dialogXoa.setCanceledOnTouchOutside(false);
                dialogXoa.show();

                //ánh xạ
                Button btnXoa = dialogXoa.findViewById(R.id.btnXoa);
                Button btnHuy = dialogXoa.findViewById(R.id.btnHuy);

                TextView tvMaNV = dialogXoa.findViewById(R.id.tvMaNV);
                TextView tvHoTen = dialogXoa.findViewById(R.id.tvHoTen);
                TextView tvPhongBan = dialogXoa.findViewById(R.id.tvPhongBan);

                tvMaNV.setText(ds.get(i).maNV);
                tvHoTen.setText(ds.get(i).tenNV);
                tvPhongBan.setText(ds.get(i).phongNV);

                btnXoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //gọi phương thức của ASMNhanVien
                        ((ASMNhanVien)c).XoaNV(i,1);
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

        Animation anim = AnimationUtils.loadAnimation((ASMNhanVien)c,R.anim.anim_list);
        view.startAnimation(anim);

        return view;
    }
}
