package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.bean.BeanMyCommentList;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hxy on  2016/11/25.
 */
public class MyCommentListAdapter extends BaseAdapter implements View.OnClickListener {
    private List<BeanMyCommentList> dataSource;
    private MyCommentListDeleteOnClickLlistener listener;

    public MyCommentListAdapter(List<BeanMyCommentList> dataSource, MyCommentListDeleteOnClickLlistener listener) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mycomment_pullto, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
            holder.itemMyCommentImgDelete.setOnClickListener(this);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemMyCommentContent.setText(dataSource.get(position).getContent());
        holder.itemMyCommentDate.setText(dataSource.get(position).getDate());
        holder.itemMyCommentWorkOrderNo.setText(dataSource.get(position).getWorkOrderNo());
        holder.itemMyCommentImgDelete.setTag(position);
        return view;
    }

    @Override
    public void onClick(View v) {
        Object tag = v.getTag();
        if (tag != null && tag instanceof Integer) {
            int position = (int) v.getTag();
            listener.onMyCommentListDeleteClick(position);
        }
    }

    static class ViewHolder {
        @Bind(R.id.item_myComment_workOrderNo)
        TextView itemMyCommentWorkOrderNo;
        @Bind(R.id.item_myComment_img_delete)
        ImageView itemMyCommentImgDelete;
        @Bind(R.id.item_myComment_content)
        TextView itemMyCommentContent;
        @Bind(R.id.item_myComment_date)
        TextView itemMyCommentDate;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public interface MyCommentListDeleteOnClickLlistener {
        void onMyCommentListDeleteClick(int position);
    }
}
