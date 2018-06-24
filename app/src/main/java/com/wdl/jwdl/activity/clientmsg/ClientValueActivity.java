package com.wdl.jwdl.activity.clientmsg;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wdl.jwdl.App;
import com.wdl.jwdl.R;
import com.wdl.jwdl.base.BaseActivity;
import com.wdl.jwdl.interfaces.API;
import com.wdl.jwdl.interfaces.ClientService;
import com.wdl.jwdl.model.ClientStickyBean;
import com.wdl.jwdl.model.ClientValueBean;
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
 * 价值 粘性
 */
public class ClientValueActivity extends BaseActivity {

    private int clientid;
    private int type;
    @BindView(R.id.client_common_ltv)
    TextView clientLtvValue;
    @BindView(R.id.client_common_rtv)
    TextView clientRtvValue;
    @BindView(R.id.client_value_ll)
    LinearLayout client_value_ll;
    @BindView(R.id.client_sticky_ll)
    LinearLayout client_sticky_ll;


    @BindView(R.id.value_byze_msg)
    TextView value_byze_msg;
    @BindView(R.id.value_bydc_msg)
    TextView value_bydc_msg;
    @BindView(R.id.value_fix_msg)
    TextView value_fix_msg;
    @BindView(R.id.value_bp_msg)
    TextView value_bp_msg;
    @BindView(R.id.value_jp_msg)
    TextView value_jp_msg;
    @BindView(R.id.value_mr_msg)
    TextView value_mr_msg;

    @BindView(R.id.sticky_xub_msg)
    TextView sticky_xub_msg;
    @BindView(R.id.sticky_m3t1_msg)
    TextView sticky_m3t1_msg;
    @Override
    protected int getlayoutview() {
        return R.layout.activity_client_value;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        clientid= intent.getIntExtra("clientid",0);
        type= intent.getIntExtra("type",0);



    }

    @Override
    protected void initData() {
        if (type==1){
            getToolbarTitle().setText("价值");
            client_value_ll.setVisibility(View.VISIBLE);
            client_sticky_ll.setVisibility(View.GONE);
            getValueData(clientid);


        }else {
            getToolbarTitle().setText("粘性");
            client_value_ll.setVisibility(View.GONE);
            client_sticky_ll.setVisibility(View.VISIBLE);

            getStickyData(clientid);


        }
    }

    /**
     * 获取粘性数据
     * @param clientid
     */
    private void getStickyData(int clientid) {
        showLoadingDialog();
        Map<String,String> params=new HashMap<>();
        params.put("userid",clientid+"");
        params.put("said",getSaId());
        App.getRetrofit(API.BASE_URL)
                .create(ClientService.class)
                .getClientSticky(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClientStickyBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ClientStickyBean clientSticky) {
                        dismissLoadingDialog();
                        if (clientSticky.getError_code()==200){
                            clientLtvValue.setText("粘性指数"+clientSticky.getResult().getSticky_score());
                            clientRtvValue.setText("总用户排行"+clientSticky.getResult().getSticky_percent()+"%");
                            sticky_xub_msg.setText("续保   "+clientSticky.getResult().getExcent_insurance());
                            sticky_m3t1_msg.setText("买三送一   "+clientSticky.getResult().getBuy3free1());
                        }
                        UIUtils.showToast(clientSticky.getReason());
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

    /**
     * 获取价值数据
     * @param clientid
     */
    private void getValueData(int clientid) {
        showLoadingDialog();
        Map<String,String> params=new HashMap<>();
        params.put("userid",clientid+"");
        params.put("said",getSaId());
        App.getRetrofit(API.BASE_URL)
                .create(ClientService.class)
                .getClientValue(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClientValueBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ClientValueBean clientValue) {
                        dismissLoadingDialog();
                        if (clientValue.getError_code()==200){
                            clientLtvValue.setText("价值指数"+clientValue.getResult().getValue_score());
                            clientRtvValue.setText("总用户排行"+clientValue.getResult().getValue_percent()+"%");
                            setValueData(clientValue.getResult());
                        }
                        UIUtils.showToast(clientValue.getReason());
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


    @SuppressLint("SetTextI18n")
    private void setValueData(ClientValueBean.ResultBean result) {
        value_byze_msg.setText(result.getMaint_sum()+"("+result.getMaint_sum_percent()+"%)");
        value_bydc_msg.setText(result.getMaint_single()+"("+result.getMaint_single_percent()+"%)");
        value_fix_msg.setText(result.getRepair_sum()+"("+result.getRepair_sum_percent()+"%)");
        value_bp_msg.setText(result.getBody_shop_sum()+"("+result.getBody_shop_sum_percent()+"%)");
        value_jp_msg.setText(result.getExcellent_sum()+"("+result.getExcellent_sum_percent()+"%)");
        value_mr_msg.setText(result.getCar_care_sum()+"("+result.getCar_care_sum_percent()+"%)");
    }
}
