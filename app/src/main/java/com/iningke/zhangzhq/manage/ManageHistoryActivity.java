package com.iningke.zhangzhq.manage;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.ManageHistoryAdapter;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.bean.BeanManageHistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class ManageHistoryActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.manage_history_amountInfo)
    TextView manageHistoryAmountInfo;
    @Bind(R.id.manage_history_moneyInfo)
    TextView manageHistoryMoneyInfo;
    private PullToRefreshListView pullTo;
    private ManageHistoryAdapter adapter;
    private List<BeanManageHistory> dataSource = new ArrayList<>();

    @Override

    public int setLayoutId() {
        return R.layout.activity_manage_history;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("历史记录");
        commonImgBack.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", -1);
        switch (type) {
            case 10:
                manageHistoryAmountInfo.setText("水量");
                manageHistoryMoneyInfo.setText("电费");
                break;
            case 20:
                manageHistoryAmountInfo.setText("电量");
                manageHistoryMoneyInfo.setText("电费");
                break;
            case 30:
                manageHistoryAmountInfo.setText("氧气量");
                manageHistoryMoneyInfo.setText("氧气费");
                break;
        }
        pullTo = (PullToRefreshListView) findViewById(R.id.manage_history_pullToListView);
        aboutPullTo();
    }

    private void aboutPullTo() {
        pullTo.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        pullTo.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                //上啦加载
                pullTo.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullTo.onRefreshComplete();
                    }
                }, 1000);
            }
        });
        BeanManageHistory bean1 = new BeanManageHistory("2016-1", "21.11", "25");
        BeanManageHistory bean2 = new BeanManageHistory("2016-2", "22.11", "25");
        BeanManageHistory bean3 = new BeanManageHistory("2016-3", "23.11", "425");
        BeanManageHistory bean4 = new BeanManageHistory("2016-4", "24.11", "525");
        BeanManageHistory bean5 = new BeanManageHistory("2016-5", "25.11", "625");
        Collections.addAll(dataSource, bean1, bean2, bean3, bean4, bean5);
        adapter = new ManageHistoryAdapter(dataSource);
        pullTo.setAdapter(adapter);
    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }
}
