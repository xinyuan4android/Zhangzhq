package com.iningke.zhangzhq.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.adapter.HomeNotifyPullToAdapter;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.bean.BeanNotifyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 通知公告 activity
 *
 * @author hxy
 * @date 2016/11/23
 */

public class NotifyActivity extends ZhangzhqActivity implements PullToRefreshBase.OnRefreshListener2, AdapterView.OnItemClickListener {
    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    private PullToRefreshListView pullTo;

    private List<BeanNotifyList> dataSource = new ArrayList<>();
    private HomeNotifyPullToAdapter adapter;

    @Override

    public int setLayoutId() {
        return R.layout.activity_notify;
    }

    @Override
    public void initView() {
        commonTxtTitle.setText("通知公告");
        commonImgBack.setVisibility(View.VISIBLE);
        pullTo = (PullToRefreshListView) findViewById(R.id.notify_pullTo);
        abtouPullTo();
    }

    private void abtouPullTo() {
        pullTo.setMode(PullToRefreshBase.Mode.BOTH);
        BeanNotifyList bean1 = new BeanNotifyList("会议通知1text", "前天上午，四川大学华西医院呼吸科，一病人家属不相信护士配药过程，欲强行进入治疗室。护士反复告知家属不能进入并把门关上。谁知家属情绪激动，一怒之下撞门而入，结果导致护士面部受伤，缝合了8针。现肇事者被治安拘留10日。", "2016-10-02");
        BeanNotifyList bean2 = new BeanNotifyList("会议通知1text", "前天上午，四川大学华西医院呼吸科，一病人家属不相信护士配药过程，欲强行进入治疗室。护士反复告知家属不能进入并把门关上。谁知家属情绪激动，一怒之下撞门而入，结果导致护士面部受伤，缝合了8针。现肇事者被治安拘留10日。", "2016-10-02");
        BeanNotifyList bean3 = new BeanNotifyList("会议通知1text", "前天上午，四川大学华西医院呼吸科，一病人家属不相信护士配药过程，欲强行进入治疗室。护士反复告知家属不能进入并把门关上。谁知家属情绪激动，一怒之下撞门而入，结果导致护士面部受伤，缝合了8针。现肇事者被治安拘留10日。", "2016-10-02");
        BeanNotifyList bean4 = new BeanNotifyList("会议通知1text", "前天上午，四川大学华西医院呼吸科，一病人家属不相信护士配药过程，欲强行进入治疗室。护士反复告知家属不能进入并把门关上。谁知家属情绪激动，一怒之下撞门而入，结果导致护士面部受伤，缝合了8针。现肇事者被治安拘留10日。", "2016-10-02");
        BeanNotifyList bean5 = new BeanNotifyList("会议通知1text", "前天上午，四川大学华西医院呼吸科，一病人家属不相信护士配药过程，欲强行进入治疗室。护士反复告知家属不能进入并把门关上。谁知家属情绪激动，一怒之下撞门而入，结果导致护士面部受伤，缝合了8针。现肇事者被治安拘留10日。", "2016-10-02");
        Collections.addAll(dataSource, bean1, bean2, bean4, bean3, bean5);
        adapter = new HomeNotifyPullToAdapter(dataSource);
        pullTo.setAdapter(adapter);
        pullTo.setOnRefreshListener(this);
        pullTo.setOnItemClickListener(this);
    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        //下拉刷新
        pullTo.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullTo.onRefreshComplete();
            }
        }, 500);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        //上啦加载
        pullTo.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullTo.onRefreshComplete();
            }
        }, 500);
    }

    /**
     * item点击事件
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        position--;
        Toast.makeText(NotifyActivity.this, "position ==" + position, Toast.LENGTH_SHORT).show();
    }
}
