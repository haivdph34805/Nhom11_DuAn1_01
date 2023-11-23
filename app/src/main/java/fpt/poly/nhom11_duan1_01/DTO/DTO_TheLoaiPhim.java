package fpt.poly.nhom11_duan1_01.DTO;

public class DTO_TheLoaiPhim {
    private int getMaTheLoai;
    private String tenTheLoai;
    private String imageTheLoai;

    public DTO_TheLoaiPhim() {
    }

    public DTO_TheLoaiPhim(int getMaTheLoai, String tenTheLoai, String imageTheLoai) {
        this.getMaTheLoai = getMaTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.imageTheLoai = imageTheLoai;
    }

    public DTO_TheLoaiPhim(String tenTheLoai, String imageTheLoai) {
        this.tenTheLoai = tenTheLoai;
        this.imageTheLoai = imageTheLoai;
    }

    public int getGetMaTheLoai() {
        return getMaTheLoai;
    }

    public void setGetMaTheLoai(int getMaTheLoai) {
        this.getMaTheLoai = getMaTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getImageTheLoai() {
        return imageTheLoai;
    }

    public void setImageTheLoai(String imageTheLoai) {
        this.imageTheLoai = imageTheLoai;
    }
}
