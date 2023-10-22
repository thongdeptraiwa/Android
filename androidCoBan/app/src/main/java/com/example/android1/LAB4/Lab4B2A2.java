package com.example.android1.LAB4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android1.R;

public class Lab4B2A2 extends AppCompatActivity {

    Button btnBaoGia;
    TextView tvTenSP;

    EditText editGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab4b2a2);

        btnBaoGia=findViewById(R.id.btnBaoGia);
        tvTenSP=findViewById(R.id.txtTenSP);
        editGia=findViewById(R.id.editGia);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("dulieu");
        tvTenSP.setText(bundle.getString("tenSP"));


        btnBaoGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dkGIa = "\\d{4,10}";
                String gia = editGia.getText().toString().trim();
//                int intGia;
//                try {
//                    intGia = Integer.parseInt(gia);
//                }catch (Exception ex){
//                    intGia = 0;
//                }
                if(gia.equals("")){
                    Toast.makeText(Lab4B2A2.this, "Bạn chưa nhập giá!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!gia.matches(dkGIa)){
                    Toast.makeText(Lab4B2A2.this, "Nhập sai!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("gia",gia);
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}