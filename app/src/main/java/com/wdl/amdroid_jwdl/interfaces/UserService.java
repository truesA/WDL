package com.wdl.amdroid_jwdl.interfaces;

/**
 * Created by 62682 on 2018/3/20.
 */
import com.wdl.amdroid_jwdl.model.BaseBean;
import com.wdl.amdroid_jwdl.model.MainServiceBean;
import com.wdl.amdroid_jwdl.model.UserMainMsg;

import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public abstract interface UserService {
    @GET("bk_call")
    public abstract Observable<MainServiceBean> getMainServetMsg(@Query("bk_month") int paramInt);

    @GET("submit_basic")
    public abstract Observable<BaseBean> getSubmit_Content(@QueryMap Map<String, String> paramMap);

    @GET("user_search_detail")
    public abstract Observable<UserMainMsg> getUserMsg(@Query("id") int paramInt);
}
