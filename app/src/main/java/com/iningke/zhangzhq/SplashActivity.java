package com.iningke.zhangzhq;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.iningke.zhangzhq.utils.PackageUtils;


public class SplashActivity extends AppCompatActivity {

    private ImageView img;
    private String version;
    private String newVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        aboutJump();
    }

    private void aboutJump() {
        SharedPreferences sp = getSharedPreferences("version", MODE_PRIVATE);
        version = sp.getString("version", null);

        newVersion = PackageUtils.getVersion(this);

        handler.sendEmptyMessageDelayed(100, 2000);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = null;
            if (newVersion.equals(version)) {
                intent = new Intent(SplashActivity.this, MainActivity.class);
            } else {
                intent = new Intent(SplashActivity.this, GuideActivity.class);
            }
            startActivity(intent);
            finish();
        }
    };

    private void initView() {
        img = (ImageView) findViewById(R.id.splash_img);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(100);
    }
}
