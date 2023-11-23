package fpt.poly.nhom11_duan1_01.DTO;

public class DTO_ThanhVien {
    private int maThanhVien;
    private String tenThanhVien,namSinh;

    private String gioiTinh;

    public DTO_ThanhVien() {
    }

    public DTO_ThanhVien(int maThanhVien, String tenThanhVien, String namSinh, String gioiTinh) {
        this.maThanhVien = maThanhVien;
        this.tenThanhVien = tenThanhVien;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
    }

    public DTO_ThanhVien(String tenThanhVien, String namSinh, String gioiTinh) {
        this.tenThanhVien = tenThanhVien;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
    }

    public int getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(int maThanhVien) {
        this.maThanhVien = maThanhVien;
    }

    public String getTenThanhVien() {
        return tenThanhVien;
    }

    public void setTenThanhVien(String tenThanhVien) {
        this.tenThanhVien = tenThanhVien;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
