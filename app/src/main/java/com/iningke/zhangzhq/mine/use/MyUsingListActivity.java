package com.iningke.zhangzhq.mine.use;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.MyUsingListAdapter;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.bean.BeanMyUsingList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的领用 activity
 *
 * @author hxy
 * @date 2016/11/24
 */
public class MyUsingListActivity extends ZhangzhqActivity implements PullToRefreshBase.OnRefreshListener2, AdapterView.OnItemClickListener {
    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    private PullToRefreshListView pullTo;
    private MyUsingListAdapter adapter;
    private List<BeanMyUsingList> dataSource = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.activity_my_using_list;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        commonTxtTitle.setText("我的领用");
        pullTo = (PullToRefreshListView) findViewById(R.id.myUsing_pullTo);
        aboutPullTo();
    }

    private void aboutPullTo() {
        pullTo.setMode(PullToRefreshBase.Mode.BOTH);
        BeanMyUsingList bean1 = new BeanMyUsingList("中心静脉导管0", "GSPA-T300", 2, "2016-10-02");
        BeanMyUsingList bean2 = new BeanMyUsingList("中心静脉导管1", "GSPA-T300", 2, "2016-10-02");
        BeanMyUsingList bean3 = new BeanMyUsingList("中心静脉导管2", "GSPA-T300", 2, "2016-10-02");
        BeanMyUsingList bean4 = new BeanMyUsingList("中心静脉导管3", "GSPA-T300", 2, "2016-10-02");
        BeanMyUsingList bean5 = new BeanMyUsingList("中心静脉导管4", "GSPA-T300", 2, "2016-10-02");
        Collections.addAll(dataSource, bean1, bean2, bean4, bean3, bean5);
        adapter = new MyUsingListAdapter(dataSource);
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
        }, 500);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        //上啦加载
        pullTo.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullTo.onRefreshComplete();
            }
        }, 500);
    }

    /**
     * item点击事件
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        position--;
        Toast.makeText(MyUsingListActivity.this, "position ==" + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MyUsingDetailActivity.class);
        intent.putExtra("usingId", position);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }
}
