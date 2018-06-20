package com.wdl.amdroid_jwdl.fragment.business;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.wdl.amdroid_jwdl.util.TimeUtil;
import com.wdl.amdroid_jwdl.util.UIUtils;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.addapp.pickers.common.LineConfig;
import cn.addapp.pickers.util.ConvertUtils;
import cn.addapp.pickers.widget.WheelListView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author：lhm on 2018/3/24 20:04
 * <p>
 * email：3186834196@qq.com
 */
public class ContinueFragment extends BaseFragment {
    private String CarUserid;
    private int continueStatus;
    private CustomAdapter adapter;

    @BindView(R.id.continue_et)
    TextView continue_et;
    private String continue_notes;
    private String continue_reason;
    String days;
    String[] daysn;
    String months;
    int mother = 1;

    @BindView(R.id.cintinue_rc)
    public RecyclerView recyclerView;

    @BindView(R.id.tv_day)
    TextView tv_day;

    @BindView(R.id.tv_mouth)
    TextView tv_mouth;

    @BindView(R.id.tv_year)
    TextView tv_year;
    WheelListView wheelListViewd;
    WheelListView wheelListViewm;
    WheelListView wheelListViewy;
    int year = 2018;
    String years;

    @BindView(R.id.continue_sumit)
    Button continue_sumit;
    private UserInfo userInfo;

    private void initRecycler() {
        ArrayList<String> Arrayname = new ArrayList();
        Arrayname.add("里程未到");
        Arrayname.add("不是车主");
        Arrayname.add("自己安排");
        Arrayname.add("外地用车");
        Arrayname.add("号码未通");
        Arrayname.add("外面保养");
        Arrayname.add("号码失联");
        Arrayname.add("他点保养");
        Arrayname.add("不愿沟通");
        Arrayname.add("有事正忙");
        adapter = new CustomAdapter(getActivity(), Arrayname);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new CustomAdapter.OnRecyclerViewItemClickListener() {
            public void onItemClick(View View, String String, int Int) {
                continue_reason=String;
                UIUtils.showToast(String);
            }
        });
    }

    private void initWheelList() {
        wheelListViewy.setItems(new String[]{"2018", "2019", "2020"}, 1);
        wheelListViewy.setSelectedTextColor(getResources().getColor(R.color.black));
        LineConfig lineConfig = new LineConfig();
        lineConfig.setColor(Color.parseColor("#c62828"));
//        lineConfig.setAlpha(100);
        // lineConfig.setRatio(0.2F);
        lineConfig.setThick(ConvertUtils.toPx(getActivity(), 3.0F));
        lineConfig.setShadowVisible(false);
        wheelListViewy.setLineConfig(lineConfig);
        wheelListViewy.setOnWheelChangeListener(new WheelListView.OnWheelChangeListener() {
            @Override
            public void onItemSelected(int i, String String) {
            //    tv_year.setText(String + "年");
                year = Integer.parseInt(String);
                daysn = TimeUtil.setDays(year, mother);
                wheelListViewd.setItems(daysn, 15);
                years = String;
            }
            });

        wheelListViewm.setItems(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}, 1);
        wheelListViewm.setSelectedTextColor(getResources().getColor(R.color.black));
        lineConfig = new LineConfig();
        lineConfig.setColor(Color.parseColor("#c62828"));
//        lineConfig.setAlpha(100);
        //lineConfig.setRatio(0.2F);
        lineConfig.setThick(ConvertUtils.toPx(getActivity(), 3.0F));
        lineConfig.setShadowVisible(false);
        wheelListViewm.setLineConfig(lineConfig);
        wheelListViewm.setOnWheelChangeListener(new WheelListView.OnWheelChangeListener() {
            @Override
            public void onItemSelected(int i, String String) {
              //  tv_mouth.setText(String + "月");
                mother = Integer.parseInt(String);
                daysn = TimeUtil.setDays(year, mother);
                wheelListViewd.setItems(daysn, 15);
                months = String;
            }
        });


        wheelListViewd.setItems(new String[]{"1"}, 0);
        wheelListViewd.setSelectedTextColor(getResources().getColor(R.color.black));
        lineConfig = new LineConfig();
        lineConfig.setColor(Color.parseColor("#c62828"));
