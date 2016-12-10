package com.iningke.baseproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.iningke.baseproject.utils.LoadingDialog;

import butterknife.ButterKnife;

/**
 * Created by iningke on 2016/6/1.
 */
public abstract class BaseFragment extends Fragment {
    public View view = null;
    private BaseActivity baseActivity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = null;
            ViewParent v = view.getParent();
            if (v instanceof ViewGroup) {
                parent = (ViewGroup) v;
            }
            if (null != parent) {
                parent.removeView(view);
            }
        } else {
            view = inflater.inflate(setLayoutId(), null);
            ButterKnife.bind(this, view);
            initView(view);
            addListener();
            initData(view);
        }
        return view;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.baseActivity = (BaseActivity) activity;
    }

    public BaseActivity getBaseActivity() {
        return baseActivity;
    }

    public void setBaseActivity(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    /**
     * 添加监听器
     *
     * @return
     */
    public void addListener() {
    }

    /**
     * 设置布局id
     *
     * @return
     */
    public abstract int setLayoutId();

    /**
     * 初始化师徒
     *
     * @return
     */
    public abstract void initView(View view);

    /**
     * 加载数据
     *
     * @return
     */
    public abstract void initData(View view);


    /**
     * view初始化
     */
    public View fingView(int id) {
        return view.findViewById(id);
    }


    /**
     * 跳转页面
     */
    public <T extends FragmentActivity> void gotoActivity(Class<T> clz, Bundle data) {
        Intent intent = new Intent(getActivity(), clz);
        intent.putExtra("data", data);
        getActivity().startActivity(intent);
    }

    public <T extends FragmentActivity> void gotoActivityForResult(Class<T> clz, Bundle data, int requestcode) {
        Intent intent = new Intent(getActivity(), clz);
        intent.putExtra("data", data);
        getActivity().startActivityForResult(intent, requestcode);
    }

    /**
     * 加载dialog
     */
    LoadingDialog dialog;

    public void showLoadingDialog(DialogInterface.OnDismissListener listener) {
        if (dialog == null) {

            dialog = new LoadingDialog(getActivity() == null ? getBaseActivity() : getActivity(), R.style.selectorDialog);
        }
        dialog.showDialog(listener);
    }

    public void dismissLoadingDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        dismissLoadingDialog();
    }
}
