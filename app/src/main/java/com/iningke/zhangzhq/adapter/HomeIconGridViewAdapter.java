package com.iningke.zhangzhq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.utils.UIUtils;
import com.joooonho.SelectableRoundedImageView;

/**
 * Created by hxy on  2016/11/14.
 */
public class HomeIconGridViewAdapter extends BaseAdapter {
    private int[] imgRes;
    private String[] txts;
    private int width_screen;

    public HomeIconGridViewAdapter(int[] imgRes, String[] txts) {
        this.imgRes = imgRes;
        this.txts = txts;
        width_screen = UIUtils.getDisplayWidth() / 4 - 20;
    }

    @Override
    public int getCount() {
        if (imgRes != null) {
            return imgRes.length;
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_icon_gridview, null);
            holder = new ViewHolder();
            holder.img = (SelectableRoundedImageView) view.findViewById(R.id.image);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width_screen, width_screen);
            holder.img.setLayoutParams(layoutParams);
            holder.txt = (TextView) view.findViewById(R.id.txt);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.img.setImageResource(imgRes[position]);
        holder.txt.setText(txts[position]);
        return view;
    }

    private class ViewHolder {
        private SelectableRoundedImageView img;
        private TextView txt;
    }
}
