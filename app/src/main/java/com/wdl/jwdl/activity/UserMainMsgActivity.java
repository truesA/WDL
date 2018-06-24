package com.wdl.jwdl.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuyenmonkey.textdecorator.TextDecorator;
import com.wdl.jwdl.App;
import com.wdl.jwdl.R;
import com.wdl.jwdl.activity.clientmsg.ClienteBehaviorActivity;
import com.wdl.jwdl.activity.clientmsg.ClientIdentityActivity;
import com.wdl.jwdl.activity.clientmsg.ClientLoyaltyActivity;
import com.wdl.jwdl.activity.clientmsg.ClientValueActivity;
import com.wdl.jwdl.base.BaseActivity;
import com.wdl.jwdl.interfaces.API;
import com.wdl.jwdl.interfaces.UserService;
import com.wdl.jwdl.model.UserMainMsg;
import com.wdl.jwdl.util.UIUtils;
import com.wdl.jwdl.view.CreditScoreView;
import com.wdl.jwdl.view.StateFrameLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author：lhm on 2018/3/24 22:29
 * <p>
 * email：3186834196@qq.com
 */
public class UserMainMsgActivity extends BaseActivity {
    private String carPai;

    @BindView(R.id.creditscoreview)
    CreditScoreView creditscoreview;

//    @BindView(R.id.user_behavior)
//    TextView user_behavior;

    @BindView(R.id.user_behavior_value)
    TextView user_behavior_value;

//    @BindView(R.id.user_identity)
//    TextView user_identity;

    @BindView(R.id.user_identity_value)
    TextView user_identity_value;

//    @BindView(R.id.user_jk_kh)
//    TextView user_jk_kh;

//    @BindView(R.id.user_loyalty)
//    TextView user_loyalty;

    @BindView(R.id.user_loyalty_value)
    TextView user_loyalty_value;

    @BindView(R.id.user_viscosity)
    TextView user_viscosity;

    @BindView(R.id.user_viscosity_value)
    TextView user_viscosity_value;

//    @BindView(R.id.user_worth)
//    TextView user_worth;

    @BindView(R.id.user_worth_value)
    TextView user_worth_value;

    @BindView(R.id.user_yy_gs)
    TextView user_yy_gs;

    @BindView(R.id.user_yycs_tv)
    TextView user_yycs_tv;
    @BindView(R.id.user_jxcs_tv)
    TextView user_jxcs_tv;
    @BindView(R.id.user_fqcs_tv)
    TextView user_fqcs_tv;

    //身份
    @BindView(R.id.user_identity_name)
    TextView user_identity_name;
    @BindView(R.id.user_identity_carAge)
    TextView user_identity_carAge;
    @BindView(R.id.user_identity_dysu)
    TextView user_identity_dysu;
    @BindView(R.id.user_identity_xubao)
    TextView user_identity_xubao;
    @BindView(R.id.user_identity_xgh)
    TextView user_identity_xgh;
    @BindView(R.id.user_identity_yygs)
    TextView user_identity_yygs;

    //行为
    @BindView(R.id.user_behavior_m1)
    TextView user_behavior_m1;
    @BindView(R.id.user_behavior_m2)
    TextView user_behavior_m2;
    @BindView(R.id.user_behavior_anum)
    TextView user_behavior_anum;
    @BindView(R.id.user_behavior_xb)
    TextView user_behavior_xb;
    @BindView(R.id.user_behavior_bp)
    TextView user_behavior_bp;
    @BindView(R.id.user_behavior_wx)
    TextView user_behavior_wx;
    @BindView(R.id.user_behavior_jp)
    TextView user_behavior_jp;
    @BindView(R.id.user_behavior_jr)
    TextView user_behavior_jr;
    @BindView(R.id.user_behavior_mr)
    TextView user_behavior_mr;

    //忠诚
    @BindView(R.id.user_loyalty_xs)
    TextView user_loyalty_xs;
    @BindView(R.id.user_loyalty_no_by)
    TextView user_loyalty_no_by;
    @BindView(R.id.user_loyalty_zjgls)
    TextView user_loyalty_zjgls;
    @BindView(R.id.user_loyalty_lczq)
    TextView user_loyalty_lczq;
    @BindView(R.id.user_loyalty_yzlc)
    TextView user_loyalty_yzlc;

    //价值
    @BindView(R.id.user_worth_byzh)
    TextView user_worth_byzh;
    @BindView(R.id.user_worth_byzh_wz)
    TextView user_worth_byzh_wz;
    @BindView(R.id.user_worth_bydc)
    TextView user_worth_bydc;
    @BindView(R.id.user_worth_bydc_wz)
    TextView user_worth_bydc_wz;

    @BindView(R.id.stateLayout)
    StateFrameLayout mStateFrameLayout;


