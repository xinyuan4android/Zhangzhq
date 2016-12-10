package com.iningke.zhangzhq.mine.comment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.MyCommentListAdapter;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.bean.BeanMyCommentList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的评论列表 activity
 *
 * @author hxy
 * @date 2016/11/25
 */
public class MyCommentListActivity extends ZhangzhqActivity implements MyCommentListAdapter.MyCommentListDeleteOnClickLlistener, PullToRefreshBase.OnRefreshListener2 {
    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    private PullToRefreshListView pullTo;
    private MyCommentListAdapter adapter;
    private List<BeanMyCommentList> dataSource = new ArrayList<>();

    @Override

    public int setLayoutId() {
        return R.layout.activity_my_comment_list;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        commonTxtTitle.setText("我的评论");
        pullTo = (PullToRefreshListView) findViewById(R.id.myCommentList_pullTo);
        aboutPullTo();
    }

    private void aboutPullTo() {
        pullTo.setMode(PullToRefreshBase.Mode.BOTH);
        BeanMyCommentList bean1 = new BeanMyCommentList("84513212", "嗨呀，真的是6。厉害了我的哥", "2016-4-5");
        BeanMyCommentList bean2 = new BeanMyCommentList("84513213", "嗨呀，真的是6。厉害了我的哥", "2016-4-5");
        BeanMyCommentList bean3 = new BeanMyCommentList("84513214", "嗨呀，真的是6。厉害了我的哥", "2016-4-5");
        BeanMyCommentList bean4 = new BeanMyCommentList("84513215", "嗨呀，真的是6。厉害了我的哥", "2016-4-5");
        BeanMyCommentList bean5 = new BeanMyCommentList("84513216", "嗨呀，真的是6。厉害了我的哥", "2016-4-5");
        Collections.addAll(dataSource, bean1, bean2, bean4, bean3, bean5);
        adapter = new MyCommentListAdapter(dataSource, this);
        pullTo.setAdapter(adapter);
        pullTo.setOnRefreshListener(this);
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }

    /**
     * 删除 按钮点击事件
     *
     * @param position
     */
    @Override
    public void onMyCommentListDeleteClick(int position) {
        Toast.makeText(MyCommentListActivity.this, "position =" + position, Toast.LENGTH_SHORT).show();
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
}
