package fpt.poly.nhom11_duan1_01.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.Adapter.AdapterPhongChieu;
import fpt.poly.nhom11_duan1_01.DAO.PhongDao;
import fpt.poly.nhom11_duan1_01.DTO.PhongModel;
import fpt.poly.nhom11_duan1_01.R;


public class Fragment_PhongChieu extends Fragment {


    public Fragment_PhongChieu() {
        // Required empty public constructor
    }

    PhongDao phongDao;
    AdapterPhongChieu adapter;
    ArrayList<PhongModel> list;
    RecyclerView rcv;
    AppCompatButton add;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.fragment_phongchieu, container, false);
         rcv=view.findViewById(R.id.rcvGhe);
         add=view.findViewById(R.id.addGhe);

         phongDao= new PhongDao(getActivity());
         list=phongDao.getAllPhongChieu();
         LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
         rcv.setLayoutManager(layoutManager);
         adapter= new AdapterPhongChieu(getActivity(),list);
         rcv.setAdapter(adapter);
//         add.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                 LayoutInflater inflater = getLayoutInflater();
//                 View view1 = inflater.inflate(R.layout.add_ghe, null);
//                 builder.setView(view1);
//                 Dialog dialog = builder.create();
//                 dialog.show();
//                 AppCompatEditText idphong = view1.findViewById(R.id.txtIDP);
//                 AppCompatEditText soghe = view1.findViewById(R.id.txtSG);
//
//                 Button them = view1.findViewById(R.id.btnadd);
//                 // xử lý khi chọn hủy
//
//                 them.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View v) {
//                         if (idphong.getText().toString().trim().isEmpty()) {
//                             Toast.makeText(getActivity(), "Vui lòng nhập ID phòng", Toast.LENGTH_SHORT).show();
//                         } else if (soghe.getText().toString().trim().isEmpty()) {
//                             Toast.makeText(getActivity(), "Vui lòng nhập Số ghế", Toast.LENGTH_SHORT).show();
//                         } else {
//                             GheModel tl = new GheModel();
//                             tl.setTrangThai(0);
//                             tl.setIdPhong(Integer.parseInt(idphong.getText().toString()));
//                             tl.setSoGhe(soghe.getText().toString());
//                             if (gheDao.addGhe(tl)) {
//                                 list.clear();
//                                 list.addAll(gheDao.getAllGhe());
//                                 adapterGhe.notifyDataSetChanged();
//                                 Toast.makeText(getActivity(), "Bạn đã thêm 1 ghế mới ", Toast.LENGTH_SHORT).show();
//                                 dialog.dismiss();
//                             }
//                         }
//                     }
//                 });
//
//             }
//         });
         return view;
    }
}