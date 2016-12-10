package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqFragment;
import com.iningke.zhangzhq.bean.BeanMineFixPullToListView;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.mine.workorder.MineFixFragment;
import com.iningke.zhangzhq.myview.MyGridView;
import com.iningke.zhangzhq.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/11/19.
 */
public class MineFixPullToListViewAdapter extends BaseAdapter implements View.OnClickListener {
    private List<BeanMineFixPullToListView> dataSource;
    private ZhangzhqFragment mFragment;
    private MineFixListGridViewAdapter.MyGridViewOnItemClickListener listener;
    private MyFixPullToBtnOnClickListener mListener;

    public MineFixPullToListViewAdapter(List<BeanMineFixPullToListView> dataSource, ZhangzhqFragment mFragment, MineFixListGridViewAdapter.MyGridViewOnItemClickListener listener, MyFixPullToBtnOnClickListener mListener) {
        this.dataSource = dataSource;
        this.mFragment = mFragment;
        this.listener = listener;
        this.mListener = mListener;
    }

    @Override
    public int getCount() {
        if (dataSource != null) {
            return dataSource.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder holder = null;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine_fix_pulltolistview, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
            MineFixListGridViewAdapter adapter = new MineFixListGridViewAdapter(new ArrayList<String>(), mFragment, listener);
            holder.itemMineFixGridView.setAdapter(adapter);
            holder.itemMineFixGridView.setTag(adapter);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemMineFixTitle.setText(dataSource.get(position).getTitle());
        holder.itemMineFixContent.setText(dataSource.get(position).getContent());
        holder.itemMineFixDate.setText(dataSource.get(position).getDate());
        holder.itemMineFixOrderNum.setText(dataSource.get(position).getId());
        holder.itemMineFixState.setText(AppUtils.getStringState(dataSource.get(position).getState()));
        holder.itemMineFixBtnLeft.setOnClickListener(this);
        holder.itemMineFixBtnLeft.setTag(position);
        holder.itemMineFixBtnRight.setOnClickListener(this);
        holder.itemMineFixBtnRight.setTag(position);
        switch (((MineFixFragment) mFragment).getRole()) {
            case App.type_role_notWorkMan:
                switch (dataSource.get(position).getState()) {
                    case App.state_wait_accept:
                        holder.itemMineFixBtnLeft.setVisibility(View.INVISIBLE);
                        holder.itemMineFixBtnRight.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnRight.setText("去评论");
                        break;
                    case App.state_wait_fix:
                        holder.itemMineFixBtnLeft.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnRight.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnLeft.setText("去评论");
                        holder.itemMineFixBtnRight.setText("联系对方");
                        break;
                    case App.state_wait_check:
                        holder.itemMineFixBtnLeft.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnRight.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnLeft.setText("去评论");
                        holder.itemMineFixBtnRight.setText("确认通过");
                        break;
                    case App.state_wait_comment:
                        holder.itemMineFixBtnLeft.setVisibility(View.INVISIBLE);
                        holder.itemMineFixBtnRight.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnRight.setText("去评论");
                        break;
                    case App.state_wait_finish:
                        holder.itemMineFixBtnLeft.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnRight.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnLeft.setText("删除工单");
                        holder.itemMineFixBtnRight.setText("去评论");
                        break;
                }
                break;
            case App.type_role_workMan:
                switch (dataSource.get(position).getState()) {
                    case App.state_wait_accept:
                        holder.itemMineFixBtnLeft.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnRight.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnLeft.setText("拒绝");
                        holder.itemMineFixBtnRight.setText("受理");
                        break;
                    case App.state_wait_fix:
                        holder.itemMineFixBtnLeft.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnRight.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnLeft.setText("联系对方");
                        holder.itemMineFixBtnRight.setText("维修完毕");
                        break;
                    case App.state_wait_check:
                        holder.itemMineFixBtnLeft.setVisibility(View.GONE);
                        holder.itemMineFixBtnRight.setVisibility(View.GONE);
                        holder.itemMineFixBtnLeft.setText("");
                        holder.itemMineFixBtnRight.setText("");
                        break;
                    case App.state_wait_comment:
                        holder.itemMineFixBtnLeft.setVisibility(View.INVISIBLE);
                        holder.itemMineFixBtnRight.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnRight.setText("去评论");
                        break;
                    case App.state_wait_finish:
                        holder.itemMineFixBtnLeft.setVisibility(View.INVISIBLE);
                        holder.itemMineFixBtnRight.setVisibility(View.VISIBLE);
                        holder.itemMineFixBtnRight.setText("删除工单");
                        break;
                }
                break;
        }

        MineFixListGridViewAdapter adapter = (MineFixListGridViewAdapter) holder.itemMineFixGridView.getTag();
        adapter.setDataSource(dataSource.get(position).getImgUrls());
        adapter.setPosition_parent(position);
        adapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() != null && v.getTag() instanceof Integer) {
            int position = (int) v.getTag();
            switch (v.getId()) {
                case R.id.item_mine_fix_btn_left:
                    mListener.myFixPullToBtnOnClickLeft(v, position);
                    break;
                case R.id.item_mine_fix_btn_right:
                    mListener.myFixPullToBtnOnClickRight(v, position);
                    break;
            }
        }
    }

    static class ViewHolder {
        @Bind(R.id.item_mine_fix_orderNum)
        TextView itemMineFixOrderNum;
        @Bind(R.id.item_mine_fix_state)
        TextView itemMineFixState;
        @Bind(R.id.item_mine_fix_date)
        TextView itemMineFixDate;
        @Bind(R.id.item_mine_fix_title)
        TextView itemMineFixTitle;
        @Bind(R.id.item_mine_fix_content)
        TextView itemMineFixContent;
        @Bind(R.id.item_mine_fix_gridView)
        MyGridView itemMineFixGridView;
        @Bind(R.id.item_mine_fix_btn_left)
        TextView itemMineFixBtnLeft;
        @Bind(R.id.item_mine_fix_btn_right)
        TextView itemMineFixBtnRight;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public interface MyFixPullToBtnOnClickListener {
        void myFixPullToBtnOnClickLeft(View view, int position);

        void myFixPullToBtnOnClickRight(View view, int position);

    }
}
