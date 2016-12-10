package com.iningke.zhangzhq.mine.workorder;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.CommentListViewAdapter;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.bean.BeanCommentList;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.myview.MyGridView;
import com.iningke.zhangzhq.myview.MyListView;
import com.iningke.zhangzhq.utils.AppUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 工单详情_维修工
 *
 * @author hxy
 * @date 2016/12/9
 */
public class WorkOrderDetailWorkManActivity extends ZhangzhqActivity implements PullToRefreshBase.OnRefreshListener {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_txt_right)
    TextView commonTxtRight;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.workOrder_detail_name)
    TextView workOrderDetailName;
    @Bind(R.id.workOrder_detail_linear_spread)
    LinearLayout workOrderDetailLinearSpread;
    @Bind(R.id.workOrder_detail_txt_phoneNumber)
    TextView workOrderDetailTxtPhoneNumber;
    @Bind(R.id.workOrder_detail_callPhone)
    ImageView workOrderDetailCallPhone;
    @Bind(R.id.workOrder_detail_area)
    TextView workOrderDetailArea;
    @Bind(R.id.workOrder_detail_address)
    TextView workOrderDetailAddress;
    @Bind(R.id.workOrder_detail_type)
    TextView workOrderDetailType;
    @Bind(R.id.workOrder_detail_description)
    TextView workOrderDetailDescription;
    @Bind(R.id.workOrder_detail_gridView)
    MyGridView workOrderDetailGridView;
    @Bind(R.id.workOrder_detail_btn_refuse)
    TextView workOrderDetailBtnRefuse;
    @Bind(R.id.workOrder_detail_btn_accept)
    TextView workOrderDetailBtnAccept;
    @Bind(R.id.workOrder_detail_detail)
    LinearLayout workOrderDetailDetail;
    @Bind(R.id.workOrder_detail_linear_scroll)
    LinearLayout workOrderDetailLinearScroll;
    @Bind(R.id.workOrder_detail_linear_progressCheck)
    LinearLayout workOrderDetailLinearProgressCheck;
    @Bind(R.id.workOrder_detail_linear_progressFinish)
    LinearLayout workOrderDetailLinearProgressFinish;
    @Bind(R.id.workOrder_detail_linear_progressAccept)
    LinearLayout workOrderDetailLinearProgressAccept;
    @Bind(R.id.workOrder_detail_linear_progressComment)
    LinearLayout workOrderDetailLinearProgressComment;
    @Bind(R.id.workOrder_detail_linear_progressApply)
    LinearLayout workOrderDetailLinearProgressApply;
    @Bind(R.id.workOrder_detail_commentList)
    MyListView workOrderDetailCommentList;
    @Bind(R.id.workOrder_detail_pullToScrollView)
    PullToRefreshScrollView workOrderDetailPullToScrollView;
    @Bind(R.id.workOrder_detail_linear_comment)
    LinearLayout workOrderDetailLinearComment;
    @Bind(R.id.workOrder_detail_linear_progressContainer)
    LinearLayout workOrderDetailLinearProgressContainer;
    @Bind(R.id.workOrder_detail_txtBtn_progressFinish)
    TextView workOrderDetailTxtBtnProgressFinish;
    @Bind(R.id.workOrder_detail_txtBtn_progressAccept)
    TextView workOrderDetailTxtBtnProgressAccept;
    private PullToRefreshScrollView pullToScrollView;

    private CommentListViewAdapter adapter;
    private List<BeanCommentList> dataSource = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.activity_work_order_detail;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("详情");
        commonImgBack.setVisibility(View.VISIBLE);
        pullToScrollView = (PullToRefreshScrollView) findViewById(R.id.workOrder_detail_pullToScrollView);
        aboutPullToScrollView();
        Intent intent = getIntent();
        int state = intent.getIntExtra("state", -1);
