package com.example.android1.ASM;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android1.R;

import java.util.ArrayList;

public class NhanVienADT extends BaseAdapter implements Filterable {

    Context c;
    ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
    ArrayList<NhanVien> dsSearch = new ArrayList<NhanVien>();

    public NhanVienADT(Context c,ArrayList<NhanVien> ds){
        this.c = c;
        this.ds = ds;
        this.dsSearch = ds;
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
        //lấy LayoutInflater
        LayoutInflater inf = ((ASMNhanVien)c).getLayoutInflater();

        // ánh xạ view
        view = inf.inflate(R.layout.item_asmnhanvien,null);

        //ánh xạ
        TextView tvMa = view.findViewById(R.id.tvMa);
        TextView tvTen = view.findViewById(R.id.tvTen);
        TextView tvPhong = view.findViewById(R.id.tvPhong);
        ImageView imgSua=view.findViewById(R.id.imgSua);
        ImageView imgXoa=view.findViewById(R.id.imgXoa);

        tvMa.setText(ds.get(i).maNV);
        tvTen.setText(ds.get(i).tenNV);
        tvPhong.setText(ds.get(i).phongNV);

        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //tạo dialog
                Dialog dialogXoa = new Dialog((ASMNhanVien)c);
                dialogXoa.setContentView(R.layout.asm_dialog_xoa);
                dialogXoa.setCanceledOnTouchOutside(false);
                dialogXoa.show();

                //ánh xạ
                Button btnXoa = dialogXoa.findViewById(R.id.btnXoa);
                Button btnHuy = dialogXoa.findViewById(R.id.btnHuy);

                TextView tvMaNV = dialogXoa.findViewById(R.id.tvMaNV);
                TextView tvHoTen = dialogXoa.findViewById(R.id.tvHoTen);
                TextView tvPhongBan = dialogXoa.findViewById(R.id.tvPhongBan);

                tvMaNV.setText(ds.get(i).maNV);
                tvHoTen.setText(ds.get(i).tenNV);
                tvPhongBan.setText(ds.get(i).phongNV);

                btnXoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //gọi phương thức của ASMNhanVien
                        ((ASMNhanVien)c).XoaNV(i,0);

                        dialogXoa.dismiss();
                    }
                });

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogXoa.cancel();
                    }
                });
            }
        });

        imgSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tạo dialog
                Dialog dialogSua = new Dialog((ASMNhanVien)c);
                dialogSua.setContentView(R.layout.asm_dialog_sua);
                dialogSua.setCanceledOnTouchOutside(false);
                dialogSua.show();

                //ánh xạ thông tin NV
                Button btnSua = dialogSua.findViewById(R.id.btnSua);
                Button btnHuy = dialogSua.findViewById(R.id.btnHuy);

                TextView tvMaNV = dialogSua.findViewById(R.id.tvMaNV);
                TextView tvHoTen = dialogSua.findViewById(R.id.tvHoTen);
                TextView tvPhongBan = dialogSua.findViewById(R.id.tvPhongBan);

                tvMaNV.setText(ds.get(i).maNV);
                tvHoTen.setText(ds.get(i).tenNV);
                tvPhongBan.setText(ds.get(i).phongNV);


                btnSua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //ánh xạ edit
                        EditText editMaNV = dialogSua.findViewById(R.id.editMaNV);
                        EditText editTenNV = dialogSua.findViewById(R.id.editTenNV);
                        EditText editPhongBan = dialogSua.findViewById(R.id.editPhongBan);

                        String maNV=editMaNV.getText().toString().trim();
                        String hoTen=editTenNV.getText().toString().trim();
                        String phong=editPhongBan.getText().toString().trim();

                        //rỗng
                        if(maNV.equals("")){
                            Toast.makeText((ASMNhanVien)c, "Bạn chưa nhập Mã NV!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(hoTen.equals("")){
                            Toast.makeText((ASMNhanVien)c, "Bạn chưa nhập Họ Tên!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(phong.equals("")){
                            Toast.makeText((ASMNhanVien)c, "Bạn chưa nhập Phòng Ban!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // điều kiện định dạng
                        String dkMaNV = "[NV]+\\d{3}";
                        String dkHoTen = "([A-Z AĂÂEÊIOÔƠUƯÁẮẤÉẾÍÓỐỚÚỨÝÀẰẦÈỀÌÒỒỜÙỪỲẢẲẨẺỂỈỎỔỞỦỬỶÃẴẪẼỄỈÕỖỠŨỮỸẠẶẬẸỆỊỌỘỢỤỰỴĐ]" +
                                "+[a-zaăâeêioôơuưyáắấéếíóốớúứýàằầèềìòồờùừỳảẳẩẻểỉỏổởủửỷãẵẫẽễĩõỗỡũữỹạặậẹệịọộợụựỵđ]{1,5}" +
                                "+[ ]+[A-Z AĂÂEÊIOÔƠUƯÁẮẤÉẾÍÓỐỚÚỨÝÀẰẦÈỀÌÒỒỜÙỪỲẢẲẨẺỂỈỎỔỞỦỬỶÃẴẪẼỄỈÕỖỠŨỮỸẠẶẬẸỆỊỌỘỢỤỰỴĐ]" +
                                "+[a-zaăâeêioôơuưyáắấéếíóốớúứýàằầèềìòồờùừỳảẳẩẻểỉỏổởủửỷãẵẫẽễĩõỗỡũữỹạặậẹệịọộợụựỵđ]{1,5}){1,6}";


                        if(!maNV.matches(dkMaNV)){
                            editMaNV.setTextColor(Color.RED);
                            Toast.makeText((ASMNhanVien)c, "Bạn nhập sai định dạng MÃ NV!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        editMaNV.setTextColor(Color.BLACK);

                        if(!hoTen.matches(dkHoTen) || !hoTen.contains(" ")){
                            editTenNV.setTextColor(Color.RED);
                            Toast.makeText((ASMNhanVien)c, "Bạn nhập sai định dạng Họ tên!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        editTenNV.setTextColor(Color.BLACK);
                        if(!phong.equals("Nhân Sự") && !phong.equals("Hành Chính") && !phong.equals("Đào Tạo")){
                            editPhongBan.setTextColor(Color.RED);
                            Toast.makeText((ASMNhanVien)c, "Không có phòng ban "+phong+" !", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        editPhongBan.setTextColor(Color.BLACK);

                        //ko trùng nhau
                        for(int j =0;j<ds.size();j++){
                            //cho lay MaNV cu
                            if(i==j){
                                j++;
                            }
                            if(j==ds.size()){
                                break;
                            }

                            if(ds.get(j).getMaNV().equals(maNV)){
                                editMaNV.setTextColor(Color.RED);
                                Toast.makeText((ASMNhanVien)c, "MÃ NV: "+maNV+" đã tồn tại !", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                        editMaNV.setTextColor(Color.BLACK);

                        Toast.makeText((ASMNhanVien)c, "Sửa NV Thành Công", Toast.LENGTH_SHORT).show();

                        //goi phương thức của ASMNhanVien
                        ((ASMNhanVien)c).suaNV(i,maNV,hoTen,phong,0);

                        dialogSua.dismiss();
                    }
                });

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogSua.cancel();
                    }
                });
            }

        });

        Animation anim = AnimationUtils.loadAnimation((ASMNhanVien)c,R.anim.anim_list);
        view.startAnimation(anim);

        return view;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();

                if(strSearch.isEmpty()){
                    ds=dsSearch;
                }else {
                    ArrayList<NhanVien> dsTemp = new ArrayList<NhanVien>();
                    for(NhanVien nv: dsSearch ){
                        if(nv.getMaNV().toLowerCase().contains(strSearch.toLowerCase())){
                            dsTemp.add(nv);
                        }
                    }
                    ds=dsTemp;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = ds;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                ds = (ArrayList<NhanVien>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
