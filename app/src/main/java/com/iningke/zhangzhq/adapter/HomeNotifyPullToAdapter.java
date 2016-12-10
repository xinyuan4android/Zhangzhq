package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.bean.BeanNotifyList;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/11/23.
 */
public class HomeNotifyPullToAdapter extends BaseAdapter {
    private List<BeanNotifyList> dataSource;

    public HomeNotifyPullToAdapter(List<BeanNotifyList> dataSource) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notify_pullto, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemNotifyContent.setText(dataSource.get(position).getContent());
        holder.itemNotifyDate.setText(dataSource.get(position).getDate());
        holder.itemNotifyTitle.setText(dataSource.get(position).getTitle());
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_notify_title)
        TextView itemNotifyTitle;
        @Bind(R.id.item_notify_content)
        TextView itemNotifyContent;
        @Bind(R.id.item_notify_date)
        TextView itemNotifyDate;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
