package com.example.android1.LAB2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android1.R;

public class Lab2 extends AppCompatActivity {
    //b1
    Button B1btn;
    TextView B1name;
    RadioButton B1rdCaoDang;
    RadioButton B1rdPhoThong;
    CheckBox B1cbJava;
    CheckBox B1cbCcc;
    CheckBox B1cbJS;
    TextView B1SaveName;
    TextView B1SaveHeHoc;
    TextView B1SaveNgonNgu;

    //b2
    Button B2btn;
    TextView B2Name;
    TextView B2MSSV;
    TextView B2Old;
    RadioButton B2rdNam;
    RadioButton B2rdNu;
    CheckBox B2cbBongDa;
    CheckBox B2cbChoiGame;
    TextView B2KQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab2);
        //b1
        B1btn = findViewById(R.id.B1btn);

        B1name = findViewById(R.id.B1name);

        B1rdCaoDang = findViewById(R.id.B1rdCaoDang);
        B1rdPhoThong = findViewById(R.id.B1rdPhoThong);

        B1cbJava = findViewById(R.id.B1cbJava);
        B1cbCcc = findViewById(R.id.B1cbCcc);
        B1cbJS = findViewById(R.id.B1cbJS);

        B1SaveName = findViewById(R.id.B1SaveName);
        B1SaveHeHoc = findViewById(R.id.B1SaveHeHoc);
        B1SaveNgonNgu = findViewById(R.id.B1SaveNgonNgu);


        B1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //name
                String DKname = "[a-z,A-Z ]{5,32}";
                String name = B1name.getText().toString().trim();
                if(name.equals("")){
                    name="Chưa nhập tên!";
                    B1name.setBackgroundColor(Color.YELLOW);
                    B1SaveName.setTextColor(Color.RED);
                }
                if(!name.contains(" ") || !name.matches(DKname)){
                    name="Nhập sai định dạng!";
                    B1name.setTextColor(Color.RED);
                    B1SaveName.setTextColor(Color.RED);
                }
                //he hoc
                String heHoc = B1rdCaoDang.isChecked()
                        ? "Cao Đẳng"
                        : B1rdPhoThong.isChecked()
                        ? "Phổ Thông"
                        : "Chưa chọn hệ học!";
                if(heHoc.equals("Chưa chọn hệ học!")){
                    B1rdCaoDang.setTextColor(Color.RED);
                    B1rdPhoThong.setTextColor(Color.RED);
                    B1SaveHeHoc.setTextColor(Color.RED);
                }

                //ngon ngu
                String ngonNgu = B1cbJava.isChecked() && B1cbCcc.isChecked() && B1cbJS.isChecked()
                        ? "Java , C++ , JS"
                        : B1cbJava.isChecked() && B1cbCcc.isChecked()
                        ? "Java , C++"
                        : B1cbJava.isChecked() && B1cbJS.isChecked()
                        ? "Java , JS"
                        : B1cbCcc.isChecked() && B1cbJS.isChecked()
                        ? "C++ , JS"
                        :  B1cbJava.isChecked()
                        ? "Java"
                        : B1cbCcc.isChecked()
                        ? "C++"
                        : B1cbJS.isChecked()
                        ? "JS"
                        : "Chưa chọn ngôn ngữ!";
                if(ngonNgu.equals("Chưa chọn ngôn ngữ!")){
                    B1cbJava.setTextColor(Color.RED);
                    B1cbCcc.setTextColor(Color.RED);
                    B1cbJS.setTextColor(Color.RED);
                    B1SaveNgonNgu.setTextColor(Color.RED);
                }

                //xuat ra
                B1SaveName.setText("Tên : "+name);
                B1SaveHeHoc.setText("Hệ hoc : "+heHoc);
                B1SaveNgonNgu.setText("Ngôn ngữ : "+ngonNgu);

                //trang
                if(!name.equals("Chưa nhập tên!") && !name.equals("Nhập sai định dạng!")){
                    B1name.setBackgroundColor(Color.WHITE);
                    B1name.setTextColor(Color.BLACK);
                    B1SaveName.setTextColor(Color.BLUE);
                }
                if(!heHoc.equals("Chưa chọn hệ học!")){
                    B1rdCaoDang.setTextColor(Color.BLACK);
                    B1rdPhoThong.setTextColor(Color.BLACK);
                    B1SaveHeHoc.setTextColor(Color.BLUE);
                }
                if(!ngonNgu.equals("Chưa chọn ngôn ngữ!")){
                    B1cbJava.setTextColor(Color.BLACK);
                    B1cbCcc.setTextColor(Color.BLACK);
                    B1cbJS.setTextColor(Color.BLACK);
                    B1SaveNgonNgu.setTextColor(Color.BLUE);
                }

                // Loi
                //name
                if(name.equals("Chưa nhập tên!")){
                    Toast.makeText(Lab2.this, "Chưa nhập tên!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(name.equals("Nhập sai định dạng!")){
                    Toast.makeText(Lab2.this, "Nhập sai định dạng!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(heHoc.equals("Chưa chọn hệ học!")){
                    Toast.makeText(Lab2.this, "Chưa chọn hệ học!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(ngonNgu.equals("Chưa chọn ngôn ngữ!")){
                    Toast.makeText(Lab2.this, "Chưa chọn ngôn ngữ!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(Lab2.this, "Lưu Thành Công", Toast.LENGTH_SHORT).show();
            }

        });


        //b2
        B2btn = findViewById(R.id.B2btnLuu);

        B2Name = findViewById(R.id.B2Name);
        B2MSSV = findViewById(R.id.B2MSSV);
        B2Old = findViewById(R.id.B2Old);

        B2rdNam = findViewById(R.id.B2rdNam);
        B2rdNu = findViewById(R.id.B2rdNu);

        B2cbBongDa = findViewById(R.id.B2cbBongDa);
        B2cbChoiGame = findViewById(R.id.B2cbChoiGame);

        B2KQ = findViewById(R.id.B2KQ);

        B2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //name
                String DKname = "[a-z,A-Z ]{5,32}";
                String name = B2Name.getText().toString().trim();
                if(name.equals("")){
                    //name="Chưa nhập tên!";
                    B2Name.setBackgroundColor(Color.YELLOW);
                    Toast.makeText(Lab2.this, "Chưa nhập tên!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!name.contains(" ") || !name.matches(DKname)){
                    //name="Nhập sai định dạng!";
                    B2Name.setTextColor(Color.RED);
                    Toast.makeText(Lab2.this, "Nhập sai định dạng tên!", Toast.LENGTH_SHORT).show();
                    return;
                }
                B2Name.setBackgroundColor(Color.WHITE);
                B2Name.setTextColor(Color.BLACK);

                //mssv
                String mssv = B2MSSV.getText().toString().trim();
                if(mssv.equals("")){
                    //mssv="Chưa nhập MSSV!";
                    B2MSSV.setBackgroundColor(Color.YELLOW);
                    Toast.makeText(Lab2.this, "Chưa nhập MSSV!", Toast.LENGTH_SHORT).show();
                    return;
                }
                B2MSSV.setBackgroundColor(Color.WHITE);

                //old
                String DKold = "\\d{2}";
                String old = B2Old.getText().toString().trim();
                if(old.equals("")){
                    //old="Chưa nhập tuổi!";
                    B2Old.setBackgroundColor(Color.YELLOW);
                    Toast.makeText(Lab2.this, "Chưa nhập tuổi!", Toast.LENGTH_SHORT).show();
                    return;
                }
                //ép kiểu phải try để ko lỗi
                int tuoi;
                try {
                    tuoi = Integer.parseInt(old);
                }catch (Exception ex){
                    tuoi = 0;
                }
                if(!old.matches(DKold) || tuoi < 18 || tuoi > 65){
                    //old="Nhập sai định dạng!";
                    B2Old.setTextColor(Color.RED);
                    Toast.makeText(Lab2.this, "Nhập sai định dạng tuổi!", Toast.LENGTH_SHORT).show();
                    return;
                }
                B2Old.setBackgroundColor(Color.WHITE);
                B2Old.setTextColor(Color.BLACK);

                //gioi tinh
                String gioiTinh = B2rdNam.isChecked()
                        ? "Nam"
                        : B2rdNu.isChecked()
                        ? "Nữ"
                        : "null";
                if(gioiTinh.equals("null")){
                    B2rdNam.setTextColor(Color.RED);
                    B2rdNu.setTextColor(Color.RED);
                    Toast.makeText(Lab2.this, "Chưa chọn giới tính!", Toast.LENGTH_SHORT).show();
                    return;
                }
                B2rdNam.setTextColor(Color.BLACK);
                B2rdNu.setTextColor(Color.BLACK);

                //so thich
                String soThich = B2cbBongDa.isChecked() && B2cbChoiGame.isChecked()
                        ? "Bóng Đá và Chơi Game"
                        : B2cbBongDa.isChecked()
                        ? "Bóng Đá"
                        : B2cbChoiGame.isChecked()
                        ? "Chơi Game"
                        : "null";
                if(soThich.equals("null")){
                    B2cbBongDa.setTextColor(Color.RED);
                    B2cbChoiGame.setTextColor(Color.RED);
                    Toast.makeText(Lab2.this, "Chưa chọn sở thích!", Toast.LENGTH_SHORT).show();
                    return;
                }
                B2cbBongDa.setTextColor(Color.BLACK);
                B2cbChoiGame.setTextColor(Color.BLACK);

                //kq
                Toast.makeText(Lab2.this, "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                B2KQ.setText("Tên: "+name+"\nMSSV: "+mssv+"\nTuổi: "+old+"\nGiới Tính: "+gioiTinh+"\nSở Thích: "+soThich);
            }
        });
    }
}