package com.iningke.zhangzhq.mine;

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
 * 建议反馈
 *
 * @author hxy
 * @date 2016/11/23
 */
public class SuggestActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.suggest_edit_content)
    EditText suggestEditContent;
    @Bind(R.id.suggest_edit_contact)
    EditText suggestEditContact;
    @Bind(R.id.suggest_btn_confirm)
    TextView suggestBtnConfirm;

    @Override
    public int setLayoutId() {
        return R.layout.activity_suggest;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("意见反馈");
        commonImgBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.suggest_btn_confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.suggest_btn_confirm:
                aboutConfirm();
                break;
        }
    }

    private void aboutConfirm() {
        String content = suggestEditContent.getText().toString();
        if ("".equals(content) || null == content) {
            Toast.makeText(SuggestActivity.this, "请输入建议内容", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(SuggestActivity.this, "反馈成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
