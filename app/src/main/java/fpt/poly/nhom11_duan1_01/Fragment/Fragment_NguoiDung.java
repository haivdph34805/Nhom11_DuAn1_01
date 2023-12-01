package fpt.poly.nhom11_duan1_01.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.Adapter.AdapterNguoiDung;
import fpt.poly.nhom11_duan1_01.DAO.NguoiDungDao;
import fpt.poly.nhom11_duan1_01.DTO.NguoiDung;
import fpt.poly.nhom11_duan1_01.R;

public class Fragment_NguoiDung extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__nguoi_dung, container, false);
        RecyclerView recyclerTop10 = view.findViewById(R.id.rcvThanhVien);

        NguoiDungDao nguoiDungDao = new NguoiDungDao(getContext());
        ArrayList<NguoiDung> list = nguoiDungDao.selectAllNguoiDUng();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerTop10.setLayoutManager(linearLayoutManager);

        AdapterNguoiDung adapter = new AdapterNguoiDung(getContext(), list);
        recyclerTop10.setAdapter(adapter);
        return view;
    }
}
