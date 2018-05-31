package com.wdl.amdroid_jwdl.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.MainActivity;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseFragment;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.UserService;
import com.wdl.amdroid_jwdl.model.LoginUesr;
import com.wdl.amdroid_jwdl.model.MainServiceBean;
import com.wdl.amdroid_jwdl.model.SavingBean;
import com.wdl.amdroid_jwdl.model.UserInfo;
import com.wdl.amdroid_jwdl.util.PreferencesUtil;
import com.wdl.amdroid_jwdl.util.UIUtils;
import com.wdl.amdroid_jwdl.view.TimeMDdialog;
import com.wdl.amdroid_jwdl.view.XOView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.addapp.pickers.picker.DatePicker;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author：lhm on 2018/5/24 19:09
 * <p>
 * email：3186834196@qq.com
 * <p>
 * 新储蓄界面
 */
public class SavingFragment extends BaseFragment {
    @BindView(R.id.saving_bonus_rl)
    LinearLayout saving_bonus_rl;
    @BindView(R.id.saving_data_one)
    LinearLayout saving_data_one;
    @BindView(R.id.saving_data_two)
    LinearLayout saving_data_two;
    @BindView(R.id.saving_data_three)
    LinearLayout saving_data_three;
    @BindView(R.id.saving_data_four)
    LinearLayout saving_data_four;

    @BindView(R.id.saving_bonus_y_n)
    TextView saving_bonus_y_n;
    @BindView(R.id.saving_bonus_value)
    TextView saving_bonus_value;
    @BindView(R.id.saving_user_num)
    TextView saving_user_num;
    @BindView(R.id.saving_bonus_rl_value_bg)
    RelativeLayout saving_bonus_rl_value_bg;
    @BindView(R.id.view_status)
    View view_status;
    //活期金额
    @BindView(R.id.saving_hqje_xo)
    XOView saving_hqje_xo;
    @BindView(R.id.saving_hqje_value)
    TextView saving_hqje_value;
    @BindView(R.id.saving_hqje_value2)
    TextView saving_hqje_value2;
    //季奖金池
    @BindView(R.id.saving_jjje_xo)
    XOView saving_jjje_xo;
    @BindView(R.id.saving_jjje_value)
    TextView saving_jjje_value;
    @BindView(R.id.saving_jjje_value2)
    TextView saving_jjje_value2;
    //丢失金额
    @BindView(R.id.saving_dsje_xo)
    XOView saving_dsje_xo;
    @BindView(R.id.saving_dsje_value)
    TextView saving_dsje_value;
    @BindView(R.id.saving_dsje_value2)
    TextView saving_dsje_value2;
    //季台次达成率
    @BindView(R.id.saving_jtcdcl_xo)
    XOView saving_jtcdcl_xo;
    @BindView(R.id.saving_jtcdcl_value)
    TextView saving_jtcdcl_value;
    @BindView(R.id.saving_jtcdcl_value2)
    TextView saving_jtcdcl_value2;
    //季T1客户数
    @BindView(R.id.saving_t1khs_xo)
    XOView saving_t1khs_xo;
    @BindView(R.id.saving_t1khs_value)
    TextView saving_t1khs_value;
    @BindView(R.id.saving_t1khs_value2)
    TextView saving_t1khs_value2;
    //季产值达成率
    @BindView(R.id.saving_jczdcl_xo)
    XOView saving_jczdcl_xo;
    @BindView(R.id.saving_jczdcl_value)
    TextView saving_jczdcl_value;
    @BindView(R.id.saving_jczdcl_value2)
    TextView saving_jczdcl_value2;
    //季M1客户数
    @BindView(R.id.saving_m1khs_xo)
    XOView saving_m1khs_xo;
    @BindView(R.id.saving_m1khs_value)
    TextView saving_m1khs_value;
    @BindView(R.id.saving_m1khs_value2)
    TextView saving_m1khs_value2;
    //季预约成功率
    @BindView(R.id.saving_jyycgl_xo)
    XOView saving_jyycgl_xo;
    @BindView(R.id.saving_jyycgl_value)
    TextView saving_jyycgl_value;
    @BindView(R.id.saving_jyycgl_value2)
    TextView saving_jyycgl_value2;
    //季M2客户数
    @BindView(R.id.saving_m2khs_xo)
    XOView saving_m2khs_xo;
    @BindView(R.id.saving_m2khs_value)
    TextView saving_m2khs_value;
    @BindView(R.id.saving_m2khs_value2)
    TextView saving_m2khs_value2;
    //季准时交车数
    @BindView(R.id.saving_jzsjcs_xo)
    XOView saving_jzsjcs_xo;
    @BindView(R.id.saving_jzsjcs_value)
    TextView saving_jzsjcs_value;
    @BindView(R.id.saving_jzsjcs_value2)
    TextView saving_jzsjcs_value2;
    //季追加产值
    @BindView(R.id.saving_jzjcz_xo)
    XOView saving_jzjcz_xo;
    @BindView(R.id.saving_jzjcz_value)
    TextView saving_jzjcz_value;
    @BindView(R.id.saving_jzjcz_value2)
    TextView saving_jzjcz_value2;
    //季准时率
    @BindView(R.id.saving_jzsl_xo)
    XOView saving_jzsl_xo;
    @BindView(R.id.saving_jzsl_value)
    TextView saving_jzsl_value;
    @BindView(R.id.saving_jzsl_value2)
    TextView saving_jzsl_value2;

