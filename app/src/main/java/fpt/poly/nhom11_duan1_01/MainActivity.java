package fpt.poly.nhom11_duan1_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import fpt.poly.nhom11_duan1_01.Fragment.FragmentHome;
import fpt.poly.nhom11_duan1_01.Fragment.FragmentLichChieu;
import fpt.poly.nhom11_duan1_01.Fragment.FragmentLichSu;
import fpt.poly.nhom11_duan1_01.Fragment.FragmentPhim;
import fpt.poly.nhom11_duan1_01.Fragment.FragmentTheLoai;
import fpt.poly.nhom11_duan1_01.Fragment.FragmentThongKe;
import fpt.poly.nhom11_duan1_01.Fragment.FragmentVoucher;
import fpt.poly.nhom11_duan1_01.Intro.DangNhap_Activity;

public class MainActivity extends AppCompatActivity {
   BottomNavigationView bottomNavigationView;
   NavigationView navigationView;
   Toolbar toolbar;
 DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigationView);
        View v=navigationView.getHeaderView(0);
        setSupportActionBar(toolbar);
      drawerLayout=findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        bottomNavigationView=findViewById(R.id.btnNavigation);
        FragmentHome frg=new FragmentHome();
        replec(frg);
        // xử lý khi click vào navigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.da1_navmenu_Phim){
                    FragmentPhim frg=new FragmentPhim();
                    replec(frg);
                } else if (item.getItemId()==R.id.da1_navmenu_Voucher) {
                    FragmentVoucher frg=new FragmentVoucher();
                    replec(frg);
                } else if (item.getItemId()==R.id.da1_navmenu_TheLoai) {
                    FragmentTheLoai frg = new FragmentTheLoai();
                    replec(frg);
                }else if (item.getItemId()==R.id.da1_navmenu_LichChieu) {
                    FragmentLichChieu frg=new FragmentLichChieu();
                    replec(frg);
                }else if (item.getItemId()==R.id.da1_navmenu_LichSu) {
                    FragmentLichSu frg=new FragmentLichSu();
                    replec(frg);
                }else if (item.getItemId()==R.id.da1_navmenu_ThongKeDoanhThu) {
                    FragmentThongKe frg=new FragmentThongKe();
                    replec(frg);
                }else if (item.getItemId()==R.id.da1_navmenu_DangXuat) {
                    Intent intent1= new Intent(MainActivity.this, DangNhap_Activity.class);
                    startActivity(intent1);
                }
                return true;
            }
        });

    }
    public void replec(Fragment fragment) {
        FragmentManager frg = getSupportFragmentManager();
        frg.beginTransaction().replace(R.id.frmBai3, fragment).commit();
    }
    // set tên  toobal
    public void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}