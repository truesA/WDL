package com.wdl.amdroid_jwdl.fragment.business;

/**
 * author：lhm on 2018/3/24 21:49
 * <p>
 * email：3186834196@qq.com
 */

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.adapter.CustomAdapter;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;

public class WaiverFragment extends BaseFragment {
    private String CarUserid;
    private int waiverStatus;
    private String giveup_reason;

    @BindView(R.id.waiver_rc)
    public RecyclerView recyclerView;

    @BindView(R.id.waiver_et)
    TextView waiver_et;

    @BindView(R.id.waiver_submit)
    Button waiver_submit;
    private UserInfo userInfo;
    private void initRecycler() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("里程未到");
        arrayList.add("不是车主");
        arrayList.add("自己安排");
        arrayList.add("外地用车");
        arrayList.add("号码未通");
        arrayList.add("外面保养");
        arrayList.add("号码失联");
        arrayList.add("他点保养");
        arrayList.add("不愿沟通");
        arrayList.add("有事正忙");
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), arrayList);
        this.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        this.recyclerView.setAdapter(customAdapter);
        customAdapter.setOnItemClickListener(new CustomAdapter.OnRecyclerViewItemClickListener() {
            public void onItemClick(View paramView, String paramString, int paramInt) {
                giveup_reason= paramString;
                UIUtils.showToast(paramString);
            }
        });
    }

    public void initData() {
        if (waiverStatus==1){
            waiver_submit.setEnabled(false);
            waiver_submit.setBackgroundResource(R.drawable.button_bg_mianhui_c5);
        }
    }

    protected void initView() {
        getActivity().getWindow().setSoftInputMode(32);
        initRecycler();
        userInfo = (UserInfo) PreferencesUtil.getInstance(getActivity()).getObject("UserInfo");
    }

    @OnClick({R.id.waiver_submit,R.id.waiver_et})
    public void onclickWaiver(View view) {
        switch (view.getId()){
            case R.id.waiver_submit:
                showLoadingDialog();
                HashMap<String, String> params = new HashMap();
                params.put("said",userInfo.getSAname());
                params.put("giveup_action", "1");
                params.put("giveup_user", this.CarUserid);
                params.put("giveup_reason", this.giveup_reason);
                params.put("giveup_notes", this.waiver_et.getText().toString());
                App.getRetrofit(API.BASE_URL).create(UserService.class)
                        .getSubmit_Content(params).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<BaseBean>() {
                            public void onComplete() {
                                dismissLoadingDialog();
                            }

                            public void onError(Throwable paramThrowable) {
                                dismissLoadingDialog();
                                UIUtils.showToast("系统繁忙");
                                paramThrowable.printStackTrace();
                            }

                            public void onNext(BaseBean paramBaseBean) {
                                if (paramBaseBean.getError_code() == 200){
                                    AppManagerUtil.instance().finishActivity();
                                    dismissLoadingDialog();
                                }else {
                                    UIUtils.showToast(paramBaseBean.getReason());
                                }
                            }

                            public void onSubscribe(Disposable paramDisposable) {
                            }
                        });
                break;
            case R.id.waiver_et:
                boolean wrapInScrollView = true;
                new MaterialDialog.Builder(getActivity())
                        .title("备注")
                        .customView(R.layout.continue_text_view, wrapInScrollView)
                        .positiveText("确定")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                EditText editText = (EditText) dialog.getView().findViewById(R.id.text_content);
                                waiver_et.setText( editText.getText());
                                waiver_et.setTextColor(Color.BLACK);
                            }
                        })
                        .show();
                break;
        }

    }

    public void setCarUseridandSubmitStatus(String paramString,int status) {
       this.waiverStatus=status;
        this.CarUserid = paramString;
    }

    protected View setRootView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup) {
        return paramLayoutInflater.inflate(R.layout.waive_fg, paramViewGroup, false);
    }
}