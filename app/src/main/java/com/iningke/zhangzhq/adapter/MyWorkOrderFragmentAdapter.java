package com.iningke.zhangzhq.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;

/**
 * Created by hxy on  2016/11/24.
 */
public class MyWorkOrderFragmentAdapter extends FragmentPagerAdapter {
    private LinkedList<Fragment> frags;

    public MyWorkOrderFragmentAdapter(FragmentManager fm, LinkedList<Fragment> frags) {
        super(fm);
        this.frags = frags;
    }

    @Override
    public int getCount() {
        if (frags != null) {
            return frags.size();
        }
        return 0;
    }


    @Override
    public Fragment getItem(int position) {
        if (frags != null) {
            return frags.get(position);
        }
        return null;
    }
}
