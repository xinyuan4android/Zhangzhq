package com.iningke.zhangzhq.utils;

import android.content.Context;
import android.util.DisplayMetrics;

import com.iningke.zhangzhq.MyApp;

/**
 * Created by iningke on 2016/7/19.
 */
public class UIUtils {
    /**
     * 全局上下文对象
     *
     * @return 上下文
     */
    public static Context getContext() {
        return MyApp.getMyApplication();
    }

    /**
     * dip转换px
     */
    public static int dip2px(int dip) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * pxz转换dip
     */
    public static int px2dip(int px) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 屏幕宽度
     *
     * @return
     */
    public static int getDisplayWidth() {
        DisplayMetrics outMetrics = new DisplayMetrics();
        MyApp.getMyApplication().getMyCurrentActivity().getWindowManager().getDefaultDisplay()
                .getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static int getDisplayHeight() {
        DisplayMetrics outMetrics = new DisplayMetrics();
        MyApp.getMyApplication().getMyCurrentActivity().getWindowManager().getDefaultDisplay()
                .getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }
}
