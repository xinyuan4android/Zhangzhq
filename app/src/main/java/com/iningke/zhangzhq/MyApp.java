package com.iningke.zhangzhq;

import android.support.annotation.NonNull;

import com.iningke.baseproject.BaseApp;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.pgyersdk.crash.PgyCrashManager;

//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//   ┃　　　┃   神兽保佑
//   ┃　　　┃   代码无BUG！
//   ┃　　　┗━━━┓
//   ┃　　　　　　　┣┓
//   ┃　　　　　　　┏┛
//   ┗┓┓┏━┳┓┏┛
//     ┃┫┫　┃┫┫
//

/**
 * Created by hxy on  2016/11/11.
 */
public class MyApp extends BaseApp {
    private static MyApp mInstance;
    private static int currentFragment;
    private ZhangzhqActivity myCurrentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        PgyCrashManager.register(this);//蒲公英 初始化
    }

    public static MyApp getmInstance() {
        return mInstance;
    }

    public static void setmInstance(MyApp mInstance) {
        MyApp.mInstance = mInstance;
    }

    public static int getCurrentFragment() {
        return currentFragment;
    }

    public static void setCurrentFragment(int currentFragment) {
        MyApp.currentFragment = currentFragment;
    }

    public static MyApp getMyApplication() {
        return mInstance;
    }

    public ZhangzhqActivity getMyCurrentActivity() {
        return myCurrentActivity;
    }

    public void setMyCurrentActivity(@NonNull ZhangzhqActivity myCurrentActivity) {
        this.myCurrentActivity = myCurrentActivity;
    }
}
