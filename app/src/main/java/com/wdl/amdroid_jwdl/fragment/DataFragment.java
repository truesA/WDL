package com.wdl.amdroid_jwdl.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseFragment;
import com.wdl.amdroid_jwdl.commom.RecycleViewDivider;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.DataService;
import com.wdl.amdroid_jwdl.model.LoginUesr;
import com.wdl.amdroid_jwdl.model.MainDataBean;
import com.wdl.amdroid_jwdl.model.UserInfo;
import com.wdl.amdroid_jwdl.util.PreferencesUtil;
import com.wdl.amdroid_jwdl.util.UIUtils;
import com.wdl.amdroid_jwdl.view.MyMarkerView;
import com.wdl.amdroid_jwdl.view.TimeMDdialog;

import android.content.res.Resources;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

import cn.addapp.pickers.common.LineConfig;
import cn.addapp.pickers.listeners.OnMoreItemPickListener;
import cn.addapp.pickers.picker.CarNumberPicker;
import cn.addapp.pickers.util.ConvertUtils;
import cn.addapp.pickers.widget.WheelListView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import retrofit2.Retrofit;

/**
 * Created by Achers on 2017/11/22.
 */

public class DataFragment extends BaseFragment implements OnCheckedChangeListener, OnChartGestureListener, OnChartValueSelectedListener {

    @BindView(R.id.chanZ_mubv)
    public TextView chanZ_mubv;

    @BindView(R.id.chanZ_sunday)
    public TextView chanZ_sunday;

    @BindView(R.id.chanZ_today)
    public TextView chanZ_today;
    int checkedIds = 0;
    private boolean isAnim = false;

    @BindView(R.id.ll_chanZ)
    public LinearLayout llChanZ;

    @BindView(R.id.ll_taiC)
    public LinearLayout llTaiC;

    @BindView(R.id.data_line_chart)
    public LineChart mLineChar;

    @BindView(R.id.rb_top_c)
    public RadioButton radioButtonC;

    @BindView(R.id.rb_top_t)
    public RadioButton radioButtonT;

    @BindView(R.id.rb_top_k)
    public RadioButton radioButtonK;

    @BindView(R.id.rg_top)
    public RadioGroup radioGroup;


//    @BindView(R.id.taiC_m1)
//    public TextView taiC_m1;
//
//    @BindView(R.id.taiC_m2)
//    public TextView taiC_m2;

    @BindView(R.id.taiC_mubv)
    public TextView taiC_mubv;

    @BindView(R.id.taiC_sunday)
    public TextView taiC_sunday;

    @BindView(R.id.taiC_today)
    public TextView taiC_today;

    @BindView(R.id.taiC_yuv)
    public TextView taiC_yuv;

    @BindView(R.id.time_selsect)
    public TextView time_selsect;

    @BindView(R.id.data_CT_zongji_mine)
    public TextView data_CT_zongji_mine;
    @BindView(R.id.data_CT_zongji_other)
    public TextView data_CT_zongji_other;
    @BindView(R.id.data_CT_zongji_p_left)
    MaterialProgressBar data_CT_zongji_p_left;
    @BindView(R.id.data_CT_zongji_p_right)
    MaterialProgressBar data_CT_zongji_p_right;

    @BindView(R.id.data_CT_baoyang_mine)
    public TextView data_CT_baoyang_mine;
    @BindView(R.id.data_CT_baoyang_other)
    public TextView data_CT_baoyang_other;
    @BindView(R.id.data_CT_baoyang_p_left)
    MaterialProgressBar data_CT_baoyang_p_left;
    @BindView(R.id.data_CT_baoyang_p_right)
    MaterialProgressBar data_CT_baoyang_p_right;

    @BindView(R.id.data_CT_weixiu_mine)
    public TextView data_CT_weixiu_mine;
    @BindView(R.id.data_CT_weixiu_other)
    public TextView data_CT_weixiu_other;
    @BindView(R.id.data_CT_weixiu_p_left)
    MaterialProgressBar data_CT_weixiu_p_left;
    @BindView(R.id.data_CT_weixiu_p_right)
    MaterialProgressBar data_CT_weixiu_p_right;

    @BindView(R.id.data_CT_jingping_mine)
    public TextView data_CT_jingping_mine;
    @BindView(R.id.data_CT_jingping_other)
    public TextView data_CT_jingping_other;
    @BindView(R.id.data_CT_jingping_p_left)
    MaterialProgressBar data_CT_jingping_p_left;
    @BindView(R.id.data_CT_jingping_p_right)
    MaterialProgressBar data_CT_jingping_p_right;

    @BindView(R.id.data_CT_yuyue_mine)
    public TextView data_CT_yuyue_mine;
    @BindView(R.id.data_CT_yuyue_other)
    public TextView data_CT_yuyue_other;
    @BindView(R.id.data_CT_yuyue_p_left)
    MaterialProgressBar data_CT_yuyue_p_left;
    @BindView(R.id.data_CT_yuyue_p_right)
    MaterialProgressBar data_CT_yuyue_p_right;

    @BindView(R.id.data_CT_t1_mine)
    public TextView data_CT_t1_mine;
    @BindView(R.id.data_CT_t1_other)
    public TextView data_CT_t1_other;
    @BindView(R.id.data_CT_t1_p_left)
    MaterialProgressBar data_CT_t1_p_left;
    @BindView(R.id.data_CT_t1_p_right)
    MaterialProgressBar data_CT_t1_p_right;

    @BindView(R.id.data_CT_m1_mine)
    public TextView data_CT_m1_mine;
    @BindView(R.id.data_CT_m1_other)
    public TextView data_CT_m1_other;
    @BindView(R.id.data_CT_m1_p_letf)
    MaterialProgressBar data_CT_m1_p_letf;
    @BindView(R.id.data_CT_m1_p_right)
    MaterialProgressBar data_CT_m1_p_right;

    @BindView(R.id.data_CT_m2_mine)
    public TextView data_CT_m2_mine;
    @BindView(R.id.data_CT_m2_other)
    public TextView data_CT_m2_other;
    @BindView(R.id.data_CT_m2_p_left)
    MaterialProgressBar data_CT_m2_p_left;
    @BindView(R.id.data_CT_m2_p_right)
    MaterialProgressBar data_CT_m2_p_right;

    @BindView(R.id.data_CT_zhunshi_mine)
    public TextView data_CT_zhunshi_mine;
    @BindView(R.id.data_CT_zhunshi_other)
    public TextView data_CT_zhunshi_other;
    @BindView(R.id.data_CT_zhunshi_p_left)
    MaterialProgressBar data_CT_zhunshi_p_left;
    @BindView(R.id.data_CT_zhunshi_p_right)
    MaterialProgressBar data_CT_zhunshi_p_right;

