package com.wdl.amdroid_jwdl.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wdl.amdroid_jwdl.MainActivity;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.model.LoginUesr;
import com.wdl.amdroid_jwdl.util.AppManagerUtil;
import com.wdl.amdroid_jwdl.util.KeyboardWatcher;
import com.wdl.amdroid_jwdl.util.PreferencesUtil;
import com.wdl.amdroid_jwdl.util.UIUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class Login2Activity extends BaseActivity implements View.OnClickListener, KeyboardWatcher.SoftKeyboardStateListener {

    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.et_mobile)
    EditText et_mobile;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.iv_show_pwd)
    ImageView iv_show_pwd;
    @BindView(R.id.et_close)
    public ImageView et_close;

    private int screenHeight = 0;//屏幕高度
    private float scale = 0.8f; //logo缩放比例
    @BindView(R.id.body)
    View body;
    private KeyboardWatcher keyboardWatcher;
    private final int charMaxNum = 20;
    private final int charMaxNumpass = 16;

    @Override
    protected int getlayoutview() {
        return R.layout.activity_login2;
    }

    @Override
    protected boolean isUseToolsBar() {
        return false;
    }

    @Override
    protected void initView() {
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        initListener();
        keyboardWatcher = new KeyboardWatcher(findViewById(Window.ID_ANDROID_CONTENT));
        keyboardWatcher.addSoftKeyboardStateListener(this);
    }


    @Override
    protected void initData() {

    }

    private void initListener() {
        et_mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > charMaxNum)
                    UIUtils.showToast("超过最大输入限制");
            }
        });
        et_password.addTextChangedListener(new TextWatcher() {
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
//                if (s.toString().isEmpty())
//                    return;
//                if (!s.toString().matches("[A-Za-z0-9]+")) {
//                    String temp = s.toString();
//                    UIUtils.showToast("密码超过最大输入限制");
//                    s.delete(temp.length() - 1, temp.length());
//                    et_password.setSelection(s.length());
//                }
            }
        });
    }

    /**
     * 缩小
     *
     * @param view
     */
    public void zoomIn(final View view, float dist) {
        view.setPivotY(view.getHeight());
        view.setPivotX(view.getWidth() / 2);
        AnimatorSet mAnimatorSet = new AnimatorSet();
        ObjectAnimator mAnimatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, scale);
        ObjectAnimator mAnimatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, scale);
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -dist);

        mAnimatorSet.play(mAnimatorTranslateY).with(mAnimatorScaleX).with(mAnimatorScaleY);

        mAnimatorSet.setDuration(300);
        mAnimatorSet.start();

    }

    /**
     * f放大
     *
     * @param view
     */
    public void zoomOut(final View view) {
        if (view.getTranslationY() == 0) {
            return;
        }
        view.setPivotY(view.getHeight());
        view.setPivotX(view.getWidth() / 2);
        AnimatorSet mAnimatorSet = new AnimatorSet();

        ObjectAnimator mAnimatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", scale, 1.0f);
        ObjectAnimator mAnimatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", scale, 1.0f);
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY(), 0);

        mAnimatorSet.play(mAnimatorTranslateY).with(mAnimatorScaleX).with(mAnimatorScaleY);
        mAnimatorSet.setDuration(300);
        mAnimatorSet.start();

    }

    private boolean flag = false;

    @OnClick({R.id.et_close,R.id.close, R.id.iv_show_pwd,R.id.btn_login})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.et_close:
                et_password.setText("");
                return;
            case R.id.close:
                finish();
                break;
            case R.id.iv_show_pwd:
                if (flag == true) {
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    iv_show_pwd.setImageResource(R.drawable.eye_close);
                    flag = false;
                } else {
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    iv_show_pwd.setImageResource(R.drawable.eye_open);
                    flag = true;
                }
                String pwd = et_password.getText().toString();
                if (!TextUtils.isEmpty(pwd))
                    et_password.setSelection(pwd.length());
                break;
            case R.id.btn_login:
                hideKeyboard();
                String name =  et_mobile.getText().toString();
                String str =  et_password.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    UIUtils.showToast("手机号不能为空");
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    UIUtils.showToast("密码不能为空");
                    return;
                }
                if (name.equals("admin1") && (str.equals("123456"))) {
                    showLoadingDialog();
                    LoginUesr login = new LoginUesr();
                    login.setLogin(true);
                    login.setToken("admin1");
                    login.setUserType(1);
                    PreferencesUtil.getInstance(this).saveParam("loginUesr", login);
                    PreferencesUtil.getInstance(this).setLogin(true);
                    startActivity(new Intent(this, MainActivity.class));
                    AppManagerUtil.instance().finishActivity();
                    return;
                }
                if (name.equals("admin2") && (str.equals("123456"))) {
                    showLoadingDialog();
                    LoginUesr login = new LoginUesr();
                    login.setLogin(true);
                    login.setToken("admin2");
                    login.setUserType(2);
                    PreferencesUtil.getInstance(this).saveParam("loginUesr", login);
                    PreferencesUtil.getInstance(this).setLogin(true);
                    startActivity(new Intent(this, MainActivity.class));
                    AppManagerUtil.instance().finishActivity();
                    return;
                }
                UIUtils.showToast("用户名密码错误");
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        keyboardWatcher.removeSoftKeyboardStateListener(this);
    }

    @Override
    public void onSoftKeyboardOpened(int keyboardSize) {
        Log.e("wenzhihao", "----->show" + keyboardSize);
        int[] location = new int[2];
        body.getLocationOnScreen(location); //获取body在屏幕中的坐标,控件左上角
        int x = location[0];
        int y = location[1];
        Log.e("wenzhihao", "y = " + y + ",x=" + x);
        int bottom = screenHeight - (y + body.getHeight());
        Log.e("wenzhihao", "bottom = " + bottom);
        Log.e("wenzhihao", "con-h = " + body.getHeight());
        if (keyboardSize > bottom) {
            ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(body, "translationY", 0.0f, -(keyboardSize - bottom));
            mAnimatorTranslateY.setDuration(300);
            mAnimatorTranslateY.setInterpolator(new AccelerateDecelerateInterpolator());
            mAnimatorTranslateY.start();
            zoomIn(logo, keyboardSize - bottom);

        }
    }

    @Override
    public void onSoftKeyboardClosed() {
        Log.e("wenzhihao", "----->hide");
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(body, "translationY", body.getTranslationY(), 0);
        mAnimatorTranslateY.setDuration(300);
        mAnimatorTranslateY.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimatorTranslateY.start();
        zoomOut(logo);
    }

}
