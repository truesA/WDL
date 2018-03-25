package com.wdl.amdroid_jwdl;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.fragment.DataFragment;
import com.wdl.amdroid_jwdl.fragment.MsgFragment;
import com.wdl.amdroid_jwdl.fragment.MyViewPagerAdapter;
import com.wdl.amdroid_jwdl.fragment.PersonFragment;
import com.wdl.amdroid_jwdl.fragment.ServiceFragment;
import com.wdl.amdroid_jwdl.util.AppManagerUtil;
import com.wdl.amdroid_jwdl.util.UIUtils;
import com.wdl.amdroid_jwdl.view.NoSlidingViewPaper;

import butterknife.BindView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation_bar)
    public BottomNavigationBar bottomNavigationBar;
    private long clickTime = 0L;
    public DataFragment dataFragment;
    public List<Fragment> fragments = new ArrayList();
    public MsgFragment msgFragment;
    public PersonFragment personFragment;
    public ServiceFragment serviceFragment;

    @BindView(R.id.view_page)
    public NoSlidingViewPaper viewPaper;


    private void initBottomNavigation() {
        bottomNavigationBar.setBackgroundStyle(2);
        bottomNavigationBar.setActiveColor("#FFFFFF").setInActiveColor(R.color.text_color06).setBarBackgroundColor(R.color.color1);
        bottomNavigationBar.setMode(1);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.mub_icon_color, "目标")
                .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.mub_icon_nocolor)))
                .addItem(new BottomNavigationItem(R.mipmap.basepan_icon_color, "基盘")
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.basepan_icon_nocolor)))
                .addItem(new BottomNavigationItem(R.mipmap.person_icon_color, "人脉")
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.person_icon_nocolor)))
                .addItem(new BottomNavigationItem(R.mipmap.money_icon_color, "储蓄")
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.money_icon_nocolor))).initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            public void onTabReselected(int paramInt) {
            }

            public void onTabSelected(int paramInt) {
                viewPaper.setCurrentItem(paramInt, false);
            }

            public void onTabUnselected(int paramInt) {
            }
        });
    }

    private void initFragment() {
        dataFragment = new DataFragment();
        msgFragment = new MsgFragment();
        personFragment = new PersonFragment();
        serviceFragment = new ServiceFragment();
        fragments.add(dataFragment);
        fragments.add(msgFragment);
        fragments.add(personFragment);
        fragments.add(serviceFragment);
    }

    protected int getlayoutview() {
        return R.layout.activity_main;
    }

    protected void initData() {
        viewPaper.setCurrentItem(0);
    }

    protected void initView() {
        initFragment();
        viewPaper.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), fragments));
        viewPaper.setOffscreenPageLimit(4);
        initBottomNavigation();
    }

    protected boolean isUseToolsBar() {
        return false;
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            if (System.currentTimeMillis() - clickTime > 2000L) {
                UIUtils.showToast("再次点击退出");
                clickTime = System.currentTimeMillis();
            } else {
                AppManagerUtil.instance().finishActivity();
            }

        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }
}