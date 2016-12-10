package com.iningke.baseproject.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/**
 * Created by iningke on 2016/6/7.
 */

public class DialogUtils {
    private static Dialog dialog;
    public static Dialog initDialog(Context context, int id){
        if (dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
        }
        dialog = new Dialog(context);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(context).inflate(id,null);
        dialog.setContentView(view);
        return dialog;
    }
    public static void showDialog(Context context,int id){
        initDialog(context,id);
        dialog.show();
    }

    /*
 * 获取对话框的窗口对象及参数对象以修改对话框的布局设置,
* 可以直接调用getWindow(),表示获得这个Activity的Window
* 对象,这样这可以以同样的方式改变这个Activity的属性.
*/
//    Window dialogWindow = dialog.getWindow();
//    WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//    dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);


/*
* lp.x与lp.y表示相对于原始位置的偏移.
* 当参数值包含Gravity.LEFT时,对话框出现在左边,所以lp.x就表示相对左边的偏移,负值忽略.
* 当参数值包含Gravity.RIGHT时,对话框出现在右边,所以lp.x就表示相对右边的偏移,负值忽略.
* 当参数值包含Gravity.TOP时,对话框出现在上边,所以lp.y就表示相对上边的偏移,负值忽略.
* 当参数值包含Gravity.BOTTOM时,对话框出现在下边,所以lp.y就表示相对下边的偏移,负值忽略.
* 当参数值包含Gravity.CENTER_HORIZONTAL时
* ,对话框水平居中,所以lp.x就表示在水平居中的位置移动lp.x像素,正值向右移动,负值向左移动.
* 当参数值包含Gravity.CENTER_VERTICAL时
* ,对话框垂直居中,所以lp.y就表示在垂直居中的位置移动lp.y像素,正值向右移动,负值向左移动.
* gravity的默认值为Gravity.CENTER,即Gravity.CENTER_HORIZONTAL |
* Gravity.CENTER_VERTICAL.
*
*/
//    lp.x = 100; // 新位置X坐标
//    lp.y = 100; // 新位置Y坐标
//    lp.width = 300; // 宽度
//    lp.height = 300; // 高度
//    lp.alpha = 0.7f; // 透明度


// 当Window的Attributes改变时系统会调用此函数,可以直接调用以应用上面对窗口参数的更改,也可以用setAttributes
// dialog.onWindowAttributesChanged(lp);
//    dialogWindow.setAttributes(lp);


/*
* 将对话框的大小按屏幕大小的百分比设置
*/
// WindowManager m = getWindowManager();
// Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
// WindowManager.LayoutParams p = getWindow().getAttributes(); // 获取对话框当前的参数值
// p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
// p.width = (int) (d.getWidth() * 0.65); // 宽度设置为屏幕的0.95
// dialogWindow.setAttributes(p);
}