    @BindView(R.id.data_CT_zhuijia_mine)
    public TextView data_CT_zhuijia_mine;
    @BindView(R.id.data_CT_zhuijia_other)
    public TextView data_CT_zhuijia_other;
    @BindView(R.id.data_CT_zhuijia_p_left)
    MaterialProgressBar data_CT_zhuijia_p_left;
    @BindView(R.id.data_CT_zhuijia_p_right)
    MaterialProgressBar data_CT_zhuijia_p_right;


    @BindView(R.id.data_CT_m1mb_mine)
    TextView data_CT_m1mb_mine;
    @BindView(R.id.data_CT_m1mb_other)
    TextView data_CT_m1mb_other;
    @BindView(R.id.data_CT_m1mb_p_left)
    MaterialProgressBar data_CT_m1mb_p_left;
    @BindView(R.id.data_CT_m1mb_p_right)
    MaterialProgressBar data_CT_m1mb_p_right;

    @BindView(R.id.data_CT_m2mb_mine)
    TextView data_CT_m2mb_mine;
    @BindView(R.id.data_CT_m2mb_other)
    TextView data_CT_m2mb_other;
    @BindView(R.id.data_CT_m2mb_p_left)
    MaterialProgressBar data_CT_m2mb_p_left;
    @BindView(R.id.data_CT_m2mb_p_right)
    MaterialProgressBar data_CT_m2mb_p_right;

    @BindView(R.id.data_CT_m1mbs_mine)
    TextView data_CT_m1mbs_mine;
    @BindView(R.id.data_CT_m1mbs_other)
    TextView data_CT_m1mbs_other;
    @BindView(R.id.data_CT_m1mbs_p_left)
    MaterialProgressBar data_CT_m1mbs_p_left;
    @BindView(R.id.data_CT_m1mbs_p_right)
    MaterialProgressBar data_CT_m1mbs_p_right;

    @BindView(R.id.data_CT_m2mbs_mine)
    TextView data_CT_m2mbs_mine;
    @BindView(R.id.data_CT_m2mbs_other)
    TextView data_CT_m2mbs_other;
    @BindView(R.id.data_CT_m2mbs_p_left)
    MaterialProgressBar data_CT_m2mbs_p_left;
    @BindView(R.id.data_CT_m2mbs_p_right)
    MaterialProgressBar data_CT_m2mbs_p_right;


    @BindView(R.id.data_fg_pg_3)
    LinearLayout data_fg_pg_3;
    @BindView(R.id.ll_zhiBi)
    LinearLayout ll_zhiBi;  //指标
    @BindView(R.id.zhiBi_yupm)
    TextView zhiBi_yupm;  //当月预约排名
    @BindView(R.id.zhiBi_rkpm)
    TextView zhiBi_rkpm; //当月入库排名

    @BindView(R.id.data_CT_dyrk_mine)
    TextView data_CT_dyrk_mine;
    @BindView(R.id.data_CT_dyrk_other)
    TextView data_CT_dyrk_other;
    @BindView(R.id.data_CT_dyrk_p_left)
    MaterialProgressBar data_CT_dyrk_p_left;
    @BindView(R.id.data_CT_dyrk_p_right)
    MaterialProgressBar data_CT_dyrk_p_right;

    @BindView(R.id.data_CT_yyrk_mine)
    TextView data_CT_yyrk_mine;
    @BindView(R.id.data_CT_yyrk_other)
    TextView data_CT_yyrk_other;
    @BindView(R.id.data_CT_yyrk_p_left)
    MaterialProgressBar data_CT_yyrk_p_left;
    @BindView(R.id.data_CT_yyrk_p_right)
    MaterialProgressBar data_CT_yyrk_p_right;

    @BindView(R.id.data_CT_yycgl_mine)
    TextView data_CT_yycgl_mine;
    @BindView(R.id.data_CT_yycgl_other)
    TextView data_CT_yycgl_other;
    @BindView(R.id.data_CT_yycgl_p_left)
    MaterialProgressBar data_CT_yycgl_p_left;
    @BindView(R.id.data_CT_yycgl_p_right)
    MaterialProgressBar data_CT_yycgl_p_right;

    @BindView(R.id.data_CT_rkcgl_mine)
    TextView data_CT_rkcgl_mine;
    @BindView(R.id.data_CT_rkcgl_other)
    TextView data_CT_rkcgl_other;
    @BindView(R.id.data_CT_rkcgl_p_left)
    MaterialProgressBar data_CT_rkcgl_p_left;
    @BindView(R.id.data_CT_rkcgl_p_right)
    MaterialProgressBar data_CT_rkcgl_p_right;

    @BindView(R.id.data_CT_dysc_mine)
    TextView data_CT_dysc_mine;
    @BindView(R.id.data_CT_dysc_other)
    TextView data_CT_dysc_other;
    @BindView(R.id.data_CT_dysc_p_left)
    MaterialProgressBar data_CT_dysc_p_left;
    @BindView(R.id.data_CT_dysc_p_right)
    MaterialProgressBar data_CT_dysc_p_right;

    @BindView(R.id.data_CT_dyjx_mine)
    TextView data_CT_dyjx_mine;
    @BindView(R.id.data_CT_dyjx_other)
    TextView data_CT_dyjx_other;
    @BindView(R.id.data_CT_dyjx_p_left)
    MaterialProgressBar data_CT_dyjx_p_left;
    @BindView(R.id.data_CT_dyjx_p_right)
    MaterialProgressBar data_CT_dyjx_p_right;

    @BindView(R.id.data_CT_dyfq_mine)
    TextView data_CT_dyfq_mine;
    @BindView(R.id.data_CT_dyfq_other)
    TextView data_CT_dyfq_other;
    @BindView(R.id.data_CT_dyfq_p_letf)
    MaterialProgressBar data_CT_dyfq_p_letf;
    @BindView(R.id.data_CT_dyfq_p_right)
    MaterialProgressBar data_CT_dyfq_p_right;

    @BindView(R.id.data_CT_dyls_mine)
    TextView data_CT_dyls_mine;
    @BindView(R.id.data_CT_dyls_other)
    TextView data_CT_dyls_other;
    @BindView(R.id.data_CT_dyls_p_left)
    MaterialProgressBar data_CT_dyls_p_left;
    @BindView(R.id.data_CT_dyls_p_right)
    MaterialProgressBar data_CT_dyls_p_right;

