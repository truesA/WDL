package com.wdl.amdroid_jwdl;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.fragment.DataFragment;
import com.wdl.amdroid_jwdl.fragment.MsgFragment;
import com.wdl.amdroid_jwdl.fragment.MyViewPagerAdapter;
import com.wdl.amdroid_jwdl.fragment.PersonFragment;
import com.wdl.amdroid_jwdl.fragment.SavingFragment;
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
    private long clickTime = 0; //记录第一次点击的时间
    public DataFragment dataFragment;
    public List<Fragment> fragments = new ArrayList();
    public MsgFragment msgFragment;
    public PersonFragment personFragment;
    public ServiceFragment serviceFragment;
    public SavingFragment savingFragment;
    private int bottomNavigationBarHeight;

    @BindView(R.id.view_page)
    public NoSlidingViewPaper viewPaper;


    private void initBottomNavigation() {
        bottomNavigationBar.setBackgroundStyle(2);
        bottomNavigationBar.setActiveColor("#FFFFFF").setInActiveColor(R.color.text_color06).setBarBackgroundColor(R.color.new_color3);
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

    private void initFragment(int bottomNavigationBarHeight) {
        dataFragment = new DataFragment();
        msgFragment = new MsgFragment();
        personFragment = new PersonFragment();
//        serviceFragment = new ServiceFragment();
        savingFragment=new SavingFragment();
        savingFragment.setBottomNavigationBarHeight(bottomNavigationBarHeight);
        fragments.add(dataFragment);
        fragments.add(msgFragment);
        fragments.add(personFragment);
//        fragments.add(serviceFragment);
        fragments.add(savingFragment);
    }

    protected int getlayoutview() {
        return R.layout.activity_main;
    }

    protected void initData() {
        viewPaper.setCurrentItem(0);

    }

    protected void initView() {
        initBottomNavigation();
        bottomNavigationBar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                bottomNavigationBar.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.e("TAG",
                        "bottomNavigationBar.getMeasuredWidth()=="
                                + bottomNavigationBar.getMeasuredWidth()+
                                "bottomNavigationBar.getMeasuredHeight()=="+bottomNavigationBar.getMeasuredHeight());
                bottomNavigationBarHeight=bottomNavigationBar.getMeasuredHeight();
                initFragment(bottomNavigationBarHeight);
                viewPaper.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), fragments));
                viewPaper.setOffscreenPageLimit(4);
            }
        });

    }

    protected boolean isUseToolsBar() {
        return false;
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }




    public void exit() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            UIUtils.showToast("再次点击退出");
            clickTime = System.currentTimeMillis();
        } else {
            AppManagerUtil.instance().AppExit(this);
        }
    }
    /**
     * 获取底部导航栏高度
     * @return
     */
    public int getbottomNavigationBarHeight(){
        return bottomNavigationBarHeight;
    }
}