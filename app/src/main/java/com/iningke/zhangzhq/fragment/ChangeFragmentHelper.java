package com.iningke.zhangzhq.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by iningke on 2016/7/7.
 */
public class ChangeFragmentHelper {
    //目标跳转Fragment
    private Fragment targetFragment;

    //是否返回主界面；
    private boolean isGoMainFragment;

    //是否返回上一级；
    private boolean isGoBackStackBack;

    //是否清空回退栈
    private boolean isClearStackBack;

    //是否加入到回退栈
    private String targetFragmentTag;

    //给目标Fragment传递Bundle值
    private Bundle bundle;

    public boolean isGoMainFragment() {
        return isGoMainFragment;
    }

    public void setIsGoMainFragment(boolean isGoMainFragment) {
        this.isGoMainFragment = isGoMainFragment;
    }

    public Fragment getTargetFragment() {
        return targetFragment;
    }

    public void setTargetFragment(Fragment targetFragment) {
        this.targetFragment = targetFragment;
    }

    public boolean isGoBackStackBack() {
        return isGoBackStackBack;
    }

    public void setIsGoBackStackBack(boolean isGoBackStackBack) {
        this.isGoBackStackBack = isGoBackStackBack;
    }

    public boolean isClearStackBack() {
        return isClearStackBack;
    }

    public void setIsClearStackBack(boolean isClearStackBack) {
        this.isClearStackBack = isClearStackBack;
    }

    public String getTargetFragmentTag() {
        return targetFragmentTag;
    }

    public void setTargetFragmentTag(String targetFragmentTag) {
        this.targetFragmentTag = targetFragmentTag;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    /**
     * @param helper
     * @param manager
     * @param intContainer
     */
    public static void changeFragment(ChangeFragmentHelper helper, FragmentManager manager, @IdRes int intContainer) {
        Fragment targetFragment = helper.getTargetFragment();

        boolean clearStackBack = helper.isClearStackBack();

        boolean goBackStackBack = helper.isGoBackStackBack();

        String targetFragmentTag = helper.getTargetFragmentTag();

        Bundle bundle = helper.getBundle();
        if (bundle != null) {
            targetFragment.setArguments(bundle);
        }
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if (targetFragment != null) {

            fragmentTransaction.replace(intContainer, targetFragment);


        }
        if (targetFragmentTag != null) {
            fragmentTransaction.addToBackStack(targetFragmentTag);
        }
        if (clearStackBack) {
            manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        if (goBackStackBack) {
            manager.popBackStack();
        }
        fragmentTransaction.commit();
    }
}
