package com.wdl.amdroid_jwdl.interfaces;

/**
 * Created by 62682 on 2018/3/20.
 */

import com.wdl.amdroid_jwdl.model.BaseBean;
import com.wdl.amdroid_jwdl.model.MainServiceBean;
import com.wdl.amdroid_jwdl.model.SavingBean;
import com.wdl.amdroid_jwdl.model.UserMainMsg;
import com.wdl.amdroid_jwdl.model.UserMainMsgBast;

import butterknife.BindView;
import io.reactivex.Observable;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface UserService {
    @GET(API.Main_mine)
    Observable<MainServiceBean> getMainServetMsg(@Query("bk_month") int bk_month);

    @GET(API.Submit_Content)
    Observable<BaseBean> getSubmit_Content(@QueryMap Map<String, String> paramMap);

    @GET(API.Main_USERMSG)
    Observable<UserMainMsg> getUserMsg(@Query("id") int id);

    @GET(API.Submit_Collection)
    Observable<BaseBean> getCollection(@Query("collection_user") int collection_user);

    //https://de70ebd3.ngrok.io/user_search_detail2?id=0  接口（9）：单个用户搜索，返回最详细信息

    @GET(API.Main_USERMSG_BAST)
    Observable<UserMainMsgBast> getUserMsgBast(@Query("id") int id);

    @GET(API.Main_saving)
    Observable<SavingBean> getMainSavingMsg(@Query("date") String date);

}
