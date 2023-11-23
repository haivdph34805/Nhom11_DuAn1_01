package fpt.poly.nhom11_duan1_01.Intro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fpt.poly.nhom11_duan1_01.MainActivity;
import fpt.poly.nhom11_duan1_01.R;

public class DangNhap_Activity extends AppCompatActivity {
    EditText txtusser,txtpassword;
    Button btnDangNhap;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
    btnDangNhap=findViewById(R.id.da1_DangNhap_BtnDangNhap);

    btnDangNhap.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(DangNhap_Activity.this, MainActivity.class);
            startActivity(intent);
        }
    });
    }
}