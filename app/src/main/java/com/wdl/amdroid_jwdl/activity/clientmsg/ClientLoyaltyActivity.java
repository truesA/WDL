package com.wdl.amdroid_jwdl.activity.clientmsg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.ClientService;
import com.wdl.amdroid_jwdl.model.ClientLoyaltyBean;
import com.wdl.amdroid_jwdl.util.UIUtils;

import java.math.BigDecimal;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author：lhm on 2018/3/24 22:29
 * <p>
 * email：3186834196@qq.com
 *
 * 忠诚
 */
public class ClientLoyaltyActivity extends BaseActivity {
    @BindView(R.id.client_common_ltv)
    TextView clientLtvValue;
    @BindView(R.id.client_common_rtv)
    TextView clientRtvValue;

    @BindView(R.id.loyalty_zcxs_msg)
    TextView loyalty_zcxs_msg;
    @BindView(R.id.loyalty_byzq_msg)
    TextView loyalty_byzq_msg;
    @BindView(R.id.loyalty_zjlc_msg)
    TextView loyalty_zjlc_msg;
    @BindView(R.id.loyalty_lcjg_msg)
    TextView loyalty_lcjg_msg;
    @BindView(R.id.loyalty_sjjg_msg)
    TextView loyalty_sjjg_msg;
    private int clientid;

    @Override
    protected int getlayoutview() {
        return R.layout.activity_client_loyalty;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        clientid= intent.getIntExtra("clientid",0);
        getToolbarTitle().setText("忠诚");

    }

    @Override
    protected void initData() {
        showLoadingDialog();
        App.getRetrofit(API.BASE_URL)
                .create(ClientService.class)
                .getClientLoyalty(clientid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClientLoyaltyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ClientLoyaltyBean clientLoyaltyBean) {
                        dismissLoadingDialog();
                        if (clientLoyaltyBean.getError_code()==200){
                            clientLtvValue.setText("忠诚指数"+clientLoyaltyBean.getResult().getLoyalty_score());
                            clientRtvValue.setText("总用户排行"+clientLoyaltyBean.getResult().getLoyalty_percent()+"%");
                            setLoyaltyData(clientLoyaltyBean.getResult());
                        }
                        UIUtils.showToast(clientLoyaltyBean.getReason());
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


    private void setLoyaltyData(ClientLoyaltyBean.ResultBean result) {
        double loy_coef = new BigDecimal(result.getLoy_coef()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        loyalty_zcxs_msg.setText(loy_coef+"");
        int  period = (int) result.getPeriod();
        loyalty_byzq_msg.setText(period+"");
        loyalty_zjlc_msg.setText(result.getKm_per_day()+"");

        loyalty_lcjg_msg.setText(toListSizeSpace(result.getMile_gap()));
        loyalty_sjjg_msg.setText(toListSizeSpace(result.getTime_gap()));
    }

    private String toListSizeSpace(List<Integer> list){
        if (list.size()==0){
            return "无";
        }
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<list.size();i++){
            sb.append(list.get(i)+"");
            sb.append(" ");
        }
        return sb.toString();
    }
}
