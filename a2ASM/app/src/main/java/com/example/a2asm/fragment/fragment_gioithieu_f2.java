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

import com.example.a2asm.R;

public class fragment_gioithieu_f2 extends Fragment {
    EditText editText;
    Button btnGui;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);
        editText = view.findViewById(R.id.editText);
        btnGui = view.findViewById(R.id.btnGui);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString().trim();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragment_gioithieu_f1 fragmentGioithieuF1 = (fragment_gioithieu_f1) fragmentManager.findFragmentById(R.id.f1);
                fragmentGioithieuF1.tv.setText(data);
                editText.setText("");
            }
        });
        return view;
    }

}
