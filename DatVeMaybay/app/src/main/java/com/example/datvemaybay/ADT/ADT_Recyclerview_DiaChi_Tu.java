package com.example.datvemaybay.ADT;

import static android.app.PendingIntent.getActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datvemaybay.MainActivity;
import com.example.datvemaybay.R;
import com.example.datvemaybay.fragment.fragment_datve;


public class ADT_Recyclerview_DiaChi_Tu extends RecyclerView.Adapter<ADT_Recyclerview_DiaChi_Tu.ViewHolder>{
    private Context c;
    private String[] ds;

    public ADT_Recyclerview_DiaChi_Tu(Context c, String[] ds) {
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
                ((MainActivity)c).setTu(ds[i]);
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
