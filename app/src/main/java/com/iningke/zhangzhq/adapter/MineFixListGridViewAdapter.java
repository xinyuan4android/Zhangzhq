package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqFragment;
import com.joooonho.SelectableRoundedImageView;

import java.util.List;

/**
 * Created by hxy on  2016/11/18.
 */
public class MineFixListGridViewAdapter extends BaseAdapter implements View.OnClickListener {
    private List<String> dataSource;
    private ZhangzhqFragment mFragment;
    private MyGridViewOnItemClickListener listener;
    private int position_parent;


    public MineFixListGridViewAdapter(List<String> dataSource, ZhangzhqFragment mFragment, MyGridViewOnItemClickListener listener) {
        this.dataSource = dataSource;
        this.mFragment = mFragment;
        this.listener = listener;
    }

    public void setPosition_parent(int position_parent) {
        this.position_parent = position_parent;
    }

    public void setDataSource(List<String> dataSource) {
        if (this.dataSource != null) {
            this.dataSource.clear();
            this.dataSource.addAll(dataSource);
        }
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_gridview, null);
        SelectableRoundedImageView imageView = (SelectableRoundedImageView) view.findViewById(R.id.item_listView_gridView_img);
        imageView.setOnClickListener(this);
        imageView.setTag(R.id.glide_tag_id, position);
        Glide.with(mFragment)
                .load(dataSource.get(position))
                .asBitmap()
                .into(imageView);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getTag(R.id.glide_tag_id) != null && v.getTag(R.id.glide_tag_id) instanceof Integer) {
            Integer position = (Integer) v.getTag(R.id.glide_tag_id);
            listener.onMyGridItemClick(position, position_parent);
        }
    }

    public interface MyGridViewOnItemClickListener {
        void onMyGridItemClick(int position, int position_parent);
    }
}
