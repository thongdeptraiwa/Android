package com.example.android1.A2Lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android1.A2ASM.QuanLySanPham;
import com.example.android1.A2ASM.SanPhamADT_Recyclerview;
import com.example.android1.A2ASM.model.SanPham;
import com.example.android1.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class A2_Lab2_SanPhamADT_Recylerview extends RecyclerView.Adapter<A2_Lab2_SanPhamADT_Recylerview.ViewHolder>{
    private Context c;
    private ArrayList<SanPham> ds = new ArrayList<SanPham>();

    public A2_Lab2_SanPhamADT_Recylerview(Context c, ArrayList<SanPham> ds) {
        this.c = c;
        this.ds = ds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //lấy LayoutInflater
        LayoutInflater inf = ((A2_Lab2_recyclerview)c).getLayoutInflater();
        //ánh xạ view
        View view = inf.inflate(R.layout.a2_asm_item_sanpham,parent,false);
        return new A2_Lab2_SanPhamADT_Recylerview.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        //hiển thị
        holder.tvName.setText(ds.get(i).getName());
        //thêm , trong giá
        NumberFormat formatter = new DecimalFormat("#,###");
        int myNumber = ds.get(i).getGia();
        String formattedNumber = formatter.format(myNumber);
        holder.tvGia.setText(formattedNumber +" VND ");
        holder.tvSL.setText("- SL: "+ds.get(i).getSl());
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
