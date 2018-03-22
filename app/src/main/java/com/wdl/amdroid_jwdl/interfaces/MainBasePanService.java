package com.wdl.amdroid_jwdl.interfaces;

/**
 * Created by 62682 on 2018/3/20.
 */

import com.wdl.amdroid_jwdl.model.SeachBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public  interface MainBasePanService {
    @GET(API.Msg_search)
    Observable<SeachBean> getSeachContent(@Query("plate_number") String paramString);
}