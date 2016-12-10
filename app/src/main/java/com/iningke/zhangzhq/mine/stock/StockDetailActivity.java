package com.iningke.zhangzhq.mine.stock;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 库存查询 结果详情页
 *
 * @author hxy
 * @date 2016/11/24
 */
public class StockDetailActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.stockDetail_txt_amount)
    TextView stockDetailTxtAmount;
    @Bind(R.id.stockDetail_txt_materialType)
    TextView stockDetailTxtMaterialType;
    @Bind(R.id.stockDetail_txt_materialName)
    TextView stockDetailTxtMaterialName;
    @Bind(R.id.stockDetail_txt_materialUnit)
    TextView stockDetailTxtMaterialUnit;
    @Bind(R.id.stockDetail_txt_materialOrganization)
    TextView stockDetailTxtMaterialOrganization;
    @Bind(R.id.stockDetail_txt_materialPrice)
    TextView stockDetailTxtMaterialPrice;
    @Bind(R.id.stockDetail_txt_materialPs)
    TextView stockDetailTxtMaterialPs;

    @Override
    public int setLayoutId() {
        return R.layout.activity_stock_detail;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        commonTxtTitle.setText("库存查询");
    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }
}
