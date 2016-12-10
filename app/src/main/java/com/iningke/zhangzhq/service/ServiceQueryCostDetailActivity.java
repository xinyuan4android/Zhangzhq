package com.iningke.zhangzhq.service;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.myview.MyGridView;

import butterknife.Bind;
import butterknife.OnClick;

public class ServiceQueryCostDetailActivity extends ZhangzhqActivity {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.service_queryCost_detail_projectName)
    TextView serviceQueryCostDetailProjectName;
    @Bind(R.id.service_queryCost_detail_materialName)
    TextView serviceQueryCostDetailMaterialName;
    @Bind(R.id.service_queryCost_detail_count)
    TextView serviceQueryCostDetailCount;
    @Bind(R.id.service_queryCost_detail_price)
    TextView serviceQueryCostDetailPrice;
    @Bind(R.id.service_queryCost_detail_time)
    TextView serviceQueryCostDetailTime;
    @Bind(R.id.service_queryCost_detail_otherFee)
    TextView serviceQueryCostDetailOtherFee;
    @Bind(R.id.service_queryCost_detail_totalAmount)
    TextView serviceQueryCostDetailTotalAmount;
    @Bind(R.id.service_queryCost_detail_gridView)
    MyGridView serviceQueryCostDetailGridView;
    @Bind(R.id.service_queryCost_detail_information)
    TextView serviceQueryCostDetailInformation;

    @Override
    public int setLayoutId() {
        return R.layout.activity_service_query_cost_detail;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("维修审核单");
        commonImgBack.setVisibility(View.VISIBLE);
        aboutGridView();

    }

    private void aboutGridView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_service_querycost_detail_workergridview, R.id.item_service_queryCost_detail_workerGridView,
                new String[]{"做工人员1", "工作人员2", "工作人员3", "工作人员4", "工作人员5"});
        serviceQueryCostDetailGridView.setAdapter(adapter);
    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }
}
