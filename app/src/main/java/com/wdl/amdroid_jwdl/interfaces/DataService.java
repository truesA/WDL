package com.wdl.amdroid_jwdl.interfaces;

/**
 * Created by 62682 on 2018/3/20.
 */

import com.wdl.amdroid_jwdl.model.MainDataBean;
import com.wdl.amdroid_jwdl.model.MsgListBean;

import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public abstract interface DataService
{
    @GET("sa_kpi")
    public abstract Observable<MainDataBean> getMainData(@Query("sa_month") int paramInt);

    @GET("user_rank")
    public abstract Observable<MsgListBean> getMsgListBean(@QueryMap Map<String, String> paramMap);
}