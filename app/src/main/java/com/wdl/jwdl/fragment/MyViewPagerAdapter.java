package com.wdl.jwdl.fragment;

/**
 * Created by 62682 on 2018/3/21.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter
{
    List<Fragment> list;

    public MyViewPagerAdapter(FragmentManager paramFragmentManager)
    {
        super(paramFragmentManager);
    }

    public MyViewPagerAdapter(FragmentManager paramFragmentManager, List<Fragment> paramList)
    {
        super(paramFragmentManager);
        this.list = paramList;
    }

    public int getCount()
    {
        return this.list.size();
    }

    public Fragment getItem(int paramInt)
    {
        return ((Fragment)this.list.get(paramInt));
    }

    public CharSequence getPageTitle(int paramInt)
    {
        if (paramInt == 0)
            return "预约";
        if (paramInt == 1)
            return "继续";
        if (paramInt == 2)
            return "放弃";
        return "流失";
    }
}