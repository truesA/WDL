package com.wdl.jwdl.fragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.wdl.jwdl.R;
import com.wdl.jwdl.activity.Login2Activity;
import com.wdl.jwdl.base.BaseFragment;
import com.wdl.jwdl.util.AppManagerUtil;
import com.wdl.jwdl.util.PreferencesUtil;

import butterknife.BindView;


/**
 * Created by Achers on 2017/11/22.
 */

public class PersonFragment extends BaseFragment {

    @BindView(R.id.m_main_fab)
    FloatingActionButton m_main_fab;

    @Override
    protected void initView() {

    }

    @Override
    protected View setRootView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.person_fg, container, false);


        return view;
    }

    @Override
    public void initData() {
        m_main_fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramView) {
                new MaterialDialog.Builder(getActivity())
                        .title("退出登录").positiveText("确定退出")
                        .negativeText("取消")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                                PreferencesUtil.getInstance(getActivity()).setLogin(false);
                                Intent intent = new Intent(getActivity(), Login2Activity.class);
                                startActivity(intent);
                                AppManagerUtil.instance().finishAllActivity();
                            }
                        }).show();
            }
        });
    }
}
