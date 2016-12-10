package com.iningke.zhangzhq.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.iningke.zhangzhq.MyApp;


/**
 * Created by iningke on 2016/7/7.
 */
public class PackageUtils {
    /**
     * 全局上下文对象
     *
     * @return 上下文
     */
    public static Context getContext() {
        return MyApp.getApplication();
    }

    public static String getVersion(Context context) {
        String version = "1.0";
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo packageInfo = manager.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            version = packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    public static String getPackageName() {
        String packageName = getContext().getPackageName();
        LogUtils.e("packageName== " + packageName);
        return packageName;
    }
}
