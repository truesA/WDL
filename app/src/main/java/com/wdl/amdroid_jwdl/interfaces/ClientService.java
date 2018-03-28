package com.wdl.amdroid_jwdl.interfaces;

import com.wdl.amdroid_jwdl.model.BaseBean;
import com.wdl.amdroid_jwdl.model.MainDataBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * author：lhm on 2018/3/28 22:52
 * <p>
 * email：3186834196@qq.com
 *
 * 客户相关
 */
public interface ClientService {
    @GET(API.Client_identity)
    Observable<MainDataBean> getClientIdentity(@Query("id") int id);

    @GET(API.Client_behavior)
    Observable<MainDataBean> getClientBehavior(@Query("id") int id);

    @GET(API.Client_loyalty)
    Observable<MainDataBean> ClientLoyalty(@Query("id") int id);

    @GET(API.Client_value)
    Observable<MainDataBean> getClientValue(@Query("id") int id);

    @GET(API.Client_sticky)
    Observable<MainDataBean> getClientSticky(@Query("id") int id);

    @GET(API.Client_submit_identity)
    Observable<BaseBean> getClientSubmitIdentity(@QueryMap Map<String, String> paramMap);
}
