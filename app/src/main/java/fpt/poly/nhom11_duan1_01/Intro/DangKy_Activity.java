package fpt.poly.nhom11_duan1_01.Intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fpt.poly.nhom11_duan1_01.R;

public class DangKy_Activity extends AppCompatActivity {
   Button btndangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
    btndangKy=findViewById(R.id.da1_DangKy_BtnDangKy);
   btndangKy.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent=new Intent(DangKy_Activity.this,DangNhap_Activity.class);
           startActivity(intent);
       }
   });
    }
}