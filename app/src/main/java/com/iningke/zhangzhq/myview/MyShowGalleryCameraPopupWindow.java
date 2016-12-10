package com.iningke.zhangzhq.myview;

import android.view.View;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.BasePopWindow;

/**
 * 选择从相册总选择还是拍照 popupwindow
 * Created by hxy on  2016/11/21.
 */
public class MyShowGalleryCameraPopupWindow extends BasePopWindow<MyShowGalleryCameraPopupWindow.OnMyGalleryAndCameraClickListener> implements View.OnClickListener {


    private TextView popupCamera;
    private TextView popupGallery;
    private TextView popupCancel;

    @Override
    protected int setLayouId() {
        return R.layout.popupwindow_selectcameragallery;
    }

    @Override
    protected void initView(View contentView) {
        popupCamera = (TextView) contentView.findViewById(R.id.popup_camera);
        popupGallery = (TextView) contentView.findViewById(R.id.popup_gallery);
        popupCancel = (TextView) contentView.findViewById(R.id.popup_cancel);

    }

    @Override
    protected void addListener() {
        popupCamera.setOnClickListener(this);
        popupGallery.setOnClickListener(this);
        popupCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.popup_camera:
                //点击相机
                getListener().onMyCameraClick(v);
                break;
            case R.id.popup_gallery:
                //点击相册
                getListener().onMyGalleryClick(v);
                break;
            case R.id.popup_cancel:
                //点击取消
                getListener().onMyCancelClick(v);
                break;
        }
    }

    public interface OnMyGalleryAndCameraClickListener {
        void onMyCameraClick(View view);

        void onMyGalleryClick(View view);

        void onMyCancelClick(View view);
    }
}
