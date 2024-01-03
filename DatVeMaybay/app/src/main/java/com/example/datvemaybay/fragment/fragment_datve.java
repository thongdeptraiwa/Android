package com.example.datvemaybay.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datvemaybay.ADT.ADT_Recyclerview_DiaChi_Den;
import com.example.datvemaybay.ADT.ADT_Recyclerview_DiaChi_Tu;
import com.example.datvemaybay.MainActivity;
import com.example.datvemaybay.R;
import com.example.datvemaybay.SignUp;


public class fragment_datve extends Fragment {

    MainActivity mainActivity;
    Context c;
    Button btnHuy,btnThanhToan,btnTu,btnDen,btnKhoiHanh,btnKetThuc,btnGhe,btnChieu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datve,container,false);
        c = getActivity();
        //ánh xạ
        mainActivity = (MainActivity) getActivity();
        btnHuy=view.findViewById(R.id.btnHuy);
        btnThanhToan=view.findViewById(R.id.btnThanhToan);
        btnTu=view.findViewById(R.id.btnTu);
        btnDen=view.findViewById(R.id.btnDen);
        btnKhoiHanh=view.findViewById(R.id.btnKhoiHanh);
        btnKetThuc=view.findViewById(R.id.btnKetThuc);
        btnGhe=view.findViewById(R.id.btnGhe);
        btnChieu=view.findViewById(R.id.btnChieu);

        //lấy data từ MainActivity
        btnTu.setText("Từ\n"+mainActivity.getTu());
        btnDen.setText("Đến\n"+mainActivity.getDen());
        btnKhoiHanh.setText("Khởi hành\n"+mainActivity.getKhoiHanh());
        btnKetThuc.setText("Kết thúc\n"+mainActivity.getKetThuc());
        btnGhe.setText("Ghế\n"+mainActivity.getGhe());
        btnChieu.setText("Chiều\n"+mainActivity.getChieu());

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.truyenFragmentTrangChu();
            }
        });
        btnTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo dialog
                Dialog dialog = new Dialog(c);
                dialog.setContentView(R.layout.dialog_diachi);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                //ánh xạ
                TextView tvTitle = dialog.findViewById(R.id.tvTitle);
                ImageView imgThoat = dialog.findViewById(R.id.imgThoat);
                Button btnOK = dialog.findViewById(R.id.btnOK);
                RecyclerView recyclerView = dialog.findViewById(R.id.recyclerView);

                //data
                String[] ds = {"TP.HCM","TP.Hà Nội","TP.Đà Nẵng","TP.Huế","Vũng Tàu","Đà Lạc","Sa Pa","Quy Nhơ","Cà Mau","Phú Quốc"};

                ADT_Recyclerview_DiaChi_Tu adapterDiaChi = new ADT_Recyclerview_DiaChi_Tu(c,ds);

                //recycleview
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(c);
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapterDiaChi);

                tvTitle.setText("Từ");

                imgThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        btnDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo dialog
                Dialog dialog = new Dialog(c);
                dialog.setContentView(R.layout.dialog_diachi);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                //ánh xạ
                TextView tvTitle = dialog.findViewById(R.id.tvTitle);
                ImageView imgThoat = dialog.findViewById(R.id.imgThoat);
                Button btnOK = dialog.findViewById(R.id.btnOK);
                RecyclerView recyclerView = dialog.findViewById(R.id.recyclerView);

                //data
                String[] ds = {"TP.HCM","TP.Hà Nội","TP.Đà Nẵng","TP.Huế","Vũng Tàu","Đà Lạc","Sa Pa","Quy Nhơ","Cà Mau","Phú Quốc"};

                ADT_Recyclerview_DiaChi_Den adapterDiaChi = new ADT_Recyclerview_DiaChi_Den(c,ds);

                //recycleview
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(c);
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapterDiaChi);

                tvTitle.setText("Đến");

                imgThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        btnKhoiHanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo dialog
                Dialog dialog = new Dialog(c);
                dialog.setContentView(R.layout.dialog_thoigian);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                //ánh xạ
                TextView tvTitle = dialog.findViewById(R.id.tvTitle);
                ImageView imgThoat = dialog.findViewById(R.id.imgThoat);
                Button btnOK = dialog.findViewById(R.id.btnOK);
                EditText editThoiGian = dialog.findViewById(R.id.editThoiGian);

                tvTitle.setText("Khởi Hành");

                imgThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String thoiGian = editThoiGian.getText().toString().trim();
                        mainActivity.setKhoiHanh(thoiGian);
                        dialog.dismiss();
                    }
                });
            }
        });
        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo dialog
                Dialog dialog = new Dialog(c);
                dialog.setContentView(R.layout.dialog_thoigian);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                //ánh xạ
                TextView tvTitle = dialog.findViewById(R.id.tvTitle);
                ImageView imgThoat = dialog.findViewById(R.id.imgThoat);
                Button btnOK = dialog.findViewById(R.id.btnOK);
                EditText editThoiGian = dialog.findViewById(R.id.editThoiGian);

                tvTitle.setText("Kết thúc");

                imgThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String thoiGian = editThoiGian.getText().toString().trim();
                        mainActivity.setKetThuc(thoiGian);
                        dialog.dismiss();
                    }
                });
            }
        });
        btnGhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo dialog
                Dialog dialog = new Dialog(c);
                dialog.setContentView(R.layout.dialog_ghe);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                //ánh xạ
                TextView tvTitle = dialog.findViewById(R.id.tvTitle);
                ImageView imgThoat = dialog.findViewById(R.id.imgThoat);
                //1
                Button btn1A = dialog.findViewById(R.id.btn1A);
                Button btn1B = dialog.findViewById(R.id.btn1B);
                Button btn1C = dialog.findViewById(R.id.btn1C);
                Button btn1D = dialog.findViewById(R.id.btn1D);
                //2
                Button btn2A = dialog.findViewById(R.id.btn2A);
                Button btn2B = dialog.findViewById(R.id.btn2B);
                Button btn2C = dialog.findViewById(R.id.btn2C);
                Button btn2D = dialog.findViewById(R.id.btn2D);
                //3
                Button btn3A = dialog.findViewById(R.id.btn3A);
                Button btn3B = dialog.findViewById(R.id.btn3B);
                Button btn3C = dialog.findViewById(R.id.btn3C);
                Button btn3D = dialog.findViewById(R.id.btn3D);
                //4
                Button btn4A = dialog.findViewById(R.id.btn4A);
                Button btn4B = dialog.findViewById(R.id.btn4B);
                Button btn4C = dialog.findViewById(R.id.btn4C);
                Button btn4D = dialog.findViewById(R.id.btn4D);


                tvTitle.setText("Chọn chỗ ngồi");

                imgThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                //1
                btn1A.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("1A");
                        dialog.dismiss();
                    }
                });
                btn1B.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("1B");
                        dialog.dismiss();
                    }
                });
                btn1C.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("1C");
                        dialog.dismiss();
                    }
                });
                btn1D.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("1D");
                        dialog.dismiss();
                    }
                });
                //2
                btn2A.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("2A");
                        dialog.dismiss();
                    }
                });
                btn2B.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("2B");
                        dialog.dismiss();
                    }
                });
                btn2C.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("2C");
                        dialog.dismiss();
                    }
                });
                btn2D.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("2D");
                        dialog.dismiss();
                    }
                });
                //3
                btn3A.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("3A");
                        dialog.dismiss();
                    }
                });
                btn3B.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("3B");
                        dialog.dismiss();
                    }
                });
                btn3C.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("3C");
                        dialog.dismiss();
                    }
                });
                btn3D.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("3D");
                        dialog.dismiss();
                    }
                });
                //4
                btn1A.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("1A");
                        dialog.dismiss();
                    }
                });
                btn1B.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("1B");
                        dialog.dismiss();
                    }
                });
                btn1C.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("1C");
                        dialog.dismiss();
                    }
                });
                btn1D.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setGhe("1D");
                        dialog.dismiss();
                    }
                });

            }
        });
        btnChieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo dialog
                Dialog dialog = new Dialog(c);
                dialog.setContentView(R.layout.dialog_chieu);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                //ánh xạ
                TextView tvTitle = dialog.findViewById(R.id.tvTitle);
                ImageView imgThoat = dialog.findViewById(R.id.imgThoat);
                Button btn1Chieu = dialog.findViewById(R.id.btn1Chieu);
                Button btn2Chieu = dialog.findViewById(R.id.btn2Chieu);

                tvTitle.setText("Chiều");

                imgThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btn1Chieu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setChieu("1 chiều");
                        dialog.dismiss();
                    }
                });
                btn2Chieu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainActivity.setChieu("2 chiều");
                        dialog.dismiss();
                    }
                });
            }
        });
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check
                if(mainActivity.getTu().equals("....")){
                    Toast.makeText(c ,"Chưa chọn từ ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mainActivity.getDen().equals("....")){
                    Toast.makeText(c ,"Chưa chọn đến ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mainActivity.getKhoiHanh().equals("....")){
                    Toast.makeText(c ,"Chưa chọn khởi hành ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mainActivity.getKetThuc().equals("....")){
                    Toast.makeText(c ,"Chưa chọn kết thúc ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mainActivity.getGhe().equals("....")){
                    Toast.makeText(c ,"Chưa chọn ghế ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mainActivity.getChieu().equals("....")){
                    Toast.makeText(c ,"Chưa chọn chiều ", Toast.LENGTH_SHORT).show();
                    return;
                }

                mainActivity.truyenFragmentHoaDon();
            }
        });

        return view;
    }

}
