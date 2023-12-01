package fpt.poly.nhom11_duan1_01.DAO;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.DTO.PhongModel;
import fpt.poly.nhom11_duan1_01.DataBase.DBHelper;

public class PhongDao {
    private final Context context;
    private final DBHelper dbhelper;

    public PhongDao(Context context) {
        this.context = context;
        this.dbhelper = new DBHelper(context);
    }

    public ArrayList<PhongModel> getAllPhongChieu(){
        ArrayList<PhongModel>list= new ArrayList<>();
        SQLiteDatabase db=dbhelper.getReadableDatabase();
        try {
            Cursor cursor=db.rawQuery("Select * from PhongChieu  ",null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    PhongModel sp= new PhongModel();
                    sp.setId(cursor.getInt(0));
                    sp.setTenPhong(cursor.getString(1));
                    sp.setSoCho(cursor.getInt(2));
                    sp.setLoaiPhong(cursor.getInt(3));
                    list.add(sp);
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "Lỗi allSP",e);
        }
        return list;
    }
    public boolean deletePhongChieu(int id){
        SQLiteDatabase db= dbhelper.getWritableDatabase();
        long row=db.delete("PhongChieu","ID_Phong=?",new String[]{String.valueOf(id)});
        return  (row>0);
    }
    public boolean updatePhongChieu(PhongModel sp){
        ContentValues values=new ContentValues();
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        values.put("ID_Phong",sp.getId());
        values.put("TenPhong",sp.getTenPhong());
        values.put("SoCho",sp.getSoCho());
        values.put("LoaiPhong",sp.getLoaiPhong());
        long row=db.update("PhongChieu",values,"ID_Phong=?",new String[]{String.valueOf(sp.getId())});
        return (row>0);
    }
    public boolean addPhongChieu(PhongModel sp){
        ContentValues values=new ContentValues();
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        values.put("TenPhong",sp.getTenPhong());
        values.put("SoCho",sp.getSoCho());
        values.put("LoaiPhong",sp.getLoaiPhong());
        long row=db.insert("PhongChieu",null,values);
        return (row>0);
    }

}
