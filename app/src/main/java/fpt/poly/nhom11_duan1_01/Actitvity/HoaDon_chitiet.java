package fpt.poly.nhom11_duan1_01.Actitvity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.Adapter.AdapterVe;
import fpt.poly.nhom11_duan1_01.DAO.VeDao;
import fpt.poly.nhom11_duan1_01.DTO.Ve;
import fpt.poly.nhom11_duan1_01.MainActivity;
import fpt.poly.nhom11_duan1_01.R;

public class HoaDon_chitiet extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterVe adapterVe;
    VeDao veDao;
    ArrayList<Ve>list;
    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_chitiet);
        recyclerView=findViewById(R.id.rcvhdct);
         ImageView img= findViewById(R.id.imgtrolai);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HoaDon_chitiet.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent=getIntent();
        int id =intent.getIntExtra("idhd",-1);
        veDao= new VeDao(this);
        list=veDao.getVeByIdHoaDon(id);
        Log.i(TAG,"ID "+id);
        LinearLayoutManager layoutManager = new LinearLayoutManager(HoaDon_chitiet.this);
        recyclerView.setLayoutManager(layoutManager);
        adapterVe= new AdapterVe(HoaDon_chitiet.this,list);
        recyclerView.setAdapter(adapterVe);
    }
}