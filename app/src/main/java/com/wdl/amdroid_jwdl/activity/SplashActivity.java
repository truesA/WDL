package com.wdl.amdroid_jwdl.activity;

import android.os.Bundle;
import android.util.Log;


import com.wdl.amdroid_jwdl.MainActivity;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.util.PreferencesUtil;

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
                        Log.e("Long", aLong + "");
                        if (PreferencesUtil.getInstance(SplashActivity.this).isLogin()) {
                            finish();
                            startActivity(MainActivity.class);

                        } else {
                            finish();
                            startActivity(LoginActivity.class);
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
