package com.iningke.zhangzhq;

import android.util.DisplayMetrics;

import com.iningke.baseproject.utils.LogUtils;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

public class TextActivity extends ZhangzhqActivity {


    @Override
    public int setLayoutId() {
        return R.layout.activity_text;
    }

    @Override
    public void initView() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int densityDpi = metric.densityDpi;
        LogUtils.e("densityDpi == "+densityDpi);
    }

    @Override
    public void initData() {

    }


}
