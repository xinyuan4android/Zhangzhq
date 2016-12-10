package com.iningke.zhangzhq.utils;

import android.content.Intent;
import android.net.Uri;

import com.iningke.zhangzhq.MyApp;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.inter.App;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hxy on  2016/11/18.
 */
public class AppUtils {
    /**
     * 获取类型（R.mipmap.xxx）
     *
     * @param state
     * @return
     */
    public static int getState(int state) {
        switch (state) {
            case App.state_wait_accept:
                return R.mipmap.item_state_waitaccept;
            case App.state_wait_check:
                return R.mipmap.item_state_waitcheck;
            case App.state_wait_fix:
                return R.mipmap.item_state_waitfix;
            case App.state_wait_comment:
                return R.mipmap.item_state_waitcomment;
            default:
                return R.mipmap.item_state_waitaccept;
        }
    }

    /**
     * 获取 类型 （String）
     *
     * @param state
     * @return
     */
    public static String getStringState(int state) {
        switch (state) {
            case App.state_wait_accept:
                return App.state_string_wait_accept;
            case App.state_wait_check:
                return App.state_string_wait_check;
            case App.state_wait_comment:
                return App.state_string_wait_comment;
            case App.state_wait_fix:
                return App.state_string_wait_fix;
            case App.state_wait_finish:
                return App.state_string_wait_finish;
            default:
                return "";
        }
    }

    /**
     * 拨打电话
     *
     * @param phoneNumber
     */
    public static void callPhone(String phoneNumber) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(phoneNumber);
        if (isNum.matches()) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri data = Uri.parse("tel:" + phoneNumber);
            intent.setData(data);
            MyApp.getMyApplication().getMyCurrentActivity().startActivity(intent);
        }
    }
}
