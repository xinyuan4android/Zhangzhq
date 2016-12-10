package com.iningke.zhangzhq.home;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.mine.applications.MyApplicaitonsDetailActivity;
import com.iningke.zhangzhq.mine.stock.StockQueryActivity;
import com.iningke.zhangzhq.mine.use.MyUsingDetailActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 材料管理 activity
 *
 * @author hxy
 * @date 2016/11/24
 */
public class MaterialManageActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.materialManage_linear_materialApplications)
    LinearLayout materialManageLinearMaterialApplications;
    @Bind(R.id.materialManage_linear_materialUsing)
    LinearLayout materialManageLinearMaterialUsing;
    @Bind(R.id.materialManage_linear_stockQuery)
    LinearLayout materialManageLinearStockQuery;

    @Override
    public int setLayoutId() {
        return R.layout.activity_material;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        commonTxtTitle.setText("材料管理");
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.materialManage_linear_materialApplications, R.id.materialManage_linear_materialUsing, R.id.materialManage_linear_stockQuery})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.materialManage_linear_materialApplications:
                Intent intent_applicaitons = new Intent(this, MyApplicaitonsDetailActivity.class);
                startActivity(intent_applicaitons);
                break;
            case R.id.materialManage_linear_materialUsing:
                Intent intent_using = new Intent(this, MyUsingDetailActivity.class);
                startActivity(intent_using);
                break;
            case R.id.materialManage_linear_stockQuery:
                Intent intent_stockQuery = new Intent(this, StockQueryActivity.class);
                startActivity(intent_stockQuery);
                break;
        }
    }
}
