package com.example.android1.A2ASM;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android1.A2ASM.Fragment.Fragment_QuanLySanPham;
import com.example.android1.A2ASM.model.SanPham;
import com.example.android1.R;
import com.example.android1.thi.Activity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class SanPhamADT_Recyclerview extends RecyclerView.Adapter<SanPhamADT_Recyclerview.ViewHolder>{
    private Context c;
    private ArrayList<SanPham> ds = new ArrayList<SanPham>();

    public SanPhamADT_Recyclerview(Context c, ArrayList<SanPham> ds){
        this.c = c;
        this.ds = ds;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //lấy LayoutInflater
        LayoutInflater inf = ((QuanLySanPham)c).getLayoutInflater();
        //ánh xạ view
        View view = inf.inflate(R.layout.a2_asm_item_sanpham,parent,false);
        //animation
        //Animation anim = AnimationUtils.loadAnimation((Activity)c,R.anim.anim_list);
        //view.startAnimation(anim);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
//        //hiển thị
        holder.tvName.setText(ds.get(i).getName());
            //thêm , trong giá
            NumberFormat formatter = new DecimalFormat("#,###");
            int myNumber = ds.get(i).getGia();
            String formattedNumber = formatter.format(myNumber);
            holder.tvGia.setText(formattedNumber +" VND ");
        holder.tvSL.setText("- SL: "+ds.get(i).getSl());
//
//        holder.tvXoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //tạo dialog
//                Dialog dialogXoa = new Dialog((Activity)c);
//                dialogXoa.setContentView(R.layout.a2_asm_dialog_xoa);
//                dialogXoa.show();
//
//                //ánh xạ
//                TextView tvThongBao = dialogXoa.findViewById(R.id.tvThongBao);
//                TextView tvKhong = dialogXoa.findViewById(R.id.tvKhong);
//                TextView tvDongY = dialogXoa.findViewById(R.id.tvDongY);
//
//                tvThongBao.setText("Bạn có chắc chắn muốn xóa '"+ds.get(i).getName()+"' không?");
//
//                tvKhong.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialogXoa.dismiss();
//                    }
//                });
//                tvDongY.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //((QuanLySanPham)c).xoaSP(ds.get(i).getName());
//                        //((QuanLySanPham)c).capNhatLayout();
//                        dialogXoa.dismiss();
//                    }
//                });
//
//            }
//        });
//
//        holder.tvChinhSua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //tạo dialog
//                Dialog dialogChinhSua = new Dialog((Activity)c);
//                dialogChinhSua.setContentView(R.layout.a2_asm_dialog_chinhsua);
//                dialogChinhSua.show();
//
//                //ánh xạ thông tin NV
//                Button btnChinhSua = dialogChinhSua.findViewById(R.id.btnChinhSua);
//                TextView tvName = dialogChinhSua.findViewById(R.id.tvName);
//                EditText editGia = dialogChinhSua.findViewById(R.id.editGia);
//                EditText editSL = dialogChinhSua.findViewById(R.id.editSL);
//
//                tvName.setText(ds.get(i).getName());
//
//                btnChinhSua.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        String name = tvName.getText().toString().trim();
//                        int gia = Integer.parseInt(editGia.getText().toString().trim());
//                        int sl = Integer.parseInt(editSL.getText().toString().trim());
//
//                        //((QuanLySanPham)c).chinhSuaSP(new SanPham(name,gia,sl));
//                        //((QuanLySanPham)c).capNhatLayout();
//
//                        dialogChinhSua.dismiss();
//                    }
//                });
//
//
//
//            }
//
//        });


    }

    @Override
    public int getItemCount() {
        return ds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvGia, tvSL, tvChinhSua, tvXoa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvTen);
            tvGia = itemView.findViewById(R.id.tvGia);
            tvSL = itemView.findViewById(R.id.tvSL);
            tvChinhSua = itemView.findViewById(R.id.tvChinhSua);
            tvXoa = itemView.findViewById(R.id.tvXoa);
        }
    }
}
