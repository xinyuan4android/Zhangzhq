package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.bean.BeanSafeHistoryList;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/12/3.
 */
public class MySafeHisrtoryListAdapter extends BaseAdapter {
    private List<BeanSafeHistoryList> dataSource;

    public MySafeHisrtoryListAdapter(List<BeanSafeHistoryList> dataSource) {
        this.dataSource = dataSource;
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_safehistory_list, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemSafeHistoryContent.setText(dataSource.get(position).getContent());
        holder.itemSafeHistoryDate.setText(dataSource.get(position).getDate());
        holder.itemSafeHistoryTitle.setText(dataSource.get(position).getTitle());
        holder.itemSafeHistoryAddress.setText(dataSource.get(position).getAddress());
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_safeHistory_title)
        TextView itemSafeHistoryTitle;
        @Bind(R.id.item_safeHistory_date)
        TextView itemSafeHistoryDate;
        @Bind(R.id.item_safeHistory_content)
        TextView itemSafeHistoryContent;
        @Bind(R.id.item_safeHistory_address)
        TextView itemSafeHistoryAddress;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