    private int userid;
    private int submit_appoint=0;
    private int submit_continue=0;
    private int submit_giveup=0;
    private int submit_loss=0;

    private void getDataMsg( int paramInt) {
        mStateFrameLayout.changeState(StateFrameLayout.LOADING);
        Map<String,String> params=new HashMap<>();
        params.put("userid",paramInt+"");
        params.put("said",getSaId());
        App.getRetrofit(API.BASE_URL)
                .create(UserService.class)
                .getUserMsg(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserMainMsg>() {
                    public void onComplete() {
                    }

                    public void onError(Throwable paramThrowable) {
//                        UIUtils.showToast("系统繁忙");
                        mStateFrameLayout.changeState(StateFrameLayout.ERROR);
                    }

                    public void onNext(UserMainMsg paramUserMainMsg) {
                        if (paramUserMainMsg.getResult()==null){
                            mStateFrameLayout.changeState(StateFrameLayout.EMPTY);
                            return;
                        }
                        if (paramUserMainMsg.getError_code() == 200) {
                            setuserMainMsg(paramUserMainMsg.getResult());
                            mStateFrameLayout.changeState(StateFrameLayout.SUCCESS);
                        }else {
                            UIUtils.showToast(paramUserMainMsg.getReason());
                        }
                    }

                    public void onSubscribe(Disposable paramDisposable) {
                    }
                });
    }

    @SuppressLint({"SetTextI18n"})
    private void setuserMainMsg(UserMainMsg.ResultBean paramResultBean) {
//        TextDecorator.decorate(user_jk_kh, "击溃" + paramResultBean.getJikuikehu() + "%").setTextColor(R.color.color1, new String[]{paramResultBean.getJikuikehu() + "%"}).build();
        TextDecorator.decorate(user_yy_gs, "T1分数线 " + paramResultBean.getT1_threshold()).setTextColor(R.color.new_color01, new String[]{paramResultBean.getT1_threshold()+""}).build();
        TextDecorator.decorate(user_yycs_tv, "预约次数 " + paramResultBean.getCount_appoint()).setTextColor(R.color.new_color01, new String[]{paramResultBean.getCount_appoint()+""}).build();
        TextDecorator.decorate(user_jxcs_tv, "继续次数 " + paramResultBean.getCount_continue()).setTextColor(R.color.new_color01, new String[]{paramResultBean.getCount_continue()+""}).build();
        TextDecorator.decorate(user_fqcs_tv, "放弃次数 " + paramResultBean.getCount_giveup()).setTextColor(R.color.new_color01, new String[]{paramResultBean.getCount_giveup()+""}).build();

        ArrayList<Integer> arrayList = (ArrayList) paramResultBean.getCred_score();
        ArrayList<Double> arrayListd = (ArrayList)paramResultBean.getCred_score_ratio();
        creditscoreview.setDataDefultfloat( arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4));
        creditscoreview.setData( arrayListd.get(0).floatValue(), arrayListd.get(1).floatValue(), arrayListd.get(2).floatValue(), arrayListd.get(3).floatValue(), arrayListd.get(4).floatValue());
        creditscoreview.invalidate();

        //身份
     //   if (paramResultBean.getName().length()>3) {
       //     user_identity_name.setText(paramResultBean.getName().substring(0,4) + "(" + paramResultBean.getBirthday() + ")");
     //       user_identity_name.setTextSize(11f);
      //  }else {
            user_identity_name.setText(paramResultBean.getName() + "(" + paramResultBean.getBirthday() + ")");
    //    }
        user_identity_carAge.setText(paramResultBean.getCar_model()+"("+paramResultBean.getCar_age()+")");
        user_identity_dysu.setText("调研速度"+"("+paramResultBean.getSurvey_speed()+") ");
        user_identity_xubao.setText("保险日"+"("+paramResultBean.getInsurance_date()+")");
        user_identity_xgh.setText("小划痕"+"("+paramResultBean.getSmall_scratch_number()+")");
        user_identity_yygs.setText("预约工时折扣"+"("+paramResultBean.getZhe()+")");

        //行为
     //   user_behavior_m1.setText("M1"+changeValue(paramResultBean.getM1()));
      //  user_behavior_m2.setText("M2"+changeValue(paramResultBean.getM2()));
        user_behavior_anum.setText("12个月内A次数"+"("+paramResultBean.getMaint_times()+")");
       // user_behavior_xb.setText("续保"+changeValue(paramResultBean.getContinue_insurance_times()));
       // user_behavior_bp.setText("钣喷"+changeValue(paramResultBean.getBody_shop_times()));
      //  user_behavior_wx.setText("维修"+changeValue(paramResultBean.getRepair_times()));
      //  user_behavior_jp.setText("精品"+changeValue(paramResultBean.getExcellent_times()));
      //  user_behavior_jr.setText("金融"+changeValue(paramResultBean.getEconomy_times()));
      //  user_behavior_mr.setText("美容"+changeValue(paramResultBean.getCar_care_times()));

