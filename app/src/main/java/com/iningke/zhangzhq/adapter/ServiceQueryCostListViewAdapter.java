package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqFragment;
import com.iningke.zhangzhq.bean.BeanServiceQueryCost;
import com.iningke.zhangzhq.inter.App;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 维修费用查询 圆饼图下面的listview的adapter
 *
 * @author hxy
 * @date 2016/11/22
 */

public class ServiceQueryCostListViewAdapter extends BaseAdapter {
    private List<BeanServiceQueryCost> dataSource;
    //    private ZhangzhqActivity mActivity;
    private ZhangzhqFragment mFragment;

    public ServiceQueryCostListViewAdapter(List<BeanServiceQueryCost> dataSource, ZhangzhqFragment mFragment) {
        this.dataSource = dataSource;
        this.mFragment = mFragment;
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service_querycost_listview, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemServiceQueryCostCostMoney.setText("￥" + dataSource.get(position).getCostMoney());
        holder.itemServiceQueryCostType.setText(dataSource.get(position).getTypeName());
//        Glide.with(mFragment)
//                .load(dataSource.get(position).getImgUrl())
//                .into(holder.itemServiceQueryCostImg);
        holder.itemServiceQueryCostTxtImg.setBackgroundColor(App.colors[position]);
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_service_queryCost_img)
        ImageView itemServiceQueryCostImg;
        @Bind(R.id.item_service_queryCost_type)
        TextView itemServiceQueryCostType;
        @Bind(R.id.item_service_queryCost_costMoney)
        TextView itemServiceQueryCostCostMoney;
        @Bind(R.id.item_service_queryCost_txtImg)
        TextView itemServiceQueryCostTxtImg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
