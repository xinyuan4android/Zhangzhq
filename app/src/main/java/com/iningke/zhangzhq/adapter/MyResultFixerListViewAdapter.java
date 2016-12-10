package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.iningke.baseproject.utils.LogUtils;
import com.iningke.zhangzhq.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/12/8.
 */
public class MyResultFixerListViewAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
    private List<String> dataSource;
    private MyRefuseFixerListCheckBoxClickListener listener;

    public MyResultFixerListViewAdapter(List<String> dataSource, MyRefuseFixerListCheckBoxClickListener listener) {
        this.dataSource = dataSource;
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_refuse_fixerlist, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemRefuseFixerListCheckBox.setTag(position);
        holder.itemRefuseFixerListCheckBox.setOnCheckedChangeListener(this);
        holder.itemRefuseFixerListTxtName.setText(dataSource.get(position));
        return view;
    }


    @Override
    public void onCheckedChanged(CompoundButton v, boolean isChecked) {
        if (v.getTag() != null && v.getTag() instanceof Integer && listener != null) {
            LogUtils.e("onclick ---=-=-=");
            CheckBox checkBox = (CheckBox) v;
            int position = (int) v.getTag();
            listener.onRefuseFixerListCheckboxClick(checkBox, isChecked, position);
        }
    }

    static class ViewHolder {
        @Bind(R.id.item_refuse_fixerList_checkBox)
        CheckBox itemRefuseFixerListCheckBox;
        @Bind(R.id.item_refuse_fixerList_txtName)
        TextView itemRefuseFixerListTxtName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 拒绝工单 后，选择维修工 列表的checkbox 点击事件
     *
     * @author hxy
     * @date 2016/12/8
     */
    public interface MyRefuseFixerListCheckBoxClickListener {
        void onRefuseFixerListCheckboxClick(CheckBox checkBox, boolean isChecked, int position);
    }
}
