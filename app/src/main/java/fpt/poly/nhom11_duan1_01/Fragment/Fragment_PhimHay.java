package fpt.poly.nhom11_duan1_01.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.Adapter.AdapterPhimHay;
import fpt.poly.nhom11_duan1_01.DAO.ThongKeDao;
import fpt.poly.nhom11_duan1_01.DTO.DTO_Phim;
import fpt.poly.nhom11_duan1_01.MainActivity;
import fpt.poly.nhom11_duan1_01.R;


public class Fragment_PhimHay extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__phim_hay, container, false);
        RecyclerView recyclerTop10 = view.findViewById(R.id.rcvTop10PhimHay);
        ImageView imageView = view.findViewById(R.id.btnExit_PhimHay);
        ThongKeDao thongKeDao = new ThongKeDao(getContext());
        ArrayList<DTO_Phim> list = thongKeDao.selectTopPhimDanhGiaCao();

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerTop10.setLayoutManager(linearLayoutManager);

        AdapterPhimHay adapter = new AdapterPhimHay(getContext(), list);
        recyclerTop10.setAdapter(adapter);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_Khac frg=new Fragment_Khac();
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.replec(frg);
            }
        });
        return view;
    }
}