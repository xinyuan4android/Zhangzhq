package com.iningke.zhangzhq.service;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 维修查询资料 activity
 *
 * @author hxy
 * @date 2016/11/21
 */
public class ServiceQueryInformationActivity extends ZhangzhqActivity {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.service_queryInformation_edit_number)
    EditText serviceQueryInformationEditNumber;
    @Bind(R.id.service_queryInformation_txt_query)
    TextView serviceQueryInformationTxtQuery;

    @Override
    public int setLayoutId() {
        return R.layout.activity_service_query_information;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("维修资料查询");
        commonImgBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.service_queryInformation_txt_query})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.service_queryInformation_txt_query:
                JumpToInformationResult();
                break;
        }
    }

    private void JumpToInformationResult() {
        String s = serviceQueryInformationEditNumber.getText().toString();
        if ("".equals(s) || null == s) {
            Toast.makeText(ServiceQueryInformationActivity.this, "请输入资料编号", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, ServiceQueryInformationResultActivity.class);
        startActivity(intent);
    }
}
