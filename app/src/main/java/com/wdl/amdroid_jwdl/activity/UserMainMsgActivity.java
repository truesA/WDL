package com.wdl.amdroid_jwdl.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tuyenmonkey.textdecorator.TextDecorator;
import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.UserService;
import com.wdl.amdroid_jwdl.model.UserMainMsg;
import com.wdl.amdroid_jwdl.util.UIUtils;
import com.wdl.amdroid_jwdl.view.CreditScoreView;

import java.text.DecimalFormat;
import java.util.ArrayList;

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

    @BindView(R.id.user_behavior)
    TextView user_behavior;

    @BindView(R.id.user_behavior_value)
    TextView user_behavior_value;

    @BindView(R.id.user_identity)
    TextView user_identity;

    @BindView(R.id.user_identity_value)
    TextView user_identity_value;

    @BindView(R.id.user_jk_kh)
    TextView user_jk_kh;

    @BindView(R.id.user_loyalty)
    TextView user_loyalty;

    @BindView(R.id.user_loyalty_value)
    TextView user_loyalty_value;

    @BindView(R.id.user_viscosity)
    TextView user_viscosity;

    @BindView(R.id.user_viscosity_value)
    TextView user_viscosity_value;

    @BindView(R.id.user_worth)
    TextView user_worth;

    @BindView(R.id.user_worth_value)
    TextView user_worth_value;

    @BindView(R.id.user_yy_gs)
    TextView user_yy_gs;
    private int userid;

    private void getDataMsg(int paramInt) {
        App.getRetrofit(API.BASE_URL).create(UserService.class)
                .getUserMsg(paramInt)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserMainMsg>() {
                    public void onComplete() {
                    }

                    public void onError(Throwable paramThrowable) {
                        UIUtils.showToast("系统繁忙");
                    }

                    @RequiresApi(api = 24)
                    public void onNext(UserMainMsg paramUserMainMsg) {
                        if (paramUserMainMsg.getError_code() == 200) {
                            setuserMainMsg(paramUserMainMsg.getResult());
                        }
                        UIUtils.showToast(paramUserMainMsg.getReason());
                    }

                    public void onSubscribe(Disposable paramDisposable) {
                    }
                });
    }

    @SuppressLint({"SetTextI18n"})
    private void setuserMainMsg(UserMainMsg.ResultBean paramResultBean) {
        TextDecorator.decorate(user_jk_kh, "击溃" + paramResultBean.getJikuikehu() + "%").setTextColor(R.color.color1, new String[]{paramResultBean.getJikuikehu() + "%"}).build();
        TextDecorator.decorate(user_yy_gs, "预约工时" + paramResultBean.getYuyuegongshi() + "折").setTextColor(R.color.color1, new String[]{paramResultBean.getYuyuegongshi() + "折"}).build();
        ArrayList arrayList = (ArrayList) paramResultBean.getCred_score();
        creditscoreview.setData(((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), ((Integer) arrayList.get(2)).intValue(), ((Integer) arrayList.get(3)).intValue(), ((Integer) arrayList.get(4)).intValue());
        creditscoreview.invalidate();
        user_identity.setText(paramResultBean.getName() + " " + paramResultBean.getCar_purpose() + " " + paramResultBean.getKm_per_day() + "公里/日" + paramResultBean.getWork_field() + " " + "小刮痕" + "(" + paramResultBean.getSmall_scratch_number() + ")" +"\n"+ " 生日" + paramResultBean.getBirthday());
        user_identity_value.setText(arrayList.get(0) + "");
        user_behavior.setText("K15" + paramResultBean.getK15() + " K20" + paramResultBean.getK20() + " 维修(" + paramResultBean.getRepair_times() + ")" + " 精品(" + paramResultBean.getEconomy() + ")" + " 美容(" + paramResultBean.getCar_care() + ")" + " 微信预约(" + paramResultBean.getWechat_appoint() + ")" + " 保养次数(" + paramResultBean.getMaint_times() + ")");
        user_behavior_value.setText(arrayList.get(1) + "");
        DecimalFormat localDecimalFormat = new DecimalFormat("#.00");
        user_loyalty.setText("忠诚系数" + localDecimalFormat.format(paramResultBean.getLoy_coef()) + " 周期" + paramResultBean.getPeriod() + "\n"+" 最近日均公里数" + paramResultBean.getDay_mile_recent() +"\n"+ " 里程间隔" + paramResultBean.getMile_gap() +"\n"+ " 时间间隔" + paramResultBean.getTime_gap());
        user_loyalty_value.setText(arrayList.get(2) + "");
        user_worth.setText("保养总和" + paramResultBean.getMaint_sum() + " 保养单车" + paramResultBean.getMaint_sum());
        user_worth_value.setText(arrayList.get(3) + "");
        user_viscosity.setText("续保(" + paramResultBean.getExcent_insurance() + ")" + " 买3送1(" + paramResultBean.getBuy3free1() + ")");
        user_viscosity_value.setText(arrayList.get(4) + "");
    }

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
    }

    @OnClick({R.id.user_yy, R.id.user_jx, R.id.user_fq, R.id.user_ls, R.id.call_phone, R.id.weixin})
    public void onClickgo(View paramView) {
        Intent intent = new Intent(this, MsgBusinessActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("carUserid", userid + "");
        bundle.putString("carPai", carPai);
        switch (paramView.getId()) {
            case R.id.user_yy:
                bundle.putInt("position", 0);
                break;
            case R.id.user_jx:
                bundle.putInt("position", 1);
                break;
            case R.id.user_fq:
                bundle.putInt("position", 2);
                break;
            case R.id.user_ls:
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
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:15100000000"));
                startActivity(intent);
                break;
            case R.id.weixin:
                UIUtils.showToast("暂无微信号");
                break;
        }
    }
}