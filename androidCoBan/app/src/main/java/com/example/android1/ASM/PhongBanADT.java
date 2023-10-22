package com.example.android1.ASM;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android1.R;

import java.util.ArrayList;

public class PhongBanADT extends BaseAdapter {
    Context c;
    ArrayList<PhongBan> ds=new ArrayList<PhongBan>();

    public PhongBanADT(Context c,ArrayList<PhongBan> ds){
        this.c=c;
        this.ds=ds;
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

        LayoutInflater inf = ((ASMPhongBan)c).getLayoutInflater();

        view = inf.inflate(R.layout.item_asmphongban,null);
        TextView tv = view.findViewById(R.id.tv);
        ImageView iv=view.findViewById(R.id.img);
        tv.setText(ds.get(i).tenPhong);
        iv.setImageResource(ds.get(i).img);

        return view;
    }
}
