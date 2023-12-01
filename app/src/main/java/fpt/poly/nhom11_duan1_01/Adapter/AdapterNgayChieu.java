package fpt.poly.nhom11_duan1_01.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import fpt.poly.nhom11_duan1_01.DAO.SuatChieuDao;
import fpt.poly.nhom11_duan1_01.DTO.SuatChieuModel;
import fpt.poly.nhom11_duan1_01.R;

public class AdapterNgayChieu extends RecyclerView.Adapter<AdapterNgayChieu.ViewHolder>{

    private final Context context;
    private final ArrayList<SuatChieuModel> list;
    private int idphim=0;

    SuatChieuDao dao;
    public AdapterNgayChieu(Context context, ArrayList<SuatChieuModel> list) {
        this.context = context;
        this.list = list;
    }
    private SuatChieuModel sc = new SuatChieuModel();
     public SuatChieuModel getlist(){
        return sc;
    }
    private OnQuantityChangeListener onQuantityChangeListener;
    public interface OnQuantityChangeListener {
        void onQuantityChanged();
    }


    public void setOnQuantityChangeListener(OnQuantityChangeListener listener) {
        this.onQuantityChangeListener = listener;
    }
    private int maphong,maphim;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_ngaychieu,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       holder.ngay.setText(list.get(position).getNgayChieu().substring(8)+list.get(position).getNgayChieu().substring(4,7));
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sc.setId(list.get(position).getId());
               sc.setIdPhong(list.get(position).getId());
               sc.setIdPhim(list.get(position).getIdPhim());
               sc.setNgayChieu(list.get(position).getNgayChieu());
               if(onQuantityChangeListener != null) {
                   onQuantityChangeListener.onQuantityChanged();
               }
           }
       });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView ngay;
        public ViewHolder(@NonNull View view) {
            super(view);
            ngay=view.findViewById(R.id.tvngay);
        }
    }

}

