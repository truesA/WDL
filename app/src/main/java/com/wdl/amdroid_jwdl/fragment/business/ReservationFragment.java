package com.wdl.amdroid_jwdl.fragment.business;

/**
 * author：lhm on 2018/3/24 21:22
 * <p>
 * email：3186834196@qq.com
 */

import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseFragment;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.UserService;
import com.wdl.amdroid_jwdl.model.BaseBean;
import com.wdl.amdroid_jwdl.util.AppManagerUtil;
import com.wdl.amdroid_jwdl.util.TimeUtil;
import com.wdl.amdroid_jwdl.util.UIUtils;

import butterknife.BindView;
import butterknife.OnClick;
import cn.addapp.pickers.common.LineConfig;
import cn.addapp.pickers.util.ConvertUtils;
import cn.addapp.pickers.widget.WheelListView;
import cn.addapp.pickers.widget.WheelListView.OnWheelChangeListener;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

public class ReservationFragment extends BaseFragment {
    private String CarUserid;
    private int reservationStatus;
    private String days;
    String[] daysn;
    private String months;
    int mother = 1;

    @BindView(R.id.tv_day)
    TextView tv_day;

    @BindView(R.id.tv_mouth)
    TextView tv_mouth;

    @BindView(R.id.tv_year)
    TextView tv_year;

    @BindView(R.id.submit_reservation)
    Button submit_reservation;
    WheelListView wheelListViewd;
    WheelListView wheelListViewm;
    WheelListView wheelListViewy;
    int year = 2018;
    private String years;

    private void initWheelList() {
        wheelListViewy.setItems(new String[]{"2018", "2019", "2020"}, 1);
        wheelListViewy.setSelectedTextColor(getResources().getColor(R.color.black));
        LineConfig localLineConfig = new LineConfig();
        localLineConfig.setColor(Color.parseColor("#c62828"));
        localLineConfig.setAlpha(100);
        // localLineConfig.setRatio(0.2F);
        localLineConfig.setThick(ConvertUtils.toPx(getActivity(), 3.0F));
        localLineConfig.setShadowVisible(false);
        wheelListViewy.setLineConfig(localLineConfig);
        wheelListViewy.setOnWheelChangeListener(new OnWheelChangeListener() {
            @Override
            public void onItemSelected(int i, String paramString) {
          //      tv_year.setText(paramString + "年");
                year = Integer.parseInt(paramString);
                daysn = TimeUtil.setDays(year, mother);
                wheelListViewd.setItems(daysn, 15);
                years = paramString;
            }
        });
        wheelListViewm.setItems(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}, 1);
        wheelListViewm.setSelectedTextColor(getResources().getColor(R.color.black));
        localLineConfig = new LineConfig();
        localLineConfig.setColor(Color.parseColor("#c62828"));
        localLineConfig.setAlpha(100);
        // localLineConfig.setRatio(0.2F);
        localLineConfig.setThick(ConvertUtils.toPx(getActivity(), 3.0F));
        localLineConfig.setShadowVisible(false);
        wheelListViewm.setLineConfig(localLineConfig);
        wheelListViewm.setOnWheelChangeListener(new OnWheelChangeListener() {
            @Override
            public void onItemSelected(int i, String paramString) {
             //   tv_mouth.setText(paramString + "月");
                mother = Integer.parseInt(paramString);
                daysn = TimeUtil.setDays(year, mother);
                wheelListViewd.setItems(daysn, 15);
                months = paramString;
            }
        });
        wheelListViewd.setItems(new String[]{"1"}, 0);
        wheelListViewd.setSelectedTextColor(getResources().getColor(R.color.black));
        localLineConfig = new LineConfig();
        localLineConfig.setColor(Color.parseColor("#c62828"));
        localLineConfig.setAlpha(100);
        // localLineConfig.setRatio(0.2F);
        localLineConfig.setThick(ConvertUtils.toPx(getActivity(), 3.0F));
        localLineConfig.setShadowVisible(false);
        wheelListViewd.setLineConfig(localLineConfig);
        wheelListViewd.setOnWheelChangeListener(new OnWheelChangeListener() {
            @Override
            public void onItemSelected(int i, String paramString) {
           //     tv_day.setText(paramString + "日");
                days = paramString;
            }
        });
    }

    public void initData() {
        if (reservationStatus==1){//已提交
            submit_reservation.setEnabled(false);
            submit_reservation.setBackgroundResource(R.drawable.button_bg_mianhui_c5);
        }
    }

    protected void initView() {
        initWheelList();
    }

    @OnClick({R.id.submit_reservation})
    public void oncklickSubmitReser() {
        showLoadingDialog();
        HashMap<String, String> params = new HashMap();
        params.put("appoint_action", "1");
        params.put("appoint_user", CarUserid);
        params.put("appoint_time", years + "-" + months + "-" + days);
        App.getRetrofit(API.BASE_URL)
                .create(UserService.class)
                .getSubmit_Content(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    public void onComplete() {
                        dismissLoadingDialog();
                    }

                    public void onError(Throwable paramThrowable) {
                        paramThrowable.printStackTrace();
                        UIUtils.showToast("系统繁忙");
                        dismissLoadingDialog();
                    }

                    public void onNext(BaseBean paramBaseBean) {
                        if (paramBaseBean.getError_code() == 200){
                            AppManagerUtil.instance().finishActivity();
                        }
                        UIUtils.showToast(paramBaseBean.getReason());
                    }

                    public void onSubscribe(Disposable paramDisposable) {
                    }
                });
    }

    public void setCarUseridandSubmitStatus(String paramString,int status) {
        this.reservationStatus=status;
        this.CarUserid = paramString;
    }

    protected View setRootView(LayoutInflater layoutInflater, ViewGroup paramViewGroup) {
        View view = layoutInflater.inflate(R.layout.reservation_fg, paramViewGroup, false);
        wheelListViewy = ((WheelListView) view.findViewById(R.id.wheelview_single1));
        wheelListViewm = ((WheelListView) view.findViewById(R.id.wheelview_single2));
        wheelListViewd = ((WheelListView) view.findViewById(R.id.wheelview_single3));
        return view;
    }
}