    @BindView(R.id.saving_refreshLayout)
    SmartRefreshLayout refreshLayouts;
    @BindView(R.id.saving_month)
    TextView saving_month;


    private int bottomNavigationBarHeight;
    private int relativeLayoutBonusHeight;
    private int isRefresh = 0;
    private String startdefult = "2018-05-26";
    private UserInfo userInfo;

    @Override
    protected void initView() {
        saving_month.setText(startdefult);
        saving_bonus_rl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                saving_bonus_rl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.e("TAG",

                        "saving_bonus_rl.getMeasuredHeight()==" + saving_bonus_rl.getMeasuredHeight());
                relativeLayoutBonusHeight = saving_bonus_rl.getMeasuredHeight();
                int viewSingeHeight = UIUtils.getScreenHeight() - UIUtils.getSystemBarHeight(getActivity()) - relativeLayoutBonusHeight - bottomNavigationBarHeight;
                ViewGroup.LayoutParams layoutParams = saving_data_one.getLayoutParams();
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams.height = viewSingeHeight / 3;
                saving_data_one.setLayoutParams(layoutParams);

                ViewGroup.LayoutParams layoutParams2 = saving_data_two.getLayoutParams();
                layoutParams2.width = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams2.height = viewSingeHeight / 3;
                saving_data_two.setLayoutParams(layoutParams2);

                ViewGroup.LayoutParams layoutParams3 = saving_data_three.getLayoutParams();
                layoutParams3.width = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams3.height = viewSingeHeight / 3;
                saving_data_three.setLayoutParams(layoutParams3);

                ViewGroup.LayoutParams layoutParams4 = saving_data_four.getLayoutParams();
                layoutParams4.width = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams4.height = viewSingeHeight / 3;
                saving_data_three.setLayoutParams(layoutParams4);
            }
        });

        refreshLayouts.setRefreshHeader(new MaterialHeader(getActivity()));
        refreshLayouts.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh(RefreshLayout RefreshLayout) {
                isRefresh = 1;
                getAllData(startdefult);
            }
        });
        refreshLayouts.setEnableLoadMore(false);
    }

    @Override
    protected View setRootView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.saving_fg, container, false);

        return view;
    }

    @Override
    public void initData() {
        userInfo = (UserInfo) PreferencesUtil.getInstance(getActivity()).getObject("UserInfo");
        getAllData(startdefult);
    }


    private void getAllData(final String date) {
        if (isRefresh == 0) {
            showLoadingDialog();
        }
        App.getRetrofit(API.BASE_URL)
                .create(UserService.class)
                .getMainSavingMsg(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SavingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    public void onError(Throwable paramThrowable) {
                        dismissLoadingDialog();
                        refreshLayouts.finishRefresh();
                        paramThrowable.printStackTrace();
                        UIUtils.showToast("出错啦！");
                    }

                    public void onNext(SavingBean savingBean) {
                        refreshLayouts.finishRefresh();
                        if (isRefresh == 0) {
                            dismissLoadingDialog();
                        }
                        if (savingBean.getError_code() == 200) {
                            // ServiceFragment.access$002(ServiceFragment.this,val$month);
                            startdefult = date.substring(date.indexOf("-")+1);
                            saving_month.setText(startdefult);
                            setDataMsg(savingBean.getResult());
                        }
                        UIUtils.showToast(savingBean.getReason());
                    }

                    @Override
                    public void onComplete() {
                        refreshLayouts.finishRefresh();
                    }
                });
    }


    @SuppressLint("SetTextI18n")
    private void setDataMsg(SavingBean.ResultBean result) {
        int cashSign;
        if (userInfo.getLogintype() == 1) {
            cashSign=result.getSA1().getCash_flow_sign();
            saving_bonus_y_n.setText(cashSign == 1 ? "+" : "-");
            saving_bonus_rl_value_bg.setBackgroundColor(cashSign == 1 ? Color.parseColor("#ff3f7fff"): Color.parseColor("#ffff3366"));
            view_status.setBackgroundColor(cashSign == 1 ? Color.parseColor("#ff3f7fff"): Color.parseColor("#ffff3366"));
            saving_bonus_value.setText(result.getSA1().getCash_flow() + "");
            saving_user_num.setText(result.getSA1().getCustomer_nm() + "");

            saving_hqje_value.setText(result.getSA1().getAlive_mn() + "");
            saving_hqje_value2.setText(result.getSA2().getAlive_mn() + "");
            saving_jjje_value.setText(result.getSA1().getS_pool_mn() + "");
            saving_jjje_value2.setText(result.getSA1().getS_pool_mn() + "");
            saving_dsje_value.setText(result.getSA1().getLost_mn() + "");
            saving_dsje_value2.setText(result.getSA2().getLost_mn() + "");
            saving_jtcdcl_value.setText(result.getSA1().getS_times_achv_rate() + "%");
            saving_jtcdcl_value2.setText(result.getSA2().getS_times_achv_rate() + "%");
            saving_t1khs_value.setText(result.getSA1().getS_T1_num() + "");
            saving_t1khs_value2.setText(result.getSA2().getS_T1_num() + "");
            saving_jczdcl_value.setText(result.getSA1().getS_mn_achv_rate() + "%");
            saving_jczdcl_value2.setText(result.getSA2().getS_mn_achv_rate() + "%");
            saving_m1khs_value.setText(result.getSA1().getS_M1_num() + "");
            saving_m1khs_value2.setText(result.getSA2().getS_M1_num() + "");
            saving_jyycgl_value.setText(result.getSA1().getS_appoint_rate() + "%");
            saving_jyycgl_value2.setText(result.getSA2().getS_appoint_rate() + "%");
            saving_m2khs_value.setText(result.getSA1().getS_M2_num() + "");
            saving_m2khs_value2.setText(result.getSA2().getS_M2_num() + "");
            saving_jzsjcs_value.setText(result.getSA1().getS_ontime_num() + "");
            saving_jzsjcs_value2.setText(result.getSA2().getS_ontime_num() + "");
            saving_jzjcz_value.setText(result.getSA1().getS_add_mn() + "");
            saving_jzjcz_value2.setText(result.getSA2().getS_add_mn() + "");
            saving_jzsl_value.setText(result.getSA1().getS_ontime_rate() + "%");
            saving_jzsl_value2.setText(result.getSA2().getS_ontime_rate() + "%");

        } else {
            cashSign=result.getSA2().getCash_flow_sign();
            saving_bonus_y_n.setText(cashSign== 1 ? "+" : "-");
            saving_bonus_rl_value_bg.setBackgroundColor(cashSign == 1 ? Color.parseColor("#ff3f7fff"): Color.parseColor("#ffff3366"));
            view_status.setBackgroundColor(cashSign == 1 ? Color.parseColor("#ff3f7fff"): Color.parseColor("#ffff3366"));
            saving_bonus_value.setText(result.getSA2().getCash_flow() + "");
            saving_user_num.setText(result.getSA2().getCustomer_nm() + "");

            saving_hqje_value2.setText(result.getSA1().getAlive_mn() + "");
            saving_hqje_value.setText(result.getSA2().getAlive_mn() + "");
            saving_jjje_value2.setText(result.getSA1().getS_pool_mn() + "");
            saving_jjje_value.setText(result.getSA1().getS_pool_mn() + "");
            saving_dsje_value2.setText(result.getSA1().getLost_mn() + "");
            saving_dsje_value.setText(result.getSA2().getLost_mn() + "");
            saving_jtcdcl_value2.setText(result.getSA1().getS_times_achv_rate() + "%");
            saving_jtcdcl_value.setText(result.getSA2().getS_times_achv_rate() + "%");
            saving_t1khs_value2.setText(result.getSA1().getS_T1_num() + "");
            saving_t1khs_value.setText(result.getSA2().getS_T1_num() + "");
            saving_jczdcl_value2.setText(result.getSA1().getS_mn_achv_rate() + "%");
            saving_jczdcl_value.setText(result.getSA2().getS_mn_achv_rate() + "%");
            saving_m1khs_value2.setText(result.getSA1().getS_M1_num() + "");
            saving_m1khs_value.setText(result.getSA2().getS_M1_num() + "");
            saving_jyycgl_value2.setText(result.getSA1().getS_appoint_rate() + "%");
            saving_jyycgl_value.setText(result.getSA2().getS_appoint_rate() + "%");
            saving_m2khs_value2.setText(result.getSA1().getS_M2_num() + "");
            saving_m2khs_value.setText(result.getSA2().getS_M2_num() + "");
            saving_jzsjcs_value2.setText(result.getSA1().getS_ontime_num() + "");
            saving_jzsjcs_value.setText(result.getSA2().getS_ontime_num() + "");
            saving_jzjcz_value2.setText(result.getSA1().getS_add_mn() + "");
            saving_jzjcz_value.setText(result.getSA2().getS_add_mn() + "");
            saving_jzsl_value2.setText(result.getSA1().getS_ontime_rate() + "%");
            saving_jzsl_value.setText(result.getSA2().getS_ontime_rate() + "%");
        }
        saving_hqje_xo.setStatus(setXoStatus(cashSign,result.getSA1().getAlive_mn_sign()));
        saving_jjje_xo.setStatus(setXoStatus(cashSign,result.getSA1().getS_pool_mn_sign()));
        saving_dsje_xo.setStatus(setXoStatus(cashSign,result.getSA1().getLost_mn_sign()));
        saving_jtcdcl_xo.setStatus(setXoStatus(cashSign,result.getSA1().getS_times_achv_rate_sign()));
        saving_t1khs_xo.setStatus(setXoStatus(cashSign,result.getSA1().getS_T1_num_sign()));
        saving_jczdcl_xo.setStatus(setXoStatus(cashSign,result.getSA1().getS_mn_achv_rate_sign()));
        saving_m1khs_xo.setStatus(setXoStatus(cashSign,result.getSA1().getS_M1_num_sign()));
        saving_jyycgl_xo.setStatus(setXoStatus(cashSign,result.getSA1().getS_appoint_rate_sign()));
        saving_m2khs_xo.setStatus(setXoStatus(cashSign,result.getSA1().getS_M2_num_sign()));
        saving_jzsjcs_xo.setStatus(setXoStatus(cashSign,result.getSA1().getS_ontime_num_sign()));
        saving_jzjcz_xo.setStatus(setXoStatus(cashSign,result.getSA1().getS_add_mn_sign()));
        saving_jzsl_xo.setStatus(setXoStatus(cashSign,result.getSA1().getS_ontime_rate_sign()));
    }

    public void setBottomNavigationBarHeight(int height) {
        this.bottomNavigationBarHeight = height;
        Log.e("TAGrela", bottomNavigationBarHeight + "");
    }

    @OnClick(R.id.saving_month)
    public void selectData() {
        final DatePicker picker = new DatePicker(getActivity());
        picker.setCanLoop(true);
        picker.setWheelModeEnable(true);
        picker.setTitleTextSize(16);
        picker.setSelectedTextColor(getResources().getColor(R.color.color2));//前四位值是透明度
        picker.setTopPadding(15);
        picker.setRangeStart(2018, 5, 26);
        picker.setRangeEnd(2118, 12, 31);
//        picker.setSelectedItem(bxyear, bxmonth, bxday);
        picker.setTitleText("");
        picker.setCancelText("取消");
        picker.setSubmitText("确定");
        picker.setWeightEnable(true);
        picker.setLineColor(Color.BLACK);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                //    UIUtils.showToast(year + "-" + month + "-" + day);
                isRefresh = 0;
                getAllData(year + "-" + month + "-" + day);
            }
        });
        picker.show();
    }

    private int setXoStatus(int cashSign, int status) {
        if (cashSign == 1) { //正  蓝圈 灰叉
            if (status == 1) {
                return 0;
            } else {
                return 3;
            }
        } else { //负  红叉 灰圈
            if (status == 1) {
                return 2;
            } else {
                return 1;
            }
        }
    }
}
