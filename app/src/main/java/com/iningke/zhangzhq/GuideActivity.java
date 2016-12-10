package com.iningke.zhangzhq;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.iningke.zhangzhq.adapter.GuideViewPagerAdapter;
import com.iningke.zhangzhq.utils.PackageUtils;

import java.util.LinkedList;

public class GuideActivity extends AppCompatActivity implements GuideViewPagerAdapter.MyOnClickListener {
    private ViewPager viewPager;
    private LinkedList<ImageView> imageViews = new LinkedList<>();
    private GuideViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        putVersionToSp();
        initView();
        aboutDataSource();
        aboutViewPager();

    }

    private void aboutDataSource() {
        int[] imgId = new int[]{R.mipmap.guide_img_1, R.mipmap.guide_img_2, R.mipmap.guide_img_3};
        for (int i = 0; i <= 2; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imgId[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);
        }
    }

    private void putVersionToSp() {
        SharedPreferences sp = getSharedPreferences("version", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        String version = PackageUtils.getVersion(this);
        edit.putString("version", version);
        edit.apply();
    }

    private void aboutViewPager() {
        adapter = new GuideViewPagerAdapter(imageViews, this);
        viewPager.setAdapter(adapter);

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.guide_viewPager);
    }

    /**
     * 点击最后一张图片
     *
     * @param view
     */
    @Override
    public void myOnClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
