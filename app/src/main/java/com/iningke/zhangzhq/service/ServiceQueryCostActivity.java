package com.iningke.zhangzhq.service;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.utils.LogUtils;

import butterknife.Bind;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;

/**
 * 维修服务 维修费用查询 activity
 *
 * @author hxy
 * @date 2016/11/22
 */

public class ServiceQueryCostActivity extends ZhangzhqActivity {
    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.common_txt_right)
    TextView commonTxtRight;
    @Bind(R.id.service_queryCost_txt_costType)
    TextView serviceQueryCostTxtCostType;
    @Bind(R.id.service_queryCost_txt_fixType)
    TextView serviceQueryCostTxtFixType;
    @Bind(R.id.service_queryCost_startDate)
    TextView serviceQueryCostStartDate;
    @Bind(R.id.service_queryCost_endDate)
    TextView serviceQueryCostEndDate;
    private ServiceQueryCostFragment costTypeFragment;
    private ServiceQueryCostFragment fixTypeFragment;
    //    private PieChart pieChart;
//    private List<ConsumeTypeMoneyPo> consumeTypeMoneyVoList = new ArrayList<>();
//    private float totalMoney;
//    private MyListView listView;
//
//    private ServiceQueryCostListViewAdapter adapter;
//    private List<BeanServiceQueryCost> dataSource = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.activity_service_query_cost;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        commonTxtTitle.setText("维修费用查询");
//        aboutMPAndroidChart();
//        listView = (MyListView) findViewById(R.id.service_queryCost_listView);
//        aboutListView();
        initFragment();
    }

    private void initFragment() {
        costTypeFragment = new ServiceQueryCostFragment();
        fixTypeFragment = new ServiceQueryCostFragment();
        Bundle bundleCost = new Bundle();
        Bundle bundleFix = new Bundle();
        bundleCost.putString("type", "costType");
        bundleFix.putString("type", "fixType");
        costTypeFragment.setArguments(bundleCost);
        fixTypeFragment.setArguments(bundleFix);
        getSupportFragmentManager().beginTransaction().add(R.id.service_queryCost_linearContainer, costTypeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.service_queryCost_linearContainer, fixTypeFragment).commit();
    }

//    private void aboutListView() {
//        BeanServiceQueryCost bean1 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "照明类1", "581.00");
//        BeanServiceQueryCost bean2 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "照明类2", "528.00");
//        BeanServiceQueryCost bean3 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "照明类3", "538.00");
//        BeanServiceQueryCost bean4 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "照明类4", "548.00");
//        BeanServiceQueryCost bean5 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "照明类5", "585.00");
//        Collections.addAll(dataSource, bean1, bean2, bean3, bean4, bean5);
//        adapter = new ServiceQueryCostListViewAdapter(dataSource, this);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(this);
//    }

    //    private void aboutMPAndroidChart() {
