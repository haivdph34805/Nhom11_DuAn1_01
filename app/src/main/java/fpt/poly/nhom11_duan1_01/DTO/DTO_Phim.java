package fpt.poly.nhom11_duan1_01.DTO;

public class DTO_Phim {
    private int ID_Phim;
    private int ID_TL;
    private String TenPhim;
    private String DaoDien;
    private String NgayPhatHanh;
    private String Mota;
    private String Anh;
    private int SoLuongVeDat;
    private float trungBinhCong;
    private int doanhThu;

    public DTO_Phim(int ID_Phim, String tenPhim, int doanhThu) {
        this.ID_Phim = ID_Phim;
        TenPhim = tenPhim;
        this.doanhThu = doanhThu;
    }

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }

    public DTO_Phim(String anh, float trungBinhCong) {
        Anh = anh;
        this.trungBinhCong = trungBinhCong;
    }

    public float getTrungBinhCong() {
        return trungBinhCong;
    }

    public void setTrungBinhCong(float trungBinhCong) {
        this.trungBinhCong = trungBinhCong;
    }

    public DTO_Phim(String tenPhim, String anh, int soLuongVeDat) {
        TenPhim = tenPhim;
        Anh = anh;
        SoLuongVeDat = soLuongVeDat;
    }

    public int getSoLuongVeDat() {
        return SoLuongVeDat;
    }

    public void setSoLuongVeDat(int soLuongVeDat) {
        SoLuongVeDat = soLuongVeDat;
    }



    public DTO_Phim() {
    }

    public DTO_Phim(int ID_TL, String tenPhim, String daoDien, String ngayPhatHanh, String mota, String anh) {
        this.ID_TL = ID_TL;
        TenPhim = tenPhim;
        DaoDien = daoDien;
        NgayPhatHanh = ngayPhatHanh;
        Mota = mota;
        Anh = anh;
    }

    public DTO_Phim(int ID_Phim, int ID_TL, String tenPhim, String daoDien, String ngayPhatHanh, String mota, String anh) {
        this.ID_Phim = ID_Phim;
        this.ID_TL = ID_TL;
        TenPhim = tenPhim;
        DaoDien = daoDien;
        NgayPhatHanh = ngayPhatHanh;
        Mota = mota;
        Anh = anh;
    }

    public int getID_Phim() {
        return ID_Phim;
    }

    public void setID_Phim(int ID_Phim) {
        this.ID_Phim = ID_Phim;
    }

    public int getID_TL() {
        return ID_TL;
    }

    public void setID_TL(int ID_TL) {
        this.ID_TL = ID_TL;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String tenPhim) {
        TenPhim = tenPhim;
    }

    public String getDaoDien() {
        return DaoDien;
    }

    public void setDaoDien(String daoDien) {
        DaoDien = daoDien;
    }

    public String getNgayPhatHanh() {
        return NgayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        NgayPhatHanh = ngayPhatHanh;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

}