        changeValueView(user_behavior_m1,"M1",paramResultBean.getM1());
        changeValueView(user_behavior_m2,"M2",paramResultBean.getM2());
        changeValueView(user_behavior_xb,"续保",paramResultBean.getContinue_insurance_times());
        changeValueView(user_behavior_bp,"钣喷",paramResultBean.getBody_shop_times());
        changeValueView(user_behavior_wx,"维修",paramResultBean.getRepair_times());
        changeValueView(user_behavior_jp,"精品",paramResultBean.getExcellent_times());
        changeValueView(user_behavior_jr,"金融",paramResultBean.getEconomy_times());
        changeValueView(user_behavior_mr,"美容",paramResultBean.getCar_care_times());

        //忠诚
        DecimalFormat localDecimalFormat = new DecimalFormat("#.00");
        user_loyalty_xs.setText("忠诚系数"+"("+localDecimalFormat.format(paramResultBean.getLoy_coef())+")");
        user_loyalty_no_by.setText("几月未保养"+"("+paramResultBean.getMonth_past()+")");
        user_loyalty_zjgls.setText("最近速度"+paramResultBean.getDay_km_recent()+"公里/日");
        user_loyalty_lczq.setText("里程周期"+paramResultBean.getKm_period());
        user_loyalty_yzlc.setText("已走公里"+paramResultBean.getKm_past());

        //价值
        user_worth_byzh.setText("12月内保养总和"+paramResultBean.getMaint_sum());
        user_worth_byzh_wz.setText("保养总和位置"+paramResultBean.getMaint_sum_pct()+"%");
        user_worth_bydc.setText("12月内保养单车"+paramResultBean.getMaint_single());
        user_worth_bydc_wz.setText("保养单车位置"+paramResultBean.getMaint_single_pct()+"%");

     //   user_identity.setText(paramResultBean.getName() + " " + paramResultBean.getCar_purpose() + " " + paramResultBean.getKm_per_day() + "公里/日" + paramResultBean.getWork_field() + " " + "小刮痕" + "(" + paramResultBean.getSmall_scratch_number() + ")" +"\n"+ " 生日" + paramResultBean.getBirthday());
        user_identity_value.setText(arrayList.get(0) + "");
      //  user_behavior.setText("K15" + paramResultBean.getK15() + " K20" + paramResultBean.getK20() + " 维修(" + paramResultBean.getRepair_times() + ")" + " 精品(" + paramResultBean.getEconomy() + ")" + " 美容(" + paramResultBean.getCar_care() + ")" + " 微信预约(" + paramResultBean.getWechat_appoint() + ")" + " 保养次数(" + paramResultBean.getMaint_times() + ")");
        user_behavior_value.setText(arrayList.get(1) + "");
   //     user_loyalty.setText("忠诚系数" + localDecimalFormat.format(paramResultBean.getLoy_coef()) + " 周期" + paramResultBean.getPeriod() + "\n"+" 最近日均公里数" + paramResultBean.getDay_mile_recent() +"\n"+ " 里程间隔" + paramResultBean.getMile_gap() +"\n"+ " 时间间隔" + paramResultBean.getTime_gap());
        user_loyalty_value.setText(arrayList.get(2) + "");
  //      user_worth.setText("保养总和" + paramResultBean.getMaint_sum() + " 保养单车" + paramResultBean.getMaint_sum());
        user_worth_value.setText(arrayList.get(3) + "");
      //  user_viscosity.setText("续保(" + paramResultBean.getExcent_insurance() + ")" + " 买3送1(" + paramResultBean.getBuy3free1() + ")");
        user_viscosity_value.setText(arrayList.get(4) + "");
        submit_appoint=paramResultBean.getSubmit_appoint();
        submit_continue=paramResultBean.getSubmit_continue();
        submit_giveup=paramResultBean.getSubmit_giveup();
        submit_loss=paramResultBean.getSubmit_loss();
        phone=paramResultBean.getNumb();
        wechat=paramResultBean.getWechat_id();
    }

    private String phone;
    private String wechat;


    protected int getlayoutview() {
        return R.layout.activity_user_main_msg;
    }

    protected void initData() {
        getDataMsg(userid);
    }

    protected void initView() {
        Intent localIntent = getIntent();
        userid = localIntent.getIntExtra("userid", 1);
        Log.e("e", userid + "");
        carPai = localIntent.getStringExtra("carPai");
        getToolbarTitle().setText(carPai);

        View emptyView = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) findViewById(android.R.id.content), false);
        mStateFrameLayout.setEmptyView(emptyView);
        mStateFrameLayout.setNetErrorViewLayoutId(R.layout.layout_net_error);
      //  mStateFrameLayout.setErrorViewLayoutId(R.layout.layout_error);
        View errorView = getLayoutInflater().inflate(R.layout.layout_error, (ViewGroup) findViewById(android.R.id.content), false);
        mStateFrameLayout.setErrorView(errorView);
        mStateFrameLayout.setOnNetErrorRetryListener(new StateFrameLayout.OnNetErrorRetryListener()
        {
            @Override
            public void onNetErrorRetry()
            {
                //Toast.makeText(UserMainMsgActivity.this, "点击网络错误重试", Toast.LENGTH_LONG).show();
                getDataMsg(userid);
            }
        });
        mStateFrameLayout.setOnEmptyRetryListener(new StateFrameLayout.OnEmptyRetryListener()
        {
            @Override
            public void onEmptyRetry()
            {
              //  Toast.makeText(UserMainMsgActivity.this, "点击空数据重试", Toast.LENGTH_LONG).show();
                getDataMsg(userid);
            }
        });
        mStateFrameLayout.setOnErrorRetryListener(new StateFrameLayout.OnErrorRetryListener() {
            @Override
            public void onErrorRetry() {
                getDataMsg(userid);
            }
        });