    @BindView(R.id.data_CT_scwcl_mine)
    TextView data_CT_scwcl_mine;
    @BindView(R.id.data_CT_scwcl_other)
    TextView data_CT_scwcl_other;
    @BindView(R.id.data_CT_scwcl_p_left)
    MaterialProgressBar data_CT_scwcl_p_left;
    @BindView(R.id.data_CT_scwcl_p_right)
    MaterialProgressBar data_CT_scwcl_p_right;

    @BindView(R.id.data_fg_pg_2)
    LinearLayout data_fg_pg_2;
    @BindView(R.id.data_fg_pg_4)
    LinearLayout data_fg_pg_4;
    @BindView(R.id.data_CT_zhunshi_ll)
    LinearLayout data_CT_zhunshi_ll;
    @BindView(R.id.data_CT_zj_zs_ll)
    LinearLayout data_CT_zj_zs_ll;

    private MainDataBean resultBean;
    private LineDataSet set1;
    private LineDataSet set2;
    private int defulter = 1;

    @BindView(R.id.data_refreshLayout)
    SmartRefreshLayout refreshLayouts;

    @BindView(R.id.data_combind_chart)
    CombinedChart combinedChart;
    private XAxis xAxis;

    private int isRefresh = 0;
    private int noyear = 1;
    private int nomonth = 1;
    private int indexyear = 1;
    private int indexmonth = 1;
    private int indexSa = 0;
    private String[] saArray;
    private UserInfo userInfo;
    private String SaName;

    @Override
    protected void initView() {
        refreshLayouts.setRefreshHeader(new MaterialHeader(getActivity()));
        refreshLayouts.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh(RefreshLayout RefreshLayout) {
                isRefresh = 1;
                getAllData(changeIndexYear(indexyear), indexmonth);
            }
        });
        refreshLayouts.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(false);//传入false表示加载失败
            }
        });
        radioGroup.setOnCheckedChangeListener(this);

        initCombindChart();
    }


    @Override
    protected View setRootView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.data_fg, container, false);
        return view;
    }

    @Override
    public void initData() {
        // setCombindData();
        // getAllData(changeIndexYear(indexyear),indexmonth);
        userInfo = (UserInfo) PreferencesUtil.getInstance(getActivity()).getObject("UserInfo");
        SaName=userInfo.getSAname();
        getAllData(1900, 01);

    }

    private void initCombindChart() {
        combinedChart.getDescription().setEnabled(false);

        combinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR,
                CombinedChart.DrawOrder.LINE
        });

//        combinedChart.setBackgroundColor();
        combinedChart.setDrawGridBackground(false);
        combinedChart.setDrawBarShadow(false);
        combinedChart.setHighlightFullBarEnabled(false);
        combinedChart.setOnChartGestureListener(this);
        combinedChart.setOnChartValueSelectedListener(this);
        combinedChart.setDrawGridBackground(false);
        combinedChart.getDescription().setEnabled(false);
        combinedChart.setTouchEnabled(true);
        combinedChart.setDragEnabled(true);
        combinedChart.setScaleEnabled(true);
        combinedChart.setPinchZoom(true);
        combinedChart.getAxisLeft().setDrawGridLines(false);
        combinedChart.getXAxis().setDrawGridLines(false);
        combinedChart.setNoDataText("没有数据");
        combinedChart.setNoDataTextColor(-1);
        //显示边界
        combinedChart.setDrawBorders(false);
        //图例说明
        Legend legend = combinedChart.getLegend();
        legend.setWordWrapEnabled(true);

        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);

        MyMarkerView markerView = new MyMarkerView(getActivity(), R.layout.custom_marker_view);
        markerView.setChartView(combinedChart);
        combinedChart.setMarker(markerView);
        xAxis = combinedChart.getXAxis();
        xAxis.setAxisMaximum(31.0F);
        xAxis.setAxisMinimum(1.0F);
        xAxis.setDrawAxisLine(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAvoidFirstLastClipping(false);


        LimitLine limitLine1 = new LimitLine(0F, " ");
        limitLine1.setLineWidth(1F);
        limitLine1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        limitLine1.setTextSize(10F);
        limitLine1.setLineColor(R.color.new_color02);
        YAxis localYAxis = combinedChart.getAxisLeft();
        localYAxis.removeAllLimitLines();
        localYAxis.addLimitLine(limitLine1);
        localYAxis.setAxisMaximum(150F);
        localYAxis.setAxisMinimum(-150F);
        localYAxis.setDrawZeroLine(false);
        localYAxis.setDrawLimitLinesBehindData(true);
        combinedChart.getAxisRight().setEnabled(false);
        combinedChart.getLegend().setEnabled(false); //去掉图例缩样

    }

    /**
     * 设置曲线图
     *
     * @param
     * @param line1
     * @param line2
     */
    private void setCombindData(List<Integer> barChartYsup, List<Integer> barChartYsdown, List<Double> line1, List<Double> line2) {
        CombinedData combinedData = new CombinedData();

        List<List<Double>> yLineDatat = new ArrayList<>();
        yLineDatat.add(line2);
        yLineDatat.add(line1);

        List<List<Integer>> barChartYs = new ArrayList<>();
        barChartYs.add(barChartYsup);
        barChartYs.add(barChartYsdown);

        List<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#c62828"));
        colors.add(Color.parseColor("#737373"));

        List<Integer> colorsb = new ArrayList<>();
        colorsb.add(Color.parseColor("#8f8f8f"));
        colorsb.add(Color.parseColor("#8f8f8f"));

        combinedData.setData(getBarDatas(barChartYs, colorsb));
        combinedData.setData(getLineData(yLineDatat, colors));

        combinedChart.setData(combinedData);
        combinedChart.animateX(2000); // 立即执行的动画,x轴
        combinedChart.invalidate();
    }

    private void getAllData(final int defulteryear, final int defultermonth) {
        if (isRefresh == 0) {
            showLoadingDialog();
        }
        Map<String, String> params = new HashMap<>();
        params.put("sa_year", defulteryear + "");
        params.put("sa_month", defultermonth + "");
        params.put("said", userInfo.getSaid());
        params.put("SAname", SaName);
        App.getRetrofit(API.BASE_URL)
                .create(DataService.class)
                .getMainData(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onNext(MainDataBean mainDataBean) {
                        refreshLayouts.finishRefresh();
                        if (isRefresh == 0) {
                            dismissLoadingDialog();
                        }
                        Log.e("mainDataBean", mainDataBean.getError_code() + "");
                        if (mainDataBean.getError_code() == 200) {

                            setReusltData(mainDataBean);
                        } else {
                            UIUtils.showToast(mainDataBean.getReason());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        dismissLoadingDialog();
                        UIUtils.showToast("出错啦！");
                        refreshLayouts.finishRefresh();
                    }

                    @Override
                    public void onComplete() {
                        refreshLayouts.finishRefresh();
                    }
                });

    }

