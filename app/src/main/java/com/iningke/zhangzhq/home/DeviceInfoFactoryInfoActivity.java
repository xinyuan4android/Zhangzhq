package com.iningke.zhangzhq.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 设备管理-设备信息-厂商信息
 *
 * @author hxy
 * @date 2016/11/26
 */
public class DeviceInfoFactoryInfoActivity extends ZhangzhqActivity {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;

    @Override
    public int setLayoutId() {
        return R.layout.activity_device_info_factory_info;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("厂商信息");
        commonImgBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }
}