//        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("管理费", 410.0f));
//        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("材料费", 256.02f));
//        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("工时费", 789.23f));
////        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("出行4", 256.1f));
////        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("出行5", 25.1f));
////        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("出行6", 186.7f));
//
//        pieChart = (PieChart) findViewById(R.id.consume_pie_chart);
//        pieChart.setUsePercentValues(true);//设置value是否用显示百分数,默认为false
//        Description description = new Description();
//        description.setText("");
//        pieChart.setDescription(description);//设置描述
////        pieChart.setdessi(20);//设置描述字体大小
////        pieChart.setDescriptionColor(); //设置描述颜色
////        pieChart.setDescriptionTypeface();//设置描述字体
//
//        pieChart.setExtraOffsets(5, 5, 5, 5);//设置饼状图距离上下左右的偏移量
//
//        pieChart.setDragDecelerationFrictionCoef(1f);//设置阻尼系数,范围在[0,1]之间,越小饼状图转动越困难
//
//
//        pieChart.setDrawCenterText(false);//是否绘制中间的文字
//        pieChart.setCenterTextColor(Color.RED);//中间的文字颜色
//        pieChart.setCenterTextSize(18);//中间的文字字体大小
//
//
//        pieChart.setDrawHoleEnabled(true);//是否绘制饼状图中间的圆
//        pieChart.setHoleColor(Color.WHITE);//饼状图中间的圆的绘制颜色
//        pieChart.setHoleRadius(40f);//饼状图中间的圆的半径大小
//
//        pieChart.setTransparentCircleColor(Color.WHITE);//设置圆环的颜色
//        pieChart.setTransparentCircleAlpha(110);//设置圆环的透明度[0,255]
//        pieChart.setTransparentCircleRadius(40f);//设置圆环的半径值
//
//
//// enable rotation of the chart by touch
//        pieChart.setRotationEnabled(false);//设置饼状图是否可以旋转(默认为true)
//        pieChart.setRotationAngle(0);//设置饼状图旋转的角度
//
//        pieChart.setHighlightPerTapEnabled(false);//设置旋转的时候点中的tab是否高亮(默认为true)
//
//
//        Legend l = pieChart.getLegend();
////        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);//设置每个tab的显示位置
////        l.setXEntrySpace(0f);
////        l.setYEntrySpace(0f);//设置tab之间Y轴方向上的空白间距值
////        l.setYOffset(0f);
//        l.setTextColor(getResources().getColor(R.color.white));
//        l.setForm(Legend.LegendForm.NONE);
//
//        pieChart.setOnChartValueSelectedListener(this);//设值点击时候的回调
//        pieChart.animateY(3400, Easing.EasingOption.EaseInQuad);//设置Y轴上的绘制动画
//        ArrayList<PieEntry> pieEntries = new ArrayList<>();
//        for (ConsumeTypeMoneyPo typeMoneyVo : consumeTypeMoneyVoList) {
//            PieEntry pieEntry = new PieEntry((float) typeMoneyVo.getTotalMoney(), typeMoneyVo.getConsumeTypeName());
//            pieEntries.add(pieEntry);
//            totalMoney += typeMoneyVo.getTotalMoney();
//        }
//        String centerText = 2016 + "年消费\n¥" + totalMoney;
////        String centerText = "年消费\n¥" + 5555;
//        pieChart.setCenterText(centerText);//设置中间的文字
//
//        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
//        pieDataSet.setColors(getPieChartColors());
//        pieDataSet.setSliceSpace(0f);//设置选中的Tab离两边的距离
//        pieDataSet.setSelectionShift(5f);//设置选中的tab的多出来的
//        PieData pieData = new PieData();
//        pieData.setDataSet(pieDataSet);
//
//        //百分比 数字
//        pieData.setValueFormatter(new PercentFormatter());
//        pieData.setValueTextSize(14f);
//        pieData.setValueTextColor(Color.WHITE);//百分比 数字的颜色
//
//        // entry label styling
//        pieChart.setDrawEntryLabels(true);//设置是否绘制Label
//        pieChart.setEntryLabelColor(Color.WHITE);//设置绘制Label的颜色
//        //pieChart.setEntryLabelTypeface(mTfRegular);
//        pieChart.setEntryLabelTextSize(14f);//设置绘制Label的字体大小
//
//        pieChart.setData(pieData);
//// undo all highlights
//        pieChart.highlightValues(null);
//        pieChart.invalidate();
//    }
//
//    private int[] getPieChartColors() {
//        int[] colors = {0xFFFFA163, 0xFFFE5874, 0xFF39B6FE};
//        return colors;
//    }
//
//    @Override
//    public void onValueSelected(Entry e, Highlight h) {
//        if (e != null) {
//            PieEntry pieEntry = (PieEntry) e;
//            Log.e("iningke", "getConsumeTypeName()" + pieEntry.getLabel());
//            Log.e("iningke", "getTotalMoney()" + pieEntry.getValue());
//        }
//    }
//
//    @Override
//    public void onNothingSelected() {
//        Log.e("iningke", "!!!!!!!!!!!!onNothingSelected()!!!!!!!!!!!");
//    }
//
    @Override
    public void initData() {

    }


    @OnClick({R.id.service_queryCost_txt_costType, R.id.service_queryCost_startDate, R.id.service_queryCost_endDate, R.id.common_img_back, R.id.service_queryCost_txt_fixType})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.service_queryCost_txt_costType:
                getSupportFragmentManager().beginTransaction().hide(fixTypeFragment)
                        .show(costTypeFragment).commit();
                break;
            case R.id.service_queryCost_txt_fixType:
                getSupportFragmentManager().beginTransaction().hide(costTypeFragment)
                        .show(fixTypeFragment).commit();
                break;
            case R.id.service_queryCost_startDate:
                showDatePicker(serviceQueryCostStartDate);
                break;
            case R.id.service_queryCost_endDate:
                showDatePicker(serviceQueryCostEndDate);
                break;
        }
    }

    private void showDatePicker(final TextView textView) {
        DatePicker picker = new DatePicker(this, DatePicker.YEAR_MONTH_DAY);
        picker.setRange(1990, 2020);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                textView.setText(year + "-" + month + "-" + day);
                LogUtils.e(year + "-" + month + "-" + day);
            }
        });
        picker.show();
    }


//
//    /**
//     * listview item点击事件
//     *
//     * @param parent
//     * @param view
//     * @param position
//     * @param id
//     */
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(ServiceQueryCostActivity.this, dataSource.get(position).getTypeName(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, ServiceQueryCostDetailListActivity.class);
//        intent.putExtra("BeanServiceQueryCost", dataSource.get(position));
//        startActivity(intent);
//    }
//
//    private class ConsumeTypeMoneyPo {
//        private float totalMoney;
//        private String consumeTypeName;
//
//        public ConsumeTypeMoneyPo() {
//        }
//
//        public ConsumeTypeMoneyPo(String consumeTypeName, float totalMoney) {
//            this.consumeTypeName = consumeTypeName;
//            this.totalMoney = totalMoney;
//        }
//
//        public float getTotalMoney() {
//            return totalMoney;
//        }
//
//        public void setTotalMoney(float totalMoney) {
//            this.totalMoney = totalMoney;
//        }
//
//        public String getConsumeTypeName() {
//            return consumeTypeName;
//        }
//
//        public void setConsumeTypeName(String consumeTypeName) {
//            this.consumeTypeName = consumeTypeName;
//        }
//    }
}
