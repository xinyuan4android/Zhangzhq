package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqFragment;
import com.iningke.zhangzhq.bean.BeanHomeListView;
import com.iningke.zhangzhq.myview.CircleImageView;
import com.iningke.zhangzhq.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/11/18.
 */
public class HomeListViewAdapter extends BaseAdapter {
    private List<BeanHomeListView> dataSource;
    private ZhangzhqFragment mfragment;
    private HomeListGridViewAdapter.MyGridViewOnItemClickListener listener;

    public HomeListViewAdapter(List<BeanHomeListView> dataSource, ZhangzhqFragment mfragment, HomeListGridViewAdapter.MyGridViewOnItemClickListener listener) {
        this.dataSource = dataSource;
        this.mfragment = mfragment;
        this.listener = listener;
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_listview, null);
            holder = new ViewHolder(view);
            HomeListGridViewAdapter adapter = new HomeListGridViewAdapter(new ArrayList<String>(), mfragment, listener);
            holder.itemHomeGridView.setAdapter(adapter);
            holder.itemHomeGridView.setTag(adapter);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemHomeAddress.setText(dataSource.get(position).getAddress());
        holder.itemHomeContent.setText(dataSource.get(position).getContent());
        holder.itemHomeName.setText(dataSource.get(position).getName());
        holder.itemHomeTime.setText(dataSource.get(position).getTime());
        holder.itemHomeState.setImageResource(AppUtils.getState(dataSource.get(position).getType()));
        HomeListGridViewAdapter adapter = (HomeListGridViewAdapter) holder.itemHomeGridView.getTag();
        adapter.setDataSource(dataSource.get(position).getImgUrl());
        adapter.setPosition_parent(position);
        adapter.notifyDataSetChanged();
//        HomeListGridViewAdapter adapter = new HomeListGridViewAdapter(dataSource.get(position).getImgUrl(), mfragment, listener);
//        adapter.setPosition_parent(position);
//        holder.itemHomeGridView.setAdapter(adapter);

        return view;
    }


    static class ViewHolder {
        @Bind(R.id.item_home_avatar)
        CircleImageView itemHomeAvatar;
        @Bind(R.id.item_home_name)
        TextView itemHomeName;
        @Bind(R.id.item_home_time)
        TextView itemHomeTime;
        @Bind(R.id.item_home_state)
        ImageView itemHomeState;
        @Bind(R.id.item_home_address)
        TextView itemHomeAddress;
        @Bind(R.id.item_home_content)
        TextView itemHomeContent;
        @Bind(R.id.item_home_gridView)
        GridView itemHomeGridView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
