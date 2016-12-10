package com.iningke.zhangzhq.mine.collections;

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
 * 我的收藏列表
 *
 * @author hxy
 * @date 2016/11/25
 */
public class MyCollectionsListActivity extends ZhangzhqActivity implements PullToRefreshBase.OnRefreshListener2, AdapterView.OnItemClickListener {
    @Bind(R.id.common_img_back)
    ImageView commonImgBack;
    @Bind(R.id.common_txt_title)
    TextView commonTxtTitle;
    @Bind(R.id.common_img_right)
    ImageView commonImgRight;
    private PullToRefreshListView pullTo;
    private HomeNotifyPullToAdapter adapter;
    private List<BeanNotifyList> dataSource = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.activity_my_collections_list;
    }

    @Override
    public void initView() {
        commonImgBack.setVisibility(View.VISIBLE);
        commonTxtTitle.setText("我的收藏");
        pullTo = (PullToRefreshListView) findViewById(R.id.myCollections_pullTo);
        aboutPullTo();
    }

    private void aboutPullTo() {
        pullTo.setMode(PullToRefreshBase.Mode.BOTH);
        BeanNotifyList bean1 = new BeanNotifyList("会议通知1", "前天上午，四川大学华西医院呼吸科，一病人家属不相信护士配药过程，欲强行进入治疗室。护士反复告知家属不能进入并把门关上。谁知家属情绪激动，一怒之下撞门而入，结果导致护士面部受伤，缝合了8针。现肇事者被治安拘留10日。", "2016-10-02");
        BeanNotifyList bean2 = new BeanNotifyList("会议通知2", "前天上午，四川大学华西医院呼吸科，一病人家属不相信护士配药过程，欲强行进入治疗室。护士反复告知家属不能进入并把门关上。谁知家属情绪激动，一怒之下撞门而入，结果导致护士面部受伤，缝合了8针。现肇事者被治安拘留10日。", "2016-10-02");
        BeanNotifyList bean3 = new BeanNotifyList("会议通知3", "前天上午，四川大学华西医院呼吸科，一病人家属不相信护士配药过程，欲强行进入治疗室。护士反复告知家属不能进入并把门关上。谁知家属情绪激动，一怒之下撞门而入，结果导致护士面部受伤，缝合了8针。现肇事者被治安拘留10日。", "2016-10-02");
        BeanNotifyList bean4 = new BeanNotifyList("会议通知4", "前天上午，四川大学华西医院呼吸科，一病人家属不相信护士配药过程，欲强行进入治疗室。护士反复告知家属不能进入并把门关上。谁知家属情绪激动，一怒之下撞门而入，结果导致护士面部受伤，缝合了8针。现肇事者被治安拘留10日。", "2016-10-02");
        BeanNotifyList bean5 = new BeanNotifyList("会议通知5", "前天上午，四川大学华西医院呼吸科，一病人家属不相信护士配药过程，欲强行进入治疗室。护士反复告知家属不能进入并把门关上。谁知家属情绪激动，一怒之下撞门而入，结果导致护士面部受伤，缝合了8针。现肇事者被治安拘留10日。", "2016-10-02");
        Collections.addAll(dataSource, bean1, bean2, bean4, bean3, bean5);
        adapter = new HomeNotifyPullToAdapter(dataSource);
        pullTo.setAdapter(adapter);
        pullTo.setOnRefreshListener(this);
        pullTo.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
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
        Toast.makeText(MyCollectionsListActivity.this, "position ==" + position, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.common_img_back)
    public void onClick() {
        finish();
    }
}
