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

public interface DataService {
    @GET(API.Main_Data)
    Observable<MainDataBean> getMainData(@QueryMap Map<String, String> paramMap);
//            @Query("sa_year") int sa_year,@Query("sa_month") int sa_month);

    @GET(API.Main_msg)
    Observable<MsgListBean> getMsgListBean(@QueryMap Map<String, String> paramMap);
}