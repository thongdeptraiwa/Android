package com.example.android1.BAI3LA;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import com.example.android1.R;

import java.sql.Array;
import java.util.List;
import java.util.Random;

public class Bai3la extends AppCompatActivity {

    ImageView ng1;
    ImageView ng2;
    ImageView ng3;
    ImageView may1;
    ImageView may2;
    ImageView may3;
    Button btnMoBai;
    Button btnXetBai;
    TextView txtNutMay;
    TextView txtNutNg;
    TextView txtKQ;



    int baCaoMay = 0;
    int baCaoNg = 0;
    int diemNg1 = 0;
    int diemNg2 = 0;
    int diemNg3 = 0;
    int diemMay1 = 0;
    int diemMay2 = 0;
    int diemMay3 = 0;
    int btn1=0;
    int btn2=0;
    int[] arrNut = {11,12,13,14,
            21,22,23,24,
            31,32,33,34,
            41,42,43,44,
            51,52,53,54,
            61,62,63,64,
            71,72,73,74,
            81,82,83,84,
            91,92,93,94,
            101,102,103,104,
            111,112,113,114,
            121,122,123,124,
            131,132,133,134};
    int[] arrImg = {R.drawable.l11,R.drawable.l12,R.drawable.l13,R.drawable.l14,
            R.drawable.l21,R.drawable.l22,R.drawable.l23,R.drawable.l24,
            R.drawable.l31,R.drawable.l32,R.drawable.l33,R.drawable.l34,
            R.drawable.l41,R.drawable.l42,R.drawable.l43,R.drawable.l44,
            R.drawable.l51,R.drawable.l52,R.drawable.l53,R.drawable.l54,
            R.drawable.l61,R.drawable.l62,R.drawable.l63,R.drawable.l64,
            R.drawable.l71,R.drawable.l72,R.drawable.l73,R.drawable.l74,
            R.drawable.l81,R.drawable.l82,R.drawable.l83,R.drawable.l84,
            R.drawable.l91,R.drawable.l92,R.drawable.l93,R.drawable.l94,
            R.drawable.l101,R.drawable.l102,R.drawable.l103,R.drawable.l104,
            R.drawable.l111,R.drawable.l112,R.drawable.l113,R.drawable.l114,
            R.drawable.l121,R.drawable.l122,R.drawable.l123,R.drawable.l124,
            R.drawable.l131,R.drawable.l132,R.drawable.l133,R.drawable.l134};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai3la);

        ng1=findViewById(R.id.ng1);
        ng2=findViewById(R.id.ng2);
        ng3=findViewById(R.id.ng3);
        may1=findViewById(R.id.may1);
        may2=findViewById(R.id.may2);
        may3=findViewById(R.id.may3);

        txtNutMay=findViewById(R.id.txtNutMay);
        txtNutNg=findViewById(R.id.txtNutNg);
        txtKQ=findViewById(R.id.txtKQ);

        btnMoBai=findViewById(R.id.btnMoBai);
        btnXetBai=findViewById(R.id.btnXetBai);



//        ng1.setImageResource(R.drawable.l12);

        btnMoBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(btn1<3){
                    btn1++;
                }

                if(btn1==1){
                    xaoBai();
                    ng1.setImageResource(arrImg[0]);
                }
                if(btn1==2){
                    ng2.setImageResource(arrImg[1]);
                }
                if(btn1==3){
                    ng3.setImageResource(arrImg[2]);
                    //bt2.titleLabel!.text = "Xếp bài"
                }


            }
        });
        btnXetBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnXetBai.setText("Xét Bài");
                if(btn2<2&& btn1==3){
                    btn2++;
                }

                if(btn2==1 && btn1==3){

                    may1.setImageResource(arrImg[3]);
                    may2.setImageResource(arrImg[4]);
                    may3.setImageResource(arrImg[5]);
                    int tongNg = tong(doi(arrNut[0],baCaoNg),doi(arrNut[1],baCaoNg),doi(arrNut[2],baCaoNg));
                    int tongMay = tong(doi(arrNut[3],baCaoMay),doi(arrNut[4],baCaoMay),doi(arrNut[5],baCaoMay));

                    if(baCaoNg == 3 || baCaoMay==3 )
                    {
                        if(baCaoNg == 3 && baCaoMay==3 ){

                            txtNutMay.setText("⭐️Ba Cao⭐️");
                            txtNutNg.setText("⭐️Ba Cao⭐️");
                            txtKQ.setText("Hòa");

                        }
                        else {
                            if(baCaoNg == 3)
                            {
                                txtNutMay.setText(tongMay+"Nút");
                                txtNutNg.setText("⭐️Ba Cao⭐️");
                                txtKQ.setText("😃Thắng😃");

                            }
                            else{

                                txtNutMay.setText("⭐️Ba Cao⭐️");
                                txtNutNg.setText(tongNg+"Nút");
                                txtKQ.setText("☹️Thua☹️");

                            }
                        }

                    }
                    else{
                        if(tongNg < tongMay){

                            txtNutMay.setText(tongMay+"Nút");
                            txtNutNg.setText(tongNg+"Nút");
                            txtKQ.setText("☹️Thua☹️");

                        }
                        if(tongNg > tongMay){

                            txtNutMay.setText(tongMay+"Nút");
                            txtNutNg.setText(tongNg+"Nút");
                            txtKQ.setText("😃Thắng😃");

                        }
                        if(tongNg == tongMay){

                            txtNutMay.setText(tongMay+"Nút");
                            txtNutNg.setText(tongNg+"Nút");
                            txtKQ.setText("Hòa");

                        }
                    }
                    baCaoMay=0;
                    baCaoNg=0;
                    btnXetBai.setText("Chơi Tiếp");
                }
                if(btn2==2 && btn1==3){
                    may1.setImageResource(R.drawable.lung);
                    may2.setImageResource(R.drawable.lung);
                    may3.setImageResource(R.drawable.lung);
                    ng1.setImageResource(R.drawable.lung);
                    ng2.setImageResource(R.drawable.lung);
                    ng3.setImageResource(R.drawable.lung);
                    txtNutMay.setText("");
                    txtNutNg.setText("");
                    txtKQ.setText("Bài Cào");
                    xaoBai();
                    btn1=0;
                    btn2=0;

                }

            }
        });
    }

    public  void xaoBai(){

        Random rd = new Random();

        for (int i = 0; i < arrNut.length; i++) {

            int Index = rd.nextInt(arrNut.length);

            int tempNut = arrNut[Index];
            arrNut[Index] = arrNut[i];
            arrNut[i] = tempNut;

            int tempImg = arrImg[Index];
            arrImg[Index] = arrImg[i];
            arrImg[i] = tempImg;

        }
    }
    public int doi(int diemGoc,int baCao) {

        int diem = diemGoc / 10;
        if( diem == 11 || diem==12 || diem==13 ){
            diem = 10;
            baCao++;
        }
        return diem;

    }


    public int tong(int a , int b , int c){
        int tong = (a+b+c)%10;
        return tong;
    }

}