package com.wdl.jwdl.activity;

import android.os.Bundle;


import com.wdl.jwdl.MainActivity;
import com.wdl.jwdl.R;
import com.wdl.jwdl.base.BaseActivity;
import com.wdl.jwdl.util.PreferencesUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * 启动页
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);

        // full(true);

        Observable.timer(3, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (PreferencesUtil.getInstance(SplashActivity.this).isLogin()) {
                            finish();
                            startActivity(MainActivity.class);

                        } else {
                            finish();
                            startActivity(Login2Activity.class);
                        }
                    }
                });

    }

    @Override
    protected boolean isUseToolsBar() {
        return false;
    }

    @Override
    protected int getlayoutview() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {


    }


}
