package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.bean.BeanDeviceInformationList;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/11/28.
 */
public class DeviceInformationListViewAdapter extends BaseAdapter {
    private List<BeanDeviceInformationList> dataSource;

    public DeviceInformationListViewAdapter(List<BeanDeviceInformationList> dataSource) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_deviceinformation_listview, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemDeviceInformationListViewContent.setText(dataSource.get(position).getContent());
        holder.itemDeviceInformationListViewName.setText(dataSource.get(position).getName());
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_deviceInformation_listView_name)
        TextView itemDeviceInformationListViewName;
        @Bind(R.id.item_deviceInformation_listView_content)
        TextView itemDeviceInformationListViewContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
