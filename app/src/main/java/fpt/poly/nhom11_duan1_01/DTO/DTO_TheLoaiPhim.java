package fpt.poly.nhom11_duan1_01.DTO;

public class DTO_TheLoaiPhim {
    private int ID_TL;
    private String TenTheLoai;

    public DTO_TheLoaiPhim() {
    }

    public DTO_TheLoaiPhim(int ID_TL, String tenTheLoai) {
        this.ID_TL = ID_TL;
        TenTheLoai = tenTheLoai;
    }

    public DTO_TheLoaiPhim(String tenTheLoai) {
        TenTheLoai = tenTheLoai;
    }

    public int getID_TL() {
        return ID_TL;
    }

    public void setID_TL(int ID_TL) {
        this.ID_TL = ID_TL;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        TenTheLoai = tenTheLoai;
    }
}
