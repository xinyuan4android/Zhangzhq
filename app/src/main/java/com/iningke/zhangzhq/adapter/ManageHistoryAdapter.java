package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.bean.BeanManageHistory;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/11/19.
 */
public class ManageHistoryAdapter extends BaseAdapter {
    private List<BeanManageHistory> dataSource;

    public ManageHistoryAdapter(List<BeanManageHistory> dataSource) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manage_history, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemManageHistoryAmount.setText(dataSource.get(position).getAmont());
        holder.itemManageHistoryMoney.setText(dataSource.get(position).getMoney());
        holder.itemManageHistoryMonth.setText(dataSource.get(position).getDate());
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_manage_history_month)
        TextView itemManageHistoryMonth;
        @Bind(R.id.item_manage_history_amount)
        TextView itemManageHistoryAmount;
        @Bind(R.id.item_manage_history_money)
        TextView itemManageHistoryMoney;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
