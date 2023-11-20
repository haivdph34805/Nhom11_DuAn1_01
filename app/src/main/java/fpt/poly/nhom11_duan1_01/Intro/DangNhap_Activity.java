package fpt.poly.nhom11_duan1_01.Intro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

import fpt.poly.nhom11_duan1_01.R;

public class DangNhap_Activity extends AppCompatActivity {
    EditText txtusser,txtpassword;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        txtusser=findViewById(R.id.da1_DangKy_txtEmail);
        txtpassword=findViewById(R.id.da1_DangKy_txtPass);
    }
}