package fpt.poly.nhom11_duan1_01.Fragment;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.Adapter.AdapterHoaDon;
import fpt.poly.nhom11_duan1_01.DAO.HoaDonDao;
import fpt.poly.nhom11_duan1_01.DAO.NguoiDungDao;
import fpt.poly.nhom11_duan1_01.DTO.HoaDonModel;
import fpt.poly.nhom11_duan1_01.R;

public class FragmentAllHoaDon extends Fragment {

    public FragmentAllHoaDon() {
        // Required empty public constructor
    }

    RecyclerView rcv;
    ArrayList<HoaDonModel>list;
    HoaDonDao hoaDonDao;
    AdapterHoaDon adapterHoaDon;
    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_all_hoa_don, container, false);
        rcv=view.findViewById(R.id.rcvhd);


        TabLayout tabLayout =view.findViewById(R.id.tabLayouthd);
        TextView tv=view.findViewById(R.id.tv);

        // sinh tablayout
        TabLayout.Tab tab1 = tabLayout.newTab().setText(" ALL ");
        tabLayout.addTab(tab1);
        TabLayout.Tab tab2 = tabLayout.newTab().setText("CHƯA THANH TOÁN");
        tabLayout.addTab(tab2);

        hoaDonDao= new HoaDonDao(getActivity());
        list=hoaDonDao.getAllHoaDon();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rcv.setLayoutManager(layoutManager);
        adapterHoaDon= new AdapterHoaDon(getActivity(),list);
        rcv.setAdapter(adapterHoaDon);

        int quyen=-1;
        // lấy mã người dùng
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("login", getActivity().MODE_PRIVATE);
        String tendangnhap = sharedPreferences.getString("username", "");
        NguoiDungDao nguoiDungDao= new NguoiDungDao(getActivity());
        quyen=nguoiDungDao.layQuyenTuDangNhap(tendangnhap);

        if(quyen==0){
            tv.setText("Hóa Đơn Của Tôi ");
            tabLayout.setVisibility(View.GONE);
           ArrayList<HoaDonModel> list1=hoaDonDao.getHoaDonByTenngdung(tendangnhap);
            adapterHoaDon= new AdapterHoaDon(getActivity(),list1);
            rcv.setAdapter(adapterHoaDon);
            adapterHoaDon.notifyDataSetChanged();
        }else {
            tabLayout.setVisibility(View.VISIBLE);
        }


        // xửa lý khi chọn tablayout
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int selectedTabIndex = tab.getPosition();
                if (selectedTabIndex == 0) {
                    list.clear();
                    list.addAll(hoaDonDao.getAllHoaDon());
                    adapterHoaDon.notifyDataSetChanged();
                } else if (selectedTabIndex == 1) {
                     list.clear();
                     list.addAll(hoaDonDao.getHoaDonByTrangThai(0));
                    adapterHoaDon.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        return view;
    }
}