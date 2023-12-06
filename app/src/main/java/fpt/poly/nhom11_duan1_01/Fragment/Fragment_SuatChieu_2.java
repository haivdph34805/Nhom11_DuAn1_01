package fpt.poly.nhom11_duan1_01.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import fpt.poly.nhom11_duan1_01.Adapter.AdapterGioChieu;
import fpt.poly.nhom11_duan1_01.Adapter.AdapterNgayChieu;
import fpt.poly.nhom11_duan1_01.DAO.SuatChieuDao;
import fpt.poly.nhom11_duan1_01.DTO.SuatChieuModel;
import fpt.poly.nhom11_duan1_01.R;

public class Fragment_SuatChieu_2 extends Fragment {


    public Fragment_SuatChieu_2() {
        // Required empty public constructor
    }

    SuatChieuDao suatChieuDao;
    AdapterNgayChieu adapterNgayChieu;
    AdapterGioChieu adapterGioChieu;
    ArrayList<SuatChieuModel> listngay,listgio;
    RecyclerView rcvn,rcvg;
    private int idphim=-1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__suat_chieu_2, container, false);
        rcvn=view.findViewById(R.id.rcyNgaychieu);
        rcvg=view.findViewById(R.id.rcyGiochieu);

// Tạo LinearLayoutManager với hướng là HORIZONTAL cho rcvg
        LinearLayoutManager layoutManagerGioChieu = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcvg.setLayoutManager(layoutManagerGioChieu);

// Tạo LinearLayoutManager với hướng là HORIZONTAL cho rcvn
        LinearLayoutManager layoutManagerNgayChieu = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcvn.setLayoutManager(layoutManagerNgayChieu);

        Bundle bundle = getArguments();
        if (bundle != null) {
            idphim = bundle.getInt("idphim");

        }

        suatChieuDao= new SuatChieuDao(getActivity());
        listngay=suatChieuDao.getSuatChieuByPhimId(idphim);
        adapterNgayChieu=new AdapterNgayChieu(getActivity(),listngay);
        rcvn.setAdapter(adapterNgayChieu);
        adapterNgayChieu.setOnQuantityChangeListener(new AdapterNgayChieu.OnQuantityChangeListener() {
            @Override
            public void onQuantityChanged() {
                SuatChieuModel sc=adapterNgayChieu.getlist();
                listgio=suatChieuDao.getSuatChieuByPhimIdAndDate(sc.getIdPhim(),sc.getNgayChieu());
                adapterGioChieu=new AdapterGioChieu(getActivity(),listgio);
                rcvg.setAdapter(adapterGioChieu);
            }
        });
        return view;
    }
}



