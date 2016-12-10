package com.iningke.zhangzhq.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.LinkedList;

/**
 * Created by iningke on 2016/7/7.
 */
public class GuideViewPagerAdapter extends PagerAdapter {
    private LinkedList<ImageView> dataSource;
    //    private Context context;
    private MyOnClickListener listener;

    public GuideViewPagerAdapter(LinkedList<ImageView> dataSource, MyOnClickListener listener) {
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
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView = dataSource.get(position & (dataSource.size()));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == dataSource.size() - 1) {
                    listener.myOnClick(view);
                }
            }
        });
        container.addView(imageView);
        return imageView;
    }

    public interface MyOnClickListener {
        void myOnClick(View view);
    }
}
