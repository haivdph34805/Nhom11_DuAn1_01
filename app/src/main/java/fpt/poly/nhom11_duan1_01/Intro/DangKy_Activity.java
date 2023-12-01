package fpt.poly.nhom11_duan1_01.Intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import fpt.poly.nhom11_duan1_01.DAO.NguoiDungDao;
import fpt.poly.nhom11_duan1_01.DTO.NguoiDung;
import fpt.poly.nhom11_duan1_01.R;

public class DangKy_Activity extends AppCompatActivity {
    Button btnDangKy;
    TextInputEditText edtTenDangNhap, hoTen, edtEmail, edtSDT, edtPass, edtEndPass;
    TextView dangnhap;
    private NguoiDungDao nguoiDungDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        hoTen = findViewById(R.id.edtHoTen);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        edtSDT = findViewById(R.id.edtSDT);
        edtEndPass = findViewById(R.id.edtEndPass);
        btnDangKy = findViewById(R.id.btnDangKy);
        dangnhap =findViewById(R.id.txtDangNhap);

        nguoiDungDao = new NguoiDungDao(this);

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DangKy_Activity.this, "Đăng Nhập!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DangKy_Activity.this, DangNhap_Activity.class);
                startActivity(intent);
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenDangNhap= edtTenDangNhap.getText().toString();
                String hoten= hoTen.getText().toString();
                String email = edtEmail.getText().toString();
                String sdt = edtSDT.getText().toString();
                String pass = edtPass.getText().toString();
                String endPass = edtEndPass.getText().toString();


//                if (!isValidPassword(pass)) {
//                    Toast.makeText(DangKy_Activity.this, "Mật khẩu Phải có ít nhất 6 kí tự, 1 chữ cái và 1 số ", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                // Kiểm tra tên đăng nhập không trùng
                if (nguoiDungDao.checkUsernameExists(tenDangNhap)) {
                    Toast.makeText(DangKy_Activity.this, "Tên đăng nhập đã tồn tại", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Kiểm tra Email
                if (nguoiDungDao.checkEmail(email)) {
                    Toast.makeText(DangKy_Activity.this, "Email đã tồn tại", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Kiểm tra SDT
                if (nguoiDungDao.checkSDT(sdt)) {
                    Toast.makeText(DangKy_Activity.this, "SĐT đã tồn tại", Toast.LENGTH_SHORT).show();
                    return;
                }

                NguoiDung nguoiDung = new NguoiDung(tenDangNhap, hoten, email, sdt, pass, 0);
                nguoiDung.setQuyen(0);
                if (tenDangNhap.isEmpty() || hoten.isEmpty() || email.isEmpty() || sdt.isEmpty() || pass.isEmpty() || endPass.isEmpty()){
                    Toast.makeText(DangKy_Activity.this, "Không Được Để Trống", Toast.LENGTH_SHORT).show();
                } else if (!checkEmail(email)) {
                    Toast.makeText(DangKy_Activity.this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
                } else if (!checkPhoneNumber(sdt)) {
                    Toast.makeText(DangKy_Activity.this, "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(endPass)){
                    Toast.makeText(DangKy_Activity.this, "Nhập Lại Mật Khẩu Sai", Toast.LENGTH_SHORT).show();
                } else {
                    if (nguoiDungDao.insert(nguoiDung)){
                        Toast.makeText(DangKy_Activity.this, "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangKy_Activity.this, DangNhap_Activity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(DangKy_Activity.this, "Đăng Kí Thất Bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private boolean checkEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
        return email.matches(emailRegex);
    }
    private boolean checkPhoneNumber(String phoneNumber) {
        String phoneRegex = "^0[0-9]{8,9}$";
        return phoneNumber.matches(phoneRegex);
    }
    private boolean isValidPassword(String password) {
        // Kiểm tra mật khẩu có ít nhất 6 kí tự và phải có ít nhất 1 chữ cái và 1 số
        String pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
        return password.matches(pattern);
    }
}


//btndangKy=findViewById(R.id.da1_DangKy_BtnDangKy);