//    private ArrayList<Entry> dealLine(List<Double> paramList) {
//        ArrayList localArrayList = new ArrayList();
//        int i = 0;
//        while (i < paramList.size()) {
//            localArrayList.add(new Entry(i + 1, new Double(((Double) paramList.get(i)).doubleValue()).intValue()));
//            i += 1;
//        }
//        return localArrayList;
//    }

    @RequiresApi(api = 24)
    private void setReusltData(MainDataBean resultBeans) {
        resultBean = resultBeans;
        MainDataBean.ResultBean result = resultBeans.getResult();
        // List转成数组
        saArray = result.getSAname().toArray(new String[0]);
        indexmonth = result.getSa_month();
        if (result.getSa_year() == 2018) {
            indexyear = 1;
        } else if (result.getSa_year() == 2019) {
            indexyear = 2;
        } else if (result.getSa_year() == 2017) {
            indexyear = 0;
        }
        time_selsect.setText(result.getSa_year() + "-" + indexmonth);
        dealProgess(resultBean, checkedIds);
        dealmeduler(resultBean, checkedIds);
        if (checkedIds == 0) {
            setCombindData(result.getBackgroundup(), result.getBackgrounddown(), result.getMn_rate_me(), result.getMn_rate_other());
        } else if (checkedIds == 1) {
            setCombindData(result.getBackgroundup(), result.getBackgrounddown(), result.getTimes_rate_me(), result.getTimes_rate_other());
        } else {
            setCombindData(result.getBackgroundup(), result.getBackgrounddown(), result.getKPI_enter_times_me(), result.getKPI_enter_times_other());
        }
        combinedChart.animateX(2500);
        combinedChart.invalidate();
    }

    @SuppressLint("SetTextI18n")
    private void dealProgess(MainDataBean resultBean, int checkedIds) {
        MainDataBean.ResultBean resultBeans = resultBean.getResult();

        if (checkedIds == 0) {
            MainDataBean.ResultBean.MnBean mn = resultBeans.getMn();
            data_CT_zongji_mine.setText(mn.getGoal_mn_now_me() + "");
            data_CT_zongji_other.setText(mn.getGoal_mn_now_other() + "");
            data_CT_zongji_p_left.setProgress(100 - dealProgressValues(mn.getGoal_mn_now_max(), mn.getGoal_mn_now_me()));
            data_CT_zongji_p_right.setProgress(dealProgressValues(mn.getGoal_mn_now_max(), mn.getGoal_mn_now_other()));

            data_CT_baoyang_mine.setText(mn.getMaint_mn_now_me() + "");
            data_CT_baoyang_other.setText(mn.getMaint_mn_now_other() + "");
            data_CT_baoyang_p_left.setProgress(100 - dealProgressValues(mn.getMaint_mn_now_max(), mn.getMaint_mn_now_me()));
            data_CT_baoyang_p_right.setProgress(dealProgressValues(mn.getMaint_mn_now_max(), mn.getMaint_mn_now_other()));

            data_CT_weixiu_mine.setText(mn.getRepair_mn_now_me() + "");
            data_CT_weixiu_other.setText(mn.getRepair_mn_now_other() + "");
            data_CT_weixiu_p_left.setProgress(100 - dealProgressValues(mn.getRepair_mn_now_max(), mn.getRepair_mn_now_me()));
            data_CT_weixiu_p_right.setProgress(dealProgressValues(mn.getRepair_mn_now_max(), mn.getRepair_mn_now_other()));

            data_CT_jingping_mine.setText(mn.getExcelt_mn_now_me() + "");
            data_CT_jingping_other.setText(mn.getExcelt_mn_now_other() + "");
            data_CT_jingping_p_left.setProgress(100 - dealProgressValues(mn.getExcelt_mn_now_max(), mn.getExcelt_mn_now_me()));
            data_CT_jingping_p_right.setProgress(dealProgressValues(mn.getExcelt_mn_now_max(), mn.getExcelt_mn_now_other()));

            data_CT_yuyue_mine.setText(mn.getAppoint_mn_now_me() + "");
            data_CT_yuyue_other.setText(mn.getAppoint_mn_now_other() + "");
            data_CT_yuyue_p_left.setProgress(100 - dealProgressValues(mn.getAppoint_mn_now_max(), mn.getAppoint_mn_now_me()));
            data_CT_yuyue_p_right.setProgress(dealProgressValues(mn.getAppoint_mn_now_max(), mn.getAppoint_mn_now_other()));

            data_CT_t1_mine.setText(mn.getT1_mn_now_me() + "");
            data_CT_t1_other.setText(mn.getT1_mn_now_other() + "");
            data_CT_t1_p_left.setProgress(100 - dealProgressValues(mn.getT1_mn_now_max(), mn.getT1_mn_now_me()));
            data_CT_t1_p_right.setProgress(dealProgressValues(mn.getT1_mn_now_max(), mn.getT1_mn_now_other()));

            data_CT_m1_mine.setText(mn.getM1_mn_now_me() + "");
            data_CT_m1_other.setText(mn.getM1_mn_now_other() + "");
            data_CT_m1_p_letf.setProgress(100 - dealProgressValues(mn.getM1_mn_now_max(), mn.getM1_mn_now_me()));
            data_CT_m1_p_right.setProgress(dealProgressValues(mn.getM1_mn_now_max(), mn.getM1_mn_now_other()));

            data_CT_m2_mine.setText(mn.getM2_mn_now_me() + "");
            data_CT_m2_other.setText(mn.getM2_mn_now_other() + "");
            data_CT_m2_p_left.setProgress(100 - dealProgressValues(mn.getM2_mn_now_max(), mn.getM2_mn_now_me()));
            data_CT_m2_p_right.setProgress(dealProgressValues(mn.getM2_mn_now_max(), mn.getM2_mn_now_other()));

            data_CT_zhuijia_mine.setText(mn.getAdd_mn_now_me() + "");
            data_CT_zhuijia_other.setText(mn.getAdd_mn_now_other() + "");
            data_CT_zhuijia_p_left.setProgress(100 - dealProgressValues(mn.getAdd_mn_now_max(), mn.getAdd_mn_now_me()));
            data_CT_zhuijia_p_right.setProgress(dealProgressValues(mn.getAdd_mn_now_max(), mn.getAdd_mn_now_other()));


        } else if (checkedIds == 1) {  //台次
            MainDataBean.ResultBean.TimesBean times = resultBeans.getTimes();
            data_CT_zongji_mine.setText(times.getGoal_times_me() + "");
            data_CT_zongji_other.setText(times.getGoal_times_other() + "");
            data_CT_zongji_p_left.setProgress(100 - dealProgressValues(times.getGoal_times_max(), times.getGoal_times_me()));
            data_CT_zongji_p_right.setProgress(dealProgressValues(times.getGoal_times_max(), times.getGoal_times_other()));

            data_CT_baoyang_mine.setText(times.getMaint_times_me() + "");
            data_CT_baoyang_other.setText(times.getMaint_times_other() + "");
            data_CT_baoyang_p_left.setProgress(100 - dealProgressValues(times.getMaint_times_max(), times.getMaint_times_me()));
            data_CT_baoyang_p_right.setProgress(dealProgressValues(times.getMaint_times_max(), times.getMaint_times_other()));

            data_CT_weixiu_mine.setText(times.getRepair_times_me() + "");
            data_CT_weixiu_other.setText(times.getRepair_times_other() + "");
            data_CT_weixiu_p_left.setProgress(100 - dealProgressValues(times.getRepair_times_max(), times.getRepair_times_me()));
            data_CT_weixiu_p_right.setProgress(dealProgressValues(times.getRepair_times_max(), times.getRepair_times_other()));

            data_CT_jingping_mine.setText(times.getExcelt_times_me() + "");
            data_CT_jingping_other.setText(times.getExcelt_times_other() + "");
            data_CT_jingping_p_left.setProgress(100 - dealProgressValues(times.getExcelt_times_max(), times.getExcelt_times_me()));
            data_CT_jingping_p_right.setProgress(dealProgressValues(times.getExcelt_times_max(), times.getExcelt_times_other()));

            data_CT_yuyue_mine.setText(times.getAppoint_times_me() + "");
            data_CT_yuyue_other.setText(times.getAppoint_times_other() + "");
            data_CT_yuyue_p_left.setProgress(100 - dealProgressValues(times.getAppoint_times_max(), times.getAppoint_times_me()));
            data_CT_yuyue_p_right.setProgress(dealProgressValues(times.getAppoint_times_max(), times.getAppoint_times_other()));

            data_CT_t1_mine.setText(times.getT1_times_me() + "");
            data_CT_t1_other.setText(times.getT1_times_other() + "");
            data_CT_t1_p_left.setProgress(100 - dealProgressValues(times.getT1_times_max(), times.getT1_times_me()));
            data_CT_t1_p_right.setProgress(dealProgressValues(times.getT1_times_max(), times.getT1_times_other()));

            data_CT_m1_mine.setText(times.getM1_times_me() + "");
            data_CT_m1_other.setText(times.getM1_times_other() + "");
            data_CT_m1_p_letf.setProgress(100 - dealProgressValues(times.getM1_times_max(), times.getM1_times_me()));
            data_CT_m1_p_right.setProgress(dealProgressValues(times.getM1_times_max(), times.getM1_times_other()));

            data_CT_m2_mine.setText(times.getM2_times_me() + "");
            data_CT_m2_other.setText(times.getM2_times_other() + "");
            data_CT_m2_p_left.setProgress(100 - dealProgressValues(times.getM2_times_max(), times.getM2_times_me()));
            data_CT_m2_p_right.setProgress(dealProgressValues(times.getM2_times_max(), times.getM2_times_other()));

            data_CT_m1mb_mine.setText(times.getM2_goal_me() + "");
            data_CT_m1mb_other.setText(times.getM2_goal_other() + "");
            data_CT_m1mb_p_left.setProgress(100 - dealProgressValues(times.getM1_goal_max(), times.getM1_goal_me()));
            data_CT_m1mb_p_right.setProgress(dealProgressValues(times.getM1_goal_max(), times.getM1_goal_other()));

            data_CT_m2mb_mine.setText(times.getM2_goal_me() + "");
            data_CT_m2mb_other.setText(times.getM2_goal_other() + "");
            data_CT_m2mb_p_left.setProgress(100 - dealProgressValues(times.getM2_goal_max(), times.getM2_goal_me()));
            data_CT_m2mb_p_right.setProgress(dealProgressValues(times.getM2_goal_max(), times.getM2_goal_other()));

            data_CT_m1mbs_mine.setText(times.getM1_star_goal_me() + "");
            data_CT_m1mbs_other.setText(times.getM1_star_goal_other() + "");
            data_CT_m1mbs_p_left.setProgress(100 - dealProgressValues(times.getM1_star_goal_max(), times.getM1_star_goal_me()));
            data_CT_m1mbs_p_right.setProgress(dealProgressValues(times.getM1_star_goal_max(), times.getM1_star_goal_other()));

            data_CT_m2mbs_mine.setText(times.getM2_star_goal_me() + "");
            data_CT_m2mbs_other.setText(times.getM2_star_goal_other() + "");
            data_CT_m2mbs_p_left.setProgress(100 - dealProgressValues(times.getM2_star_goal_max(), times.getM2_star_goal_me()));
            data_CT_m2mbs_p_right.setProgress(dealProgressValues(times.getM2_star_goal_max(), times.getM2_star_goal_other()));

            data_CT_zhunshi_mine.setText(times.getOntime_times_me() + "");
            data_CT_zhunshi_other.setText(times.getOntime_times_other() + "");
            data_CT_zhunshi_p_left.setProgress(100 - dealProgressValues(times.getOntime_times_max(), times.getOntime_times_me()));
            data_CT_zhunshi_p_right.setProgress(dealProgressValues(times.getOntime_times_max(), times.getOntime_times_other()));

            data_CT_zhuijia_mine.setText(times.getAdd_times_me() + "");
            data_CT_zhuijia_other.setText(times.getAdd_times_other() + "");
            data_CT_zhuijia_p_left.setProgress(100 - dealProgressValues(times.getAdd_times_max(), times.getAdd_times_me()));
            data_CT_zhuijia_p_right.setProgress(dealProgressValues(times.getAdd_times_max(), times.getAdd_times_other()));

        } else if (checkedIds == 2) {  //kpi
            MainDataBean.ResultBean.KPIBean kpi = resultBeans.getKPI();
            //    sethtmlValue(zhiBi_yupm,"当月预约排名",kpi.getappr);
            //     sethtmlValue(zhiBi_rkpm,"当月预入库排名",);
            data_CT_dyrk_mine.setText(kpi.getAppoint_me() + "");
            data_CT_dyrk_other.setText(kpi.getAppoint_other() + "");
            data_CT_dyrk_p_left.setProgress(100 - dealProgressValues(kpi.getAppoint_max(), kpi.getAppoint_me()));
            data_CT_dyrk_p_right.setProgress(dealProgressValues(kpi.getAppoint_max(), kpi.getAppoint_other()));

            data_CT_yyrk_mine.setText(kpi.getAppoint_enter_me() + "");
            data_CT_yyrk_other.setText(kpi.getAppoint_enter_other() + "");
            data_CT_yyrk_p_left.setProgress(100 - dealProgressValues(kpi.getAppoint_enter_max(), kpi.getAppoint_enter_me()));
            data_CT_yyrk_p_right.setProgress(dealProgressValues(kpi.getAppoint_enter_max(), kpi.getAppoint_enter_other()));

            data_CT_yycgl_mine.setText(kpi.getAppoint_success_rate_me() + "");
            data_CT_yycgl_other.setText(kpi.getAppoint_success_rate_other() + "");
            data_CT_yycgl_p_left.setProgress(100 - dealProgressValues(kpi.getAppoint_success_rate_max(), kpi.getAppoint_success_rate_me()));
            data_CT_yycgl_p_right.setProgress(dealProgressValues(kpi.getAppoint_success_rate_max(), kpi.getAppoint_success_rate_other()));

            data_CT_rkcgl_mine.setText(kpi.getEnter_success_rate_me() + "");
            data_CT_rkcgl_other.setText(kpi.getEnter_success_rate_other() + "");
            data_CT_rkcgl_p_left.setProgress(100 - dealProgressValues(kpi.getEnter_success_rate_max(), kpi.getEnter_success_rate_me()));
            data_CT_rkcgl_p_right.setProgress(dealProgressValues(kpi.getEnter_success_rate_max(), kpi.getEnter_success_rate_other()));

            data_CT_dysc_mine.setText(kpi.getCollection_me() + "");
            data_CT_dysc_other.setText(kpi.getCollection_other() + "");
            data_CT_dysc_p_left.setProgress(100 - dealProgressValues(kpi.getCollection_max(), kpi.getCollection_me()));
            data_CT_dysc_p_right.setProgress(dealProgressValues(kpi.getCollection_max(), kpi.getCollection_other()));

            data_CT_dyjx_mine.setText(kpi.getContinue_me() + "");
            data_CT_dyjx_other.setText(kpi.getContinue_other() + "");
            data_CT_dyjx_p_left.setProgress(100 - dealProgressValues(kpi.getContinue_max(), kpi.getContinue_me()));
            data_CT_dyjx_p_right.setProgress(dealProgressValues(kpi.getContinue_max(), kpi.getContinue_other()));

            data_CT_dyfq_mine.setText(kpi.getGiveup_me() + "");
            data_CT_dyfq_other.setText(kpi.getGiveup_other() + "");
            data_CT_dyfq_p_letf.setProgress(100 - dealProgressValues(kpi.getGiveup_max(), kpi.getGiveup_me()));
            data_CT_dyfq_p_right.setProgress(dealProgressValues(kpi.getGiveup_max(), kpi.getGiveup_other()));

            data_CT_dyls_mine.setText(kpi.getLoss_me() + "");
            data_CT_dyls_other.setText(kpi.getLoss_other() + "");
            data_CT_dyls_p_left.setProgress(100 - dealProgressValues(kpi.getLoss_max(), kpi.getLoss_me()));
            data_CT_dyls_p_right.setProgress(dealProgressValues(kpi.getLoss_max(), kpi.getLoss_other()));

            data_CT_scwcl_mine.setText(kpi.getUnsolved_collection_me() + "");
            data_CT_scwcl_other.setText(kpi.getUnsolved_collection_other() + "");
            data_CT_scwcl_p_left.setProgress(100 - dealProgressValues(kpi.getUnsolved_collection_max(), kpi.getUnsolved_collection_me()));
            data_CT_scwcl_p_right.setProgress(dealProgressValues(kpi.getUnsolved_collection_max(), kpi.getUnsolved_collection_other()));

        }
    }

    /**
     * 计算进度
     *
     * @param maxvalue
     * @param value
     * @return
     */
    private int dealProgressValues(int maxvalue, int value) {
        int lastvalue = 0;
        if (value == 0) {
            if (checkedIds != 0) {
                value = 1;
            } else {
                value = 2500;
            }
        }
        double d1 = maxvalue * 1.0;
        double d2 = value * 1.0;
        Log.e("ints", d1 + "---" + d2 + "");
        d1 = d2 / d1;
        lastvalue = (int) (100.0D * d1);
        Log.e("int", maxvalue + "---" + d1 + "");

        if (lastvalue < 0.5) {
            lastvalue = 1;
            return lastvalue;
        } else if (lastvalue < 1) {
            lastvalue = 2;
            return lastvalue;
        }
        return lastvalue;
    }


    @SuppressLint("SetTextI18n")
    private void dealmeduler(MainDataBean resultBean, int checkedIds) {
        UserInfo userInfo = (UserInfo) PreferencesUtil.getInstance(getActivity()).getObject("UserInfo");
        if (checkedIds == 0) {
            int d = (Integer) resultBean.getResult().getGoal_mn_achv_rate().get(0);
            chanZ_mubv.setText(d + "%");
            chanZ_today.setText(resultBean.getResult().getWeekday_mn_now().get(0).intValue() + "");
            chanZ_sunday.setText(resultBean.getResult().getWeekend_mn_now().get(0).intValue() + "");
        } else if (checkedIds == 1) { //台次
            sethtmlValue(taiC_mubv, "目标达成率", resultBean.getResult().getGoal_times_achv_rate().get(0) + "%");
            sethtmlValue(taiC_today, "平日（辆）", resultBean.getResult().getWeekday_times().get(0).intValue() + "");
            sethtmlValue(taiC_sunday, "周末（辆）", resultBean.getResult().getWeekend_times().get(0).intValue() + "");
        } else {

            sethtmlValue(zhiBi_yupm, "当月预约排名", resultBean.getResult().getKPI_appoint_rank().get(0) + "");
            sethtmlValue(zhiBi_rkpm, "当月预入库排名", resultBean.getResult().getKPI_enter_rank().get(0) + "");

        }
    }


