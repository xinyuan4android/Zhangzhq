package com.iningke.zhangzhq.mine.workorder;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 评论activity
 *
 * @author hxy
 * @date 2016/11/24
 */
public class CommentActivity extends ZhangzhqActivity {

    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.comment_edit_content)
    EditText commentEditContent;
    @Bind(R.id.comment_btn_confrim)
    TextView commentBtnConfrim;

    @Override
    public int setLayoutId() {
        return R.layout.activity_comment;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("评论");
        commonImgBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.common_img_back, R.id.comment_btn_confrim})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_img_back:
                finish();
                break;
            case R.id.comment_btn_confrim:
                break;
        }
    }
}
