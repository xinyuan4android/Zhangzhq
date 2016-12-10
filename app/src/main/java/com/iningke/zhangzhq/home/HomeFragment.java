package com.iningke.zhangzhq.home;


import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.iningke.zhangzhq.MainActivity;
import com.iningke.zhangzhq.MyApp;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.TextActivity;
import com.iningke.zhangzhq.adapter.HomeAdViewPagerAdapter;
import com.iningke.zhangzhq.adapter.HomeIconGridViewAdapter;
import com.iningke.zhangzhq.adapter.HomeListGridViewAdapter;
import com.iningke.zhangzhq.adapter.HomeListViewAdapter;
import com.iningke.zhangzhq.base.ZhangzhqFragment;
import com.iningke.zhangzhq.bean.BeanAdViewPager;
import com.iningke.zhangzhq.bean.BeanHomeListView;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.myview.MyListView;
import com.iningke.zhangzhq.myview.viewpager.CarouselViewPager;
import com.iningke.zhangzhq.utils.UIUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends ZhangzhqFragment implements AdapterView.OnItemClickListener,
        HomeAdViewPagerAdapter.MyAdOnClickListener, ViewPager.OnPageChangeListener,
        HomeListGridViewAdapter.MyGridViewOnItemClickListener {


    @Bind(R.id.home_icon_gridView)
    GridView homeIconGridView;
    @Bind(R.id.home_ad_txt)
    TextView homeAdTxt;
    @Bind(R.id.home_listView)
    MyListView homeListView;
    @Bind(R.id.home_img_notice)
    ImageView homeImgNotice;
    @Bind(R.id.home_txt_notice)
    TextView homeTxtNotice;
    @Bind(R.id.home_linear_notice)
    LinearLayout homeLinearNotice;
    @Bind(R.id.home_img_manage)
    ImageView homeImgManage;
    @Bind(R.id.home_txt_manage)
    TextView homeTxtManage;
    @Bind(R.id.home_linear_manage)
    LinearLayout homeLinearManage;
    @Bind(R.id.home_img_service)
    ImageView homeImgService;
    @Bind(R.id.home_txt_service)
    TextView homeTxtService;
    @Bind(R.id.home_linear_service)
    LinearLayout homeLinearService;
    @Bind(R.id.home_img_device)
    ImageView homeImgDevice;
    @Bind(R.id.home_txt_device)
    TextView homeTxtDevice;
    @Bind(R.id.home_linear_device)
    LinearLayout homeLinearDevice;
    @Bind(R.id.home_ad_carouseViewPager)
    CarouselViewPager homeAdCarouseViewPager;
    @Bind(R.id.home_ad_radioGroup)
    RadioGroup homeAdRadioGroup;
    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_txt_right)
    TextView commonTxtRight;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.home_pullToScrollView)
    PullToRefreshScrollView homePullToScrollView;


    private CarouselViewPager viewPager;
    private HomeAdViewPagerAdapter viewPagerAdapter;
    private List<BeanAdViewPager> dataSource = new ArrayList<>();
    private List<BeanHomeListView> dataSource_listView = new ArrayList<>();
    private HomeListViewAdapter listViewAdapter;
    private PullToRefreshScrollView pullTo;
    private MainActivity activity;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (MainActivity) activity;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MyApp.getCurrentFragment() == App.Currentpage_HomeFragment) {
            viewPager.setLifeCycle(CarouselViewPager.RESUME);
        }
    }

    @Override
    public void initView(View view) {
        commonTxtTitle.setText("某医院");
        viewPager = (CarouselViewPager) view.findViewById(R.id.home_ad_carouseViewPager);
        pullTo = (PullToRefreshScrollView) view.findViewById(R.id.home_pullToScrollView);
        homeListView.setFocusable(false);
        aboutPllTo();
        aboutGridView();
        aboutViewPager();
        aboutRadioGroup();
        aboutListView();
    }

    private void aboutPllTo() {

        pullTo.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        pullTo.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pullTo.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullTo.onRefreshComplete();
                    }
                }, 1000);
            }
        });
    }

    private void aboutListView() {
        List<String> imgUrl = new ArrayList<>();
        Collections.addAll(imgUrl, "http://img1.imgtn.bdimg.com/it/u=2308329143,2620506960&fm=23&gp=0.jpg",
                "http://img1.imgtn.bdimg.com/it/u=3315889182,1097209493&fm=23&gp=0.jpg",
                "http://img1.imgtn.bdimg.com/it/u=2623974986,2629351623&fm=23&gp=0.jpg");
        BeanHomeListView bean1 = new BeanHomeListView("Come On~", "11-8 12:12", "员工宿舍2栋", "门坏了",
                1, imgUrl.subList(0, 1));
        BeanHomeListView bean2 = new BeanHomeListView("Come On2~", "11-8 12:22", "员工宿舍23栋", "门坏了2",
                2, imgUrl);
        BeanHomeListView bean3 = new BeanHomeListView("Come On3~", "11-8 12:32", "员工宿舍24栋", "门坏了3",
                3, imgUrl.subList(1, 2));
        BeanHomeListView bean4 = new BeanHomeListView("Come On4~", "11-8 12:42", "员工宿舍44栋", "门坏了4",
                3, new ArrayList<String>());
        Collections.addAll(dataSource_listView, bean1, bean2, bean3, bean4);
        listViewAdapter = new HomeListViewAdapter(dataSource_listView, this, this);
        homeListView.setAdapter(listViewAdapter);
        homeListView.setOnItemClickListener(this);
    }


    private void aboutViewPager() {
        BeanAdViewPager bean1 = new BeanAdViewPager("http://img5.imgtn.bdimg.com/it/u=2616942041,3879750022&fm=21&gp=0.jpg", "图片1");
        BeanAdViewPager bean2 = new BeanAdViewPager("http://img4.imgtn.bdimg.com/it/u=3735625611,280467979&fm=21&gp=0.jpg", "图片2");
//        BeanAdViewPager bean3 = new BeanAdViewPager("http://img4.imgtn.bdimg.com/it/u=3735625611,280467979&fm=21&gp=0.jpg", "图片3");
        Collections.addAll(dataSource, bean1, bean2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, UIUtils.getDisplayWidth() * 1 / 2);
//        layoutParams.setMargins(UIUtils.dip2px(10), UIUtils.dip2px(10), UIUtils.dip2px(10), UIUtils.dip2px(10));
        viewPager.setLayoutParams(layoutParams);
        viewPagerAdapter = new HomeAdViewPagerAdapter(viewPager, dataSource, this, this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
    }

    private void aboutGridView() {
        int[] imgRes = {R.mipmap.home_icon_notice, R.mipmap.home_icon_manage, R.mipmap.home_icon_service, R.mipmap.home_icon_device};
        String[] txts = {"通知公告", "水电气管理", "维修服务", "物资管理"};
        HomeIconGridViewAdapter adapter = new HomeIconGridViewAdapter(imgRes, txts);
        homeIconGridView.setAdapter(adapter);
        homeIconGridView.setOnItemClickListener(this);
    }

    private void aboutRadioGroup() {
        for (int i = 0; i < dataSource.size(); i++) {
            RadioButton radioBtn = new RadioButton(getContext());
            radioBtn.setButtonDrawable(android.R.color.transparent);
            radioBtn.setId(i);
            radioBtn.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.selector_home_radiobtn), null,
                    null,
                    null);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 0, 0, 0);
            radioBtn.setLayoutParams(params);
            homeAdRadioGroup.addView(radioBtn, params);
        }
        RadioButton radioButton = (RadioButton) homeAdRadioGroup.getChildAt(0);
        radioButton.setChecked(true);
    }

    @Override
    public void initData(View view) {

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
        switch (parent.getId()) {
            case R.id.home_icon_gridView:
                //icon gridView item 点击事件
                Toast.makeText(getContext(), "position == " + position, Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_listView:
                //listview item点击事件
                Toast.makeText(getContext(), "poition == " + position, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 轮播图点击事件
     *
     * @param position
     */
    @Override
    public void myOnClick(int position) {

        Toast.makeText(getContext(), dataSource.get(position).getImgTxt() + "点击了...", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(getContext(), MyTestTransformMatrixVIewActivity.class);
        Intent intent = new Intent(getContext(), TextActivity.class);
        startActivity(intent);
    }

    /**
     * viewpager 滑动事件监听
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * viewpager 滑动事件监听
     *
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        if (homeAdRadioGroup != null) {
            RadioButton radioBtn = (RadioButton) homeAdRadioGroup.getChildAt(position % (dataSource.size()));
            radioBtn.setChecked(true);
            homeAdTxt.setText(dataSource.get(position % dataSource.size()).getImgTxt());
        }
    }

    /**
     * viewpager 滑动事件监听
     *
     * @param state
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPause() {
        super.onPause();
        viewPager.setLifeCycle(CarouselViewPager.PAUSE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewPager.setLifeCycle(CarouselViewPager.DESTROY);
    }

    @OnClick({R.id.home_linear_notice, R.id.home_linear_manage, R.id.home_linear_service, R.id.home_linear_device})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_linear_notice:
                Toast.makeText(getContext(), "通知", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), NotifyActivity.class);
                startActivity(intent);
                break;
            case R.id.home_linear_manage:
                Toast.makeText(getContext(), "管理", Toast.LENGTH_SHORT).show();
                activity.goToManageFragment();
                break;
            case R.id.home_linear_service:
                Toast.makeText(getContext(), "服务", Toast.LENGTH_SHORT).show();
                activity.goToServceFragment();
                break;
            case R.id.home_linear_device:
                Toast.makeText(getContext(), "物资", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getContext(), GoodsManageActivity.class);
                startActivity(intent1);
                break;
        }
    }

    /**
     * listview 里面的图片的点击事件
     *
     * @param position
     * @param position_parent
     */
    @Override
    public void onMyGridItemClick(int position, int position_parent) {
        Toast.makeText(getContext(), dataSource_listView.get(position_parent).getName() + position, Toast.LENGTH_SHORT).show();
    }

}
