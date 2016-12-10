package com.iningke.zhangzhq.mine.changePhone;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.utils.AppUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class ChangePhoneNextActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.changePhoneNext_edit_phoneNumber)
    EditText changePhoneNextEditPhoneNumber;
    @Bind(R.id.changePhoneNext_edit_verificationCode)
    EditText changePhoneNextEditVerificationCode;
    @Bind(R.id.changePhoneNext_txt_getVerificationCode)
    TextView changePhoneNextTxtGetVerificationCode;
    @Bind(R.id.changePhoneNext_linear_getVerificationCode)
    LinearLayout changePhoneNextLinearGetVerificationCode;
    @Bind(R.id.changePhoneNext_txt_next)
    TextView changePhoneNextTxtNext;
    @Bind(R.id.changePhoneNext_txt_contactService)
    TextView changePhoneNextTxtContactService;

    private int seconds = 60;

    @Override
    public int setLayoutId() {
        return R.layout.activity_change_phone_next;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("换绑手机号");
        commonImgBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.common_img_back, R.id.changePhoneNext_linear_getVerificationCode, R.id.changePhoneNext_txt_next, R.id.changePhoneNext_txt_contactService})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.changePhoneNext_linear_getVerificationCode:
                getVerificationCode();
                break;
            case R.id.changePhoneNext_txt_next:
                changePhone();
                break;
            case R.id.changePhoneNext_txt_contactService:
                checkPermission(Manifest.permission.CALL_PHONE, App.RequestCode_CallPhone);
                break;
        }
    }

    @Override
    protected void permissionDenied(int requestCode) {
        super.permissionDenied(requestCode);
    }

    @Override
    protected void permissionGrant(int requestCode) {
        super.permissionGrant(requestCode);
        AppUtils.callPhone("18363853990");
    }

    private void changePhone() {
        Intent intent = new Intent();
        intent.putExtra("result", 100);
        setResult(100, intent);
        finish();
    }

    private void getVerificationCode() {
        if ("获取验证码".equals(changePhoneNextTxtGetVerificationCode.getText().toString())) {
            changePhoneNextLinearGetVerificationCode.setEnabled(false);
            changePhoneNextTxtGetVerificationCode.setTextColor(getResources().getColor(R.color.txt_second_8b8d8f));
            changePhoneNextTxtGetVerificationCode.setText("60s后获取");
            handler.sendEmptyMessageDelayed(100, 1000);
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (seconds > 0) {
                seconds--;
                changePhoneNextTxtGetVerificationCode.setText(seconds + "s后获取");
                handler.sendEmptyMessageDelayed(100, 1000);
            } else {
                changePhoneNextLinearGetVerificationCode.setEnabled(true);
                changePhoneNextTxtGetVerificationCode.setText("获取验证码");
                changePhoneNextTxtGetVerificationCode.setTextColor(getResources().getColor(R.color.theme));
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(100);
    }
}
