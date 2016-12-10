package com.iningke.zhangzhq.service;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 维修查询资料结果 activity
 *
 * @author hxy
 * @date 2016/11/21
 */
public class ServiceQueryInformationResultActivity extends ZhangzhqActivity {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;

    @Override
    public int setLayoutId() {
        return R.layout.activity_service_query_information_result;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("维修资料查询");
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
