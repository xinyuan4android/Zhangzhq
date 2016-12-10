package com.iningke.zhangzhq.service;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.ServiceQueryCostDetailPullToAdapter;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.bean.BeanServiceQueryCost;
import com.iningke.zhangzhq.bean.BeanServiceQueryCostDetailPullTo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 维修费用 费用明细
 *
 * @author hxy
 * @date 2016/11/22
 */
public class ServiceQueryCostDetailListActivity extends ZhangzhqActivity implements PullToRefreshBase.OnRefreshListener2, AdapterView.OnItemClickListener {
    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.item_service_queryCost_img)
    ImageView itemServiceQueryCostImg;
    @Bind(R.id.item_service_queryCost_type)
    TextView itemServiceQueryCostType;
    @Bind(R.id.item_service_queryCost_costMoney)
    TextView itemServiceQueryCostCostMoney;
    @Bind(R.id.item_service_queryCost_imgMore)
    ImageView itemServiceQueryCostImgMore;
    private PullToRefreshListView pullTo;
    private ServiceQueryCostDetailPullToAdapter adapter;
    private List<BeanServiceQueryCostDetailPullTo> dataSource = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.activity_service_query_cost_detaillist;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("费用明细");
        commonImgBack.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        BeanServiceQueryCost bean = (BeanServiceQueryCost) intent.getSerializableExtra("BeanServiceQueryCost");
        if (bean != null) {
            itemServiceQueryCostType.setText(bean.getTypeName());
            itemServiceQueryCostCostMoney.setText("￥" + bean.getCostMoney());
            Glide.with(this)
                    .load(bean.getImgUrl())
                    .into(itemServiceQueryCostImg);
            itemServiceQueryCostImgMore.setVisibility(View.GONE);
            pullTo = (PullToRefreshListView) findViewById(R.id.service_queryCost_detail_pullTo);
            aboutPullTo();
        }
    }

    private void aboutPullTo() {
        BeanServiceQueryCostDetailPullTo bean1 = new BeanServiceQueryCostDetailPullTo("2016-11-10", "10.00", "值班室灯泡坏了1");
        BeanServiceQueryCostDetailPullTo bean2 = new BeanServiceQueryCostDetailPullTo("2016-11-10", "10.00", "值班室灯泡坏了2");
        BeanServiceQueryCostDetailPullTo bean3 = new BeanServiceQueryCostDetailPullTo("2016-11-10", "10.00", "值班室灯泡坏了3");
        BeanServiceQueryCostDetailPullTo bean4 = new BeanServiceQueryCostDetailPullTo("2016-11-10", "10.00", "值班室灯泡坏了41");
        BeanServiceQueryCostDetailPullTo bean5 = new BeanServiceQueryCostDetailPullTo("2016-11-10", "10.00", "值班室灯泡坏了51");
        BeanServiceQueryCostDetailPullTo bean6 = new BeanServiceQueryCostDetailPullTo("2016-11-10", "10.00", "值班室灯泡坏了61");
        Collections.addAll(dataSource, bean1, bean2, bean3, bean4, bean5, bean6);
        pullTo.setMode(PullToRefreshBase.Mode.BOTH);
        adapter = new ServiceQueryCostDetailPullToAdapter(dataSource);
        pullTo.setAdapter(adapter);
        pullTo.setOnRefreshListener(this);
        pullTo.setOnItemClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        //下拉刷新
        pullTo.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullTo.onRefreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        //上啦加载
        pullTo.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullTo.onRefreshComplete();
            }
        }, 1000);
    }


    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ServiceQueryCostDetailActivity.class);
        startActivity(intent);
    }
}
