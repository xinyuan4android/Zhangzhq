package com.iningke.zhangzhq.home;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.zxing.activity.CaptureActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 物资管理 activity
 *
 * @author hxy
 * @date 2016/11/24
 */
public class GoodsManageActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.goodsManage_linear_materialManage)
    LinearLayout goodsManageLinearMaterialManage;
    @Bind(R.id.goodsManage_linear_deviceManage)
    LinearLayout goodsManageLinearDeviceManage;

    @Override
    public int setLayoutId() {
        return R.layout.activity_goodsmanage;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("物资管理");
        commonImgBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.common_img_back, R.id.goodsManage_linear_materialManage, R.id.goodsManage_linear_deviceManage})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.goodsManage_linear_materialManage:
                Intent intent = new Intent(this, MaterialManageActivity.class);
                startActivity(intent);
                break;
            case R.id.goodsManage_linear_deviceManage:
                Intent intent1 = new Intent(this, CaptureActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
