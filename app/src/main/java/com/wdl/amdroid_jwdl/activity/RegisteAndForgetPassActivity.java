package com.wdl.amdroid_jwdl.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.util.UIUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class RegisteAndForgetPassActivity extends BaseActivity {

    @BindView(R.id.et_phone)
    public EditText et_phone;
    @BindView(R.id.et_number)
    public EditText et_number;
    @BindView(R.id.et_new_pass)
    public EditText et_new_pass;
    @BindView(R.id.register_url)
    public TextView register_url;
    @BindView(R.id.tv_number)
    public TextView tv_number;
    @BindView(R.id.bt_submit)
    public Button bt_submit;

    private Disposable mdDisposable;

    private boolean intentflag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //"用户注册"=false  "忘记密码"=true
        intentflag = getIntent().getBooleanExtra("intentflag", false);
        if (!intentflag) {
            getToolbarTitle().setText("用户注册");
            String content = "注册表示你已经阅读，并同意<font color=\"#1296db\">《用户协议》</font>";
            if (Build.VERSION.SDK_INT >= 24)
                register_url.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
            else
                register_url.setText(Html.fromHtml(content));

        } else {
            getToolbarTitle().setText("忘记密码");
        }
    }


    @Override
    protected int getlayoutview() {
        return R.layout.activity_registe;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_number, R.id.bt_submit})
    public void onRegisteOnclick(View view) {
        switch (view.getId()) {

            case R.id.tv_number:

                String et_phone_string = et_phone.getText().toString();
                if (TextUtils.isEmpty(et_phone_string)) {
                    UIUtils.showToast("请输入手机号");
                    return;
                }

                //点击后置为不可点击状态
                tv_number.setEnabled(false);
                //从0开始发射11个数字为：0-10依次输出，延时0s执行，每1s发射一次。
                mdDisposable = Flowable.intervalRange(0, 60, 0, 1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                tv_number.setText("重新获取(" + (60 - aLong) + ")");
                            }
                        })
                        .doOnComplete(new Action() {
                            @Override
                            public void run() throws Exception {
                                //倒计时完毕置为可点击状态
                                tv_number.setEnabled(true);
                                tv_number.setText("获取验证码");
                            }
                        })
                        .subscribe();
                break;

            case R.id.bt_submit:
                String phoneString = et_phone.getText().toString();
                String numberString = et_number.getText().toString();
                String new_passString = et_new_pass.getText().toString();

                //"忘记密码"=true
                if (intentflag) {

                } else {
                    //  "用户注册"=false
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mdDisposable != null) {
            mdDisposable.dispose();
        }
    }
}
