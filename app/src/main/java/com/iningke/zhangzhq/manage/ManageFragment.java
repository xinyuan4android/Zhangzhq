package com.iningke.zhangzhq.manage;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
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
public class ManageFragment extends ZhangzhqFragment {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.manage_img_queryWater)
    ImageView manageImgQueryWater;
    @Bind(R.id.manage_img_queryElectric)
    ImageView manageImgQueryElectric;
    @Bind(R.id.manage_img_queryOxygen)
    ImageView manageImgQueryOxygen;

    public ManageFragment() {
        // Required empty public constructor
    }


    @Override
    public int setLayoutId() {
        return R.layout.fragment_manage;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MyApp.getCurrentFragment() == App.Currentpage_ManageFragment) {
            LogUtils.e("-------------manageFragment  onResume-------------");
        }
    }

    @Override
    public void initView(View view) {
        commonTxtTitle.setText("水电气管理");
    }

    @Override
    public void initData(View view) {

    }

    @OnClick({R.id.manage_img_queryWater, R.id.manage_img_queryElectric, R.id.manage_img_queryOxygen})
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), ManageQueryActivity.class);
        int type = 0;
        switch (view.getId()) {
            case R.id.manage_img_queryWater:
                type = 10;
                break;
            case R.id.manage_img_queryElectric:
                type = 20;
                break;
            case R.id.manage_img_queryOxygen:
                type = 30;
                break;
        }
        intent.putExtra("type", type);
        startActivity(intent);
    }
}
