package com.wdl.jwdl;

/**
 * Created by 62682 on 2018/3/20.
 */

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.crashreport.CrashReport;
import com.wdl.jwdl.util.UIUtils;
import com.wdl.jwdl.util.log.LogUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class App extends Application {
    private static final String TAG = "APP_TAG";
    private static final int TIMEOUT_CONNECTION = 35;
    private static final int TIMEOUT_READ = 35;
    public static OkHttpClient client;
    private static Context context;
    private static Retrofit retrofit;

    public static Context getAppContext() {
        return context;
    }

    public static Retrofit getRetrofit(String paramString) {
        retrofit = new Retrofit.Builder().baseUrl(paramString)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        MultiDex.install(getApplicationContext());
        LogUtils.initParam(true);
        HttpLoggingInterceptor localHttpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            public void log(String paramString) {
                Log.i("WDL  App  Log", paramString);
            }
        });
        localHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .addInterceptor(localHttpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .readTimeout(10000, TimeUnit.SECONDS)
                .connectTimeout(10000, TimeUnit.SECONDS)
                .build();
        configBugly();
    }

    private void configBugly() {

        Beta.initDelay = 5 * 1000;
        Beta.upgradeCheckPeriod = 60 * 1000;
        Beta.canShowUpgradeActs.add(MainActivity.class);
//        Beta.upgradeDialogLayoutId = R.layout.upgrade_dialog;

        Bugly.init(getApplicationContext(), "6845ca5a4c", false);


    }
}