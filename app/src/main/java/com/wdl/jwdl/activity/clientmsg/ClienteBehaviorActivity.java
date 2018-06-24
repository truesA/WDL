package com.wdl.jwdl.activity.clientmsg;

import android.content.Intent;
import android.widget.TextView;

import com.wdl.jwdl.App;
import com.wdl.jwdl.R;
import com.wdl.jwdl.base.BaseActivity;
import com.wdl.jwdl.interfaces.API;
import com.wdl.jwdl.interfaces.ClientService;
import com.wdl.jwdl.model.ClientBehaviorBean;
import com.wdl.jwdl.util.UIUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author：lhm on 2018/3/24 22:29
 * <p>
 * email：3186834196@qq.com
 *
 * 行为
 */
public class ClienteBehaviorActivity extends BaseActivity {

    @BindView(R.id.client_common_ltv)
    TextView clientLtvValue;
    @BindView(R.id.client_common_rtv)
    TextView clientRtvValue;
    private int clientid;

    @BindView(R.id.behavior_5k_msg)
    TextView behavior_5k_msg;
    @BindView(R.id.behavior_10k_msg)
    TextView behavior_10k_msg;
    @BindView(R.id.behavior_15k_msg)
    TextView behavior_15k_msg;
    @BindView(R.id.behavior_20k_msg)
    TextView behavior_20k_msg;
    @BindView(R.id.behavior_bp_msg)
    TextView behavior_bp_msg;
    @BindView(R.id.behavior_fix_msg)
    TextView behavior_fix_msg;
    @BindView(R.id.behavior_bx_msg)
    TextView behavior_bx_msg;
    @BindView(R.id.behavior_yb_msg)
    TextView behavior_yb_msg;
    @BindView(R.id.behavior_jr_msg)
    TextView behavior_jr_msg;
    @BindView(R.id.behavior_mr_msg)
    TextView behavior_mr_msg;
//    @BindView(R.id.behavior_wc_msg)
//    TextView behavior_wc_msg;
//    @BindView(R.id.behavior_cycs_msg)
//    TextView behavior_cycs_msg;


    @Override
    protected int getlayoutview() {
        return R.layout.activity_client_behavior;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        clientid= intent.getIntExtra("clientid",0);
        getToolbarTitle().setText("行为");

    }

    @Override
    protected void initData() {
        showLoadingDialog();
        Map<String,String> params=new HashMap<>();
        params.put("userid",clientid+"");
        params.put("said",getSaId());
        App.getRetrofit(API.BASE_URL)
                .create(ClientService.class)
                .getClientBehavior(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClientBehaviorBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ClientBehaviorBean clientBehaviorBean) {
                        dismissLoadingDialog();
                        if (clientBehaviorBean.getError_code()==200){
                            clientLtvValue.setText("行为指数"+clientBehaviorBean.getResult().getBehavior_score());
                            clientRtvValue.setText("总用户排行"+clientBehaviorBean.getResult().getBehavior_percent()+"%");
                            setBehavior(clientBehaviorBean.getResult());
                        }
                        UIUtils.showToast(clientBehaviorBean.getReason());
                        
                    }

                    @Override
                    public void onError(Throwable e) {
                        dismissLoadingDialog();
                        UIUtils.showToast("系统繁忙");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void setBehavior(ClientBehaviorBean.ResultBean result) {
        behavior_5k_msg.setText("5K   "+changeValue(result.getK5()));
        behavior_10k_msg.setText("10K   "+changeValue(result.getK10()));
        behavior_15k_msg.setText("M1   "+changeValue(result.getK15()));
        behavior_20k_msg.setText("M2   "+changeValue(result.getK20()));
        behavior_bp_msg.setText("钣喷   "+changeValue(result.getBody_shop()));
        behavior_fix_msg.setText("维修  "+changeValue(result.getRepair_times()));
        behavior_bx_msg.setText("保险   "+changeValue(result.getInsurance()));
        behavior_yb_msg.setText("延保   "+changeValue(result.getExtension()));
        behavior_jr_msg.setText("金融   "+changeValue(result.getInsurance()));
        behavior_mr_msg.setText("美容   "+changeValue(result.getCar_care()));
//        behavior_wc_msg.setText("微信主动预约   "+changeValue(result.getWechat_appoint()));
//        behavior_cycs_msg.setText("12个月内保养次数   "+changeValue(result.getMaint_times()));
    }

    private String changeValue(int value){
        if (value==1){
            return "O";
        }else if (value==0){
            return "X";
        }
        return "X";
    }
}
