package fpt.poly.nhom11_duan1_01.Adapter;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.security.AccessController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import fpt.poly.nhom11_duan1_01.DAO.NguoiDungDao;
import fpt.poly.nhom11_duan1_01.DAO.PhimDao;
import fpt.poly.nhom11_duan1_01.DAO.PhongDao;
import fpt.poly.nhom11_duan1_01.DAO.SuatChieuDao;
import fpt.poly.nhom11_duan1_01.DTO.DTO_Phim;
import fpt.poly.nhom11_duan1_01.DTO.PhongModel;
import fpt.poly.nhom11_duan1_01.DTO.SuatChieuModel;
import fpt.poly.nhom11_duan1_01.Fragment.Fragment_SuatChieu_2;
import fpt.poly.nhom11_duan1_01.MainActivity;
import fpt.poly.nhom11_duan1_01.R;
import fpt.poly.nhom11_duan1_01.Spinner.AdapterSpinnerPhim;
import fpt.poly.nhom11_duan1_01.Spinner.AdapterSpinnerPhong;

public class AdapterSuatChieu extends RecyclerView.Adapter<AdapterSuatChieu.ViewHolder>{

    private final Context context;
    private final ArrayList<SuatChieuModel> list;
    private int idphong=0,idphim=0;
    PhongDao phongDao;
    SuatChieuDao dao;

    public AdapterSuatChieu(Context context, ArrayList<SuatChieuModel> list) {
        this.context = context;
        this.list = list;
    }

    private int maphong,maphim;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_suat_chieu,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int quyen=-1;
        SharedPreferences sharedPreferences = context.getSharedPreferences("login", context.MODE_PRIVATE);
        String tendangnhap = sharedPreferences.getString("username", "");
        NguoiDungDao nguoiDungDao= new NguoiDungDao(context);
        quyen=nguoiDungDao.layQuyenTuDangNhap(tendangnhap);
        if(quyen==0){
            holder.chinh.setVisibility(View.INVISIBLE);
        }
        phongDao= new PhongDao(context);
        SuatChieuModel suatChieuModel= list.get(position);
        dao= new SuatChieuDao(context);
        holder.name.setText(String.valueOf(list.get(position).getTenPhim()));


        String base64String = list.get(position).getAnh();

// Giải mã chuỗi Base64 thành mảng byte
        byte[] decodedByteArray = Base64.decode(base64String, Base64.DEFAULT);

// Chuyển đổi mảng byte thành Bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);

// Hiển thị Bitmap bằng Glide
        Glide.with(context)
                .load(bitmap)
                .into(holder.anh);
//       Glide.with(context).load(list.get(position).getAnh()).into(holder.anh);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ngay = list.get(position).getNgayChieu();
                @SuppressLint({"NewApi", "LocalSuppress"})
                String ngayht = String.valueOf(LocalDate.now());
                int result = compareDates(ngay, ngayht);
                if(result>0||result==0) {

//                    Fragment_DatPhim frg = new Fragment_DatPhim();
//                    Fragment_HoaDon frg1 = new Fragment_HoaDon();
//                    MainActivity mainActivity = (MainActivity) context;
//                    mainActivity.replec(frg);
//
//                    String ng = list.get(position).getGioChieu() + "  " + list.get(position).getNgayChieu();
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("scid", list.get(position).getId());
//                    bundle.putString("ngaygio", ng);
//                    bundle.putString("ten", list.get(position).getTenPhim());
//                    bundle.putInt("gia", list.get(position).getGia());
//                    frg.setArguments(bundle);
//                    frg1.setArguments(bundle);
                    Fragment_SuatChieu_2 frg = new Fragment_SuatChieu_2();
                    MainActivity mainActivity = (MainActivity) context;
                    Bundle bundle= new Bundle();
                    bundle.putInt("idphim",list.get(position).getIdPhim());
                     frg.setArguments(bundle);

                    mainActivity.replec(frg);
                }else {
                    Toast.makeText(context, "Xuất chiếu này đã được chiếu ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.chinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                popupMenu.getMenuInflater().inflate(R.menu.popumenu, popupMenu.getMenu());

                // Bắt sự kiện khi một mục trong menu được chọn
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int itemId = item.getItemId();

                        if (itemId == R.id.action_custom){
                            // Xử lý khi chọn tùy chỉnh
                            openDialogUpdate(list.get(position));
                            return true;
                        } else if (itemId == R.id.action_delete) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setTitle("Cảnh báo!");
                            builder.setIcon(R.drawable.baseline_warning_24);
                            builder.setMessage("Bạn có muốn xoá?");
                            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    if (dao.deleteSuatChieu(list.get(position).getId())) {
                                        list.clear();
                                        list.addAll(dao.getAllSuatChieuWithInfo());
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Xoá thành công", Toast.LENGTH_SHORT).show();
                                        // Sau khi xóa thành công sản phẩm
                                        //  NotificationHelper.showNotification(context.getApplicationContext(), "Bạn đã xóa một sản phẩm.");

                                    } else {
                                        Toast.makeText(context, "Xoá thất bại", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                            builder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    Toast.makeText(context, "Huỷ xoá", Toast.LENGTH_SHORT).show();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            // Xử lý khi chọn xóa
                            return true;
                        }
                        return  false;
                    }
                });

