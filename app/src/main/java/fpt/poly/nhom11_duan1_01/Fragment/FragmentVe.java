package fpt.poly.nhom11_duan1_01.Fragment;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.Adapter.AdapterVe;
import fpt.poly.nhom11_duan1_01.DAO.NguoiDungDao;
import fpt.poly.nhom11_duan1_01.DAO.VeDao;
import fpt.poly.nhom11_duan1_01.DTO.Ve;
import fpt.poly.nhom11_duan1_01.R;

public class FragmentVe extends Fragment {
    public FragmentVe() {
        // Required empty public constructor
    }


    RecyclerView rcv;
    AdapterVe adapterVe;
    VeDao veDao;
    NguoiDungDao nguoiDungDao;
    ArrayList<Ve> list;
    TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ve, container, false);
        rcv=view.findViewById(R.id.rcvve);
        tv=view.findViewById(R.id.tvn);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("login",getActivity().MODE_PRIVATE);
        String tendangnhap = sharedPreferences.getString("username", "");
        nguoiDungDao= new NguoiDungDao(getActivity());
        veDao= new VeDao(getActivity());
        int quyen=nguoiDungDao.layQuyenTuDangNhap(tendangnhap);
        if(quyen==1){
            list=veDao.getAllVe();
            tv.setText("Quản Lý Vé");
        }else {
            list=veDao.getVeByTendangnhap(tendangnhap);
            tv.setText(" Vé Của Tôi");
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rcv.setLayoutManager(layoutManager);
        adapterVe= new AdapterVe(getActivity(),list);
        rcv.setAdapter(adapterVe);
        return view;

    }
}
