package fpt.poly.nhom11_duan1_01.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.Adapter.AdapterDoanhThuPhim;
import fpt.poly.nhom11_duan1_01.DAO.ThongKeDao;
import fpt.poly.nhom11_duan1_01.DTO.DTO_Phim;
import fpt.poly.nhom11_duan1_01.R;


public class Fragment_DanhThuTheoPhim extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__danh_thu_theo_phim, container, false);
        RecyclerView recyclerDT = view.findViewById(R.id.rcvDoanhThuPHim);

        ThongKeDao thongKeDao = new ThongKeDao(getContext());
        ArrayList<DTO_Phim> list = thongKeDao.DoanhThuTheoPhim();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerDT.setLayoutManager(linearLayoutManager);

        AdapterDoanhThuPhim adapter = new AdapterDoanhThuPhim(getContext(), list);
        recyclerDT.setAdapter(adapter);
        return view;
    }
}