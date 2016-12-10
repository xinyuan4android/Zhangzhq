package com.iningke.zhangzhq.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.DeviceInformationListViewAdapter;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.bean.BeanDeviceInformationList;

import java.util.Collections;
import java.util.LinkedList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 设备信息 activity
 *
 * @author hxy
 * @date 2016/11/28
 */
public class DeviceInformationActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.deviceInformation_lsitView)
    ListView deviceInformationLsitView;

    private LinkedList<BeanDeviceInformationList> dataSource = new LinkedList<>();
    private DeviceInformationListViewAdapter adapter;

    @Override

    public int setLayoutId() {
        return R.layout.activity_device_information;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("设备信息");
        commonImgBack.setVisibility(View.VISIBLE);
        aboutListView();
    }

    private void aboutListView() {
        BeanDeviceInformationList bean1 = new BeanDeviceInformationList("设备名称1", "电脑");
        BeanDeviceInformationList bean2 = new BeanDeviceInformationList("设备名称2", "电脑");
        BeanDeviceInformationList bean3 = new BeanDeviceInformationList("设备名称3", "电脑");
        BeanDeviceInformationList bean4 = new BeanDeviceInformationList("设备名称4", "电脑");
        BeanDeviceInformationList bean5 = new BeanDeviceInformationList("设备名称5", "电脑");
        BeanDeviceInformationList bean6 = new BeanDeviceInformationList("设备名称6", "电脑");
        Collections.addAll(dataSource, bean1, bean2, bean3, bean4, bean5, bean6);
        adapter = new DeviceInformationListViewAdapter(dataSource);
        deviceInformationLsitView.setAdapter(adapter);

    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }
}
