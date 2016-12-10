package com.iningke.baseproject;

import com.iningke.baseproject.net.GNetWorkUtils;
import com.iningke.baseproject.net.callback.GActivityCallback;

import org.xutils.http.RequestParams;

/**
 * Created by iningke on 2016/6/4.
 */

public class BasePre extends GNetWorkUtils {
    public GActivityCallback callback;

    public BasePre(GActivityCallback callback) {
        this.callback = callback;
    }

    public RequestParams getParamas(String url){
        RequestParams params = new RequestParams(url);
        return params;
    }

    @Override
    public void onNetStart() {
        super.onNetStart();
        if (callback!=null){
            callback.onNetStart();
        }
    }

    @Override
    public void onNetFinish() {
        super.onNetFinish();
        if (callback!=null){
            callback.onNetFinish();
        }
    }
}
