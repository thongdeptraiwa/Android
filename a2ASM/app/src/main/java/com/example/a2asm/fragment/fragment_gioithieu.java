package com.example.a2asm.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.a2asm.R;


public class fragment_gioithieu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.a2_asm_fragment_gioithieu,container,false);

        // Nhúng fragment con vào
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        fragment_gioithieu_f1 childFragment1 = new fragment_gioithieu_f1();
        transaction.replace(R.id.f1, childFragment1);
        fragment_gioithieu_f2 childFragment2 = new fragment_gioithieu_f2();
        transaction.replace(R.id.f2, childFragment2);

        transaction.commit();

        return view;
    }
}
