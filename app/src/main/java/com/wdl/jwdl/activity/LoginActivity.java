package com.wdl.jwdl.activity;

/**
 * Created by 62682 on 2018/3/20.
 */

import android.content.Intent;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wdl.jwdl.R;
import com.wdl.jwdl.base.BaseActivity;
import com.wdl.jwdl.util.UIUtils;

import butterknife.BindView;
import butterknife.OnClick;

@Deprecated
public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_name)
    public EditText nameEt;
    @BindView(R.id.et_password)
    public EditText passwordEt;
    @BindView(R.id.bt_login)
    public Button login;
    @BindView(R.id.et_close)
    public ImageView et_close;
    @BindView(R.id.et_password_type)
    public ImageView et_password_type;
    @BindView(R.id.login_forget)
    public TextView login_forget;
    @BindView(R.id.login_register)
    public TextView login_register;
    @BindView(R.id.login_qq)
    public ImageView login_qq;
    @BindView(R.id.login_weixin)
    public ImageView login_weixin;
    @BindView(R.id.login_sina)
    public ImageView login_sina;

    private final int charMaxNum = 20;
    private final int charMaxNumpass = 16;
    private Boolean showPassword = true;

    protected int getlayoutview() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.bt_login})
    public void goLogin() {
        hideKeyboard();
        String name =  nameEt.getText().toString();
        String str =  passwordEt.getText().toString();
        if (TextUtils.isEmpty(name)) {
            UIUtils.showToast("手机号不能为空");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UIUtils.showToast("密码不能为空");
            return;
        }
//        if (name.equals("admin1") && (str.equals("123456"))) {
//            showLoadingDialog();
//            LoginUesr login = new LoginUesr();
//            login.setLogin(true);
//            login.setToken("admin1");
//            login.setUserType(1);
//            PreferencesUtil.getInstance(this).saveParam("loginUesr", login);
//            PreferencesUtil.getInstance(this).setLogin(true);
//            startActivity(new Intent(this, MainActivity.class));
//            AppManagerUtil.instance().finishActivity();
//            return;
//        }
//        if (name.equals("admin2") && (str.equals("123456"))) {
//            showLoadingDialog();
//            LoginUesr login = new LoginUesr();
//            login.setLogin(true);
//            login.setToken("admin2");
//            login.setUserType(2);
//            PreferencesUtil.getInstance(this).saveParam("loginUesr", login);
//            PreferencesUtil.getInstance(this).setLogin(true);
//            startActivity(new Intent(this, MainActivity.class));
//            AppManagerUtil.instance().finishActivity();
//            return;
//        }
        UIUtils.showToast("用户名密码错误");
    }

    protected void initData() {
    }

    protected void initView() {
        getToolbarTitle().setText("登录");
        String content = "还没有帐号,<font color=\"#ffff3366\">去注册</font>";
        if (Build.VERSION.SDK_INT >= 24)
            login_register.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
        else
            login_register.setText(Html.fromHtml(content));


        nameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (s.length() > charMaxNum)
                    //  nametextInputLayout.setError("超过最大输入限制");
                    UIUtils.showToast("超过最大输入限制");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    et_close.setVisibility(View.VISIBLE);
                } else {
                    et_close.setVisibility(View.GONE);
                }

                if (s.length() > charMaxNumpass)
                    UIUtils.showToast("密码超过最大输入限制");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    protected boolean isShowBacking() {
        return false;
    }

    protected void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
    }

    @OnClick({R.id.et_close,R.id.et_password_type, R.id.login_forget,R.id.login_register,R.id.login_qq,R.id.login_weixin,R.id.login_sina})
    public void onViewClicked(View view){
        boolean bool2 = true;
        boolean bool1 = true;
        Intent localIntent = new Intent();
        switch (view.getId()) {
            default:
                return;
            case R.id.et_close:
                 passwordEt.setText("");
                return;
            case R.id.et_password_type:
                if (showPassword) {// 显示密码
                    et_password_type.setImageDrawable(getResources().getDrawable(R.drawable.eye_open));
                    passwordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passwordEt.setSelection(passwordEt.getText().toString().length());
                    showPassword = !showPassword;
                } else {// 隐藏密码
                    et_password_type.setImageDrawable(getResources().getDrawable(R.drawable.eye_close));
                    passwordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passwordEt.setSelection(passwordEt.getText().toString().length());
                    showPassword = !showPassword;
                }
                return;
            case R.id.login_forget:
                localIntent.putExtra("intentflag", true);
                localIntent.setClass(this, RegisteAndForgetPassActivity.class);
                startActivity(localIntent);
                return;
            case R.id.login_register:
                localIntent.putExtra("intentflag", false);
                localIntent.setClass(this, RegisteAndForgetPassActivity.class);
                startActivity(localIntent);
                return;
            case R.id.login_qq:
                UIUtils.showToast("QQ登录内测暂不提供此功能");
                return;
            case R.id.login_weixin:
                UIUtils.showToast("微信登录内测暂不提供此功能");
                return;
            case R.id.login_sina:
                UIUtils.showToast("新浪登录内测暂不提供此功能");
                return;
        }

    }
}