package com.iningke.zhangzhq.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.iningke.zhangzhq.R;


/**
 * Created by iningke on 2016/8/5.
 */
public abstract class BasePopWindow<T> {
    private T listener;
    private PopupWindow popupWindow;
    private View contentView;
    private boolean cancelOnTouchOutside = true;

    public PopupWindow initPopupWindow(Context context, @LayoutRes int parentId, T listener) {
        this.listener = listener;
        contentView = LayoutInflater.from(context).inflate(setLayouId(), null);
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        initView(contentView);

        addListener();

        if (cancelOnTouchOutside) {
            contentView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int height = contentView.findViewById(R.id.pop_layout).getTop();
                    int y = (int) event.getY();
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        if (y < height) {
                            popupWindow.dismiss();
                        }
                    }
                    return true;
                }
            });
        }
        View parent = LayoutInflater.from(context).inflate(parentId, null);
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        return popupWindow;
    }

    public T getListener() {
        return listener;
    }

    public void setListener(T listener) {
        this.listener = listener;
    }

    protected abstract int setLayouId();

    protected abstract void initView(View contentView);


    protected void addListener() {

    }

    /**
     * 点击 popupWindow 外侧是否取消poopuWindow
     *
     * @param cancelOnTouchOutside true取消 ，false 不取消
     */
    public void setCancelOnTouchOutside(boolean cancelOnTouchOutside) {
        this.cancelOnTouchOutside = cancelOnTouchOutside;
    }

    public void disMiss() {
        popupWindow.dismiss();
    }

}
