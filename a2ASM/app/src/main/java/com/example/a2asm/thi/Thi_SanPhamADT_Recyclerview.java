package com.example.a2asm.thi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2asm.R;
import com.example.a2asm.dao.SanPhamDao;
import com.example.a2asm.dao.Thi_Dao;
import com.example.a2asm.model.SanPham;
import com.example.a2asm.model.Thi_model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Thi_SanPhamADT_Recyclerview extends RecyclerView.Adapter<Thi_SanPhamADT_Recyclerview.ViewHolder>{
    private Context c;
    private ArrayList<Thi_model> ds = new ArrayList<Thi_model>();
    private Thi_Dao sanPhamDao;

    public Thi_SanPhamADT_Recyclerview(Context c, ArrayList<Thi_model> ds, Thi_Dao sanPhamDao) {
        this.c = c;
        this.ds = ds;
        this.sanPhamDao = sanPhamDao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //lấy LayoutInflater
        LayoutInflater inf = ((Activity)c).getLayoutInflater();
        //ánh xạ view
        View view = inf.inflate(R.layout.thi_item_sanpham,parent,false);
        //animation
        //Animation anim = AnimationUtils.loadAnimation((Activity)c,R.anim.anim_list);
        //view.startAnimation(anim);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
//        //hiển thị
        holder.tvName.setText(ds.get(i).getName());

//        //img
        if(ds.get(i).getMa()==1){
            holder.img.setImageResource(R.drawable.food1);
        }else{
            holder.img.setImageResource(R.drawable.food2);
        }


            //thêm , trong giá
            NumberFormat formatter = new DecimalFormat("#,###");
            int myNumber = ds.get(i).getGia();
            String formattedNumber = formatter.format(myNumber);
            holder.tvGia.setText(formattedNumber +" VND ");
        //holder.tvSL.setText("- SL: "+ds.get(i).getSl());

        holder.imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //tạo dialog
                Dialog dialogXoa = new Dialog((Activity)c);
                dialogXoa.setContentView(R.layout.a2_asm_dialog_xoa);
                dialogXoa.show();

                //ánh xạ
                TextView tvThongBao = dialogXoa.findViewById(R.id.tvThongBao);
                TextView tvKhong = dialogXoa.findViewById(R.id.tvKhong);
                TextView tvDongY = dialogXoa.findViewById(R.id.tvDongY);

                tvThongBao.setText("Bạn có chắc chắn muốn xóa '"+ds.get(i).getName()+"' không?");

                tvKhong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogXoa.dismiss();
                    }
                });
                tvDongY.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanPhamDao.xoaSP(ds.get(i).getName());
                        ds.clear();
                        ds = sanPhamDao.xemSP();
                        notifyDataSetChanged();
                        dialogXoa.dismiss();
                    }
                });

            }
        });

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
//                        sanPhamDao.suaSP(new SanPham(name,gia,sl));
//                        ds.clear();
//                        ds = sanPhamDao.xemSP();
//                        notifyDataSetChanged();
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
        TextView tvName, tvGia, tvChinhSua;
        ImageView img,imgXoa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvTen);
            tvGia = itemView.findViewById(R.id.tvGia);
            //tvSL = itemView.findViewById(R.id.tvSL);
            tvChinhSua = itemView.findViewById(R.id.tvChinhSua);
            imgXoa = itemView.findViewById(R.id.imgXoa);
            img = itemView.findViewById(R.id.img);
        }
    }
}
