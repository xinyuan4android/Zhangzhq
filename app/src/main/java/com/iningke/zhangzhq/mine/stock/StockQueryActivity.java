package com.iningke.zhangzhq.mine.stock;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 库存查询
 *
 * @author hxy
 * @date 2016/11/24
 */
public class StockQueryActivity extends ZhangzhqActivity {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.stockQuery_txt_selectStock)
    TextView stockQueryTxtSelectStock;
    @Bind(R.id.stockQuery_img_selectStock_more)
    ImageView stockQueryImgSelectStockMore;
    @Bind(R.id.stockQuery_linear_selectStock)
    LinearLayout stockQueryLinearSelectStock;
    @Bind(R.id.stockQuery_txt_selectMaterial)
    TextView stockQueryTxtSelectMaterial;
    @Bind(R.id.stockQuery_img_selectMaterial_more)
    ImageView stockQueryImgSelectMaterialMore;
    @Bind(R.id.stockQuery_linear_selectMaterial)
    LinearLayout stockQueryLinearSelectMaterial;
    @Bind(R.id.stockQuery_txt_query)
    TextView stockQueryTxtQuery;

    @Override
    public int setLayoutId() {
        return R.layout.activity_stock_query;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        commonTxtTitle.setText("库存查询");
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.stockQuery_linear_selectStock, R.id.stockQuery_linear_selectMaterial, R.id.stockQuery_txt_query})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.stockQuery_linear_selectStock:
                break;
            case R.id.stockQuery_linear_selectMaterial:
                break;
            case R.id.stockQuery_txt_query:
                aboutQuery();
                break;
        }
    }

    private void aboutQuery() {
        Intent intent = new Intent(this, StockDetailActivity.class);
        startActivity(intent);
    }
}