//    private void setData(ArrayList<Entry> paramArrayList1, ArrayList<Entry> paramArrayList2) {
//        if ((mLineChar.getData() != null) && (mLineChar.getData()).getDataSetCount() > 0) {
//
//            LineDataSet localLineDataSet1 = (LineDataSet) (mLineChar.getData()).getDataSetByIndex(0);
//            LineDataSet localLineDataSet2 = (LineDataSet) (mLineChar.getData().getDataSetByIndex(1));
//            localLineDataSet1.setValues(paramArrayList1);
//            localLineDataSet2.setValues(paramArrayList2);
//            mLineChar.getData().notifyDataChanged();
//            mLineChar.notifyDataSetChanged();
//
//        } else {
//            set1 = new LineDataSet(paramArrayList1, "");
//            set1.setColor(Color.parseColor("#c62828"));
//            //  set1.setCircleColor(getResources().getColor(R.color.color1));
//            set1.setLineWidth(3.0F);
//            set1.setCircleRadius(3.0F);
//            set1.setDrawCircleHole(false);
//            set1.setValueTextSize(9.0F);
//            set1.setDrawFilled(false);
//            set1.setFormSize(15.0F);
//
//            set2 = new LineDataSet(paramArrayList2, "");
//            set2.setColor(Color.parseColor("#737373"));
//            //  set2.setCircleColor(Color.BLACK);
//            set2.setLineWidth(3.0F);
//            set2.setCircleRadius(3.0F);
//            set2.setDrawCircleHole(false);
//            set2.setValueTextSize(9.0F);
//            set1.setDrawFilled(false);
//            set2.setFormSize(15.0F);
//
//            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
//            dataSets.add(set1);
//            dataSets.add(set2);
//            LineData lineData1 = new LineData(dataSets);
//            lineData1.setValueTextColor(0);
//            lineData1.setValueTextSize(9.0F);
//            mLineChar.setData(lineData1);
//
//        }
//
//        List<ILineDataSet> setsFilled = mLineChar.getData().getDataSets();
//        for (ILineDataSet iSet : setsFilled) {
//            LineDataSet set = (LineDataSet) iSet;
//            set.setDrawCircles(false);
//            set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
//        }
//
//
//    }

    private void sethtmlValue(TextView paramTextView, String paramString1, String paramString2) {
        paramTextView.setText(Html.fromHtml(paramString1 + "  " + "<font color=\"#ff3366\">" + paramString2 + "</font>"));
    }

