package fpt.poly.nhom11_duan1_01.DAO;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.DTO.GheModel;
import fpt.poly.nhom11_duan1_01.DataBase.DBHelper;

public class GheDao {
    private final Context context;
    private final DBHelper dbhelper;

    public GheDao(Context context) {
        this.context = context;
        this.dbhelper = new DBHelper(context);
    }

    public ArrayList<GheModel> getAllGhe(){
        ArrayList<GheModel>list= new ArrayList<>();
        SQLiteDatabase db=dbhelper.getReadableDatabase();
        try {
            Cursor cursor=db.rawQuery("Select * from Ghe  ",null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    GheModel sp= new GheModel();
                    sp.setId(cursor.getInt(0));
                    sp.setSoGhe(cursor.getString(1));
                    list.add(sp);
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG, "Lỗi allSP",e);
        }
        return list;
    }
    public boolean deleteGhe(int id){
        SQLiteDatabase db= dbhelper.getWritableDatabase();
        long row=db.delete("Ghe","ID_Ghe=?",new String[]{String.valueOf(id)});
        return  (row>0);
    }
    public boolean updateghe(GheModel sp){
        ContentValues values=new ContentValues();
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        values.put("ID_Ghe",sp.getId());
        values.put("SoGhe",sp.getSoGhe());
        long row=db.update("Ghe",values,"ID_Ghe=?",new String[]{String.valueOf(sp.getId())});
        return (row>0);
    }
    public boolean addGhe(GheModel sp){
        ContentValues values=new ContentValues();
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        values.put("SoGhe",sp.getSoGhe());
        long row=db.insert("Ghe",null,values);
        return (row>0);
    }

    @SuppressLint("Range")
    public String getPhimAnhBySuatChieuId(int suatChieuId) {
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        String anh = null;

        // Truy vấn dữ liệu từ bảng SuatChieu và Phim dựa trên ID suất chiếu
        String query = "SELECT Phim.Anh FROM Phim " +
                "INNER JOIN SuatChieu ON Phim.ID_Phim = SuatChieu.ID_Phim " +
                "WHERE SuatChieu.ID_SC = ?";

        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(suatChieuId)});

        if (cursor.moveToFirst()) {
            // Lấy giá trị ảnh từ cột "Anh"
            anh = cursor.getString(cursor.getColumnIndex("Anh"));
        }

        cursor.close();
        db.close();

        return anh;
    }
}

