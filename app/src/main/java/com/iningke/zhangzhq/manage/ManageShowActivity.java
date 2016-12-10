package com.iningke.zhangzhq.manage;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class ManageShowActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.manage_show_img_showType)
    ImageView manageShowImgShowType;
    @Bind(R.id.manage_txt_amount)
    TextView manageTxtAmount;
    @Bind(R.id.manage_txt_amount_info)
    TextView manageTxtAmountInfo;
    @Bind(R.id.manage_txt_money)
    TextView manageTxtMoney;
    @Bind(R.id.manage_txt_money_info)
    TextView manageTxtMoneyInfo;
    @Bind(R.id.manage_show_readPeople)
    TextView manageShowReadPeople;
    @Bind(R.id.manage_show_readTime)
    TextView manageShowReadTime;
    @Bind(R.id.manage_show_lastMonthRed)
    TextView manageShowLastMonthRed;
    @Bind(R.id.manage_show_thisMonthRed)
    TextView manageShowThisMonthRed;
    @Bind(R.id.common_txt_right)
    TextView commonTxtRight;
    @Bind(R.id.manage_show_txt_date)
    TextView manageShowTxtDate;
    @Bind(R.id.manage_water_txt_selfUsing)
    TextView manageWaterTxtSelfUsing;
    @Bind(R.id.manage_water_txt_toiletUsing)
    TextView manageWaterTxtToiletUsing;
    @Bind(R.id.manage_linear_water)
    LinearLayout manageLinearWater;
    @Bind(R.id.manage_electric_txt_selfUsing)
    TextView manageElectricTxtSelfUsing;
    @Bind(R.id.manage_electric_txt_elevatorUsing)
    TextView manageElectricTxtElevatorUsing;
    @Bind(R.id.manage_electric_txt_airConditionerUsing)
    TextView manageElectricTxtAirConditionerUsing;
    @Bind(R.id.manage_electric_txt_waterBucketUisng)
    TextView manageElectricTxtWaterBucketUisng;
    @Bind(R.id.manage_electric_txt_heaterUsing)
    TextView manageElectricTxtHeaterUsing;
    @Bind(R.id.manage_linear_electric)
    LinearLayout manageLinearElectric;
    private int type;

    @Override
    public int setLayoutId() {
        return R.layout.activity_manage_show;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        commonImgRight.setImageResource(R.mipmap.manage_history);
        commonImgRight.setVisibility(View.VISIBLE);
        type = getIntent().getIntExtra("type", -1);
        if (type > 0) {
            switch (type) {
                case 10:
                    //水费
                    setView("水费查询", "水量", "水费", R.mipmap.manage_water);
                    manageLinearWater.setVisibility(View.VISIBLE);
                    break;
                case 20:
                    //电费
                    setView("电费查询", "电量", "电费", R.mipmap.manage_electric);
                    manageLinearElectric.setVisibility(View.VISIBLE);
                    break;
                case 30:
                    //氧气费
                    setView("氧气费查询", "氧气量", "氧气费", R.mipmap.manage_oxygen);
                    break;
            }
        } else
            Toast.makeText(ManageShowActivity.this, "数据异常！", Toast.LENGTH_SHORT).show();
    }

    private void setView(String title, String amountInfo, String moneyInfo, int manage_water) {
        commonTxtTitle.setText(title);
        manageTxtAmountInfo.setText(amountInfo);
        manageTxtMoneyInfo.setText(moneyInfo);
        manageShowImgShowType.setImageResource(manage_water);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.common_img_back, R.id.common_img_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.common_img_right:
                aboutJumpToHistory();
                break;
        }
    }

    private void aboutJumpToHistory() {
        if (type < 0) {
            Toast.makeText(ManageShowActivity.this, "数据异常！", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, ManageHistoryActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }

}
