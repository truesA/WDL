package com.wdl.amdroid_jwdl.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.util.AppManagerUtil;
import com.wdl.amdroid_jwdl.util.UIUtils;

import butterknife.ButterKnife;

//import com.achers.mvpdemo.util.SharedPreferencesUtils;

/**
 * Created by Achers on 2017/11/30.
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 全局上下文
     */
    public Context mContext;
    // public SharedPreferences dataSPF;
    //the container of this activity layout and sub-activity layout
    private LinearLayout parentLinearLayout;

    private TextView mTvTitle;
    private TextView mTvRight;
    //private Toolbar mToolbar;
    private ImageView mIvRight;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        // dataSPF = SharedPreferencesUtils.getInstance().getSharedPreferences(Constant.SPF_DATA);
        if (isUseToolsBar()) {
            initContentView(R.layout.activity_base);
            setContentViewNo(getlayoutview());
            //   AndroidBug5497Workaround.assistActivity(findViewById(android.R.id.content));
            setBackIcon();
            initToolBar();
            ButterKnife.bind(this);
        } else {
            setContentView(getlayoutview());
            //     AndroidBug5497Workaround.assistActivity(findViewById(android.R.id.content));
            ButterKnife.bind(this);
        }

        initView();
        initData();

        // 2.ActvityManange 管理
        AppManagerUtil.instance().addActivity(this);

        /**
         * 设置StatusBarColor
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }


    }

    public void dismissLoadingDialog() {
        if ((alertDialog == null) || (!(alertDialog.isShowing())))
            return;
        alertDialog.dismiss();
    }


    public void showLoadingDialog() {
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        alertDialog.setCancelable(false);
        alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent) {
                if ((paramInt != 84) && (paramInt == 4)) ;
                return false;
            }
        });
        alertDialog.show();
        alertDialog.setContentView(R.layout.loading_alert);
        alertDialog.setCanceledOnTouchOutside(false);
    }


    /***
     * 是否启用toolbar
     * @return
     */
    protected boolean isUseToolsBar() {
        return true;
    }


    private void initToolBar() {
        mIvRight = findViewById(R.id.iv_right);
        mTvTitle = findViewById(R.id.tv_title);
        mTvRight = findViewById(R.id.tv_right);
        //getToolbar().setBackgroundColor(getResources().getColor(R.color.white));
        setStatusBarPaddingAndHeight(getToolbar());
    }

    /**
     * 动态设置状态栏高度+toolbar的高度
     * 防止软键盘弹出时Toolbar被顶上去了
     *
     * @param toolBar
     */
    protected void setStatusBarPaddingAndHeight(View toolBar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (toolBar != null) {
                int statusBarHeight = UIUtils.getSystemBarHeight(this);
                toolBar.setPadding(toolBar.getPaddingLeft(), statusBarHeight, toolBar.getPaddingRight(),
                        toolBar.getPaddingBottom());
                toolBar.getLayoutParams().height = statusBarHeight +
                        (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
            }
        }
    }


    private void initContentView(@LayoutRes int layoutResID) {
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        parentLinearLayout = new LinearLayout(this);
        parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        //  add parentLinearLayout in viewGroup
        viewGroup.addView(parentLinearLayout);
        //  add the layout of BaseActivity in parentLinearLayout
        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
    }

    /**
     * @param layoutResID layout id of sub-activity
     */
//    @Override
//    public void setContentView(@LayoutRes int layoutResID) {
//        //  added the sub-activity layout id in parentLinearLayout
//        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
//
//    }
    public void setContentViewNo(@LayoutRes int layoutResID) {

        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
    }

    protected abstract int getlayoutview();

    protected abstract void initView();

    protected abstract void initData();

    /**
     * @return TextView in center
     */
    public TextView getToolbarTitle() {
        return mTvTitle;
    }

    /**
     * @return TextView on the right
     */
    public TextView getSubTitle() {
        return mTvRight;
    }

    public ImageView getmIvRight() {
        return mIvRight;
    }

    /**
     * set Title
     *
     * @param title
     */
    public void setToolBarTitle(CharSequence title) {
        if (mTvTitle != null) {
            mTvTitle.setText(title);
        } else {
            getToolbar().setTitle(title);
            setSupportActionBar(getToolbar());
        }
    }

    /**
     * 设置返回
     */
    private void setBackIcon() {
        if (null != getToolbar() && isShowBacking()) {
            getToolbar().setNavigationIcon(R.drawable.back_whilte_icon);
            getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppManagerUtil.instance().finishActivity();
                    // onBackPressed();
                }
            });
        }
    }

    public void showIvRight() {
//        getmIvRight().setVisibility(View.VISIBLE);
//        getmIvRight().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UIUtils.showToast("筛选");
//                startActivity(BankCardAddActivity.class);
//            }
//        });
    }

    /**
     * the toolbar of this Activity
     *
     * @return support.v7.widget.Toolbar.
     */
    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.base_toolbar);
    }

    /**
     * is show back icon,default is none。
     * you can override the function in subclass and return to true show the back icon
     *
     * @return
     */
    protected boolean isShowBacking() {
        return true;
    }

    /**
     * 实现对状态栏的控制
     *
     * @param enable
     */
    public void full(boolean enable) {
        if (enable) {
            WindowManager.LayoutParams mLp = getWindow().getAttributes();
            mLp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(mLp);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        } else {
            WindowManager.LayoutParams mAttr = getWindow().getAttributes();
            mAttr.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setAttributes(mAttr);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    /**
     * 隐藏软键盘
     */
    public void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    //4.多样式启动starActvity

    /**
     * 基starActvity
     * action 隐式意图
     */
    public void startActivity(String className, String action, Bundle options) {
        Intent intent = new Intent();
        if (className != null) {
            intent.setClassName(getPackageName(), className);
        } else if (action != null) {
            intent.setAction(action);
        } else {
            return;
        }
        startActivity(intent);
    }

    /**
     * action + options
     *
     * @param action
     * @param options
     */
    public void startActvityAction(String action, Bundle options) {
        startActivity(null, action, options);
    }

    /**
     * action + 无参
     *
     * @param action
     */
    public void startActvityAction(String action) {
        startActivity(null, action, null);
    }

    /**
     * className + options
     *
     * @param className
     * @param options
     */
    public void startActivityClassName(String className, Bundle options) {
        startActivity(className, null, options);
    }

    /**
     * className+ 无参
     *
     * @param className
     */
    public void startActivityClassName(String className) {
        startActivity(className, null, null);
    }

    /**
     * @param className
     */
    public void startActivity(Class className) {
        startActivity(className, null);
    }

    /**
     * @param className
     * @param options
     */
    public void startActivity(Class className, Bundle options) {
        if (Activity.class.isAssignableFrom(className))
            startActivity(className.getName(), null, options);
        else
            Log.e("startActivity err", "this class is not activity");
    }
}
