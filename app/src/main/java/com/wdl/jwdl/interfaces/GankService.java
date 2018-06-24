package com.wdl.jwdl.interfaces;

/**
 * Created by 62682 on 2018/3/20.
 */

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public abstract interface GankService {
    @GET("/score_request")
    public abstract Observable<String> getGanHuo(@Query("id") String paramString);
}