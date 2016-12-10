package com.iningke.zhangzhq.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.baseproject.utils.LogUtils;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 设备管理-结果 activity
 *
 * @author hxy
 * @date 2016/11/26
 */
public class DeviceManageResultActivity extends ZhangzhqActivity {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.deviceInfo_txt_deviceNo)
    TextView deviceInfoTxtDeviceNo;
    @Bind(R.id.deviceInfo_txt_deviceDate)
    TextView deviceInfoTxtDeviceDate;
    @Bind(R.id.deviceInfo_txt_personSave)
    TextView deviceInfoTxtPersonSave;
    @Bind(R.id.deviceInfo_txt_departmentSave)
    TextView deviceInfoTxtDepartmentSave;
    @Bind(R.id.deviceInfo_txt_chusuoSave)
    TextView deviceInfoTxtChusuoSave;
    @Bind(R.id.deviceInfo_txt_personInput)
    TextView deviceInfoTxtPersonInput;
    @Bind(R.id.deviceInfo_txt_ps)
    TextView deviceInfoTxtPs;
    @Bind(R.id.deviceInfo_linear_factoryInfo)
    LinearLayout deviceInfoLinearFactoryInfo;
    @Bind(R.id.deviceInfo_linear_deviceInfo)
    LinearLayout deviceInfoLinearDeviceInfo;
    @Bind(R.id.deviceInfo_linear_allocationRecord)
    LinearLayout deviceInfoLinearAllocationRecord;
    @Bind(R.id.deviceInfo_linear_scrapTable)
    LinearLayout deviceInfoLinearScrapTable;
    @Bind(R.id.deviceInfo_linear_applications)
    LinearLayout deviceInfoLinearApplications;
    @Bind(R.id.deviceInfo_linear_maintain)
    LinearLayout deviceInfoLinearMaintain;

    @Override
    public int setLayoutId() {
        return R.layout.activity_device_manage_result;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("设备管理");
        commonImgBack.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            int width = extras.getInt("width");
            int height = extras.getInt("height");
            String result = extras.getString("result");
            LogUtils.e("width====" + width + "\nheight--- " + height + "\nresult -=- " + result);
        }
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.deviceInfo_linear_factoryInfo, R.id.deviceInfo_linear_deviceInfo, R.id.deviceInfo_linear_allocationRecord, R.id.deviceInfo_linear_scrapTable, R.id.deviceInfo_linear_applications, R.id.deviceInfo_linear_maintain})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.deviceInfo_linear_factoryInfo:
                //厂商信息
                startActivity(new Intent(this, DeviceInfoFactoryInfoActivity.class));
                break;
            case R.id.deviceInfo_linear_deviceInfo:
                //设备信息
                startActivity(new Intent(this, DeviceInformationActivity.class));
                break;
            case R.id.deviceInfo_linear_allocationRecord:
                break;
            case R.id.deviceInfo_linear_scrapTable:
                break;
            case R.id.deviceInfo_linear_applications:
                break;
            case R.id.deviceInfo_linear_maintain:
                break;
        }
    }
}
