package fpt.poly.nhom11_duan1_01.Fragment;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.Adapter.AdapterPhim;
import fpt.poly.nhom11_duan1_01.DAO.PhimDao;
import fpt.poly.nhom11_duan1_01.DTO.DTO_Phim;
import fpt.poly.nhom11_duan1_01.MainActivity;
import fpt.poly.nhom11_duan1_01.R;

public class FragmentPhim extends Fragment {
    private RecyclerView rcvQLPhim;
    private FloatingActionButton fltAddPhim;

    private ArrayList<DTO_Phim> list = new ArrayList<DTO_Phim>();

    private PhimDao phimDao;
    ArrayList<DTO_Phim> tempListPhim = new ArrayList<>();

    AdapterPhim adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__phim, container, false);

        rcvQLPhim = view.findViewById(R.id.rcvQLPhim);
        fltAddPhim = view.findViewById(R.id.fltAddPhim);


        // data
        phimDao = new PhimDao(getContext());
        list = phimDao.selectAllPhim();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvQLPhim.setLayoutManager(linearLayoutManager);

        adapter = new AdapterPhim(getContext(),list);
        rcvQLPhim.setAdapter(adapter);


        fltAddPhim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_ThemPhim frg=new Fragment_ThemPhim();
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.replec(frg);
            }
        });


        tempListPhim = phimDao.selectAllPhim();
        EditText edt_timKiem = view.findViewById(R.id.edtSeach);
        edt_timKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                list.clear();
                for (DTO_Phim pm:tempListPhim) {
                    if(pm.getTenPhim().contains(charSequence.toString())){
                        list.add(pm);
                    }}adapter.notifyDataSetChanged();}
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }
}
