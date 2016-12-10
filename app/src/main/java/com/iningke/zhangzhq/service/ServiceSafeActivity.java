package com.iningke.zhangzhq.service;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 维修服务-维护巡检 界面
 *
 * @author hxy
 * @date 2016/12/3
 */
public class ServiceSafeActivity extends ZhangzhqActivity {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.service_safe_txt_selectName)
    TextView serviceSafeTxtSelectName;
    @Bind(R.id.service_safe_linear_selectName)
    LinearLayout serviceSafeLinearSelectName;
    @Bind(R.id.service_safe_edit_selectAddress)
    EditText serviceSafeEditSelectAddress;
    @Bind(R.id.service_safe_linear_selectAddress)
    LinearLayout serviceSafeLinearSelectAddress;
    @Bind(R.id.service_applyFix_edit_detail)
    EditText serviceApplyFixEditDetail;
    @Bind(R.id.service_safe_txt_selectTime)
    TextView serviceSafeTxtSelectTime;
    @Bind(R.id.service_safe_linear_selectTime)
    LinearLayout serviceSafeLinearSelectTime;
    @Bind(R.id.service_safe_txt_selectPerson)
    TextView serviceSafeTxtSelectPerson;
    @Bind(R.id.service_safe_linear_selectPerson)
    LinearLayout serviceSafeLinearSelectPerson;
    @Bind(R.id.service_safe_txtBtn)
    TextView serviceSafeTxtBtn;

    @Override
    public int setLayoutId() {
        return R.layout.activity_service_safe;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        commonTxtTitle.setText("维修巡检");
        Intent intent = getIntent();
        int applicationsId = intent.getIntExtra("applicationsId", -1);
        if (applicationsId < 0) {
            serviceSafeTxtBtn.setVisibility(View.VISIBLE);
            serviceSafeLinearSelectPerson.setVisibility(View.VISIBLE);
            serviceSafeEditSelectAddress.setEnabled(true);
            serviceApplyFixEditDetail.setEnabled(true);
            serviceSafeLinearSelectName.setClickable(true);
        }
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.service_safe_linear_selectName, R.id.service_safe_linear_selectAddress, R.id.service_safe_linear_selectTime, R.id.service_safe_linear_selectPerson, R.id.service_safe_txtBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.service_safe_linear_selectName:
                break;
            case R.id.service_safe_linear_selectAddress:
                break;
            case R.id.service_safe_linear_selectTime:
                break;
            case R.id.service_safe_linear_selectPerson:
                break;
            case R.id.service_safe_txtBtn:
                //提交维护巡检
                finish();
                break;
        }
    }
}
