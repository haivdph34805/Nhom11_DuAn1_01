package fpt.poly.nhom11_duan1_01.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context,"DuAn1", null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table NguoiDung(\n" +
                "      TenDangNhap text primary key ,\n" +
                "      HoTen TEXT not null,\n" +
                "      Email TEXT not null,\n" +
                "      SDT TEXT not null,\n" +
                "      Quyen int not null,\n" +
                "      MatKhau TEXT not null)");
        db.execSQL("create table TheLoai(\n" +
                "      ID_TL integer primary key autoincrement,\n" +
                "      TenTheLoai TEXT not null)");

        db.execSQL("create table Phim(\n"+
                "      ID_Phim integer primary key autoincrement,\n" +
                "      ID_TL integer REFERENCES TheLoai(ID_TL),\n" +
                "      TenPhim TEXT not null,\n" +
                "      DaoDien TEXT not null,\n" +
                "      NgayPhatHanh TEXT ,\n" +
                "      Mota TEXT ,\n" +
                "      Anh TEXT)");


        // Thêm dữ liệu vào bảng NguoiDung
        db.execSQL("INSERT INTO NguoiDung  VALUES ('anh','admin', 'hi@gmail.com', '123456789',0, 'admin')");
        db.execSQL("INSERT INTO NguoiDung  VALUES ('admin','admin', 'hi@gmail.com', '123456789',1, 'admin')");

// Thêm dữ liệu vào bảng TheLoai
        db.execSQL("INSERT INTO TheLoai (TenTheLoai) VALUES ('TenTheLoai1')");

        // Thêm dữ liệu vào bảng Phim
        db.execSQL("INSERT INTO Phim (ID_TL, TenPhim, DaoDien, NgayPhatHanh, Mota, Anh) VALUES (1, 'TenPhim1', 'DaoDien1', '2023-11-12', 'Mo ta phim 1','android.resource://\" + context.getPackageName() + \"/drawable/img_3')");
        db.execSQL("INSERT INTO Phim (ID_TL, TenPhim, DaoDien, NgayPhatHanh, Mota, Anh) VALUES (1, 'TenPhim2', 'DaoDien2', '2023-11-12', 'Mo ta phim 2', 'android.resource://\" + context.getPackageName() + \"/drawable/img_4')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
