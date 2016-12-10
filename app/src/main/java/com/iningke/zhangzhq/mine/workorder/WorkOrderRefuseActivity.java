package com.iningke.zhangzhq.mine.workorder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.MyResultFixerListViewAdapter;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.utils.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 拒绝 工单
 *
 * @author hxy
 * @date 2016/12/8
 */
public class WorkOrderRefuseActivity extends ZhangzhqActivity implements MyResultFixerListViewAdapter.MyRefuseFixerListCheckBoxClickListener, AdapterView.OnItemClickListener {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_txt_right)
    TextView commonTxtRight;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.refuse_fixer_listView)
    ListView refuseFixerListView;
    @Bind(R.id.refuse_btn_confirm)
    TextView refuseBtnConfirm;
    private MyResultFixerListViewAdapter adapter;
    private List<String> dataSource = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.activity_work_order_refuse;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("拒绝工单");
        commonImgBack.setVisibility(View.VISIBLE);
        aboutListView();
    }

    private void aboutListView() {
        Collections.addAll(dataSource, "工作人员1", "工作人员2", "工作人员3", "工作人员4");
        adapter = new MyResultFixerListViewAdapter(dataSource, this);
        refuseFixerListView.setAdapter(adapter);
        refuseFixerListView.setOnItemClickListener(this);
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.refuse_btn_confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.refuse_btn_confirm:
                break;
        }
    }

    @Override
    public void onRefuseFixerListCheckboxClick(CheckBox checkBox, boolean isChecked, int position) {
        LogUtils.e("onRefuseFixerListCheckboxClick" + checkBox.isChecked() + position);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.item_refuse_fixerList_checkBox);
        LogUtils.e("itemclick " + checkBox.isChecked());
        checkBox.setChecked(!checkBox.isChecked());
    }
}
