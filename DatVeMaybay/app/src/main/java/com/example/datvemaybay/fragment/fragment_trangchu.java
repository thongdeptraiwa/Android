package com.example.datvemaybay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.datvemaybay.Login;
import com.example.datvemaybay.MainActivity;
import com.example.datvemaybay.R;


public class fragment_trangchu extends Fragment {

    public TextView tvXinChao;

    MainActivity mainActivity;
    Button btnDatVe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trangchu,container,false);
        //ánh xạ
        tvXinChao = view.findViewById(R.id.tvXinChao);
        mainActivity = (MainActivity) getActivity();
        btnDatVe = view.findViewById(R.id.btnDatVe);

        //truyền tên xin chào
        tvXinChao.setText("Xin chào, "+mainActivity.getFullName());

        //
        btnDatVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.truyenFragmentDatVe();
            }
        });

        return view;
    }

}