                popupMenu.show();
            }
        });

        // xử lý khi click vào item suất chiếu

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView anh,chinh;
        TextView ngay,name;
        public ViewHolder(@NonNull View view) {
            super(view);
            anh=view.findViewById(R.id.anhchieu);
            name=view.findViewById(R.id.namephim);

            chinh=view.findViewById(R.id.imgchinh);
        }
    }
    @SuppressLint("MissingInflatedId")
    public void openDialogUpdate (SuatChieuModel sc) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.sua_suat_chieu,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        Spinner phim,phong;
        phim=view.findViewById(R.id.spinnerPhims);
        phong=view.findViewById(R.id.spinnerphongs);
        EditText gia,ngay,gio;
        gia=view.findViewById(R.id.txtgia);
        ngay=view.findViewById(R.id.ngay);
        gio=view.findViewById(R.id.gio);
        AppCompatButton huy,update;
        huy=view.findViewById(R.id.btnhuy);
        update=view.findViewById(R.id.btnupdate);

        // không cho  nhập vào dittext
        gio.setKeyListener(null);
        ngay.setKeyListener(null);
        // xử lý khi chọn giờ
        gio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the current time
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                // Create a TimePickerDialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                // Format the selected time and set it to the EditText
                                String formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
                                gio.setText(formattedTime);
                            }
                        }, hour, minute, true);

                // Show the dialog
                timePickerDialog.show();
            }
        });
        // xử lý khi chọn ngày
        ngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                String ngayy = "";
                                String thang = "";
                                if (dayOfMonth < 10) {
                                    ngayy = "0" + dayOfMonth;
                                } else {
                                    ngayy = String.valueOf(dayOfMonth);
                                }

                                if ((month + 1) < 10) {
                                    thang = "0" + (month + 1);
                                } else {
                                    thang = String.valueOf((month + 1));
                                }
                                ngay.setText(ngayy+ "-" + thang + "-" + year);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
        PhongDao dao1 = new PhongDao(context);
        ArrayList<PhongModel> list2 = dao1.getAllPhongChieu();
        AdapterSpinnerPhong adapter2 = new AdapterSpinnerPhong(context, list2);
        phong.setAdapter(adapter2);

        PhimDao dao2 = new PhimDao(context);
        ArrayList<DTO_Phim> list1 = dao2.selectAllPhim();
        AdapterSpinnerPhim adapter3 = new AdapterSpinnerPhim(context, list1);
        phim.setAdapter(adapter3);

        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        phong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idphong = ((PhongModel) phong.getItemAtPosition(position)).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        phim.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idphim = ((DTO_Phim) phim.getItemAtPosition(position)).getID_Phim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        int map = 0 ;// sửa lỗi ở đây
        int mapi = 0; // sửa lỗi ở đây
        for(int i=0;i<list1.size();i++){
            DTO_Phim phim1=list1.get(i);
            if(phim1.getID_Phim()==sc.getIdPhim()){
                mapi=i;
            }
        }
        for(int i=0;i<list2.size();i++){
            PhongModel p=list2.get(i);
            if(p.getId()==sc.getIdPhong()){
                map=i;
            }
        }
//set gia tri phong phim cho spinner
        phong.setSelection(map);
        phim.setSelection(mapi);
        // sét ngày giờ
        gio.setText(sc.getGioChieu());
        ngay.setText(sc.getNgayChieu());
        gia.setText(String.valueOf(sc.getGia()));
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // xửa lý lấy dữ liệu từ spinner
                String Gia = gia.getText().toString().trim();
                String Ngay=ngay.getText().toString().trim();
                String Gio=gio.getText().toString().trim();
                if (Gia.isEmpty()) {
                    Toast.makeText(context, "Không để trống giá", Toast.LENGTH_SHORT).show();
                } else if (Ngay.isEmpty()) {
                    Toast.makeText(context, "Không để trống ngày", Toast.LENGTH_SHORT).show();
                }else if (Gio.isEmpty()) {
                    Toast.makeText(context, "Không để trống giờ", Toast.LENGTH_SHORT).show();
                }
                else {
                    int idsc=sc.getId();
                    try {
                        sc.setId(idsc);
                        sc.setNgayChieu(Ngay);
                        sc.setGia(Integer.parseInt(Gia));
                        sc.setGioChieu(Gio);
                        sc.setIdPhong(idphong);
                        sc.setIdPhim(idphim);

                        if (dao.updateSuatChieu(sc)) {
                            list.clear();
                            list.addAll(dao.getAllSuatChieuWithInfo());
                            notifyDataSetChanged();
                            Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });

    }

    public static int compareDates(String ngay1, String ngay2) {
        try {
            // Định dạng chuỗi ngày
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            // Chuyển đổi chuỗi ngày thành đối tượng Date
            Date date1 = sdf.parse(ngay1);
            Date date2 = sdf.parse(ngay2);

            // Chuyển đổi Date thành LocalDate
            LocalDate localDate1 = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            LocalDate localDate2 = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }

            // So sánh LocalDate
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                return localDate1.compareTo(localDate2);
            }
        } catch (ParseException e) {
            // Xử lý lỗi định dạng ngày nếu cần
            e.printStackTrace();
            return 0; // Trả về 0 nếu có lỗi
        }
        return 0;
    }

}

