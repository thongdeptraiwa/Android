package com.example.datvemaybay.ADT;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datvemaybay.MainActivity;
import com.example.datvemaybay.R;
import com.example.datvemaybay.model.HoaDon;

import java.util.ArrayList;


public class ADT_Recyclerview_DanhSachVe extends RecyclerView.Adapter<ADT_Recyclerview_DanhSachVe.ViewHolder>{
    private Context c;
    private ArrayList<HoaDon> ds = new ArrayList<HoaDon>();

    public ADT_Recyclerview_DanhSachVe(Context c, ArrayList<HoaDon> ds) {
        this.c = c;
        this.ds = ds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //lấy LayoutInflater
        LayoutInflater inf = ((MainActivity)c).getLayoutInflater();
        //ánh xạ view
        View view = inf.inflate(R.layout.item_hoadon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        //hiển thị
        holder.tvKhoiHanh.setText(ds.get(i).getKhoiHanh());
        holder.tvKetThuc.setText(ds.get(i).getKetThuc());
        holder.tvTu.setText(ds.get(i).getTu());
        holder.tvDen.setText(ds.get(i).getDen());
        holder.tvGia.setText(ds.get(i).getGia());

    }

    @Override
    public int getItemCount() {
        return ds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvKhoiHanh,tvKetThuc,tvTu,tvDen,tvGia;
        Button btnXemChiTiet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKhoiHanh = itemView.findViewById(R.id.tvKhoiHanh);
            tvKetThuc = itemView.findViewById(R.id.tvKetThuc);
            tvTu = itemView.findViewById(R.id.tvTu);
            tvDen = itemView.findViewById(R.id.tvDen);
            tvGia = itemView.findViewById(R.id.tvGia);
            btnXemChiTiet = itemView.findViewById(R.id.btnXemChiTiet);

        }
    }
}
