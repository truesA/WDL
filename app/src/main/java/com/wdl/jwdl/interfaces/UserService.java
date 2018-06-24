package com.wdl.jwdl.interfaces;

/**
 * Created by 62682 on 2018/3/20.
 */

import com.wdl.jwdl.model.BaseBean;
import com.wdl.jwdl.model.LoginUesr;
import com.wdl.jwdl.model.MainServiceBean;
import com.wdl.jwdl.model.SavingBean;
import com.wdl.jwdl.model.UserMainMsg;
import com.wdl.jwdl.model.UserMainMsgBast;

import io.reactivex.Observable;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface UserService {
    @FormUrlEncoded
    @POST(API.User_Login)
    Observable<LoginUesr> getLoginuser(@FieldMap Map<String,String> map);

    @GET(API.Main_mine)
    Observable<MainServiceBean> getMainServetMsg(@Query("bk_month") int bk_month);

    @GET(API.Submit_Content)
    Observable<BaseBean> getSubmit_Content(@QueryMap Map<String, String> paramMap);

    @GET(API.Main_USERMSG)
    Observable<UserMainMsg> getUserMsg(@QueryMap Map<String, String> paramMap);
//            @Query("id") int id);

    @GET(API.Submit_Collection)
    Observable<BaseBean> getCollection(@QueryMap Map<String, String> paramMap);
//            @Query("said") String said,@Query("collection_user") int collection_user

    //https://de70ebd3.ngrok.io/user_search_detail2?id=0  接口（9）：单个用户搜索，返回最详细信息

    @GET(API.Main_USERMSG_BAST)
    Observable<UserMainMsgBast> getUserMsgBast(@Query("id") int id);

    @GET(API.Main_saving)
    Observable<SavingBean> getMainSavingMsg(@QueryMap Map<String, String> paramMap);

}