//    private void initMAChartLine() {
//        mLineChar.setOnChartGestureListener(this);
//        mLineChar.setOnChartValueSelectedListener(this);
//        mLineChar.setDrawGridBackground(false);
//        mLineChar.getDescription().setEnabled(false);
//        mLineChar.setTouchEnabled(true);
//        mLineChar.setDragEnabled(true);
//        mLineChar.setScaleEnabled(true);
//        mLineChar.setPinchZoom(true);
//        mLineChar.getAxisLeft().setDrawGridLines(false);
//        mLineChar.getXAxis().setDrawGridLines(false);
//        mLineChar.setNoDataText("没有数据");
//        mLineChar.setNoDataTextColor(-1);
//        MyMarkerView markerView = new MyMarkerView(getActivity(), R.layout.custom_marker_view);
//        markerView.setChartView(mLineChar);
//        mLineChar.setMarker(markerView);
//        LimitLine limitLine = new LimitLine(1.0F, "标记");
//        limitLine.setLineWidth(4.0F);
//        limitLine.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
//        limitLine.setTextSize(10.0F);
//        XAxis xAxis = mLineChar.getXAxis();
//        xAxis.setAxisMaximum(31.0F);
//        xAxis.setAxisMinimum(1.0F);
//        xAxis.setDrawAxisLine(false);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setAvoidFirstLastClipping(false);
//        LimitLine limitLine1 = new LimitLine(0F, " ");
//        limitLine1.setLineWidth(1F);
//        limitLine1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
//        limitLine1.setTextSize(10F);
//        limitLine1.setLineColor(R.color.black);
//        YAxis localYAxis = mLineChar.getAxisLeft();
//        localYAxis.removeAllLimitLines();
//        localYAxis.addLimitLine(limitLine1);
//        localYAxis.setAxisMaximum(150F);
//        localYAxis.setAxisMinimum(-150F);
//        localYAxis.setDrawZeroLine(false);
//        localYAxis.setDrawLimitLinesBehindData(true);
//        mLineChar.getAxisRight().setEnabled(false);
//        if (!isAnim) {
//            mLineChar.animateX(3000);
//            isAnim = true;
//        }
//        mLineChar.getLegend().setForm(Legend.LegendForm.LINE);
//        mLineChar.getLegend().setEnabled(false); //去掉图例缩样
//    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == radioButtonC.getId()) {  //产值
            if (resultBean == null) {
                getAllData(changeIndexYear(indexyear), indexmonth);
                return;
            }
            checkedIds = 0;
            data_fg_pg_2.setVisibility(View.VISIBLE);
            data_fg_pg_3.setVisibility(View.GONE);
            data_fg_pg_4.setVisibility(View.GONE);
            llChanZ.setVisibility(View.VISIBLE);
            llTaiC.setVisibility(View.GONE);
            ll_zhiBi.setVisibility(View.GONE);
            data_CT_zhunshi_ll.setVisibility(View.GONE);
            data_CT_zj_zs_ll.setVisibility(View.VISIBLE);
            setReusltData(resultBean);

        } else if (checkedId == radioButtonT.getId()) { //台次
            if (resultBean == null) {
                getAllData(changeIndexYear(indexyear), indexmonth);
                return;
            }
            checkedIds = 1;
            data_fg_pg_2.setVisibility(View.VISIBLE);
            data_fg_pg_3.setVisibility(View.VISIBLE);
            data_fg_pg_4.setVisibility(View.GONE);
            llChanZ.setVisibility(View.GONE);
            llTaiC.setVisibility(View.VISIBLE);
            ll_zhiBi.setVisibility(View.GONE);
            data_CT_zhunshi_ll.setVisibility(View.VISIBLE);
            data_CT_zj_zs_ll.setVisibility(View.VISIBLE);
            setReusltData(resultBean);
        } else if (checkedId == radioButtonK.getId()) { //指标
            if (resultBean == null) {
                getAllData(changeIndexYear(indexyear), indexmonth);
                return;
            }
            checkedIds = 2;
            data_fg_pg_2.setVisibility(View.GONE);
            data_fg_pg_3.setVisibility(View.GONE);
            data_fg_pg_4.setVisibility(View.VISIBLE);
            llChanZ.setVisibility(View.GONE);
            llTaiC.setVisibility(View.GONE);
            data_CT_zhunshi_ll.setVisibility(View.VISIBLE);
            ll_zhiBi.setVisibility(View.VISIBLE);
            data_CT_zj_zs_ll.setVisibility(View.GONE);
            setReusltData(resultBean);

        }
    }


    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        if (lastPerformedGesture == ChartTouchListener.ChartGesture.SINGLE_TAP)
            return;
        mLineChar.highlightValues(null);
    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @OnClick({R.id.time_selsect})
    public void setTime() {
        MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .title("选择时间")
                .customView(R.layout.time_md_dialog, false)
                .positiveText("确定")
                .positiveColorRes(R.color.color1)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        isRefresh = 0;
                        getAllData(changeIndexYear(indexyear), indexmonth);
                    }
                })
                .build();
        View customView = dialog.getCustomView();
        WheelListView wheelListViewY = customView.findViewById(R.id.wheelview_timeY);
        WheelListView wheelListViewM = customView.findViewById(R.id.wheelview_timeM);
        wheelListViewY.setItems(new String[]{"2017", "2018", "2019"}, indexyear);
        wheelListViewY.setSelectedTextColor(getResources().getColor(R.color.black));
        LineConfig config = new LineConfig();
        config.setColor(Color.parseColor("#c62828"));
        config.setThick(ConvertUtils.toPx(getActivity(), 3.0F));
        config.setShadowVisible(false);
        wheelListViewY.setLineConfig(config);
        wheelListViewY.setOnWheelChangeListener(new WheelListView.OnWheelChangeListener() {
            @Override
            public void onItemSelected(int paramInt, String s) {
                indexyear = paramInt;
            }
        });
        wheelListViewM.setItems(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}, indexmonth - 1);
        wheelListViewM.setSelectedTextColor(getResources().getColor(R.color.black));
        LineConfig configm = new LineConfig();
        configm.setColor(Color.parseColor("#c62828"));
        configm.setThick(ConvertUtils.toPx(getActivity(), 3.0F));
        configm.setShadowVisible(false);
        wheelListViewM.setLineConfig(configm);
        wheelListViewM.setOnWheelChangeListener(new WheelListView.OnWheelChangeListener() {
            @Override
            public void onItemSelected(int paramInt, String s) {
                indexmonth = paramInt + 1;
            }
        });
        dialog.show();
    }

    @OnClick(R.id.sa_selsect)
    public void selsectVsPerson() {
        MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .title("选择SA")
                .customView(R.layout.sa_md_dialog, false)
                .positiveText("确定")
                .positiveColorRes(R.color.color1)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        isRefresh = 0;
                         getAllData(indexyear,indexmonth);
                    }
                })
                .build();
        View customView = dialog.getCustomView();
        WheelListView wheelListView = customView.findViewById(R.id.wheelview_single);
        wheelListView.setItems(saArray, indexSa);
        wheelListView.setSelectedTextColor(getResources().getColor(R.color.black));
        LineConfig config = new LineConfig();
        config.setColor(Color.parseColor("#c62828"));//线颜色
        config.setThick(ConvertUtils.toPx(getActivity(), 3));//线粗
        config.setShadowVisible(false);
        wheelListView.setLineConfig(config);
        wheelListView.setOnWheelChangeListener(new WheelListView.OnWheelChangeListener() {
            @Override
            public void onItemSelected(int index, String item) {
//                UIUtils.showToast("index=" + index + ",item=" + item);
                indexSa = index;
                SaName=item;
            }
        });
        dialog.show();
    }

