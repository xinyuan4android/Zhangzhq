package com.iningke.zhangzhq.mine.use;

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
 * 我的领用 详情页和编辑页
 *
 * @author hxy
 * @date 2016/11/24
 */
public class MyUsingDetailActivity extends ZhangzhqActivity {

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
    @Bind(R.id.myApplication_txt_materialType)
    TextView myApplicationTxtMaterialType;
    @Bind(R.id.myApplication_img_materialType_more)
    ImageView myApplicationImgMaterialTypeMore;
    @Bind(R.id.myApplication_linear_materialType)
    LinearLayout myApplicationLinearMaterialType;
    @Bind(R.id.myApplication_txt_materialUsing)
    EditText myApplicationTxtMaterialUsing;
    @Bind(R.id.myApplication_txt_materialDate)
    TextView myApplicationTxtMaterialDate;
    @Bind(R.id.myApplication_img_materialDate_more)
    ImageView myApplicationImgMaterialDateMore;
    @Bind(R.id.myApplication_linear_materialDate)
    LinearLayout myApplicationLinearMaterialDate;
    @Bind(R.id.myApplication_txt_confirm)
    TextView myApplicationTxtConfirm;
    @Bind(R.id.common_txt_right)
    TextView commonTxtRight;

    @Override
    public int setLayoutId() {
        return R.layout.activity_my_using_detail;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        int usingId = intent.getIntExtra("usingId", -1);
        if (usingId < 0) {
            myApplicationImgMaterialBrandMore.setVisibility(View.VISIBLE);
            myApplicationImgMaterialNameMore.setVisibility(View.VISIBLE);
            myApplicationImgMaterialTypeMore.setVisibility(View.VISIBLE);
            myApplicationImgMaterialDateMore.setVisibility(View.VISIBLE);
            myApplicationTxtConfirm.setVisibility(View.VISIBLE);
            myApplicationLinearMaterialBrand.setClickable(true);
            myApplicationLinearMaterialType.setClickable(true);
            myApplicationLinearMaterialDate.setClickable(true);
            myApplicationLinearMaterialName.setClickable(true);
        }
        commonTxtTitle.setText(usingId >= 0 ? "我的领用" : "材料领用");
        commonTxtRight.setText(usingId >= 0 ? "" : "领用历史");
        commonTxtRight.setVisibility(usingId >= 0 ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.common_txt_right, R.id.myApplication_linear_materialName, R.id.myApplication_linear_materialBrand, R.id.myApplication_linear_materialType, R.id.myApplication_linear_materialDate, R.id.myApplication_txt_confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.common_txt_right:
                startActivity(new Intent(this, MyUsingListActivity.class));
                break;
            case R.id.myApplication_linear_materialName:
                break;
            case R.id.myApplication_linear_materialBrand:
                break;
            case R.id.myApplication_linear_materialType:
                break;
            case R.id.myApplication_linear_materialDate:
                break;
            case R.id.myApplication_txt_confirm:
                Toast.makeText(MyUsingDetailActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
