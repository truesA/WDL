package com.wdl.amdroid_jwdl.activity.clientmsg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;

import butterknife.BindView;

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
    @Override
    protected int getlayoutview() {
        return R.layout.activity_client_value;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        clientid= intent.getIntExtra("clientid",0);
        type= intent.getIntExtra("type",0);
        if (type==1){
            getToolbarTitle().setText("价值");
            clientLtvValue.setText("价值指数");
            clientRtvValue.setText("总用户排行");
            client_value_ll.setVisibility(View.VISIBLE);
            client_sticky_ll.setVisibility(View.GONE);
        }else {
            getToolbarTitle().setText("粘性");
            clientLtvValue.setText("粘性指数");
            clientRtvValue.setText("总用户排行");
            client_value_ll.setVisibility(View.GONE);
            client_sticky_ll.setVisibility(View.VISIBLE);
        }


    }

    @Override
    protected void initData() {

    }
}
