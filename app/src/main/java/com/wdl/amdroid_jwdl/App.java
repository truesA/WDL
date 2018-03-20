package com.wdl.amdroid_jwdl;

/**
 * Created by 62682 on 2018/3/20.
 */

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.wdl.amdroid_jwdl.util.log.LogUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import okhttp3.logging.HttpLoggingInterceptor.Logger;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class App extends Application {
    private static final String TAG = "Degin_TAG";
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

    public void onCreate() {
        super.onCreate();
        context = this;
        LogUtils.initParam(true);
        HttpLoggingInterceptor localHttpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            public void log(String paramString) {
                Log.i("Degin_TAG", paramString);
            }
        });
        localHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .addInterceptor(localHttpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .readTimeout(35L, TimeUnit.SECONDS)
                .connectTimeout(35L, TimeUnit.SECONDS)
                .build();
        MultiDex.install(this);
    }
}