package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.bean.BeanMyUsingList;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/11/24.
 */
public class MyUsingListAdapter extends BaseAdapter {
    private List<BeanMyUsingList> dataSource;

    public MyUsingListAdapter(List<BeanMyUsingList> dataSource) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_myusing_pullto, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemMyUsingBrand.setText(dataSource.get(position).getBrand());
        holder.itemMyUsingCount.setText(dataSource.get(position).getCount() + "");
        holder.itemMyUsingDate.setText(dataSource.get(position).getDate());
        holder.itemMyUsingName.setText(dataSource.get(position).getName());
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_myUsing_name)
        TextView itemMyUsingName;
        @Bind(R.id.item_myUsing_brand)
        TextView itemMyUsingBrand;
        @Bind(R.id.item_myUsing_date)
        TextView itemMyUsingDate;
        @Bind(R.id.item_myUsing_count)
        TextView itemMyUsingCount;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
