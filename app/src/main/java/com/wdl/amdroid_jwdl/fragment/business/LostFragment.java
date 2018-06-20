package com.wdl.amdroid_jwdl.fragment.business;

/**
 * author：lhm on 2018/3/24 21:33
 * <p>
 * email：3186834196@qq.com
 */

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseFragment;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.UserService;
import com.wdl.amdroid_jwdl.model.BaseBean;
import com.wdl.amdroid_jwdl.model.UserInfo;
import com.wdl.amdroid_jwdl.util.AppManagerUtil;
import com.wdl.amdroid_jwdl.util.PreferencesUtil;
import com.wdl.amdroid_jwdl.util.UIUtils;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

public class LostFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {
    private String CarUserid;
    private int lostStatus;
    private String loss_reason;

    @BindView(R.id.lost_et)
    TextView lost_et;

    @BindView(R.id.lost_r_1)
    RadioButton radioButton1;

    @BindView(R.id.lost_r_2)
    RadioButton radioButton2;

    @BindView(R.id.lost_r_3)
    RadioButton radioButton3;

    @BindView(R.id.lost_r_4)
    RadioButton radioButton4;

    @BindView(R.id.lost_rg)
    RadioGroup radioGroup;

    @BindView(R.id.lost_submit)
    Button lost_submit;

    private UserInfo userInfo;
    public void initData() {
        if (lostStatus == 1) {
            lost_submit.setEnabled(false);
            lost_submit.setBackgroundResource(R.drawable.button_bg_mianhui_c5);
        }
    }

    protected void initView() {
        getActivity().getWindow().setSoftInputMode(32);
        radioGroup.setOnCheckedChangeListener(this);
        userInfo = (UserInfo) PreferencesUtil.getInstance(getActivity()).getObject("UserInfo");

    }

    public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {
        if (paramInt == radioButton1.getId()) {
            loss_reason = "过路车辆";
            radioButton1.setTextColor(Color.WHITE);
            radioButton2.setTextColor(Color.BLACK);
            radioButton3.setTextColor(Color.BLACK);
            radioButton4.setTextColor(Color.BLACK);

        } else if (paramInt == radioButton2.getId()) {
            loss_reason = "在外保养";
            radioButton2.setTextColor(Color.WHITE);
            radioButton1.setTextColor(Color.BLACK);
            radioButton3.setTextColor(Color.BLACK);
            radioButton4.setTextColor(Color.BLACK);

        } else if (paramInt == radioButton3.getId()) {
            loss_reason = "车已卖了";
            radioButton3.setTextColor(Color.WHITE);
            radioButton2.setTextColor(Color.BLACK);
            radioButton1.setTextColor(Color.BLACK);
            radioButton4.setTextColor(Color.BLACK);
            return;
        } else {
            loss_reason = "投诉抱怨";
            radioButton4.setTextColor(Color.WHITE);
            radioButton2.setTextColor(Color.BLACK);
            radioButton1.setTextColor(Color.BLACK);
            radioButton3.setTextColor(Color.BLACK);
        }
    }


    @OnClick({R.id.lost_submit, R.id.lost_et})
    public void onclickSubmitLost(View view) {
        switch (view.getId()) {
            case R.id.lost_submit:
                showLoadingDialog();
                HashMap<String,String> localHashMap = new HashMap();
                localHashMap.put("said",userInfo.getSAname());
                localHashMap.put("loss_action", "1");
                localHashMap.put("loss_user", CarUserid);
                localHashMap.put("loss_reason", loss_reason);
                localHashMap.put("loss_notes", lost_et.getText().toString());
                App.getRetrofit(API.BASE_URL)
                        .create(UserService.class)
                        .getSubmit_Content(localHashMap)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<BaseBean>() {
                            public void onComplete() {
                                dismissLoadingDialog();
                            }

                            public void onError(Throwable paramThrowable) {
                                UIUtils.showToast("系统繁忙");
                                dismissLoadingDialog();
                            }

                            public void onNext(BaseBean paramBaseBean) {
                                if (paramBaseBean.getError_code() == 200) {
                                    dismissLoadingDialog();
                                    AppManagerUtil.instance().finishActivity();
                                }
                                UIUtils.showToast(paramBaseBean.getReason());
                            }

                            public void onSubscribe(Disposable paramDisposable) {
                            }
                        });
                break;
            case R.id.lost_et:
                boolean wrapInScrollView = true;
                new MaterialDialog.Builder(getActivity())
                        .title("备注")
                        .customView(R.layout.continue_text_view, wrapInScrollView)
                        .positiveText("确定")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                EditText editText = (EditText) dialog.getView().findViewById(R.id.text_content);
                                lost_et.setText(editText.getText());
                                lost_et.setTextColor(Color.BLACK);
                            }
                        })
                        .show();
                break;
        }

    }

    public void setCarUseridandSubmitStatus(String paramString, int status) {
        this.lostStatus = status;
        this.CarUserid = paramString;
    }

    protected View setRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.lost_fg, viewGroup, false);
    }
}