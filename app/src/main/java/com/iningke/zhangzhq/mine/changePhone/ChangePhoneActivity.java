package com.iningke.zhangzhq.mine.changePhone;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.mine.changpassword.ChangePasswordActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 换绑手机号
 *
 * @author hxy
 * @date 2016/11/25
 */
public class ChangePhoneActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.changePhone_edit_phoneNumber)
    EditText changePhoneEditPhoneNumber;
    @Bind(R.id.changePhone_edit_verificationCode)
    EditText changePhoneEditVerificationCode;
    @Bind(R.id.changePhone_txt_getVerificationCode)
    TextView changePhoneTxtGetVerificationCode;
    @Bind(R.id.changePhone_linear_getVerificationCode)
    LinearLayout changePhoneLinearGetVerificationCode;
    @Bind(R.id.changePhone_txt_next)
    TextView changePhoneTxtNext;

    private int seconds = 60;
    private int type;

    @Override
    public int setLayoutId() {
        return R.layout.activity_change_phone;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        type = intent.getIntExtra("type", -1);
        switch (type) {
            case 100:
                //忘记密码
                commonTxtTitle.setText("找回密码");
                break;
            case 200:
                //修改密码
                commonTxtTitle.setText("修改密码");
                break;
            case 300:
                //绑定新手机号
                commonTxtTitle.setText("换绑手机号");
                break;
        }
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.changePhone_linear_getVerificationCode, R.id.changePhone_txt_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.changePhone_linear_getVerificationCode:
                getVerificationCode();
                break;
            case R.id.changePhone_txt_next:
                jumpToNext();
                break;
        }
    }

    private void jumpToNext() {
        String phone = changePhoneEditPhoneNumber.getText().toString();
        if (phone.length() != 11) {
            Toast.makeText(ChangePhoneActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        String verificationCode = changePhoneEditVerificationCode.getText().toString();
        if ("".equals(verificationCode) || null == verificationCode) {
            Toast.makeText(ChangePhoneActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }
        switch (type) {
            case 100:
            case 200:
                //忘记密码
                //修改密码
                startActivityForResult(new Intent(this, ChangePasswordActivity.class), 200);
                break;
            case 300:
                //绑定新手机号
                startActivityForResult(new Intent(this, ChangePhoneNextActivity.class), 200);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        int result = data.getIntExtra("result", -1);
        switch (result) {
            case 100:
                finish();
                break;
        }
    }

    private void getVerificationCode() {
        if ("获取验证码".equals(changePhoneTxtGetVerificationCode.getText().toString())) {
            changePhoneLinearGetVerificationCode.setEnabled(false);
            changePhoneTxtGetVerificationCode.setTextColor(getResources().getColor(R.color.txt_second_8b8d8f));
            changePhoneTxtGetVerificationCode.setText("60s后获取");
            handler.sendEmptyMessageDelayed(100, 1000);
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (seconds > 0) {
                seconds--;
                changePhoneTxtGetVerificationCode.setText(seconds + "s后获取");
                handler.sendEmptyMessageDelayed(100, 1000);
            } else {
                changePhoneLinearGetVerificationCode.setEnabled(true);
                changePhoneTxtGetVerificationCode.setText("获取验证码");
                changePhoneTxtGetVerificationCode.setTextColor(getResources().getColor(R.color.theme));
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(100);
    }
}
