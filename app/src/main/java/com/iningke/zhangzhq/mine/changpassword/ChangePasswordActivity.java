package com.iningke.zhangzhq.mine.changpassword;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 输入新密码 和确认密码 界面
 *
 * @author hxy
 * @date 2016/11/25
 */
public class ChangePasswordActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.changePassword_txt_next)
    TextView changePasswordTxtNext;
    @Bind(R.id.changePassword_edit_pwd)
    EditText changePasswordEditPwd;
    @Bind(R.id.changePassword_edit_pwdAgain)
    EditText changePasswordEditPwdAgain;

    @Override
    public int setLayoutId() {
        return R.layout.activity_change_password;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("修改密码");
        commonImgBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.changePassword_txt_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.changePassword_txt_next:
                changePassword();
                break;
        }
    }

    private void changePassword() {
        String pwd = changePasswordEditPwd.getText().toString();
        if ("".equals(pwd) || null == pwd) {
            Toast.makeText(ChangePasswordActivity.this, "请输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }
        String pwd_again = changePasswordEditPwdAgain.getText().toString();
        if ("".equals(pwd_again) || null == pwd_again) {
            Toast.makeText(ChangePasswordActivity.this, "请确认密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!pwd.equals(pwd_again)) {
            Toast.makeText(ChangePasswordActivity.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("result", 100);
        setResult(100, intent);
        finish();

    }
}