//    private BarData getBarData(List<Integer> barChartY, int barColor) {
//        BarData barData = new BarData();
//        ArrayList<BarEntry> yValues = new ArrayList<>();
//        for (int i = 0; i < barChartY.size(); i++) {
//            yValues.add(new BarEntry(i, barChartY.get(i).floatValue()));
//        }
//
//        BarDataSet barDataSet = new BarDataSet(yValues, "");
//        barDataSet.setDrawValues(false);
//        barDataSet.setColor(barColor);
//        barDataSet.setValueTextSize(10f);
//        barDataSet.setValueTextColor(barColor);
//        barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
//        barData.addDataSet(barDataSet);
//
//        //以下是为了解决 柱状图 左右两边只显示了一半的问题 根据实际情况 而定
//        xAxis.setAxisMinimum(-0.5f);
//        xAxis.setAxisMaximum((float) (barChartY.size() - 0.5));
//
//        return barData;
//    }

    /**
     * 得到柱状图(多条)
     *
     * @param barChartYs Y轴值
     * @param barColors  柱状图颜色
     * @return
     */

    private BarData getBarDatas(List<List<Integer>> barChartYs, List<Integer> barColors) {
        List<IBarDataSet> lists = new ArrayList<>();
        for (int i = 0; i < barChartYs.size(); i++) {
            ArrayList<BarEntry> entries = new ArrayList<>();

            for (int j = 0; j < barChartYs.get(i).size(); j++) {
                entries.add(new BarEntry(j, barChartYs.get(i).get(j).floatValue()));
            }
            BarDataSet barDataSet = new BarDataSet(entries, "");

            barDataSet.setColor(barColors.get(i));
            barDataSet.setValueTextColor(barColors.get(i));
            barDataSet.setDrawValues(false);
            barDataSet.setValueTextSize(10f);
            barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            lists.add(barDataSet);
        }
        BarData barData = new BarData(lists);

//        int amount = barChartYs.size(); //需要显示柱状图的类别 数量
//        float groupSpace = 0.12f; //柱状图组之间的间距
//        float barSpace = (float) ((1 - 0.12) / amount / 10); // x4 DataSet
//        float barWidth = (float) ((1 - 0.12) / amount / 10 * 9); // x4 DataSet
//
//        // (0.2 + 0.02) * 4 + 0.12 = 1.00 即100% 按照百分百布局
//        //柱状图宽度
//        barData.setBarWidth(barWidth);
//        //(起始点、柱状图组间距、柱状图之间间距)
//        barData.groupBars(0, groupSpace, barSpace);
        return barData;
    }

    /**
     * 得到折线图(多条)
     *
     * @param lineChartYs 折线Y轴值
     * @param lineColors  折线颜色
     * @return
     */
    private LineData getLineData(List<List<Double>> lineChartYs, List<Integer> lineColors) {
        LineData lineData = new LineData();

        for (int i = 0; i < lineChartYs.size(); i++) {
            ArrayList<Entry> yValues = new ArrayList<>();
            for (int j = 0; j < lineChartYs.get(i).size(); j++) {
                yValues.add(new Entry(j, lineChartYs.get(i).get(j).floatValue()));
            }
            LineDataSet dataSet = new LineDataSet(yValues, "");

            dataSet.setColor(lineColors.get(i));
            dataSet.setDrawCircles(false);
            dataSet.setDrawValues(false);
            dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            dataSet.setLineWidth(3.0F);
            dataSet.setCircleRadius(3.0F);
            dataSet.setDrawCircleHole(false);
            dataSet.setValueTextSize(9.0F);
            dataSet.setDrawFilled(false);
            dataSet.setFormSize(15.0F);
            lineData.addDataSet(dataSet);
        }
        return lineData;
    }

    private int changeIndexYear(int defulteryear) {
        if (defulteryear == 1) {
            defulteryear = 2018;
        } else if (defulteryear == 2) {
            defulteryear = 2019;
        } else if (defulteryear == 0) {
            defulteryear = 2017;
        }
        return defulteryear;
    }


}
