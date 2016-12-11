package com.iningke.zhangzhq;

import android.util.DisplayMetrics;

import com.bumptech.glide.Glide;
import com.iningke.baseproject.utils.LogUtils;
import com.iningke.zhangzhq.activity.MyZoomImageView;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;

public class TextActivity extends ZhangzhqActivity {


    @Bind(R.id.img)
    MyZoomImageView img;

    @Override
    public int setLayoutId() {
        return R.layout.activity_text;
    }

    @Override
    public void initView() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int densityDpi = metric.densityDpi;
        LogUtils.e("densityDpi == " + densityDpi);
        Glide.with(this)
                .load("http://img1.imgtn.bdimg.com/it/u=3315889182,1097209493&fm=23&gp=0.jpg")
                .into(img);
    }

    @Override
    public void initData() {

    }


}
