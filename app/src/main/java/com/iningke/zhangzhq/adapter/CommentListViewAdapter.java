package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.bean.BeanCommentList;
import com.iningke.zhangzhq.myview.CircleImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/11/23.
 */
public class CommentListViewAdapter extends BaseAdapter {
    private List<BeanCommentList> dataSource;
    private ZhangzhqActivity mActivity;

    public CommentListViewAdapter(List<BeanCommentList> dataSource, ZhangzhqActivity mActivity) {
        this.dataSource = dataSource;
        this.mActivity = mActivity;
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workorder_commentlist, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemCommentContent.setText(dataSource.get(position).getContent());
        holder.itemCommentName.setText(dataSource.get(position).getName());
        holder.itemCommentTime.setText(dataSource.get(position).getDate());
        Glide.with(mActivity)
                .load(dataSource.get(position).getImgUrl())
                .into(holder.itemCommentAvatar);
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_comment_avatar)
        CircleImageView itemCommentAvatar;
        @Bind(R.id.item_comment_name)
        TextView itemCommentName;
        @Bind(R.id.item_comment_time)
        TextView itemCommentTime;
        @Bind(R.id.item_comment_content)
        TextView itemCommentContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
