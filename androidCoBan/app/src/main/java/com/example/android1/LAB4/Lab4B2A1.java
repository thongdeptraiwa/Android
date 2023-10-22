package com.example.android1.LAB4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android1.R;

public class Lab4B2A1 extends AppCompatActivity {

    Button btnGui;

    EditText editTenSP;
    TextView tvGia;


    int REQUEST_CODE_EDIT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab4b2a1);

        btnGui=findViewById(R.id.btnGui);
        editTenSP=findViewById(R.id.editTenSP);
        tvGia=findViewById(R.id.txtGia);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ktTenSP = editTenSP.getText().toString().trim();
                if(ktTenSP.equals("")){
                    Toast.makeText(Lab4B2A1.this, "Bạn chưa nhập tên SP!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(Lab4B2A1.this,Lab4B2A2.class);
                Bundle bundle = new Bundle();
                bundle.putString("tenSP",editTenSP.getText().toString());
                intent.putExtra("dulieu",bundle);
                //startActivity(intent);
                startActivityForResult(intent,REQUEST_CODE_EDIT);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null){
            Bundle bundle = data.getExtras();
            String gia = bundle.getString("gia");
            tvGia.setText(gia);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}