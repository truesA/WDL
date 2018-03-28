package com.wdl.amdroid_jwdl.activity.clientmsg;

import android.widget.TextView;

import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;

import butterknife.BindView;

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


    @Override
    protected int getlayoutview() {
        return R.layout.activity_client_behavior;
    }

    @Override
    protected void initView() {
        getToolbarTitle().setText("行为");
        clientLtvValue.setText("行为指数");
        clientRtvValue.setText("总用户排行");
    }

    @Override
    protected void initData() {

    }
}
