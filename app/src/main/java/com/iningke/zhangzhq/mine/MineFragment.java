package com.iningke.zhangzhq.mine;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.baseproject.utils.LogUtils;
import com.iningke.zhangzhq.MyApp;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqFragment;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.login.LoginActivity;
import com.iningke.zhangzhq.mine.applications.MyApplicationsListActivity;
import com.iningke.zhangzhq.mine.changePhone.ChangePhoneActivity;
import com.iningke.zhangzhq.mine.collections.MyCollectionsListActivity;
import com.iningke.zhangzhq.mine.comment.MyCommentListActivity;
import com.iningke.zhangzhq.mine.safe.SafeHistoryListActivity;
import com.iningke.zhangzhq.mine.stock.StockQueryActivity;
import com.iningke.zhangzhq.mine.use.MyUsingListActivity;
import com.iningke.zhangzhq.mine.userinfo.UserBaseInformationActivity;
import com.iningke.zhangzhq.mine.workorder.MineFixActivity;
import com.iningke.zhangzhq.myview.CircleImageView;
import com.iningke.zhangzhq.service.ServiceQueryCostActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 个人 中心 fragment
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends ZhangzhqFragment {


    @Bind(R.id.mine_img_avatar)
    CircleImageView mineImgAvatar;
    @Bind(R.id.mine_txt_name)
    TextView mineTxtName;
    @Bind(R.id.mine_linear_fix)
    LinearLayout mineLinearFix;
    @Bind(R.id.mine_linear_cost)
    LinearLayout mineLinearCost;
    @Bind(R.id.mine_linear_stock)
    LinearLayout mineLinearStock;
    @Bind(R.id.mine_linear_comment)
    LinearLayout mineLinearComment;
    @Bind(R.id.mine_linear_collection)
    LinearLayout mineLinearCollection;
    @Bind(R.id.mine_linear_suggest)
    LinearLayout mineLinearSuggest;
    @Bind(R.id.mine_linear_changePhone)
    LinearLayout mineLinearChangePhone;
    @Bind(R.id.mine_linear_modifyPwd)
    LinearLayout mineLinearModifyPwd;
    @Bind(R.id.mine_linear_logOut)
    LinearLayout mineLinearLogOut;
    @Bind(R.id.mine_txt_profession)
    TextView mineTxtProfession;
    @Bind(R.id.mine_linear_userInfo)
    LinearLayout mineLinearUserInfo;
    @Bind(R.id.mine_workOrder_waitAccept_img)
    ImageView mineWorkOrderWaitAcceptImg;
    @Bind(R.id.mine_workOrder_waitAccept_count)
    TextView mineWorkOrderWaitAcceptCount;
    @Bind(R.id.mine_workOrder_waitAccept_txt)
    TextView mineWorkOrderWaitAcceptTxt;
    @Bind(R.id.mine_workOrder_waitAccept_linear)
    LinearLayout mineWorkOrderWaitAcceptLinear;
    @Bind(R.id.mine_workOrder_waitFix_img)
    ImageView mineWorkOrderWaitFixImg;
    @Bind(R.id.mine_workOrder_waitFix_count)
    TextView mineWorkOrderWaitFixCount;
    @Bind(R.id.mine_workOrder_waitFix_txt)
    TextView mineWorkOrderWaitFixTxt;
    @Bind(R.id.mine_workOrder_waitFix_linear)
    LinearLayout mineWorkOrderWaitFixLinear;
    @Bind(R.id.mine_workOrder_waitCheck_img)
    ImageView mineWorkOrderWaitCheckImg;
    @Bind(R.id.mine_workOrder_waitCheck_count)
    TextView mineWorkOrderWaitCheckCount;
    @Bind(R.id.mine_workOrder_waitCheck_txt)
    TextView mineWorkOrderWaitCheckTxt;
    @Bind(R.id.mine_workOrder_waitCheck_linear)
    LinearLayout mineWorkOrderWaitCheckLinear;
    @Bind(R.id.mine_workOrder_finish_img)
    ImageView mineWorkOrderFinishImg;
    @Bind(R.id.mine_workOrder_finish_count)
    TextView mineWorkOrderFinishCount;
    @Bind(R.id.mine_workOrder_finish_txt)
    TextView mineWorkOrderFinishTxt;
    @Bind(R.id.mine_workOrder_finish_linear)
    LinearLayout mineWorkOrderFinishLinear;
    @Bind(R.id.mine_linear_applications)
    LinearLayout mineLinearApplications;
    @Bind(R.id.mine_linear_safeHistory)
    LinearLayout mineLinearSafeHistory;
    @Bind(R.id.mine_linear_use)
    LinearLayout mineLinearUse;
    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_txt_right)
    TextView commonTxtRight;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    @Bind(R.id.mine_linear_workMan_fix)
    LinearLayout mineLinearWorkManFix;
    @Bind(R.id.mine_workOrder_waitAccept_workMan_img)
    ImageView mineWorkOrderWaitAcceptWorkManImg;
    @Bind(R.id.mine_workOrder_waitAccept_workMan_count)
    TextView mineWorkOrderWaitAcceptWorkManCount;
    @Bind(R.id.mine_workOrder_waitAccept_workMan_workMan_txt)
    TextView mineWorkOrderWaitAcceptWorkManWorkManTxt;
    @Bind(R.id.mine_workOrder_waitAccept_workMan_linear)
    LinearLayout mineWorkOrderWaitAcceptWorkManLinear;
    @Bind(R.id.mine_workOrder_waitFix_workMan_img)
    ImageView mineWorkOrderWaitFixWorkManImg;
    @Bind(R.id.mine_workOrder_waitFix_workMan_count)
    TextView mineWorkOrderWaitFixWorkManCount;
    @Bind(R.id.mine_workOrder_waitFix_workMan_txt)
    TextView mineWorkOrderWaitFixWorkManTxt;
    @Bind(R.id.mine_workOrder_waitFix_workMan_linear)
    LinearLayout mineWorkOrderWaitFixWorkManLinear;
    @Bind(R.id.mine_workOrder_waitCheck_workMan_img)
    ImageView mineWorkOrderWaitCheckWorkManImg;
    @Bind(R.id.mine_workOrder_waitCheck_workMan_count)
    TextView mineWorkOrderWaitCheckWorkManCount;
    @Bind(R.id.mine_workOrder_waitCheck_workMan_txt)
    TextView mineWorkOrderWaitCheckWorkManTxt;
    @Bind(R.id.mine_workOrder_waitCheck_workMan_linear)
    LinearLayout mineWorkOrderWaitCheckWorkManLinear;
    @Bind(R.id.mine_workOrder_finish_workMan_img)
    ImageView mineWorkOrderFinishWorkManImg;
    @Bind(R.id.mine_workOrder_finish_workMan_count)
    TextView mineWorkOrderFinishWorkManCount;
    @Bind(R.id.mine_workOrder_finish_workMan_txt)
    TextView mineWorkOrderFinishWorkManTxt;
    @Bind(R.id.mine_workOrder_finish_workMan_linear)
    LinearLayout mineWorkOrderFinishWorkManLinear;
    @Bind(R.id.mine_linear_Workman)
    LinearLayout mineLinearWorkman;
    @Bind(R.id.mine_workOrder_refuse_img)
    ImageView mineWorkOrderRefuseImg;
    @Bind(R.id.mine_workOrder_refuse_count)
    TextView mineWorkOrderRefuseCount;
    @Bind(R.id.mine_workOrder_refuse_txt)
    TextView mineWorkOrderRefuseTxt;
    @Bind(R.id.mine_workOrder_refuse_linear)
    LinearLayout mineWorkOrderRefuseLinear;
    @Bind(R.id.mine_linear_notWorkman)
    LinearLayout mineLinearNotWorkman;

    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MyApp.getCurrentFragment() == App.Currentpage_MineFragment) {
            LogUtils.e("-------------mineFragment  onResume-------------");
        }
    }

    @Override
    public void initView(View view) {
        commonTxtTitle.setText("个人中心");
    }

    @Override
    public void initData(View view) {

    }


    @OnClick({R.id.mine_linear_workMan_fix, R.id.mine_workOrder_waitAccept_workMan_linear, R.id.mine_workOrder_waitFix_workMan_linear, R.id.mine_workOrder_waitCheck_workMan_linear, R.id.mine_workOrder_finish_workMan_linear
            , R.id.mine_img_avatar, R.id.mine_linear_userInfo, R.id.mine_linear_safeHistory, R.id.mine_workOrder_waitAccept_linear, R.id.mine_workOrder_waitFix_linear, R.id.mine_workOrder_waitCheck_linear, R.id.mine_workOrder_finish_linear, R.id.mine_linear_applications, R.id.mine_linear_use,
            R.id.mine_workOrder_refuse_linear, R.id.mine_txt_name, R.id.mine_linear_fix, R.id.mine_linear_cost, R.id.mine_linear_stock, R.id.mine_linear_comment, R.id.mine_linear_collection, R.id.mine_linear_suggest, R.id.mine_linear_changePhone, R.id.mine_linear_modifyPwd, R.id.mine_linear_logOut})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_img_avatar:
            case R.id.mine_txt_name:
                startActivity(new Intent(getContext(), UserBaseInformationActivity.class));
                break;
            case R.id.mine_workOrder_waitAccept_linear:
                jumpTpMyFixActivity(App.state_wait_accept - 1, App.type_role_notWorkMan);
                break;
            case R.id.mine_workOrder_waitFix_linear:
                jumpTpMyFixActivity(App.state_wait_fix - 1, App.type_role_notWorkMan);
                break;
            case R.id.mine_workOrder_waitCheck_linear:
                jumpTpMyFixActivity(App.state_wait_check - 1, App.type_role_notWorkMan);
                break;
            case R.id.mine_workOrder_finish_linear:
                jumpTpMyFixActivity(App.state_wait_finish - 1, App.type_role_notWorkMan);
                break;
            case R.id.mine_workOrder_refuse_linear:
                jumpTpMyFixActivity(App.state_wait_refuse - 1, App.type_role_notWorkMan);
                break;
            case R.id.mine_linear_fix:
                jumpTpMyFixActivity(0, App.type_role_notWorkMan);
                break;
            case R.id.mine_linear_workMan_fix:
                jumpTpMyFixActivity(0, App.type_role_workMan);
                break;
            case R.id.mine_workOrder_waitAccept_workMan_linear:
                jumpTpMyFixActivity(App.state_wait_accept - 1, App.type_role_workMan);
                break;
            case R.id.mine_workOrder_waitFix_workMan_linear:
                jumpTpMyFixActivity(App.state_wait_fix - 1, App.type_role_workMan);
                break;
            case R.id.mine_workOrder_waitCheck_workMan_linear:
                jumpTpMyFixActivity(App.state_wait_check - 1, App.type_role_workMan);
                break;
            case R.id.mine_workOrder_finish_workMan_linear:
                jumpTpMyFixActivity(App.state_wait_finish - 1, App.type_role_workMan);
                break;
            case R.id.mine_linear_cost:
                //维修费用查询
                startActivity(new Intent(getContext(), ServiceQueryCostActivity.class));
                break;
            case R.id.mine_linear_stock:
                //库存查询
                startActivity(new Intent(getContext(), StockQueryActivity.class));
                break;
            case R.id.mine_linear_comment:
                //我的评论
                startActivity(new Intent(getContext(), MyCommentListActivity.class));
                break;
            case R.id.mine_linear_collection:
                //我的收藏
                startActivity(new Intent(getContext(), MyCollectionsListActivity.class));
                break;
            case R.id.mine_linear_suggest:
                //意见反馈
                startActivity(new Intent(getContext(), SuggestActivity.class));
                break;
            case R.id.mine_linear_changePhone:
                //换绑手机号
                Intent intent_chagePhone = new Intent(getContext(), ChangePhoneActivity.class);
                intent_chagePhone.putExtra("type", 300);
                startActivity(intent_chagePhone);
                break;
            case R.id.mine_linear_modifyPwd:
                //修改密码
                Intent intent_changePwd = new Intent(getContext(), ChangePhoneActivity.class);
                intent_changePwd.putExtra("type", 200);
                startActivity(intent_changePwd);
                break;
            case R.id.mine_linear_logOut:
                Intent intent_login = new Intent(getContext(), LoginActivity.class);
                startActivity(intent_login);
                break;
            case R.id.mine_linear_userInfo:
                break;
            case R.id.mine_linear_applications:
                //我的申购
                startActivity(new Intent(getContext(), MyApplicationsListActivity.class));
                break;
            case R.id.mine_linear_use:
                //我的领用
                startActivity(new Intent(getContext(), MyUsingListActivity.class));
                break;
            case R.id.mine_linear_safeHistory:
                //巡检记录
                startActivity(new Intent(getContext(), SafeHistoryListActivity.class));
                break;
        }
    }

    private void jumpTpMyFixActivity(int selectionType, int role) {
        Intent intent = new Intent(getContext(), MineFixActivity.class);
        intent.putExtra("selection", selectionType);
        intent.putExtra("role", role);
        startActivity(intent);
    }

}
