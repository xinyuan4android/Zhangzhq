package com.iningke.zhangzhq.login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.mine.changePhone.ChangePhoneActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 登录 界面
 *
 * @author hxy
 * @date 2016/11/25
 */
public class LoginActivity extends ZhangzhqActivity {


    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.login_edit_pwd)
    EditText loginEditPwd;
    @Bind(R.id.login_edit_userName)
    EditText loginEditUserName;
    @Bind(R.id.login_txt_login)
    TextView loginTxtLogin;
    @Bind(R.id.login_txt_register)
    TextView loginTxtRegister;
    @Bind(R.id.login_txt_forget)
    TextView loginTxtForget;

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("登录");
        commonImgBack.setVisibility(View.VISIBLE);

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.common_img_back, R.id.login_txt_login, R.id.login_txt_register, R.id.login_txt_forget})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.login_txt_login:
                aboutLogin();
                break;
            case R.id.login_txt_register:
                Intent intent_register = new Intent(this, RegisterActivity.class);
                startActivity(intent_register);
                break;
            case R.id.login_txt_forget:
                Intent intent = new Intent(this, ChangePhoneActivity.class);
                intent.putExtra("type", 100);
                startActivity(intent);
                break;
        }
    }

    private void aboutLogin() {
        String userName = loginEditUserName.getText().toString();
        if ("".equals(userName) || null == userName) {
            Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        String pwd = loginEditPwd.getText().toString();
        if ("".equals(pwd) || null == pwd) {
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
