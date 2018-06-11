package com.wdl.amdroid_jwdl.adapter;

/**
 * author：lhm on 2018/3/24 11:18
 * <p>
 * email：3186834196@qq.com
 */

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.commom.CommonRecyclerViewAdapter;
import com.wdl.amdroid_jwdl.commom.CommonViewHolder;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.UserService;
import com.wdl.amdroid_jwdl.model.BaseBean;
import com.wdl.amdroid_jwdl.model.MsgListBean;
import com.wdl.amdroid_jwdl.util.UIUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MsgAdapter extends CommonRecyclerViewAdapter<MsgListBean.ResultBean> {
    //private int[] colors = { -16711681, -256, -16711936 };

    public MsgAdapter(Context paramContext, int paramInt, List<MsgListBean.ResultBean> paramList) {
        super(paramContext, paramInt, paramList);
    }

    public void convert(CommonViewHolder ViewHolder, final MsgListBean.ResultBean paramResultBean, final int paramInt) {
        TextView carType = (TextView) ViewHolder.getView(R.id.carType);
        TextView name = (TextView) ViewHolder.getView(R.id.name);
        TextView phone = (TextView) ViewHolder.getView(R.id.phone);
        TextView carPai = (TextView) ViewHolder.getView(R.id.carPai);
        TextView project_t1 = (TextView) ViewHolder.getView(R.id.project_t1);
        TextView msg_total_score = (TextView) ViewHolder.getView(R.id.msg_total_score);
        TextView xu = (TextView) ViewHolder.getView(R.id.xu);
        TextView zhe = (TextView) ViewHolder.getView(R.id.zhe);
        TextView msgzcd = (TextView) ViewHolder.getView(R.id.msg_zcd);
        final ImageView msg_zcd_iv = ViewHolder.getView(R.id.msg_zcd_iv);
        LinearLayout zcd_ll = ViewHolder.getView(R.id.zcd_ll);
        View item_left_color=ViewHolder.getView(R.id.item_left_color);
        LinearLayout msg_data =ViewHolder.getView(R.id.msg_data);
        TextView msg_month =ViewHolder.getView(R.id.msg_month);
        TextView msg_day=ViewHolder.getView(R.id.msg_day);

        double loy_coef = new BigDecimal(paramResultBean.getLoy_coef()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        msgzcd.setText(loy_coef+"");
//        carType.setText(paramResultBean.getInitial());
        carType.setText("凯美瑞");
        name.setText(paramResultBean.getName());
        phone.setText(paramResultBean.getPhone_number());
        carPai.setText(paramResultBean.getPlate_num());

//        project_t1.setText(paramResultBean.getLevel());
        xu.setText("续 " + paramResultBean.getXu());
        zhe.setText("折" + paramResultBean.getZhe());
        msg_total_score.setText(paramResultBean.getTotal_score() + "");
        if (paramResultBean.getT1_target()==1){
            project_t1.setVisibility(View.VISIBLE);
        }else {
            project_t1.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(paramResultBean.getColor())){
            item_left_color.setBackgroundColor(Color.WHITE);
        }else {
            item_left_color.setBackgroundColor(Color.parseColor(paramResultBean.getColor()));
        }
        if (TextUtils.isEmpty(paramResultBean.getDate())){
            msg_data.setVisibility(View.GONE);
        }else {
            msg_data.setVisibility(View.VISIBLE);
            String[] bxString = paramResultBean.getDate().split("-");
            msg_month.setText(bxString[1]);
            msg_day.setText(bxString[2]);

        }

        if (paramResultBean.getCollection() == 1) {
            msg_zcd_iv.setImageResource(R.drawable.loyalty_icon_color);
        } else {
            msg_zcd_iv.setImageResource(R.drawable.loyalty_icon_hui);
        }

        zcd_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg_zcd_iv.setImageResource(R.drawable.loyalty_icon_color);
                App.getRetrofit(API.BASE_URL)
                        .create(UserService.class)
                        .getCollection(paramResultBean.getId())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<BaseBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(BaseBean baseBean) {
                                if (baseBean.getError_code() == 200) {
                                    if (mdataPostionChangeListener!=null){
                                        mdataPostionChangeListener.dataPostionChange(paramInt);
                                    }
                                }else {
                                    UIUtils.showToast(baseBean.getReason());
                                    msg_zcd_iv.setImageResource(R.drawable.loyalty_icon_hui);
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                                UIUtils.showToast("系统繁忙");
                                msg_zcd_iv.setImageResource(R.drawable.loyalty_icon_hui);
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });


    }
    public static DataPostionChangeListener mdataPostionChangeListener;

    public static void setDataPostionChangeListener(DataPostionChangeListener dataPostionChangeListener){
        mdataPostionChangeListener=dataPostionChangeListener;
    }

    public interface DataPostionChangeListener {
        void dataPostionChange(int postion);

    }
}