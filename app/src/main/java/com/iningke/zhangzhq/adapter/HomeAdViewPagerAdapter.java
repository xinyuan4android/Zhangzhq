package com.iningke.zhangzhq.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqFragment;
import com.iningke.zhangzhq.bean.BeanAdViewPager;
import com.iningke.zhangzhq.myview.viewpager.CarouselPagerAdapter;
import com.iningke.zhangzhq.myview.viewpager.CarouselViewPager;
import com.joooonho.SelectableRoundedImageView;

import java.util.List;

/**
 * Created by hxy on  2016/11/15.
 */
public class HomeAdViewPagerAdapter extends CarouselPagerAdapter<CarouselViewPager> implements View.OnClickListener {
    private List<BeanAdViewPager> dataSource;
    private MyAdOnClickListener listener;
    private ZhangzhqFragment mfragment;


    public HomeAdViewPagerAdapter(CarouselViewPager viewPager, List<BeanAdViewPager> dataSource, MyAdOnClickListener listener, ZhangzhqFragment mfragment) {
        super(viewPager);
        this.dataSource = dataSource;
        this.mfragment = mfragment;
        this.listener = listener;
    }

    @Override
    public int getCountOfVisual() {
        if (dataSource != null) {
            return dataSource.size();
        }
        return 0;
    }

    @Override
    public Object instantiateRealItem(ViewGroup container, int position) {

        SelectableRoundedImageView imageView = new SelectableRoundedImageView(mfragment.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        imageView.setCornerRadiiDP(0f, 0f, 0f, 0f);
        imageView.setOnClickListener(this);
        imageView.setTag(R.id.glide_tag_id, position);
        Glide.with(mfragment)
                .load(dataSource.get(position).getImgUrl())
                .asBitmap()
                .into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void onClick(View v) {
        if (v.getTag(R.id.glide_tag_id) != null && v.getTag(R.id.glide_tag_id) instanceof Integer) {
            Integer position = (Integer) v.getTag(R.id.glide_tag_id);
            listener.myOnClick(position);
        }
    }

    public interface MyAdOnClickListener {
        void myOnClick(int position);
    }
}
