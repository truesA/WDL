package com.wdl.amdroid_jwdl.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import butterknife.BindView;
import butterknife.OnClick;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    private int monthdefult = 1;

    @BindView(R.id.rb_top_c)
    public RadioButton radioButtonC;

    @BindView(R.id.rb_top_t)
    public RadioButton radioButtonT;

    @BindView(R.id.rg_top)
    public RadioGroup radioGroup;


    @BindView(R.id.taiC_m1)
    public TextView taiC_m1;

    @BindView(R.id.taiC_m2)
    public TextView taiC_m2;

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

    private MainDataBean resultBean;
    private LineDataSet set1;
    private LineDataSet set2;
    private int defulter = 1;

    @BindView(R.id.data_refreshLayout)
    SmartRefreshLayout refreshLayouts;

    @BindView(R.id.data_combind_chart)
    CombinedChart combinedChart;
    private YAxis leftAxis;
    private YAxis rightAxis;
    private XAxis xAxis;

    private int isRefresh = 0;

    @Override
    protected void initView() {
        refreshLayouts.setRefreshHeader(new MaterialHeader(getActivity()));
        refreshLayouts.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh(RefreshLayout RefreshLayout) {
                isRefresh = 1;
                getAllData(defulter);
            }
        });
        refreshLayouts.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(false);//传入false表示加载失败
            }
        });
        radioGroup.setOnCheckedChangeListener(this);
        //  initMAChartLine();
        //  initMaCharBar();
        //  getAllData(defulter);
        initCombindChart();
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

        // setCombindData();


    }

    /**
     * 设置曲线图
     *
     * @param barChartYs
     * @param line1
     * @param line2
     */
    private void setCombindData(List<Double> barChartYs, List<Double> line1, List<Double> line2) {
        CombinedData combinedData = new CombinedData();

        List<Double> barChartY = new ArrayList<>();
        for (int j = 0; j <= 30; j++) {
            barChartY.add((double) (Math.random() * 100));

        }

        List<List<Double>> yLineDatat = new ArrayList<>();
        yLineDatat.add(line1);
        yLineDatat.add(line2);

        List<List<Double>> yLineDatas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            //y轴数
            List<Double> yData = new ArrayList<>();
            for (int j = 0; j <= 30; j++) {
                yData.add((double) (Math.random() * 100));
            }
            yLineDatas.add(yData);
        }
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#c62828"));
        colors.add(Color.parseColor("#737373"));

        combinedData.setData(getBarData(barChartY, Color.parseColor("#737373")));
        combinedData.setData(getLineData(yLineDatas, colors));

        combinedChart.setData(combinedData);
        combinedChart.animateX(2000); // 立即执行的动画,x轴
        combinedChart.invalidate();
    }

    private void getAllData(final int defulter) {
        if (isRefresh == 0) {
            showLoadingDialog();
        }
        App.getRetrofit(API.BASE_URL)
                .create(DataService.class)
                .getMainData(defulter)
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
                            monthdefult = defulter;
                            time_selsect.setText(monthdefult + "月");
                            setReusltData(mainDataBean);
                        }
                        UIUtils.showToast(mainDataBean.getReason());
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

    private ArrayList<Entry> dealLine(List<Double> paramList) {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramList.size()) {
            localArrayList.add(new Entry(i + 1, new Double(((Double) paramList.get(i)).doubleValue()).intValue()));
            i += 1;
        }
        return localArrayList;
    }

    @RequiresApi(api = 24)
    private void setReusltData(MainDataBean resultBeans) {
        resultBean = resultBeans;
        dealProgess(resultBean, checkedIds);
        dealmeduler(resultBean, checkedIds);
        if (checkedIds == 0) {
            setData(dealLine(resultBean.getResult().getMn_rate().get(0)), dealLine(resultBean.getResult().getMn_rate().get(1)));
        } else {
            setData(dealLine(resultBean.getResult().getTimes_rate().get(0)), dealLine(resultBean.getResult().getTimes_rate().get(1)));
        }


        mLineChar.animateX(2500);
        mLineChar.invalidate();
    }

    private void dealProgess(MainDataBean resultBean, int checkedIds) {
        if (checkedIds == 0) {
//            tv_zcz_tc.setText("总产值");
//            tv_bycz_bytc.setText("保养产值");
//            tv_t1cz_t1tc.setText("T1产值");
//            tv_m1cz_m1tc.setText("M1产值");
//            tv_m2cz_m2tc.setText("M2产值");
//            tv_yycz_yytc.setText("预约产值");
//            probar_zcz_right_p.setProgress(100 - dealProgressValues(500000, ((Integer) resultBean.getResult().getGoal_mn_now().get(0)).intValue()));
//            probar_zcz_left_p.setProgress(dealProgressValues(500000, ((Integer) resultBean.getResult().getGoal_mn_now().get(1)).intValue()));
//            probar_zcz_right_tv.setText(resultBean.getResult().getGoal_mn_now().get(0) + "");
//            probar_zcz_left_tv.setText(resultBean.getResult().getGoal_mn_now().get(1) + "");
//            probar_zbycz_right_p.setProgress(100 - dealProgressValues(150000, ((Integer) resultBean.getResult().getMaint_mn_now().get(0)).intValue()));
//            probar_zbycz_left_p.setProgress(dealProgressValues(150000, ((Integer) resultBean.getResult().getMaint_mn_now().get(1)).intValue()));
//            probar_zbycz_right_tv.setText(resultBean.getResult().getMaint_mn_now().get(0) + "");
//            probar_zbycz_left_tv.setText(resultBean.getResult().getMaint_mn_now().get(1) + "");
//            probar_t1cz_right_p.setProgress(100 - dealProgressValues(100000, ((Integer) resultBean.getResult().getT1_mn_now().get(0)).intValue()));
//            probar_t1cz_left_p.setProgress(dealProgressValues(100000, ((Integer) resultBean.getResult().getT1_mn_now().get(1)).intValue()));
//            probar_t1cz_right_tv.setText(resultBean.getResult().getT1_mn_now().get(0) + "");
//            probar_t1cz_left_tv.setText(resultBean.getResult().getT1_mn_now().get(1) + "");
//            probar_m1cz_right_p.setProgress(100 - dealProgressValues(100000, ((Integer) resultBean.getResult().getM1_mn_now().get(0)).intValue()));
//            probar_m1cz_left_p.setProgress(dealProgressValues(100000, ((Integer) resultBean.getResult().getM1_mn_now().get(1)).intValue()));
//            probar_m1cz_right_tv.setText(resultBean.getResult().getM1_mn_now().get(0) + "");
//            probar_m1cz_left_tv.setText(resultBean.getResult().getM1_mn_now().get(1) + "");
//            probar_m2cz_right_p.setProgress(100 - dealProgressValues(100000, ((Integer) resultBean.getResult().getM2_mn_now().get(0)).intValue()));
//            probar_m2cz_left_p.setProgress(dealProgressValues(100000, ((Integer) resultBean.getResult().getM2_mn_now().get(1)).intValue()));
//            probar_m2cz_right_tv.setText(resultBean.getResult().getM2_mn_now().get(0) + "");
//            probar_m2cz_left_tv.setText(resultBean.getResult().getM2_mn_now().get(1) + "");
//            probar_yycz_right_p.setProgress(100 - dealProgressValues(100000, ((Integer) resultBean.getResult().getAppoint_mn_now().get(0)).intValue()));
//            probar_yycz_left_p.setProgress(dealProgressValues(100000, ((Integer) resultBean.getResult().getAppoint_mn_now().get(1)).intValue()));
//            probar_yycz_right_tv.setText(resultBean.getResult().getAppoint_mn_now().get(0) + "");
//            probar_yycz_left_tv.setText(resultBean.getResult().getAppoint_mn_now().get(1) + "");

        } else {
//            tv_zcz_tc.setText("总台次");
//            tv_bycz_bytc.setText("保养台次");
//            tv_t1cz_t1tc.setText("T1台次");
//            tv_m1cz_m1tc.setText("M1台次");
//            tv_m2cz_m2tc.setText("M2台次");
//            tv_yycz_yytc.setText("预约台次");
//            probar_zcz_right_p.setProgress(100 - dealProgressValues(350, ((Integer) resultBean.getResult().getGoal_times().get(0)).intValue()));
//            probar_zcz_left_p.setProgress(dealProgressValues(350, ((Integer) resultBean.getResult().getGoal_times().get(1)).intValue()));
//            probar_zcz_right_tv.setText(resultBean.getResult().getGoal_times().get(0) + "");
//            probar_zcz_left_tv.setText(resultBean.getResult().getGoal_times().get(1) + "");
//            probar_zbycz_right_p.setProgress(100 - dealProgressValues(350, ((Integer) resultBean.getResult().getMaint_times().get(0)).intValue()));
//            probar_zbycz_left_p.setProgress(dealProgressValues(350, ((Integer) resultBean.getResult().getMaint_times().get(1)).intValue()));
//            probar_zbycz_right_tv.setText(resultBean.getResult().getMaint_times().get(0) + "");
//            probar_zbycz_left_tv.setText(resultBean.getResult().getMaint_times().get(1) + "");
//            probar_t1cz_right_p.setProgress(100 - dealProgressValues(20, ((Integer) resultBean.getResult().getT1_times().get(0)).intValue()));
//            probar_t1cz_left_p.setProgress(dealProgressValues(20, ((Integer) resultBean.getResult().getT1_times().get(1)).intValue()));
//            probar_t1cz_right_tv.setText(resultBean.getResult().getT1_times().get(0) + "");
//            probar_t1cz_left_tv.setText(resultBean.getResult().getT1_times().get(1) + "");
//            probar_m1cz_right_p.setProgress(100 - dealProgressValues(20, ((Integer) resultBean.getResult().getM1_times().get(0)).intValue()));
//            probar_m1cz_left_p.setProgress(dealProgressValues(20, ((Integer) resultBean.getResult().getM1_times().get(1)).intValue()));
//            probar_m1cz_right_tv.setText(resultBean.getResult().getM1_times().get(0) + "");
//            probar_m1cz_left_tv.setText(resultBean.getResult().getM1_times().get(1) + "");
//            probar_m2cz_right_p.setProgress(100 - dealProgressValues(20, ((Integer) resultBean.getResult().getM2_times().get(0)).intValue()));
//            probar_m2cz_left_p.setProgress(dealProgressValues(20, ((Integer) resultBean.getResult().getM2_times().get(1)).intValue()));
//            probar_m2cz_right_tv.setText(resultBean.getResult().getM2_times().get(0) + "");
//            probar_m2cz_left_tv.setText(resultBean.getResult().getM2_times().get(1) + "");
//            probar_yycz_right_p.setProgress(100 - dealProgressValues(20, (resultBean.getResult().getAppoint_times().get(0)).intValue()));
//            probar_yycz_left_p.setProgress(dealProgressValues(20, ((Integer) resultBean.getResult().getAppoint_times().get(1)).intValue()));
//            probar_yycz_right_tv.setText(resultBean.getResult().getAppoint_times().get(0) + "");
//            probar_yycz_left_tv.setText(resultBean.getResult().getAppoint_times().get(1) + "");
        }
    }

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

        return lastvalue;
    }


    @SuppressLint("SetTextI18n")
    private void dealmeduler(MainDataBean resultBean, int checkedIds) {
        UserInfo userInfo = (UserInfo) PreferencesUtil.getInstance(getActivity()).getObject("UserInfo");
        if (checkedIds == 0) {
            if (userInfo.getLogintype() == 1) {
                int d = (Integer) resultBean.getResult().getGoal_mn_achv_rate().get(0);
                chanZ_mubv.setText(d + "%");
                chanZ_today.setText(resultBean.getResult().getWeekday_mn_now().get(0).intValue() + "");
                chanZ_sunday.setText(resultBean.getResult().getWeekend_mn_now().get(0).intValue() + "");
            } else {
                int d = (Integer) resultBean.getResult().getGoal_mn_achv_rate().get(1);
                chanZ_mubv.setText(d + "%");
                chanZ_today.setText(resultBean.getResult().getWeekday_mn_now().get(1) + "");
                chanZ_sunday.setText(resultBean.getResult().getWeekend_mn_now().get(1) + "");
            }
        } else {
            if (userInfo.getLogintype() == 1) {
                sethtmlValue(taiC_m1, "M1", resultBean.getResult().getM1_rate().get(0) + "%");
                sethtmlValue(taiC_m2, "M2", resultBean.getResult().getM2_rate().get(0) + "%");
                sethtmlValue(taiC_yuv, "预约率", resultBean.getResult().getAppoint_rate().get(0) + "%");
                sethtmlValue(taiC_mubv, "目标达成率", resultBean.getResult().getGoal_times_achv_rate().get(0) + "%");
                sethtmlValue(taiC_today, "平日（辆）", resultBean.getResult().getWeekday_times().get(0).intValue() + "");
                sethtmlValue(taiC_sunday, "周末（辆）", resultBean.getResult().getWeekend_times().get(0).intValue() + "");
            } else {
                sethtmlValue(taiC_m1, "M1", resultBean.getResult().getM1_rate().get(1) + "%");
                sethtmlValue(taiC_m2, "M2", resultBean.getResult().getM2_rate().get(1) + "%");
                sethtmlValue(taiC_yuv, "预约率", resultBean.getResult().getAppoint_rate().get(1) + "%");
                sethtmlValue(taiC_mubv, "目标达成率", resultBean.getResult().getGoal_times_achv_rate().get(1) + "%");
                sethtmlValue(taiC_today, "平日（辆）", resultBean.getResult().getWeekday_times().get(1).intValue() + "");
                sethtmlValue(taiC_sunday, "周末（辆）", resultBean.getResult().getWeekend_times().get(1).intValue() + "");
            }
        }
    }


    private void setData(ArrayList<Entry> paramArrayList1, ArrayList<Entry> paramArrayList2) {
        if ((mLineChar.getData() != null) && (mLineChar.getData()).getDataSetCount() > 0) {

            LineDataSet localLineDataSet1 = (LineDataSet) (mLineChar.getData()).getDataSetByIndex(0);
            LineDataSet localLineDataSet2 = (LineDataSet) (mLineChar.getData().getDataSetByIndex(1));
            localLineDataSet1.setValues(paramArrayList1);
            localLineDataSet2.setValues(paramArrayList2);
            mLineChar.getData().notifyDataChanged();
            mLineChar.notifyDataSetChanged();

        } else {
            set1 = new LineDataSet(paramArrayList1, "");
            set1.setColor(Color.parseColor("#c62828"));
            //  set1.setCircleColor(getResources().getColor(R.color.color1));
            set1.setLineWidth(3.0F);
            set1.setCircleRadius(3.0F);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9.0F);
            set1.setDrawFilled(false);
            set1.setFormSize(15.0F);

            set2 = new LineDataSet(paramArrayList2, "");
            set2.setColor(Color.parseColor("#737373"));
            //  set2.setCircleColor(Color.BLACK);
            set2.setLineWidth(3.0F);
            set2.setCircleRadius(3.0F);
            set2.setDrawCircleHole(false);
            set2.setValueTextSize(9.0F);
            set1.setDrawFilled(false);
            set2.setFormSize(15.0F);

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1);
            dataSets.add(set2);
            LineData lineData1 = new LineData(dataSets);
            lineData1.setValueTextColor(0);
            lineData1.setValueTextSize(9.0F);
            mLineChar.setData(lineData1);

        }

        List<ILineDataSet> setsFilled = mLineChar.getData().getDataSets();
        for (ILineDataSet iSet : setsFilled) {
            LineDataSet set = (LineDataSet) iSet;
            set.setDrawCircles(false);
            set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        }


    }

    private void sethtmlValue(TextView paramTextView, String paramString1, String paramString2) {
        paramTextView.setText(Html.fromHtml(paramString1 + "  " + "<font color=\"#ff3366\">" + paramString2 + "</font>"));
    }

    private void initMAChartLine() {
        mLineChar.setOnChartGestureListener(this);
        mLineChar.setOnChartValueSelectedListener(this);
        mLineChar.setDrawGridBackground(false);
        mLineChar.getDescription().setEnabled(false);
        mLineChar.setTouchEnabled(true);
        mLineChar.setDragEnabled(true);
        mLineChar.setScaleEnabled(true);
        mLineChar.setPinchZoom(true);
        mLineChar.getAxisLeft().setDrawGridLines(false);
        mLineChar.getXAxis().setDrawGridLines(false);
        mLineChar.setNoDataText("没有数据");
        mLineChar.setNoDataTextColor(-1);
        MyMarkerView markerView = new MyMarkerView(getActivity(), R.layout.custom_marker_view);
        markerView.setChartView(mLineChar);
        mLineChar.setMarker(markerView);
        LimitLine limitLine = new LimitLine(1.0F, "标记");
        limitLine.setLineWidth(4.0F);
        limitLine.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        limitLine.setTextSize(10.0F);
        XAxis xAxis = mLineChar.getXAxis();
        xAxis.setAxisMaximum(31.0F);
        xAxis.setAxisMinimum(1.0F);
        xAxis.setDrawAxisLine(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAvoidFirstLastClipping(false);
        LimitLine limitLine1 = new LimitLine(0F, " ");
        limitLine1.setLineWidth(1F);
        limitLine1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        limitLine1.setTextSize(10F);
        limitLine1.setLineColor(R.color.black);
        YAxis localYAxis = mLineChar.getAxisLeft();
        localYAxis.removeAllLimitLines();
        localYAxis.addLimitLine(limitLine1);
        localYAxis.setAxisMaximum(150F);
        localYAxis.setAxisMinimum(-150F);
        localYAxis.setDrawZeroLine(false);
        localYAxis.setDrawLimitLinesBehindData(true);
        mLineChar.getAxisRight().setEnabled(false);
        if (!isAnim) {
            mLineChar.animateX(3000);
            isAnim = true;
        }
        mLineChar.getLegend().setForm(Legend.LegendForm.LINE);
        mLineChar.getLegend().setEnabled(false); //去掉图例缩样
    }

    private void initMaCharBar() {

    }

    @Override
    protected View setRootView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.data_fg, container, false);
        return view;
    }

    @Override
    public void initData() {
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == radioButtonC.getId()) {
            Log.e("checkedId", checkedId + "");
//            if (resultBean == null) {
//                getAllData(monthdefult);
//                return;
//            }
            checkedIds = 0;
//            ArrayList<Entry> value1 = dealLine((List) resultBean.getResult().getMn_rate().get(0));
            //           ArrayList<Entry> value2 = dealLine((List) resultBean.getResult().getMn_rate().get(1));
            llChanZ.setVisibility(View.VISIBLE);
            llTaiC.setVisibility(View.GONE);
//            setData(value1, value2);
//            mLineChar.animateX(2500);
//            mLineChar.invalidate();
//            dealProgess(resultBean, checkedIds);
//            dealmeduler(resultBean, checkedIds);
        } else {
//            if (resultBean == null) {
//                getAllData(monthdefult);
//                return;
//            }
            Log.e("checkedIds", checkedId + "");
            checkedIds = 1;
//            ArrayList<Entry> value1 = dealLine((List) resultBean.getResult().getTimes_rate().get(0));
//            ArrayList<Entry> value2 = dealLine((List) resultBean.getResult().getTimes_rate().get(1));
            llChanZ.setVisibility(View.GONE);
            llTaiC.setVisibility(View.VISIBLE);
//            setData(value1, value2);
//            mLineChar.animateX(2500);
//            mLineChar.invalidate();
//            dealProgess(resultBean, checkedIds);
//            dealmeduler(resultBean, checkedIds);
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
        TimeMDdialog timeMDdialog = new TimeMDdialog();
        timeMDdialog.setIndexmonthItem(monthdefult);
        timeMDdialog.setTimeMDdialogListener(new TimeMDdialog.TimeMDdialogListener() {
            @Override
            public void ontimeMDdialogComplete(String year, String month) {
                isRefresh = 0;
                defulter = Integer.parseInt(month);
                getAllData(Integer.parseInt(month));
            }
        });
        timeMDdialog.show(getActivity().getFragmentManager(), "time");
    }

    private BarData getBarData(List<Double> barChartY, int barColor) {
        BarData barData = new BarData();
        ArrayList<BarEntry> yValues = new ArrayList<>();
        for (int i = 0; i < barChartY.size(); i++) {
            yValues.add(new BarEntry(i, barChartY.get(i).floatValue()));
        }

        BarDataSet barDataSet = new BarDataSet(yValues, "");
        barDataSet.setDrawValues(false);
        barDataSet.setColor(barColor);
        barDataSet.setValueTextSize(10f);
        barDataSet.setValueTextColor(barColor);
        barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        barData.addDataSet(barDataSet);

        //以下是为了解决 柱状图 左右两边只显示了一半的问题 根据实际情况 而定
        xAxis.setAxisMinimum(-0.5f);
        xAxis.setAxisMaximum((float) (barChartY.size() - 0.5));

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
//            dataSet.setColor(lineColors.get(i));
//            dataSet.setCircleColor(lineColors.get(i));
//            dataSet.setValueTextColor(lineColors.get(i));
//
//            dataSet.setCircleSize(1);
//            dataSet.setDrawValues(true);
//            dataSet.setValueTextSize(10f);
//            dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
//            dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            dataSet.setColor(lineColors.get(i));
            // dataSet.setValueTextColor(lineColors.get(i));
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

}
