package com.iningke.zhangzhq.base;

import android.widget.Toast;

import com.iningke.baseproject.BaseFragment;
import com.iningke.baseproject.net.callback.GActivityCallback;
import com.iningke.zhangzhq.MyApp;

/**
 * Created by hxy on  2016/11/14.
 */
public abstract class ZhangzhqFragment extends BaseFragment implements GActivityCallback {

    @Override
    public void success(Object obj, int requestCode) {

    }

    @Override
    public void onFaild(int requestCode, boolean isCancell, Throwable ex) {
        Toast.makeText(MyApp.getMyApplication(), "网络不稳定", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResult(int resultCode, Object... obj) {

    }

    @Override
    public void onNetStart() {

    }

    @Override
    public void onNetFinish() {

    }
}