//        lineConfig.setAlpha(100);
        // lineConfig.setRatio(0.2F);
        lineConfig.setThick(ConvertUtils.toPx(getActivity(), 3.0F));
        lineConfig.setShadowVisible(false);
        wheelListViewd.setLineConfig(lineConfig);
        wheelListViewd.setOnWheelChangeListener(new WheelListView.OnWheelChangeListener() {
            @Override
            public void onItemSelected(int i, String String) {
            //    tv_day.setText(String + "日");
                days = String;
            }
        });
    }

    public void initData() {
        if (continueStatus==1){
            continue_sumit.setEnabled(false);
            continue_sumit.setBackgroundResource(R.drawable.button_bg_mianhui_c5);
        }
    }

    protected void initView() {
        getActivity().getWindow().setSoftInputMode(32);
        initWheelList();
        initRecycler();
        userInfo = (UserInfo) PreferencesUtil.getInstance(getActivity()).getObject("UserInfo");
    }

    @OnClick({R.id.continue_sumit,R.id.continue_et})
    public void oncklickSubmit(View view) {
       switch (view.getId()){
           case R.id.continue_sumit:
               showLoadingDialog();
               HashMap<String, String> localHashMap = new HashMap();
               localHashMap.put("said",userInfo.getSAname());
               localHashMap.put("continue_action", "1");
               localHashMap.put("continue_user", CarUserid);
               localHashMap.put("continue_time", years + "-" + months + "-" + days);
               localHashMap.put("continue_reason", continue_reason);
               localHashMap.put("continue_notes", continue_et.getText().toString());
               App.getRetrofit(API.BASE_URL)
                       .create(UserService.class)
                       .getSubmit_Content(localHashMap)
                       .subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(new Observer<BaseBean>() {
                           public void onComplete() {
                               dismissLoadingDialog();
                           }

                           public void onError(Throwable Throwable) {
                               UIUtils.showToast("系统繁忙");
                               dismissLoadingDialog();
                           }

                           public void onNext(BaseBean BaseBean) {
                               if (BaseBean.getError_code() == 200){
                                   AppManagerUtil.instance().finishActivity();
                                   dismissLoadingDialog();
                               }
                               UIUtils.showToast(BaseBean.getReason());
                           }

                           public void onSubscribe(Disposable Disposable) {
                           }
                       });
               break;
           case R.id.continue_et:
               boolean wrapInScrollView = true;
               new MaterialDialog.Builder(getActivity())
                       .title("备注")
                       .customView(R.layout.continue_text_view, wrapInScrollView)
                       .positiveText("确定")
                       .onPositive(new MaterialDialog.SingleButtonCallback() {
                           @Override
                           public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                             EditText editText = (EditText) dialog.getView().findViewById(R.id.text_content);
                             continue_et.setText( editText.getText());
                               continue_et.setTextColor(Color.BLACK);
                           }
                       })
                       .show();
               break;
       }
    }

    public void setCarUseridandSubmitStatus(String String,int status) {
        this.continueStatus=status;
        this.CarUserid = String;
    }

    protected View setRootView(LayoutInflater LayoutInflater, ViewGroup ViewGroup) {
        View view = LayoutInflater.inflate(R.layout.cintinue_fg, ViewGroup, false);
        wheelListViewy = ((WheelListView) view.findViewById(R.id.wheelview_single1));
        wheelListViewm = ((WheelListView) view.findViewById(R.id.wheelview_single2));
        wheelListViewd = ((WheelListView) view.findViewById(R.id.wheelview_single3));
        return view;
    }
}
