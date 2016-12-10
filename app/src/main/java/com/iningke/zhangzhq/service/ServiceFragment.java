package com.iningke.zhangzhq.service;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.baseproject.utils.LogUtils;
import com.iningke.zhangzhq.MyApp;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqFragment;
import com.iningke.zhangzhq.inter.App;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends ZhangzhqFragment {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.service_linear_applyFix)
    LinearLayout serviceLinearApplyFix;
    @Bind(R.id.service_linear_queryInformation)
    LinearLayout serviceLinearQueryInformation;
    @Bind(R.id.service_linear_queryCost)
    LinearLayout serviceLinearQueryCost;
    @Bind(R.id.service_linear_save)
    LinearLayout serviceLinearSave;

    public ServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public int setLayoutId() {
        return R.layout.fragment_service;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MyApp.getCurrentFragment() == App.Currentpage_ServiceFragment) {
            LogUtils.e("-------------serviceFragment  onResume-------------");
        }
    }

    @Override
    public void initView(View view) {
        commonTxtTitle.setText("维修服务");
    }

    @Override
    public void initData(View view) {

    }

    @OnClick({R.id.service_linear_applyFix, R.id.service_linear_save, R.id.service_linear_checkCost, R.id.service_linear_queryInformation, R.id.service_linear_queryCost})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.service_linear_applyFix:
                //我要报修
                Intent intent = new Intent(getContext(), ServiceApplyFixActivity.class);
                startActivity(intent);
                break;
            case R.id.service_linear_queryInformation:
                //维修资料查询
                Intent intent2 = new Intent(getContext(), ServiceQueryInformationActivity.class);
                startActivity(intent2);
                break;
            case R.id.service_linear_queryCost:
                //维修费用查询
                Intent intent3 = new Intent(getContext(), ServiceQueryCostActivity.class);
                startActivity(intent3);
                break;
            case R.id.service_linear_checkCost:
                //维修费用审核
//                Intent intent1 = new Intent(getContext(), ServiceQueryCostDetailActivity.class);
//                startActivity(intent1);
                startActivity(new Intent(getContext(), ServiceFixCostCheckActivity.class));
                break;
            case R.id.service_linear_save:
                //维护巡检
                startActivity(new Intent(getContext(), ServiceSafeActivity.class));
                break;
        }
    }
}
