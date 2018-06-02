package com.wdl.amdroid_jwdl.activity;

/**
 * author：lhm on 2018/3/24 14:25
 * <p>
 * email：3186834196@qq.com
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.fragment.MyViewPagerAdapter;
import com.wdl.amdroid_jwdl.fragment.business.ContinueFragment;
import com.wdl.amdroid_jwdl.fragment.business.LostFragment;
import com.wdl.amdroid_jwdl.fragment.business.ReservationFragment;
import com.wdl.amdroid_jwdl.fragment.business.WaiverFragment;

import butterknife.BindView;

import java.util.ArrayList;
import java.util.List;

public class MsgBusinessActivity extends BaseActivity
        implements TabLayout.OnTabSelectedListener {
    private String carName;
    private String carUesrid;

    @BindView(R.id.car_user_viewpage)
    public ViewPager car_user_viewpage;
    private ContinueFragment continueFragment;
    public List<Fragment> fragments = new ArrayList();
    private LostFragment lostFragment;
    private ReservationFragment reservationFragment;
    private WaiverFragment waiverFragment;
    @BindView(R.id.tl_tab)
    public TabLayout tl_tab;

    private int submit_appoint = 0;
    private int submit_continue = 0;
    private int submit_giveup = 0;
    private int submit_loss = 0;


    private void initFragment() {
        reservationFragment = new ReservationFragment();
        reservationFragment.setCarUseridandSubmitStatus(carUesrid,submit_appoint);

        continueFragment = new ContinueFragment();
        continueFragment.setCarUseridandSubmitStatus(carUesrid,submit_continue);

        waiverFragment = new WaiverFragment();
        waiverFragment.setCarUseridandSubmitStatus(carUesrid,submit_giveup);

        lostFragment = new LostFragment();
        lostFragment.setCarUseridandSubmitStatus(carUesrid,submit_loss);

        fragments.add(reservationFragment);
        fragments.add(continueFragment);
        fragments.add(waiverFragment);
        fragments.add(lostFragment);
    }

    protected int getlayoutview() {
        return R.layout.activity_car_user_msg_main;
    }

    protected void initData() {
    }

    protected void initView() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int i = bundle.getInt("position");
        carUesrid = bundle.getString("carUserid");
        carName = bundle.getString("carPai");
        submit_appoint = bundle.getInt("submit_appoint");
        submit_continue = bundle.getInt("submit_continue");
        submit_giveup = bundle.getInt("submit_giveup");
        submit_loss = bundle.getInt("submit_loss");
        getToolbarTitle().setText(carName);
        initFragment();
        MyViewPagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragments);
        car_user_viewpage.setAdapter(pagerAdapter);
        tl_tab.setOnTabSelectedListener(this);
        tl_tab.setupWithViewPager(car_user_viewpage, false);
        //tl_tab.setTabTextColors();
        tl_tab.setTabGravity(0);
        tl_tab.setTabMode(1);
        tl_tab.getTabAt(i).select();
    }

    public void onTabReselected(TabLayout.Tab Tab) {
    }

    public void onTabSelected(TabLayout.Tab Tab) {
        int i = Tab.getPosition();
        car_user_viewpage.setCurrentItem(i, false);
    }

    public void onTabUnselected(TabLayout.Tab Tab) {
    }
}
