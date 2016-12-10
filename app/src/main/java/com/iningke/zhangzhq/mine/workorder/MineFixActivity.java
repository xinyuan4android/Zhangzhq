package com.iningke.zhangzhq.mine.workorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.MyWorkOrderFragmentAdapter;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.inter.App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MineFixActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LinkedList<Fragment> frags = new LinkedList<>();
    private FragmentPagerAdapter adapter;
    private int selection;
    private List<String> dataSource = new ArrayList<>();
    private int role;


    @Override

    public int setLayoutId() {
        return R.layout.activity_mine_fix;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("我的维修");
        commonImgBack.setVisibility(View.VISIBLE);
        tabLayout = (TabLayout) findViewById(R.id.workOrder_tabLayout);
        viewPager = (ViewPager) findViewById(R.id.workOrder_viewPager);
        Intent intent = getIntent();
        selection = intent.getIntExtra("selection", -1);
        selection = selection >= 0 ? selection : 0;
        role = intent.getIntExtra("role", -1);
        switch (role) {
            case App.type_role_notWorkMan:
                Collections.addAll(dataSource, App.strings_orderState_NotFix);
                break;
            case App.type_role_workMan:
                Collections.addAll(dataSource, App.strings_orderState_fix);
                break;
        }

        aboutTabLayout();
        aboutViewPager();
    }

    private void aboutViewPager() {
        adapter = new MyWorkOrderFragmentAdapter(getSupportFragmentManager(), frags);
        viewPager.setAdapter(adapter);
    }

    private void viewPagerAdd() {
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    protected void addListener() {
        super.addListener();
        tablayoutAdd();
        viewPagerAdd();
    }

    private void aboutTabLayout() {
        for (int i = 0; i < dataSource.size(); i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(dataSource.get(i));
            tabLayout.addTab(tab);
        }
    }

    private void tablayoutAdd() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public void initData() {
        aboutDataSource();
        viewPager.setCurrentItem(selection);
    }

    private void aboutDataSource() {

        for (int i = 0; i < dataSource.size(); i++) {
            MineFixFragment orderAllFragment = new MineFixFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("orderState", App.ints_orderState_NotFix[i]);
            bundle.putInt("role", role);
            orderAllFragment.setArguments(bundle);
            frags.add(orderAllFragment);
        }
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }


}