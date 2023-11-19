package fpt.poly.nhom11_duan1_01.Intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;

import fpt.poly.nhom11_duan1_01.R;

public class ManHinhChao_Activity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chao);

        progressBar = findViewById(R.id.progressBar);
        // Hiển thị ảnh và vòng tròn xoay

        progressBar.setVisibility(View.VISIBLE);

        // Xoay vòng tròn
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(2000); // Thời gian quay 2 giây
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        progressBar.setAnimation(rotateAnimation);

        // Tạo một Handler để tắt màn hình chào sau 5 giây
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Ẩn ảnh và vòng tròn xoay


                Intent intent=new Intent(ManHinhChao_Activity.this, Intro_Activity.class);
                startActivity(intent);
                // Chuyển đến màn hình chính hoặc màn hình tiếp theo
                // Ví dụ: startMainScreen();
            }
        }, 5000); // 5 giây
    }

    // Hàm để chuyển đến màn hình chính hoặc màn hình tiếp theo
    private void startMainScreen() {
        // Điều hướng đến màn hình chính hoặc màn hình tiếp theo
        // Ví dụ: startActivity(new Intent(this, MainActivity.class));
    }
}