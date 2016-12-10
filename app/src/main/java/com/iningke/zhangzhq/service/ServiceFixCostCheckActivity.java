package com.iningke.zhangzhq.service;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.mine.workorder.MineFixFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 维修费用审核 界面
 *
 * @author hxy
 * @date 2016/12/9
 */

public class ServiceFixCostCheckActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_txt_right)
    TextView commonTxtRight;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.service_fixCostCheck_linearContainer)
    LinearLayout serviceFixCostCheckLinearContainer;

    @Override
    public int setLayoutId() {
        return R.layout.activity_service_fix_cost_check;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("维修费用查询");
        commonImgBack.setVisibility(View.VISIBLE);
        MineFixFragment mineFixFragment = new MineFixFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("orderState", App.state_wait_check);
        bundle.putInt("role", App.type_role_notWorkMan);
        mineFixFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.service_fixCostCheck_linearContainer, mineFixFragment).commit();
    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }
}
