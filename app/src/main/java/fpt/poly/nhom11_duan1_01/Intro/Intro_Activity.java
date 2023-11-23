package fpt.poly.nhom11_duan1_01.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fpt.poly.nhom11_duan1_01.R;

public class Intro_Activity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private Handler sliderHandler = new Handler();

    private LinearLayout indicatorLayout;
    private int dotsCount;
    private ImageView[] dots;

    AppCompatButton btnDangnhap;
    TextView tvsinup;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        viewPager = findViewById(R.id.viewPager);
        btnDangnhap=findViewById(R.id.da1_Intro_BtnDangNhap);
        tvsinup=findViewById(R.id.TvSignUp);

        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intro_Activity.this, DangNhap_Activity.class);
                startActivity(intent);
            }
        });
//        tvsinup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(introlActivity.this,DangKyActivity.class);
//                startActivity(intent);
//            }
//        });

        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.imageintro1);
        imageList.add(R.drawable.imageintro2);
        imageList.add(R.drawable.imageintro3);
        imageList.add(R.drawable.imageintro4);

        AdapterIntro adapter = new AdapterIntro(imageList);
        viewPager.setAdapter(adapter);
        autoSlide();

        indicatorLayout = findViewById(R.id.indicatorLayout);
        dotsCount = adapter.getItemCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_dot_inactive));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(8, 0, 8, 0);
            indicatorLayout.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_dot_active));

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(Intro_Activity.this, R.drawable.ic_dot_inactive));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(Intro_Activity.this, R.drawable.ic_dot_active));
            }
        });
    }
    private boolean isAutoForward = true; // Biến để kiểm tra xem slider đang tự động chạy về phía trước hay phía sau

    private void autoSlide() {
        sliderHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentPosition = viewPager.getCurrentItem();
                int nextPosition;

                if (isAutoForward) {
                    nextPosition = currentPosition + 1;
                } else {
                    nextPosition = currentPosition - 1;
                }

                if (nextPosition >= viewPager.getAdapter().getItemCount()) {
                    isAutoForward = false;
                    nextPosition = viewPager.getAdapter().getItemCount() - 2;
                } else if (nextPosition < 0) {
                    isAutoForward = true;
                    nextPosition = 1;
                }

                viewPager.setCurrentItem(nextPosition);
                autoSlide();
            }
        }, 5000); // Thời gian chờ giữa các lần chuyển ảnh (3 giây ở đây)
    }
    }

