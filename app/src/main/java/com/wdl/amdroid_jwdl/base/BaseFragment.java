package com.wdl.amdroid_jwdl.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wdl.amdroid_jwdl.util.PreferencesUtil;

import butterknife.ButterKnife;


/**
 * Created by lenovo on 2017/6/28.
 */
public abstract class BaseFragment extends Fragment {

    protected Context context;
    protected View rootView;
    /**
     * TODO 重写父类方法，完成绑定界面布局，注解界面
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     * @see Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.context = getActivity();
        // to load the page (the LayoutInflater inflater passed on to the next
        // page)
        rootView = setRootView((LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE),container);

        ButterKnife.bind(this,rootView);//绑定framgent
        return rootView;
    }

    /**
     * TODO 重写父类方法，完成初始化类的工作，调用 initView();requestServiceHook();initData();
     * @param savedInstanceState
     * @see Fragment#onActivityCreated(Bundle)
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

        initData();
    }

    /**
     * TODO 获取Fragment当前布局实例
     * @return View 返回View的实例
     */
    public View getContentView() {
        return rootView;
    }

    /**
     * TODO 抽象方法，实现初始化控件逻辑
     */
    protected abstract void initView();

    /**
     * TODO 抽象方法，实现设定Fragment的布局
     * @param inflater
     * @param container
     * @return View
     */
    protected abstract View setRootView(LayoutInflater inflater,ViewGroup container);

    /**
     * TODO 抽象方法，实现数据初始化逻辑
     */
    public abstract void initData();


    /**
     * 通过键值对形式保存信息到本地
     * @param key 键值
     * @param //obj object类型
     */
    protected void saveParam(String key, Object object) {
        PreferencesUtil.getInstance(context).saveParam(key, object);
    }

    /**
     * 通过键值获取本地存储的信息
     * @param key
     * @param //defaultObject
     * @return Object
     */
    protected String getString(String key) {
        return (String) PreferencesUtil.getInstance(context).getParam(key, "");
    }

}
