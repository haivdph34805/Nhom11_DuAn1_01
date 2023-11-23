package fpt.poly.nhom11_duan1_01.DTO;

public class DTO_LichSu {
    private int MaLichSu;
    private String TenPhim;
    private String Email;
    private String ngayKhoiChieu;
    private String phongChieu;
    private String gioChieu;
    private String soLuongVe;
    private String gheDaChon;
    private String thanhToan;
    private String tongTien;

    public DTO_LichSu() {
    }

    public DTO_LichSu(int maLichSu, String tenPhim, String email, String ngayKhoiChieu, String phongChieu, String gioChieu, String soLuongVe, String gheDaChon, String thanhToan, String tongTien) {
        MaLichSu = maLichSu;
        TenPhim = tenPhim;
        Email = email;
        this.ngayKhoiChieu = ngayKhoiChieu;
        this.phongChieu = phongChieu;
        this.gioChieu = gioChieu;
        this.soLuongVe = soLuongVe;
        this.gheDaChon = gheDaChon;
        this.thanhToan = thanhToan;
        this.tongTien = tongTien;
    }

    public DTO_LichSu(String tenPhim, String email, String ngayKhoiChieu, String phongChieu, String gioChieu, String soLuongVe, String gheDaChon, String thanhToan, String tongTien) {
        TenPhim = tenPhim;
        Email = email;
        this.ngayKhoiChieu = ngayKhoiChieu;
        this.phongChieu = phongChieu;
        this.gioChieu = gioChieu;
        this.soLuongVe = soLuongVe;
        this.gheDaChon = gheDaChon;
        this.thanhToan = thanhToan;
        this.tongTien = tongTien;
    }

    public int getMaLichSu() {
        return MaLichSu;
    }

    public void setMaLichSu(int maLichSu) {
        MaLichSu = maLichSu;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String tenPhim) {
        TenPhim = tenPhim;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNgayKhoiChieu() {
        return ngayKhoiChieu;
    }

    public void setNgayKhoiChieu(String ngayKhoiChieu) {
        this.ngayKhoiChieu = ngayKhoiChieu;
    }

    public String getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(String phongChieu) {
        this.phongChieu = phongChieu;
    }

    public String getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(String gioChieu) {
        this.gioChieu = gioChieu;
    }

    public String getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(String soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public String getGheDaChon() {
        return gheDaChon;
    }

    public void setGheDaChon(String gheDaChon) {
        this.gheDaChon = gheDaChon;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }
}
