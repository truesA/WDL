package com.wdl.amdroid_jwdl.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseFragment;


/**
 * Created by Achers on 2017/11/22.
 */

public class PersonFragment extends BaseFragment {



    @Override
    protected void initView() {

    }

    @Override
    protected View setRootView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.person_fg, container,false);


        return view;
    }

    @Override
    public void initData() {

    }
}