//        findViewById(R.id.btn_empty).setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//
//            }
//        });
//        findViewById(R.id.btn_net_error).setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                mStateFrameLayout.changeState(StateFrameLayout.NET_ERROR);
//            }
//        });
//        findViewById(R.id.btn_success).setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                mStateFrameLayout.changeState(StateFrameLayout.SUCCESS);
//            }
//        });
    }

    @OnClick({R.id.user_yy, R.id.user_jx, R.id.user_fq, R.id.user_ls})
    public void onClickgo(View paramView) {
        Intent intent = new Intent(this, MsgBusinessActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("carUserid", userid + "");
        bundle.putString("carPai", carPai);

        switch (paramView.getId()) {
            case R.id.user_yy:
                bundle.putInt("submit_appoint",submit_appoint);
                bundle.putInt("position", 0);
                break;
            case R.id.user_jx:
                bundle.putInt("submit_continue",submit_continue);
                bundle.putInt("position", 1);
                break;
            case R.id.user_fq:
                bundle.putInt("submit_giveup",submit_giveup);
                bundle.putInt("position", 2);
                break;
            case R.id.user_ls:
                bundle.putInt("submit_loss",submit_loss);
                bundle.putInt("position", 3);
                break;
        }
        intent.putExtras(bundle);
        startActivity(intent);

    }
    @OnClick({R.id.call_phone, R.id.weixin})
    public void onclickPhonetowx(View view){
        switch (view.getId()) {
            case R.id.call_phone:
                if (TextUtils.isEmpty(phone)){
                    UIUtils.showToast("暂无手机号");
                }else{
                    Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phone));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                break;
            case R.id.weixin:
                if (TextUtils.isEmpty(wechat)){
                    UIUtils.showToast("暂无微信号");
                }else{
                    UIUtils.clipText(this,wechat);
                    UIUtils.showToast("微信号已复制到粘贴板");
                }

                break;
        }
    }
    @OnClick({R.id.user_msg_identity,R.id.user_msg_action,R.id.user_msg_loyalty,R.id.user_msg_value,R.id.user_msg_viscosity})
    public void goToClientMsg(View view){
        Intent intent=new Intent();
        intent.putExtra("clientid",userid);
        switch (view.getId()){
            case R.id.user_msg_identity:
                intent.setClass(this, ClientIdentityActivity.class);
                break;
            case R.id.user_msg_action:
                intent.setClass(this, ClienteBehaviorActivity.class);
                break;
            case R.id.user_msg_loyalty:
                intent.setClass(this, ClientLoyaltyActivity.class);
                break;
            case R.id.user_msg_value:
                intent.putExtra("type",1);// 1 价值
                intent.setClass(this, ClientValueActivity.class);
                break;
            case R.id.user_msg_viscosity:
                intent.putExtra("type",2);// 2 粘性
                intent.setClass(this, ClientValueActivity.class);
                break;
        }
        startActivity(intent);
    }

    private String changeValue(int value){
        if (value==1){
            return "O";
        }else if (value==0){
            return "X";
        }
        return "X";
    }

    private void changeValueView(TextView view,String name,int value){
        if (value==1){
            view.setText(name+" O");
        }else if (value==0){
            view.setText(name+" X");
            view.setBackgroundColor(Color.parseColor("#ffff3366"));
        }
    }
}