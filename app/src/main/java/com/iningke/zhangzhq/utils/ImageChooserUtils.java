package com.iningke.zhangzhq.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.iningke.zhangzhq.MyApp;

/**
 * Created by iningke on 2016/7/27.
 */
public class ImageChooserUtils {
    /**
     * 全局上下文对象
     *
     * @return 上下文
     */
    public static Context getContext() {
        return MyApp.getMyApplication();
    }

    private static final String FILE = "b_chooser_prefs";
    private static final String FOLDER_NAME = "folder_name";
    private SharedPreferences preferences;

    public ImageChooserUtils() {
        this.preferences = getContext().getSharedPreferences("b_chooser_prefs", 0);
    }

    public void setFolderName(String folderName) {
        SharedPreferences.Editor editor = this.preferences.edit();
        editor.putString("folder_name", folderName);
        editor.commit();
    }

    public String getFolderName() {
        return this.preferences.getString("folder_name", "bichooser");
    }
}
