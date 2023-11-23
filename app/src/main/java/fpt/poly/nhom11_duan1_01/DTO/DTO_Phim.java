package fpt.poly.nhom11_duan1_01.DTO;

public class DTO_Phim {
    private int maPhim;
    private String tenPhim;

    private String mieuTaPhim;

    private  String giaVe;
    private String ngayKhoiChieu;

    public DTO_Phim() {
    }

    public DTO_Phim(int maPhim, String tenPhim, String mieuTaPhim, String giaVe, String ngayKhoiChieu) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.mieuTaPhim = mieuTaPhim;
        this.giaVe = giaVe;
        this.ngayKhoiChieu = ngayKhoiChieu;
    }

    public DTO_Phim(String tenPhim, String mieuTaPhim, String giaVe, String ngayKhoiChieu) {
        this.tenPhim = tenPhim;
        this.mieuTaPhim = mieuTaPhim;
        this.giaVe = giaVe;
        this.ngayKhoiChieu = ngayKhoiChieu;
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getMieuTaPhim() {
        return mieuTaPhim;
    }

    public void setMieuTaPhim(String mieuTaPhim) {
        this.mieuTaPhim = mieuTaPhim;
    }

    public String getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(String giaVe) {
        this.giaVe = giaVe;
    }

    public String getNgayKhoiChieu() {
        return ngayKhoiChieu;
    }

    public void setNgayKhoiChieu(String ngayKhoiChieu) {
        this.ngayKhoiChieu = ngayKhoiChieu;
    }


}
