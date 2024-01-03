package com.example.datvemaybay.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.datvemaybay.Login;
import com.example.datvemaybay.MainActivity;
import com.example.datvemaybay.R;
import com.example.datvemaybay.SignUp;


public class fragment_taikhoan extends Fragment {

    MainActivity mainActivity;
    TextView tvFullName,tvDangXuat,tvThongTinCaNhan,tvDoiMatKhau;
    Context c;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_taikhoan,container,false);
        c = getActivity();
        //ánh xạ
        mainActivity = (MainActivity) getActivity();
        tvFullName = view.findViewById(R.id.tvFullName);
        tvDangXuat = view.findViewById(R.id.tvDangXuat);
        tvThongTinCaNhan = view.findViewById(R.id.tvThongTinCaNhan);
        tvDoiMatKhau = view.findViewById(R.id.tvDoiMatKhau);

        //lấy data từ MainActivity
        tvFullName.setText(mainActivity.getFullName());

        tvDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.dangXuat();
            }
        });
        tvThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.truyenFragmentThongTinCaNhan();
            }
        });
        tvDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.truyenFragmentDoiMatKhau();
            }
        });


        return view;
    }

}
