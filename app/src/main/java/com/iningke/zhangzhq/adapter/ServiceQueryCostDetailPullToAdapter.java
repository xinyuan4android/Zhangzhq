package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.bean.BeanServiceQueryCostDetailPullTo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/11/22.
 */
public class ServiceQueryCostDetailPullToAdapter extends BaseAdapter {
    private List<BeanServiceQueryCostDetailPullTo> dataSource;

    public ServiceQueryCostDetailPullToAdapter(List<BeanServiceQueryCostDetailPullTo> dataSource) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service_querycost_detail_pullto, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemServiceQueryCostDetailContent.setText(dataSource.get(position).getContent());
        holder.itemServiceQueryCostDetailDate.setText(dataSource.get(position).getDate());
        holder.itemServiceQueryCostDetailMoney.setText("￥" + dataSource.get(position).getMoney());
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_service_queryCost_detail_date)
        TextView itemServiceQueryCostDetailDate;
        @Bind(R.id.item_service_queryCost_detail_money)
        TextView itemServiceQueryCostDetailMoney;
        @Bind(R.id.item_service_queryCost_detail_content)
        TextView itemServiceQueryCostDetailContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