//        if (state > 0) {
        workOrderDetailLinearComment.setVisibility(View.GONE);
        workOrderDetailLinearScroll.setVisibility(View.VISIBLE);
        workOrderDetailLinearSpread.setVisibility(View.GONE);
        workOrderDetailDetail.setVisibility(View.VISIBLE);
        aboutProgressLinear();
        aboutListView();
    }

    @Override
    public void initData() {

    }

    private void aboutProgressLinear() {
        View view = LayoutInflater.from(this).inflate(R.layout.item_workorder_serviceprogress, null);
        TextView date = (TextView) view.findViewById(R.id.item_workOrderDetail_txt_serviceProgressDate);
        TextView description = (TextView) view.findViewById(R.id.item_workOrderDetail_txt_serviceProgressDescription);
        TextView title = (TextView) view.findViewById(R.id.item_workOrderDetail_txt_serviceProgressTitle);
        TextView txtBtn = (TextView) view.findViewById(R.id.item_workOrderDetail_txt_serviceProgressBtn);
        ImageView imgBtn = (ImageView) view.findViewById(R.id.item_workOrderDetail_img_serviceProgressBtn);
        date.setText("12-12 17:00");
        title.setText("最后的战役");
        description.setText("我留着pei你，强忍着泪滴。");
        txtBtn.setText("联系对方");
        imgBtn.setVisibility(View.GONE);
        txtBtn.setVisibility(View.VISIBLE);
        workOrderDetailLinearProgressContainer.addView(view);
    }

    private void aboutListView() {
        workOrderDetailCommentList.setFocusable(false);
        BeanCommentList bean1 = new BeanCommentList(R.mipmap.item_avatar_default_small, "微微一笑1", "2016-1-1", "你家的灯天天坏。。。");
        BeanCommentList bean2 = new BeanCommentList(R.mipmap.item_avatar_default_small, "微微一笑2", "2016-1-1", "你家的灯天天坏。。。");
        BeanCommentList bean3 = new BeanCommentList(R.mipmap.item_avatar_default_small, "微微一笑43", "2016-1-1", "你家的灯天天坏。。。");
        BeanCommentList bean4 = new BeanCommentList(R.mipmap.item_avatar_default_small, "微微一笑4", "2016-1-1", "你家的灯天天坏。。。");
        Collections.addAll(dataSource, bean1, bean2, bean3, bean4);
        adapter = new CommentListViewAdapter(dataSource, this);
        workOrderDetailCommentList.setAdapter(adapter);
    }

    private void aboutPullToScrollView() {
        pullToScrollView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        pullToScrollView.setOnRefreshListener(this);

    }

    @OnClick({R.id.common_img_back, R.id.workOrder_detail_callPhone, R.id.workOrder_detail_btn_refuse, R.id.workOrder_detail_btn_accept, R.id.workOrder_detail_linear_spread, R.id.workOrder_detail_linear_scroll})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.workOrder_detail_callPhone:
                break;
            case R.id.workOrder_detail_linear_spread:
                workOrderDetailLinearSpread.setVisibility(View.GONE);
                workOrderDetailDetail.setVisibility(View.VISIBLE);
                workOrderDetailLinearScroll.setVisibility(View.VISIBLE);
                break;
            case R.id.workOrder_detail_btn_refuse:
                startActivity(new Intent(this, WorkOrderRefuseActivity.class));
                break;
            case R.id.workOrder_detail_btn_accept:
                break;
            case R.id.workOrder_detail_linear_scroll:
                //缩放
                workOrderDetailLinearScroll.setVisibility(View.GONE);
                workOrderDetailDetail.setVisibility(View.GONE);
                workOrderDetailLinearSpread.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void permissionDenied(int requestCode) {
        switch (requestCode) {
            case App.RequestCode_CallPhone:
                break;
        }
    }

    @Override
    protected void permissionGrant(int requestCode) {
        switch (requestCode) {
            case App.RequestCode_CallPhone:
                String phoneNumber = workOrderDetailTxtPhoneNumber.getText().toString();
                AppUtils.callPhone(phoneNumber);
                break;
        }
    }

    @Override
    public void onRefresh(PullToRefreshBase refreshView) {
        //上啦加载
        pullToScrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToScrollView.onRefreshComplete();
            }
        }, 500);
    }
}
