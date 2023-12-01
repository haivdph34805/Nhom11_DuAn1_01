package fpt.poly.nhom11_duan1_01.DAO;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.DTO.Ve;
import fpt.poly.nhom11_duan1_01.DataBase.DBHelper;

public class VeDao {

    private final Context context;
    private final DBHelper dbhelper;

    public VeDao(Context context) {
        this.context = context;
        this.dbhelper = new DBHelper(context);
    }
    public boolean isSeatBooked(int seatId, int showId) {
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        String query = "SELECT COUNT(*) FROM Ve WHERE ID_Ghe = ? AND ID_SC = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(seatId), String.valueOf(showId)});

        boolean isBooked = false;

        if (cursor.moveToFirst()) {
            int count = cursor.getInt(0);
            isBooked = count > 0;
        }

        cursor.close();
        db.close();

        return isBooked;
    }


    // lấy tên phim
    @SuppressLint("Range")
    public String getTenPhimByIdSC(int idSC) {
        String tenPhim = null;
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        try (Cursor cursor = db.rawQuery("SELECT Phim.TenPhim FROM SuatChieu " +
                "INNER JOIN Phim ON SuatChieu.ID_Phim = Phim.ID_Phim " +
                "WHERE SuatChieu.ID_SC = ?", new String[]{String.valueOf(idSC)})) {

            if (cursor.moveToFirst()) {
                tenPhim = cursor.getString(cursor.getColumnIndex("TenPhim"));
            }

        } catch (Exception e) {
            Log.e(TAG, "Error in getTenPhimByIdSC", e);
        } finally {
            db.close();
        }

        return tenPhim;
    }

    // lấy sô ghế
    @SuppressLint("Range")
    public String getSoGheById(int id) {
        String soGhe = null;
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        try (Cursor cursor = db.rawQuery("SELECT SoGhe FROM Ghe WHERE ID_Ghe = ?", new String[]{String.valueOf(id)})) {
            if (cursor.moveToFirst()) {
                soGhe = cursor.getString(cursor.getColumnIndex("SoGhe"));
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in getSoGheById", e);
        } finally {
            db.close();
        }

        return soGhe;
    }


    @SuppressLint("Range")
    public String getTenPhongByIdSC(int idSC) {
        String tenPhong = null;
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        try (Cursor cursor = db.rawQuery("SELECT PhongChieu.TenPhong FROM SuatChieu " +
                "INNER JOIN PhongChieu ON SuatChieu.ID_Phong = PhongChieu.ID_Phong " +
                "WHERE SuatChieu.ID_SC = ?", new String[]{String.valueOf(idSC)})) {

            if (cursor.moveToFirst()) {
                tenPhong = cursor.getString(cursor.getColumnIndex("TenPhong"));
            }

        } catch (Exception e) {
            Log.e(TAG, "Error in getTenPhongByIdSC", e);
        } finally {
            db.close();
        }

        return tenPhong;
    }

    // lấy trạng thái
    @SuppressLint("Range")
    public int getTrangThaiHoaDonByIdHD(int idHD) {
        int trangThai = -1; // Giá trị mặc định nếu không tìm thấy hoặc có lỗi
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        try (Cursor cursor = db.rawQuery("SELECT TrangThai FROM HoaDon WHERE ID_HD = ?", new String[]{String.valueOf(idHD)})) {

            if (cursor.moveToFirst()) {
                trangThai = cursor.getInt(cursor.getColumnIndex("TrangThai"));
            }

        } catch (Exception e) {
            Log.e(TAG, "Lỗi trong getTrangThaiHoaDonByIdHD", e);
        } finally {
            db.close();
        }

        return trangThai;
    }


    public ArrayList<Ve> getAllVe(){
        ArrayList<Ve>list= new ArrayList<>();
        SQLiteDatabase db=dbhelper.getReadableDatabase();
        try {


            Cursor cursor = db.rawQuery("select * from Ve", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Ve sp = new Ve();
                    sp.setId(cursor.getInt(0));
                    sp.setTendangnhap(cursor.getString(1));
                    sp.setIdsc(cursor.getInt(2));
                    sp.setIdghe(cursor.getInt(3));
                    sp.setIdhd(cursor.getInt(4));
                    sp.setGia(cursor.getInt(5));
                    sp.setNgay(cursor.getString(6));
                    list.add(sp);
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Ve> getVeByTendangnhap(String tendangnhap) {
        ArrayList<Ve> list = new ArrayList<>();
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        try {
            // Sử dụng câu truy vấn với điều kiện WHERE
            String query = "SELECT * FROM Ve WHERE tendangnhap = ?";
            Cursor cursor = db.rawQuery(query, new String[]{tendangnhap});

            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Ve ve = new Ve();
                    ve.setId(cursor.getInt(0));
                    ve.setTendangnhap(cursor.getString(1));
                    ve.setIdsc(cursor.getInt(2));
                    ve.setIdghe(cursor.getInt(3));
                    ve.setIdhd(cursor.getInt(4));
                    ve.setGia(cursor.getInt(5));
                    ve.setNgay(cursor.getString(6));
                    list.add(ve);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

        return list;
    }

    public ArrayList<Ve> getVeByIdHoaDon(int idHoaDon) {
        ArrayList<Ve> list = new ArrayList<>();
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        try {
            // Sử dụng câu truy vấn với điều kiện WHERE
            String query = "SELECT * FROM Ve WHERE ID_HD = ?";
            Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(idHoaDon)});

            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Ve ve = new Ve();
                    ve.setId(cursor.getInt(0));
                    ve.setTendangnhap(cursor.getString(1));
                    ve.setIdsc(cursor.getInt(2));
                    ve.setIdghe(cursor.getInt(3));
                    ve.setIdhd(cursor.getInt(4));
                    ve.setGia(cursor.getInt(5));
                    ve.setNgay(cursor.getString(6));
                    list.add(ve);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

        return list;
    }


}
