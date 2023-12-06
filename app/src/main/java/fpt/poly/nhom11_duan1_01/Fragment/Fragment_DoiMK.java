package fpt.poly.nhom11_duan1_01.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import fpt.poly.nhom11_duan1_01.DAO.NguoiDungDao;
import fpt.poly.nhom11_duan1_01.Intro.DangNhap_Activity;
import fpt.poly.nhom11_duan1_01.MainActivity;
import fpt.poly.nhom11_duan1_01.R;


public class Fragment_DoiMK extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment__doi_m_k, container, false);
        EditText edtOldPass = view.findViewById(R.id.edtPassOld);
        EditText edtNewPass = view.findViewById(R.id.edtNewPass);
        EditText edtReNewPass = view.findViewById(R.id.edtReNewPass);
        Button btnDoiMK = view.findViewById(R.id.btnDOiMK);
        Button btnHuy = view.findViewById(R.id.btnHuy);
        ImageView imageView = view.findViewById(R.id.btnExit_DoiMK);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_Khac frg=new Fragment_Khac();
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.replec(frg);
            }
        });

        btnDoiMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldPass = edtOldPass.getText().toString();
                String newPass = edtNewPass.getText().toString();
                String renewPass = edtReNewPass.getText().toString();

                if (edtOldPass.getText().length()==0 | edtNewPass.getText().length()==0 | edtReNewPass.getText().length()==0){
                    Toast.makeText(getContext(), "Hãy Nhập Đầy Đủ Thông Tin", Toast.LENGTH_SHORT).show();
                }else if (newPass.equals(renewPass)){
                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("ThongTin", Context.MODE_PRIVATE);
                    String tenDangNhap = sharedPreferences.getString("TenDangNhap", "");
                    // cap nhat
                    NguoiDungDao nguoiDungDao = new NguoiDungDao(getContext());
                    boolean check = nguoiDungDao.capNhatMatKhau(tenDangNhap, oldPass, newPass);
                    if (check){
                        Toast.makeText(getContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(), DangNhap_Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getContext(), "Bạn Nhập Sai Mật Khẩu Cũ", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getContext(), "Mật Khẩu Không Trùng", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtOldPass.setText("");
                edtNewPass.setText("");
                edtReNewPass.setText("");
            }
        });
        return view;
    }
}