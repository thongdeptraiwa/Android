package com.example.datvemaybay.ADT;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datvemaybay.MainActivity;
import com.example.datvemaybay.R;


public class ADT_Recyclerview_DiaChi_Den extends RecyclerView.Adapter<ADT_Recyclerview_DiaChi_Den.ViewHolder>{
    private Context c;
    private String[] ds;

    public ADT_Recyclerview_DiaChi_Den(Context c, String[] ds) {
        this.c = c;
        this.ds = ds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //lấy LayoutInflater
        LayoutInflater inf = ((MainActivity)c).getLayoutInflater();
        //ánh xạ view
        View view = inf.inflate(R.layout.item_diachi,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        //hiển thị
        holder.tv.setText(ds[i]);
        holder.tv.setBackgroundColor(Color.GRAY);

        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)c).setDen(ds[i]);
                //đổi màu item đc nhấn
                holder.tv.setBackgroundColor(Color.BLUE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ds.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
