package com.iningke.zhangzhq.base;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;

import com.iningke.baseproject.BaseActivity;
import com.iningke.baseproject.net.callback.GActivityCallback;
import com.iningke.zhangzhq.MyApp;

/**
 * Created by hxy on  2016/11/14.
 */
public abstract class ZhangzhqActivity extends BaseActivity implements GActivityCallback {


    @Override
    public View setLayoutView() {
        MyApp.getMyApplication().setMyCurrentActivity(this);
        return null;
    }

    @Override
    public void success(Object obj, int requestCode) {

    }


    @Override
    public void onFaild(int requestCode, boolean isCancell, Throwable ex) {
        Toast.makeText(ZhangzhqActivity.this, "网络不稳定", Toast.LENGTH_SHORT).show();
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

    protected void checkPermission(String perission, int request_code) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, perission) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                ActivityCompat.requestPermissions(this, new String[]{perission},
                        request_code);
                return;
            } else
                //已经允许权限，直接调用方法
                permissionGrant(request_code);
        } else
            //android系统6.0以下，直接调用方法
            permissionGrant(request_code);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        doNext(requestCode, grantResults);
    }

    private void doNext(int requestCode, int[] grantResults) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permission Granted
            permissionGrant(requestCode);
        } else {
            // Permission Denied
            permissionDenied(requestCode);
        }

    }

    /**
     * 权限申请拒绝后，执行的代码
     *
     * @param requestCode
     */
    protected void permissionDenied(int requestCode) {

    }

    ;

    /**
     * 权限申请成功后，代码
     *
     * @param requestCode
     */
    protected void permissionGrant(int requestCode) {
    }

    ;
}
