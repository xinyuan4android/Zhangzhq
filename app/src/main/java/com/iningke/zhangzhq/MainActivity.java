package com.iningke.zhangzhq;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.iningke.baseproject.utils.LogUtils;
import com.iningke.zhangzhq.base.ZhangzhqActivity;
import com.iningke.zhangzhq.fragment.ChangeFragmentHelper;
import com.iningke.zhangzhq.home.HomeFragment;
import com.iningke.zhangzhq.inter.App;
import com.iningke.zhangzhq.manage.ManageFragment;
import com.iningke.zhangzhq.mine.MineFragment;
import com.iningke.zhangzhq.service.ServiceFragment;

import butterknife.Bind;

public class MainActivity extends ZhangzhqActivity implements RadioGroup.OnCheckedChangeListener {


    @Bind(R.id.main_linearContainer)
    LinearLayout mainLinearContainer;
    @Bind(R.id.main_radioBtn_home)
    RadioButton mainRadioBtnHome;
    @Bind(R.id.main_radioBtn_manager)
    RadioButton mainRadioBtnManager;
    @Bind(R.id.main_radioBtn_service)
    RadioButton mainRadioBtnService;
    @Bind(R.id.main_radioBtn_mine)
    RadioButton mainRadioBtnMine;
    @Bind(R.id.main_radioGroup)
    RadioGroup mainRadioGroup;
    private FragmentManager manager;
    private HomeFragment homeFragment;
    private ManageFragment managerFragment;
    private MineFragment mineFragment;
    private ServiceFragment serviceFragment;
    private Fragment currentFragment;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        manager = getSupportFragmentManager();
        aboutRadioGroup();
        initFragment();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        managerFragment = new ManageFragment();
        mineFragment = new MineFragment();
        serviceFragment = new ServiceFragment();
//
//        ChangeFragmentHelper helper = new ChangeFragmentHelper();
//        helper.setTargetFragment(homeFragment);
//        MyApp.setCurrentFragment(App.Currentpage_HomeFragment);
//        ChangeFragmentHelper.changeFragment(helper, manager, R.id.main_linearContainer);
        MyApp.setCurrentFragment(App.Currentpage_HomeFragment);
        switchFragment(homeFragment);
    }

    private void aboutRadioGroup() {
        mainRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void initData() {

    }

    public FragmentManager getManager() {
        return manager;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Fragment fragment = null;
        ChangeFragmentHelper helper = new ChangeFragmentHelper();
        switch (checkedId) {
            case R.id.main_radioBtn_home:
//                fragment = new HomeFragment();
                fragment = homeFragment;
                MyApp.setCurrentFragment(App.Currentpage_HomeFragment);
                break;
            case R.id.main_radioBtn_manager:
                MyApp.setCurrentFragment(App.Currentpage_ManageFragment);
                fragment = managerFragment;
                break;
            case R.id.main_radioBtn_service:
                MyApp.setCurrentFragment(App.Currentpage_ServiceFragment);
                fragment = serviceFragment;
                break;
            case R.id.main_radioBtn_mine:
                MyApp.setCurrentFragment(App.Currentpage_MineFragment);
                fragment = mineFragment;
                break;
        }
        switchFragment(fragment);
//        helper.setTargetFragment(fragment);
//        ChangeFragmentHelper.changeFragment(helper, manager, R.id.main_linearContainer);
    }

    //fragment 切换
    private void switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction
                    .add(R.id.main_linearContainer, targetFragment)
                    .commit();
            LogUtils.e("还没添加呢");
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment)
                    .commit();
            LogUtils.e("添加了( ⊙o⊙ )哇");
        }
        currentFragment = targetFragment;
    }

    //水电气管理
    public void goToManageFragment() {
        mainRadioBtnManager.setChecked(true);
    }

    //维修服务
    public void goToServceFragment() {
        mainRadioBtnService.setChecked(true);
    }

    /**
     * 双击退出程序；
     */
    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                android.os.Process.killProcess(android.os.Process.myPid());
//                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}
