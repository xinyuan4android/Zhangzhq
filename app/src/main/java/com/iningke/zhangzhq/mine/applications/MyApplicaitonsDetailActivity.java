package com.iningke.zhangzhq.mine.applications;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的申购 详情页 和 编辑页
 *
 * @author hxy
 * @date 2016/11/24
 */
public class MyApplicaitonsDetailActivity extends ZhangzhqActivity {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.myApplication_txt_materialName)
    TextView myApplicationTxtMaterialName;
    @Bind(R.id.myApplication_img_materialName_more)
    ImageView myApplicationImgMaterialNameMore;
    @Bind(R.id.myApplication_linear_materialName)
    LinearLayout myApplicationLinearMaterialName;
    @Bind(R.id.myApplication_txt_materialBrand)
    TextView myApplicationTxtMaterialBrand;
    @Bind(R.id.myApplication_img_materialBrand_more)
    ImageView myApplicationImgMaterialBrandMore;
    @Bind(R.id.myApplication_linear_materialBrand)
    LinearLayout myApplicationLinearMaterialBrand;
    @Bind(R.id.myApplication_txt_materialUsing)
    EditText myApplicationTxtMaterialUsing;
    @Bind(R.id.myApplication_txt_materialReason)
    EditText myApplicationTxtMaterialReason;
    @Bind(R.id.myApplication_txt_confirm)
    TextView myApplicationTxtConfirm;
    @Bind(R.id.common_txt_right)
    TextView commonTxtRight;

    @Override
    public int setLayoutId() {
        return R.layout.activity_my_applicaitons_detail;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        int applicationsId = intent.getIntExtra("applicationsId", -1);
        commonTxtTitle.setText(applicationsId >= 0 ? "我的申购" : "材料申购");
        commonTxtRight.setText(applicationsId >= 0 ? "" : "申购历史");
        commonTxtRight.setVisibility(applicationsId >= 0 ? View.INVISIBLE : View.VISIBLE);
        if (applicationsId < 0) {
            myApplicationImgMaterialBrandMore.setVisibility(View.VISIBLE);
            myApplicationImgMaterialNameMore.setVisibility(View.VISIBLE);
            myApplicationTxtConfirm.setVisibility(View.VISIBLE);
            myApplicationLinearMaterialBrand.setClickable(true);
            myApplicationLinearMaterialName.setClickable(true);
        }
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.common_img_back, R.id.common_txt_right, R.id.myApplication_linear_materialName, R.id.myApplication_linear_materialBrand, R.id.myApplication_txt_confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.common_txt_right:
                startActivity(new Intent(this, MyApplicationsListActivity.class));
                break;
            case R.id.myApplication_linear_materialName:
                break;
            case R.id.myApplication_linear_materialBrand:
                break;
            case R.id.myApplication_txt_confirm:
                Toast.makeText(MyApplicaitonsDetailActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

}
