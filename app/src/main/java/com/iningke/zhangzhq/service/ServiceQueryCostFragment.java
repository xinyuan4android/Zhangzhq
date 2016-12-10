package com.iningke.zhangzhq.service;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.ServiceQueryCostListViewAdapter;
import com.iningke.zhangzhq.base.ZhangzhqFragment;
import com.iningke.zhangzhq.bean.BeanServiceQueryCost;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.myview.MyListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 维修费用查询 切换fragment
 * A simple {@link Fragment} subclass.
 */
public class ServiceQueryCostFragment extends ZhangzhqFragment implements AdapterView.OnItemClickListener, OnChartValueSelectedListener {
    private PieChart pieChart;
    private List<ConsumeTypeMoneyPo> consumeTypeMoneyVoList = new ArrayList<>();
    private float totalMoney;
    private MyListView listView;

    private ServiceQueryCostListViewAdapter adapter;
    private List<BeanServiceQueryCost> dataSource = new ArrayList<>();

    public ServiceQueryCostFragment() {
        // Required empty public constructor
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_service_query_cost;
    }

    @Override
    public void initView(View view) {
        Bundle arguments = getArguments();
        String type = arguments.getString("type");
        if ("fixType".equals(type)) {
            BeanServiceQueryCost bean1 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "照明类1", 581.00f);
            BeanServiceQueryCost bean2 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "照明类2", 528.00f);
            BeanServiceQueryCost bean3 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "照明类3", 538.00f);
            BeanServiceQueryCost bean4 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "照明类4", 548.00f);
            BeanServiceQueryCost bean5 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "照明类5", 585.00f);
            Collections.addAll(dataSource, bean1, bean2, bean3, bean4, bean5);
        } else if ("costType".equals(type)) {
            BeanServiceQueryCost bean1 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "管理费", 33.00f);
            BeanServiceQueryCost bean2 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "材料费", 33.00f);
            BeanServiceQueryCost bean3 = new BeanServiceQueryCost(R.mipmap.service_cost_light, "工时费", 33.00f);
            Collections.addAll(dataSource, bean1, bean2, bean3);
        }
        listView = (MyListView) view.findViewById(R.id.service_queryCost_listView);
        listView.setFocusable(false);
        aboutListView(view);
        aboutMPAndroidChart(view);
    }

    @Override
    public void initData(View view) {

    }

    private void aboutListView(View view) {

        adapter = new ServiceQueryCostListViewAdapter(dataSource, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private void aboutMPAndroidChart(View view) {
//        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo(dataSource.get(), 410.0f));
//        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("材料费", 256.02f));
//        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("工时费", 789.23f));
        for (BeanServiceQueryCost bean : dataSource) {
            consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo(bean.getTypeName(), bean.getCostMoney()));
        }
//        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("出行4", 256.1f));
//        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("出行5", 25.1f));
//        consumeTypeMoneyVoList.add(new ConsumeTypeMoneyPo("出行6", 186.7f));

        pieChart = (PieChart) view.findViewById(R.id.consume_pie_chart);
        pieChart.setUsePercentValues(true);//设置value是否用显示百分数,默认为false
        Description description = new Description();
        description.setText("");
        pieChart.setDescription(description);//设置描述
//        pieChart.setdessi(20);//设置描述字体大小
//        pieChart.setDescriptionColor(); //设置描述颜色
//        pieChart.setDescriptionTypeface();//设置描述字体

        pieChart.setExtraOffsets(5, 5, 5, 5);//设置饼状图距离上下左右的偏移量

        pieChart.setDragDecelerationFrictionCoef(1f);//设置阻尼系数,范围在[0,1]之间,越小饼状图转动越困难


        pieChart.setDrawCenterText(false);//是否绘制中间的文字
        pieChart.setCenterTextColor(Color.RED);//中间的文字颜色
        pieChart.setCenterTextSize(18);//中间的文字字体大小


        pieChart.setDrawHoleEnabled(true);//是否绘制饼状图中间的圆
        pieChart.setHoleColor(Color.WHITE);//饼状图中间的圆的绘制颜色
        pieChart.setHoleRadius(40f);//饼状图中间的圆的半径大小

        pieChart.setTransparentCircleColor(Color.WHITE);//设置圆环的颜色
        pieChart.setTransparentCircleAlpha(110);//设置圆环的透明度[0,255]
        pieChart.setTransparentCircleRadius(40f);//设置圆环的半径值


// enable rotation of the chart by touch
        pieChart.setRotationEnabled(false);//设置饼状图是否可以旋转(默认为true)
        pieChart.setRotationAngle(0);//设置饼状图旋转的角度

        pieChart.setHighlightPerTapEnabled(false);//设置旋转的时候点中的tab是否高亮(默认为true)


        Legend l = pieChart.getLegend();
//        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);//设置每个tab的显示位置
//        l.setXEntrySpace(0f);
//        l.setYEntrySpace(0f);//设置tab之间Y轴方向上的空白间距值
//        l.setYOffset(0f);
        l.setTextColor(getResources().getColor(R.color.white));
        l.setForm(Legend.LegendForm.NONE);

        pieChart.setOnChartValueSelectedListener(this);//设值点击时候的回调
        pieChart.animateY(3400, Easing.EasingOption.EaseInQuad);//设置Y轴上的绘制动画
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        for (ConsumeTypeMoneyPo typeMoneyVo : consumeTypeMoneyVoList) {
            PieEntry pieEntry = new PieEntry((float) typeMoneyVo.getTotalMoney(), typeMoneyVo.getConsumeTypeName());
            pieEntries.add(pieEntry);
            totalMoney += typeMoneyVo.getTotalMoney();
        }
        String centerText = 2016 + "年消费\n¥" + totalMoney;
//        String centerText = "年消费\n¥" + 5555;
        pieChart.setCenterText(centerText);//设置中间的文字

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColors(getPieChartColors());
        pieDataSet.setSliceSpace(0f);//设置选中的Tab离两边的距离
        pieDataSet.setSelectionShift(5f);//设置选中的tab的多出来的
        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);

        //百分比 数字
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(14f);
        pieData.setValueTextColor(Color.WHITE);//百分比 数字的颜色

        // entry label styling
        pieChart.setDrawEntryLabels(true);//设置是否绘制Label
        pieChart.setEntryLabelColor(Color.WHITE);//设置绘制Label的颜色
        //pieChart.setEntryLabelTypeface(mTfRegular);
        pieChart.setEntryLabelTextSize(14f);//设置绘制Label的字体大小

        pieChart.setData(pieData);
// undo all highlights
        pieChart.highlightValues(null);
        pieChart.invalidate();
    }

    private int[] getPieChartColors() {
        int[] colors = new int[dataSource.size()];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = App.colors[i];
        }
        return colors;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        if (e != null) {
            PieEntry pieEntry = (PieEntry) e;
            Log.e("iningke", "getConsumeTypeName()" + pieEntry.getLabel());
            Log.e("iningke", "getTotalMoney()" + pieEntry.getValue());
        }
    }

    @Override
    public void onNothingSelected() {
        Log.e("iningke", "!!!!!!!!!!!!onNothingSelected()!!!!!!!!!!!");
    }


    /**
     * listview item点击事件
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), dataSource.get(position).getTypeName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), ServiceQueryCostDetailListActivity.class);
        intent.putExtra("BeanServiceQueryCost", dataSource.get(position));
        startActivity(intent);
    }

    private class ConsumeTypeMoneyPo {
        private float totalMoney;
        private String consumeTypeName;

        public ConsumeTypeMoneyPo() {
        }

        public ConsumeTypeMoneyPo(String consumeTypeName, float totalMoney) {
            this.consumeTypeName = consumeTypeName;
            this.totalMoney = totalMoney;
        }

        public float getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(float totalMoney) {
            this.totalMoney = totalMoney;
        }

        public String getConsumeTypeName() {
            return consumeTypeName;
        }

        public void setConsumeTypeName(String consumeTypeName) {
            this.consumeTypeName = consumeTypeName;
        }
    }
}
