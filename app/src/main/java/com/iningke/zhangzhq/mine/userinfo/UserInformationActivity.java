package com.iningke.zhangzhq.mine.userinfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 个人资料
 *
 * @author hxy
 * @date 2016/12/1
 */
public class UserInformationActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.userInfo_txt_area)
    TextView userInfoTxtArea;
    @Bind(R.id.userInfo_linear_area)
    LinearLayout userInfoLinearArea;
    @Bind(R.id.userInfo_txt_hospital)
    TextView userInfoTxtHospital;
    @Bind(R.id.userInfo_linear_hospital)
    LinearLayout userInfoLinearHospital;
    @Bind(R.id.userInfo_txt_department)
    TextView userInfoTxtDepartment;
    @Bind(R.id.userInfo_linear_department)
    LinearLayout userInfoLinearDepartment;
    @Bind(R.id.userInfo_txt_role)
    TextView userInfoTxtRole;
    @Bind(R.id.userInfo_linear_role)
    LinearLayout userInfoLinearRole;
    @Bind(R.id.userInfo_txt_realName)
    TextView userInfoTxtRealName;
    @Bind(R.id.userInfo_linear_realName)
    LinearLayout userInfoLinearRealName;
    @Bind(R.id.userInfo_txt_phone)
    TextView userInfoTxtPhone;
    @Bind(R.id.userInfo_linear_phone)
    LinearLayout userInfoLinearPhone;
    @Bind(R.id.userInfo_txt_email)
    TextView userInfoTxtEmail;
    @Bind(R.id.userInfo_linear_email)
    LinearLayout userInfoLinearEmail;

    @Override
    public int setLayoutId() {
        return R.layout.activity_user_information;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("个人资料");
        commonImgBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }
}
