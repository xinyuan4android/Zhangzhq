package com.iningke.zhangzhq.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.ManageSelectListViewAdapter;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.inter.App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class SelectAreaActivity extends ZhangzhqActivity implements AdapterView.OnItemClickListener {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.manage_select_editText)
    EditText manageSelectEditText;
    @Bind(R.id.manage_select_listView)
    ListView manageSelectListView;

    private ManageSelectListViewAdapter adapter;
    private List<String> dataSource = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.activity_manage_select;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        int selectType = intent.getIntExtra("selectType", -1);
        if (selectType > 0) {
            switch (selectType) {
                case App.type_selectArea:
                    //选择区域
                    commonTxtTitle.setText("选择区域");
                    break;
                case App.type_selectBuilding:
                    //选择建筑楼
                    commonTxtTitle.setText("选择建筑楼");
                    break;
                case App.type_selectFloor:
                    //选择楼层
                    commonTxtTitle.setText("选择楼层");
                    break;
                case App.type_selectRoom:
                    //选择科室或者房间号
                    commonTxtTitle.setText("选择科室或者房间号");
                    break;
                case App.type_selectHospital:
                    //选择医院
                    commonTxtTitle.setText("选择医院");
                    break;
                case App.type_selectRole:
                    //选择角色
                    commonTxtTitle.setText("选择角色");
                    break;
            }
            aboutListView();
        } else
            Toast.makeText(SelectAreaActivity.this, "数据异常！", Toast.LENGTH_SHORT).show();
    }


    private void aboutListView() {
        String s1 = "北区教工宿舍1";
        String s2 = "北区教工宿舍2";
        String s3 = "北区教工宿舍3";
        String s4 = "北区教工宿舍4";
        Collections.addAll(dataSource, s1, s2, s3, s4);
        adapter = new ManageSelectListViewAdapter(dataSource);
        manageSelectListView.setAdapter(adapter);
        manageSelectListView.setOnItemClickListener(this);
    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }

    /**
     * item 点击事件
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("result", dataSource.get(position));
        setResult(1111, intent);
        finish();
    }
}
