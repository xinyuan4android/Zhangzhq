package com.iningke.zhangzhq.mine.workorder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.MineFixListGridViewAdapter;
import com.iningke.zhangzhq.adapter.MineFixPullToListViewAdapter;
import com.iningke.zhangzhq.base.ZhangzhqFragment;
import com.iningke.zhangzhq.bean.BeanMineFixPullToListView;
import com.iningke.zhangzhq.inter.App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFixFragment extends ZhangzhqFragment implements MineFixListGridViewAdapter.MyGridViewOnItemClickListener, MineFixPullToListViewAdapter.MyFixPullToBtnOnClickListener, AdapterView.OnItemClickListener
        , PullToRefreshBase.OnRefreshListener2 {
    private PullToRefreshListView pullTo;
    private List<BeanMineFixPullToListView> dataSource = new ArrayList<>();
    private MineFixPullToListViewAdapter adapter;
    private int role;

    public MineFixFragment() {
        // Required empty public constructor
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_mine_fix;
    }

    @Override
    public void initView(View view) {
        Bundle arguments = getArguments();
        int orderState = arguments.getInt("orderState", -1);
        role = arguments.getInt("role", -1);
        pullTo = (PullToRefreshListView) view.findViewById(R.id.mine_fix_pullToListView);
        aboutPullTo();
    }

    private void aboutPullTo() {
        pullTo.setMode(PullToRefreshBase.Mode.BOTH);
        pullTo.setOnRefreshListener(this);
        List<String> imgUrls = new ArrayList<>();
        Collections.addAll(imgUrls, "http://img1.imgtn.bdimg.com/it/u=2308329143,2620506960&fm=23&gp=0.jpg",
                "http://img1.imgtn.bdimg.com/it/u=3315889182,1097209493&fm=23&gp=0.jpg",
                "http://img1.imgtn.bdimg.com/it/u=2623974986,2629351623&fm=23&gp=0.jpg");
        BeanMineFixPullToListView bean1 = new BeanMineFixPullToListView("35875342", "2012-12 14:50", 1,
                "员工宿舍1", "门坏了又1", imgUrls);
        BeanMineFixPullToListView bean2 = new BeanMineFixPullToListView("358753422", "2012-12 14:52", 2,
                "员工宿舍2", "门坏了又2", imgUrls.subList(1, 2));
        BeanMineFixPullToListView bean3 = new BeanMineFixPullToListView("358753423", "2012-12 14:53", 3,
                "员工宿舍3", "门坏了又3", imgUrls.subList(0, 1));
        BeanMineFixPullToListView bean4 = new BeanMineFixPullToListView("358753424", "2012-12 14:54", 4,
                "员工宿舍4", "门坏了又4", new ArrayList<String>());
        BeanMineFixPullToListView bean5 = new BeanMineFixPullToListView("358753425", "2012-12 14:55", 5,
                "员工宿舍5", "门坏了又5", imgUrls.subList(1, 1));
        Collections.addAll(dataSource, bean1, bean2, bean3, bean4, bean5);
        adapter = new MineFixPullToListViewAdapter(dataSource, this, this, this);
        pullTo.setAdapter(adapter);
        pullTo.setOnItemClickListener(this);
    }

    @Override
    public void initData(View view) {

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

    /**
     * gridview 图片的点击事件
     *
     * @param position
     * @param position_parent
     */
    @Override
    public void onMyGridItemClick(int position, int position_parent) {
        Toast.makeText(getContext(), dataSource.get(position_parent).getTitle() + "position" + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void myFixPullToBtnOnClickLeft(View view, int position) {
        TextView v = (TextView) view;
        Toast.makeText(getContext(), v.getText().toString() + "position" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void myFixPullToBtnOnClickRight(View view, int position) {
        TextView v = (TextView) view;
        Toast.makeText(getContext(), v.getText().toString() + "position" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (role) {
            case App.type_role_notWorkMan:
                Intent intent = new Intent(getContext(), WorkOrderDetailActivity.class);
                intent.putExtra("state", dataSource.get(position - 1).getState());
                startActivity(intent);
                break;
            case App.type_role_workMan:
                Intent intent2 = new Intent(getContext(), WorkOrderDetailWorkManActivity.class);
                intent2.putExtra("state", dataSource.get(position - 1).getState());
                startActivity(intent2);
                break;
        }

    }

    public int getRole() {
        return role;
    }
}
