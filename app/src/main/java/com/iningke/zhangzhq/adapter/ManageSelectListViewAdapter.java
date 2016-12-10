package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iningke.zhangzhq.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/11/19.
 */
public class ManageSelectListViewAdapter extends BaseAdapter {
    private List<String> dataSource;

    public ManageSelectListViewAdapter(List<String> dataSource) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manage_select_listview, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemManageSelectListViewTxt.setText(dataSource.get(position));
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_manage_select_listView_txt)
        TextView itemManageSelectListViewTxt;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
